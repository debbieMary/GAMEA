package elalto.gamea.testviolencia.contacto.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;

import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.testviolencia.contacto.model.ContactoInteractorImpl;
import elalto.gamea.testviolencia.contacto.presenter.ContactoPresenter;
import elalto.gamea.testviolencia.contacto.presenter.ContactoPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

public class ContactoActivity extends AppCompatActivity implements ContactoView {
    private ContactoPresenter presenter;
    TokenManager tokenManager;
    String email;
    Double lat, lng;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.til_mensaje)
    TextInputLayout tilMesnaje;
    @BindView(R.id.btn_enviar_msj)
    Button btnEnviarMsj;
    ProgressDialog progressDialog;
    private static final int GET_COORDENADAS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        presenter = new ContactoPresenterImpl(this, new ContactoInteractorImpl());
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        ButterKnife.bind(this);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Contacta con nosotros");
        setSupportActionBar(toolbar);
        solicitarPermisos();
        getEmail();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Enviando Mensaje");
        getCoordenadas();
    }

    @OnClick(R.id.btn_enviar_msj)
    public void enviar_mensaje() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Esta seguro de enviar el mensaje");
        builder.setMessage("La información que comparte con nosotros es estrictamente privada y confidencial.")
              .setCancelable(false)
              .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      if (TextUtils.isEmpty(email)) {
                          getEmail();
                          return;
                      }
                      presenter.send_mensaje(tilMesnaje.getEditText().getText().toString(), email, lat, lng, tokenManager);
                  }
              }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void getEmail() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = AccountManager.newChooseAccountIntent(null, null, new String[]{"com.google"},
                  false, null, null, null, null);
            startActivityForResult(intent, 200);
        }
    }

    public void solicitarPermisos() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.GET_ACCOUNTS)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS}, 100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 200:
                    String accountName = (String) data.getExtras().get(AccountManager.KEY_ACCOUNT_NAME);
                    email = accountName;
                    break;
            }
        }
    }

    public void getCoordenadas() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            locationStart();
        }
    }

    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();

        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 300000, 10, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 300000, 10, (LocationListener) Local);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showResponse(String string) {
        Toasty.success(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
        tilMesnaje.getEditText().setText("");
    }

    @Override
    public void showErrorMessage(String string) {
        Toasty.warning(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }

    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {
        ContactoActivity contactoActivity;

        public ContactoActivity getContactoActivity() {
            return contactoActivity;
        }

        public void setContactoActivity(ContactoActivity contactoActivity) {
            this.contactoActivity = contactoActivity;
        }

        @Override
        public void onLocationChanged(Location loc) {
            lat = loc.getLatitude();
            lng = loc.getLongitude();
        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }
}
