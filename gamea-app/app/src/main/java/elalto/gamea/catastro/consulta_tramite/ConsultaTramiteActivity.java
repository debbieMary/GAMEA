package elalto.gamea.catastro.consulta_tramite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.catastro.consulta_tramite.entities.Tramite;
import elalto.gamea.catastro.consulta_tramite.model.ConsultaTramiteInteractorImpl;
import elalto.gamea.catastro.consulta_tramite.presenter.ConsultaTramitePresenter;
import elalto.gamea.catastro.consulta_tramite.presenter.ConsultaTramitePresenterImpl;
import elalto.gamea.catastro.consulta_tramite.view.ConsultaTramiteView;
import es.dmoral.toasty.Toasty;

public class ConsultaTramiteActivity extends AppCompatActivity implements ConsultaTramiteView {
    private ConsultaTramitePresenter presenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.til_tramite)
    TextInputLayout tilTramite;
    @BindView(R.id.btn_buscar_tramite)
    Button btnBuscarTramite;
    ProgressDialog progressDialog;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_tramite);
        presenter = new ConsultaTramitePresenterImpl(this, new ConsultaTramiteInteractorImpl());
        ButterKnife.bind(this);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("CONSULTA DE TRÁMITES VECINO");
        setSupportActionBar(toolbar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupCatastro);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Buscando infomracion");
        progressDialog.setCancelable(false);
    }

    @OnClick(R.id.btn_buscar_tramite)
    public void findTramite() {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rbt_administracion_territorial:
                presenter.getConsultaTramite(tilTramite.getEditText().getText().toString(),"OT");
                break;
            case R.id.rbt_catastro:
                presenter.getConsultaTramite(tilTramite.getEditText().getText().toString(),"VE");
                break;
            default:
                    Toasty.warning(this,"Elija la unidad",Toast.LENGTH_SHORT).show();
                break;
        }
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
    public void showErrorMessage(String message) {
        progressDialog.dismiss();
        Toasty.error(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setErrorConsulta(String message) {
        tilTramite.setError(message);
    }

    @Override
    public void getDtm(Tramite tramite) {
        Intent intent = new Intent(ConsultaTramiteActivity.this, ShowTramiteActivity.class);
        intent.putExtra("tramite", tramite);
        startActivity(intent);
    }
}
