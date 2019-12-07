package elalto.gamea.recaudaciones.patente.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.recaudaciones.entities.Patente;
import elalto.gamea.recaudaciones.patente.model.PatenteInteractorImpl;
import elalto.gamea.recaudaciones.patente.presenter.PatentePresenter;
import elalto.gamea.recaudaciones.patente.presenter.PatentePresenterImpl;
import elalto.gamea.recaudaciones.vehiculo.model.VehiculoInteractorImpl;
import elalto.gamea.recaudaciones.vehiculo.presenter.VehiculoPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

public class PatenteActivity extends AppCompatActivity implements PatenteView {
    private PatentePresenter presenter;
    TokenManager tokenManager;
    String tipo_doc = "NIT";
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
        setContentView(R.layout.activity_patente);
        presenter = new PatentePresenterImpl(this, new PatenteInteractorImpl());
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Consultar deuda patente");
        setSupportActionBar(toolbar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tilNroDoc = (TextInputLayout) findViewById(R.id.til_nro_doc);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbt_ci:
                        tilNroDoc.setHint("Ej. 8415719");
                        tipo_doc = "CI";
                        break;
                    case R.id.rbt_nit:
                        tilNroDoc.setHint("Ej. 2615KDG");
                        tipo_doc = "NIT";
                        break;
                    case R.id.rbt_ruc:
                        tilNroDoc.setHint("Ej. 186481515");
                        tipo_doc = "RUC";
                        break;
                }
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Buscando infomracion");
        progressDialog.setCancelable(false);
    }

    @OnClick(R.id.btn_consultar)
    public void findPatente() {
        presenter.findPatente(tipo_doc, tilNroDoc.getEditText().getText().toString(), tokenManager);
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
    public void showResponse(Patente patente) {
        progressDialog.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(PatenteActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.patente_info, null);
        TextView tvNomRazon, tvDocumento, tvNroDeterMixta, tvDeuda;
        tvNomRazon = (TextView) mView.findViewById(R.id.tv_nom_razon);
        tvDocumento = (TextView) mView.findViewById(R.id.tv_documento);
        tvNroDeterMixta = (TextView) mView.findViewById(R.id.tv_nro_deter_mixta);
        tvDeuda = (TextView) mView.findViewById(R.id.tv_deuda_2013);
        tvNomRazon.setText(patente.getNom_razon().toString());
        tvDocumento.setText(patente.getTipo_doc().toString() + " " + patente.getNro_doc().toString());
        tvNroDeterMixta.setText(patente.getNro_deter_mixta().toString());
        tvDeuda.setText(String.valueOf(patente.getDeuda_2014()) + " Bs.");
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
