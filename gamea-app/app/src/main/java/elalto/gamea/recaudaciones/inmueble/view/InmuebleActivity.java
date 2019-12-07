package elalto.gamea.recaudaciones.inmueble.view;

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
import elalto.gamea.recaudaciones.entities.Inmueble;
import elalto.gamea.recaudaciones.inmueble.model.InmuebleInteractorImpl;
import elalto.gamea.recaudaciones.inmueble.presenter.InmueblePresenter;
import elalto.gamea.recaudaciones.inmueble.presenter.InmueblePresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

public class InmuebleActivity extends AppCompatActivity implements InmuebleView {
    private InmueblePresenter presenter;
    TokenManager tokenManager;
    String tipo_doc = "nro_inmueble";
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
        setContentView(R.layout.activity_inmueble);
        presenter = new InmueblePresenterImpl(this, new InmuebleInteractorImpl());
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Consultar deuda inmueble");
        setSupportActionBar(toolbar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tilNroDoc = (TextInputLayout) findViewById(R.id.til_nro_doc);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbt_ci:
                        tilNroDoc.setHint("Ej. 8415719");
                        tipo_doc = "doc_identificacion";
                        break;
                    case R.id.rbt_nro_inmuenble:
                        tilNroDoc.setHint("Ej. 186481515");
                        tipo_doc = "nro_inmueble";
                        break;
                }
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Buscando infomracion");
        progressDialog.setCancelable(false);
    }

    @OnClick(R.id.btn_consultar)
    public void findInmueble() {
        presenter.findInmueble(tipo_doc, tilNroDoc.getEditText().getText().toString(), tokenManager);
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
    public void showResponse(Inmueble inmueble) {
        progressDialog.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(InmuebleActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.inmueble_info, null);
        TextView tvNomRazon, tvDocumento, tvNroInmueble, tvNroDeterMixta, tvDeuda;
        tvNomRazon = (TextView) mView.findViewById(R.id.tv_nom_razon);
        tvDocumento = (TextView) mView.findViewById(R.id.tv_documento);
        tvNroInmueble = (TextView)mView.findViewById(R.id.tvNroInmueble);
        tvNroDeterMixta = (TextView) mView.findViewById(R.id.tv_nro_deter_mixta);
        tvDeuda = (TextView) mView.findViewById(R.id.tv_deuda_2013);
        tvNomRazon.setText(inmueble.getNom_razon().toString());
        tvDocumento.setText(inmueble.getDoc_indentificacion().toString());
        tvNroInmueble.setText(inmueble.getNro_inmueble().toString());
        tvNroDeterMixta.setText(inmueble.getNro_deter_mixta().toString());
        tvDeuda.setText(String.valueOf(inmueble.getDeuda_2013())+" "+"Bs.");
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
