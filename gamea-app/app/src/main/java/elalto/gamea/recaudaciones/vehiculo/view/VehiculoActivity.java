package elalto.gamea.recaudaciones.vehiculo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.recaudaciones.entities.Vehiculo;
import elalto.gamea.recaudaciones.vehiculo.model.VehiculoInteractorImpl;
import elalto.gamea.recaudaciones.vehiculo.presenter.VehiculoPresenter;
import elalto.gamea.recaudaciones.vehiculo.presenter.VehiculoPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

public class VehiculoActivity extends AppCompatActivity implements VehiculoView {
    private VehiculoPresenter presenter;
    TokenManager tokenManager;
    String tipo_doc = "placa";
    RadioGroup radioGroup;
    TextInputLayout tilNroDoc;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_consultar)
    Button btnConsultar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);
        presenter = new VehiculoPresenterImpl(this, new VehiculoInteractorImpl());
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Consultar deuda vehiculo");
        setSupportActionBar(toolbar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tilNroDoc = (TextInputLayout) findViewById(R.id.til_nro_doc);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbt_ci:
                        tilNroDoc.setHint("Ej. 8415719");
                        tipo_doc = "ci";
                        break;
                    case R.id.rbt_placa:
                        tilNroDoc.setHint("Ej. 2615KDG");
                        tipo_doc = "placa";
                        break;
                    case R.id.rbt_poliza:
                        tilNroDoc.setHint("Ej. 2615KDG");
                        tipo_doc = "poliza";
                        break;
                    case R.id.rbt_nit:
                        tilNroDoc.setHint("Ej. 186481515");
                        tipo_doc = "nit";
                        break;

                }
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Buscando infomracion");
        progressDialog.setCancelable(false);
    }

    @OnClick(R.id.btn_consultar)
    public void findVehiculo() {
        presenter.getVehiculo(tipo_doc, tilNroDoc.getEditText().getText().toString(), tokenManager);
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
    public void showResponse(Vehiculo vehiculo) {
        progressDialog.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(VehiculoActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.vehiculo_info, null);
        TextView tvNomRazon, tvDocumento, tvPtaPoliza, tvNroDeterMixta, tvDeuda;
        tvNomRazon = (TextView) mView.findViewById(R.id.tv_nom_razon);
        tvDocumento = (TextView) mView.findViewById(R.id.tv_documento);
        tvPtaPoliza = (TextView) mView.findViewById(R.id.tv_pta_poliza);
        tvNroDeterMixta = (TextView) mView.findViewById(R.id.tv_nro_deter_mixta);
        tvDeuda = (TextView) mView.findViewById(R.id.tv_deuda_2013);
        tvNomRazon.setText(vehiculo.getNom_razon().toString());
        tvDocumento.setText(vehiculo.getTipo_doc().toString() + " " + vehiculo.getNro_doc().toString());
        tvPtaPoliza.setText(vehiculo.getPlaca().toString()+" <--> "+vehiculo.getPoliza().toString());
        tvNroDeterMixta.setText(vehiculo.getNro_deter_mixta().toString());
        tvDeuda.setText(String.valueOf(vehiculo.getDeuda_2013())+" "+"Bs.");
        builder.setView(mView);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showErrorMessage(String message) {
        progressDialog.dismiss();
        Toasty.error(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
