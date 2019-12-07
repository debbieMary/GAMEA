package elalto.gamea.home.view;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.ami.AmiActivity;
import elalto.gamea.artesano.categoria.view.ArtCategoriaActivity;
import elalto.gamea.auth.login.view.LoginActivity;
import elalto.gamea.catastro.consulta_tramite.ConsultaTramiteActivity;
import elalto.gamea.denuncia.DenunciaActivity;
import elalto.gamea.home.model.HomeInteractorImpl;
import elalto.gamea.home.presenter.HomePresenter;
import elalto.gamea.home.presenter.HomePresenterImpl;
import elalto.gamea.institucional.InstitucionalActivity;
import elalto.gamea.map.UbicacionesActivity;
import elalto.gamea.recaudaciones.view.RecaudacionesActivity;
import elalto.gamea.siget.view.SigetActivity;
import elalto.gamea.testviolencia.TestViolenciaActivity;
import elalto.gamea.vocero.VoceroActivity;
import elalto.gamea.yayo.YayoActivity;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private static final int REQUEST_PERMISSION = 101;
    Toolbar toolbar;
    TokenManager tokenManager;
    private HomePresenter presenter;
    @BindView(R.id.img_institucional)
    ImageView imgInstitucional;
    @BindView(R.id.img_canchas)
    ImageView imgCanchas;
    @BindView(R.id.img_ami)
    ImageView imgAmi;
    @BindView(R.id.img_artesano)
    ImageView imgArtesano;
    @BindView(R.id.img_test)
    ImageView imgTest;
    @BindView(R.id.img_yayo)
    ImageView imgYayo;
    @BindView(R.id.img_denuncia)
    ImageView imgDenuncia;
    @BindView(R.id.img_siget)
    ImageView imgSiget;
    @BindView(R.id.img_map)
    ImageView imgMap;
    @BindView(R.id.img_catastro)
    ImageView imgCatastro;
    @BindView(R.id.img_vocero)
    ImageView imgVocero;
    @BindView(R.id.img_recaudaciones)
    ImageView imgRecaudaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        toolbar.setTitle("EL ALTO");
        setSupportActionBar(toolbar);

        presenter = new HomePresenterImpl(this, new HomeInteractorImpl());
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));

        if (tokenManager.getToken().getAccess_token() == null) {
            logout();
        }
        solicitarPermisos();
    }

    private void solicitarPermisos() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return;
        if ((checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) && (checkSelfPermission(ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED))
            return;

        if ((shouldShowRequestPermissionRationale(CAMERA)) || (shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE)) || (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) || (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION))) {
            cargarDialogoRecomendacion();
        } else {
            requestPermissions(new String[]{CAMERA, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, ACCESS_FINE_LOCATION}, REQUEST_PERMISSION);
        }

    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                requestPermissions(new String[]{CAMERA, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, ACCESS_FINE_LOCATION}, REQUEST_PERMISSION);
            }
        });
        dialogo.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults.length == 4 && grantResults[0] != PackageManager.PERMISSION_GRANTED && grantResults[1] != PackageManager.PERMISSION_GRANTED && grantResults[2] != PackageManager.PERMISSION_GRANTED && grantResults[3] != PackageManager.PERMISSION_GRANTED) {
                solicitarPermisosManual();
            }
        }
    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones = {"si", "no"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(this);
        alertOpciones.setTitle("¿Desa configurar los permisos de fomra manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (opciones[which].equals("si")) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                } else {
                    dialog.dismiss();
                }
            }
        });
        alertOpciones.show();
    }

    @OnClick(R.id.img_institucional)
    public void navigateInstitucional() {
        Intent intent = new Intent(this, InstitucionalActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_ami)
    public void navigateAmi() {
        Intent intent = new Intent(this, AmiActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_artesano)
    public void navigateToCategoriaArtesano() {
        Intent intent = new Intent(this, ArtCategoriaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_test)
    public void navigateToTestViolencia() {
        Intent intent = new Intent(this, TestViolenciaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_yayo)
    public void navigateToYayo() {
        Intent intent = new Intent(this, YayoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_denuncia)
    public void navigateDenuncia() {
        Intent intent = new Intent(this, DenunciaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_siget)
    public void navigateToSiget() {
        Intent intent = new Intent(this, SigetActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_map)
    public void navigateToUbicaciones() {
        Intent intent = new Intent(this, UbicacionesActivity.class);
        intent.putExtra("goTo","completeMap");
        startActivity(intent);
    }


    @OnClick({R.id.img_canchas})
    public void navigateToCanchas() {
        Intent intent = new Intent(this, UbicacionesActivity.class);
        intent.putExtra("goTo","canchasMap");
        startActivity(intent);
    }

    @OnClick(R.id.img_catastro)
    public void navigateToConsultaTramite() {
        Intent intent = new Intent(this, ConsultaTramiteActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_vocero)
    public void navigateToVocero() {
        Intent intent = new Intent(this, VoceroActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.img_recaudaciones)
    public void navigateToRecaudaciones() {
        Intent intent = new Intent(this, RecaudacionesActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        switch (id) {
            case R.id.close_sesion:
                presenter.logout(tokenManager);
                break;
            case R.id.call_suma:
                intent.setData(Uri.parse("tel:161"));
                startActivity(intent);
                break;
            case R.id.call_emergencia:
                intent.setData(Uri.parse("tel:156"));
                startActivity(intent);
                break;
            case R.id.sugerencia:
                AlertDialog.Builder alert = new AlertDialog.Builder(HomeActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.layout_sugerencia_dialog, null);
                TextInputLayout tilSugerencia = (TextInputLayout)mView.findViewById(R.id.til_sugerencia);
                Button btn_enviar = (Button)mView.findViewById(R.id.btn_enviar);
                alert.setView(mView);
                AlertDialog alertDialog = alert.create();
                btn_enviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        presenter.sendSugerencia(tokenManager,tilSugerencia.getEditText().getText().toString());
                    }
                });

                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void logout() {
        Toast.makeText(this, "HASTA PRONTO", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void succesSend(String message) {
        Toasty.success(HomeActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorSend(String message) {
        Toasty.error(HomeActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        if (tokenManager.getToken().getAccess_token() == null) {
            Toasty.error(this, "Su sesion a caducado \nVuelva a iniciar sesion", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        super.onResume();
    }
}
