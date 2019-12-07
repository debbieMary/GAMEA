package elalto.gamea.recaudaciones.patentepublicidad.view;

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
import elalto.gamea.recaudaciones.entities.PatentePublicidad;
import elalto.gamea.recaudaciones.patentepublicidad.model.PatentePublicidadInteractorImpl;
import elalto.gamea.recaudaciones.patentepublicidad.presenter.PatentePublicidadPresenter;
import elalto.gamea.recaudaciones.patentepublicidad.presenter.PatentePublicidadPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

public class PatentePublicidadActivity extends AppCompatActivity implements PatentePublicidadView {
    private PatentePublicidadPresenter presenter;
    TokenManager tokenManager;
    String tipo_doc;
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
        setContentView(R.layout.activity_patente_publicidad);
        presenter = new PatentePublicidadPresenterImpl(this, new PatentePublicidadInteractorImpl());
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
                        tilNroDoc.setHint("Ej. 186481515");
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
    public void findPatemtePublicidad() {
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
    public void showResponse(PatentePublicidad patentePublicidad) {
        progressDialog.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(PatentePublicidadActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.patente_publicidad_info, null);
        TextView tvNomRazon, tvDocumento, tvTasa, tvNroDeterMixta, tvDeuda2012, tvDeuda2013, tvDeuda2014;
        tvNomRazon = (TextView) mView.findViewById(R.id.tv_nom_razon);
        tvDocumento = (TextView) mView.findViewById(R.id.tv_documento);
        tvTasa = (TextView)mView.findViewById(R.id.tv_nro_tasa);
        tvNroDeterMixta = (TextView) mView.findViewById(R.id.tv_nro_deter_mixta);
        tvDeuda2012 = (TextView)mView.findViewById(R.id.tv_deuda_2012);
        tvDeuda2013 = (TextView)mView.findViewById(R.id.tv_deuda_2013);
        tvDeuda2014 = (TextView)mView.findViewById(R.id.tv_deuda_2014);
        tvNomRazon.setText(patentePublicidad.getNom_razon().toString());
        tvDocumento.setText(patentePublicidad.getTipo_doc()+" "+patentePublicidad.getNro_doc());
        tvTasa.setText(patentePublicidad.getNro_tasa().toString());
        tvNroDeterMixta.setText(patentePublicidad.getNro_determinacion());
        tvDeuda2012.setText(String.valueOf(patentePublicidad.getDeuda_2012())+" Bs.");
        tvDeuda2013.setText(String.valueOf(patentePublicidad.getDeuda_2013())+" Bs.");
        tvDeuda2014.setText(String.valueOf(patentePublicidad.getDeuda_2014())+" Bs.");
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
