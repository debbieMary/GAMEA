package elalto.gamea.siget.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.siget.model.SigetInteractorImpl;
import elalto.gamea.siget.presenter.SigetPresenter;
import elalto.gamea.siget.presenter.SigetPresenterImpl;
import es.dmoral.toasty.Toasty;
import okhttp3.ResponseBody;

public class SigetActivity extends AppCompatActivity implements SigetView {
    private SigetPresenter presenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.til_dtm)
    TextInputLayout tilDtm;
    @BindView(R.id.btn_buscar_dtm)
    Button btnBuscarSiget;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siget);
        presenter = new SigetPresenterImpl(this, new SigetInteractorImpl());
        ButterKnife.bind(this);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("SEGUIMIENTO DTM");
        setSupportActionBar(toolbar);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Buscando infomracion");
        progressDialog.setCancelable(false);
    }

    @OnClick(R.id.btn_buscar_dtm)
    public void findDtm() {
        presenter.getDtm(tilDtm.getEditText().getText().toString());
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
        Toasty.error(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setErrorDtm() {
        tilDtm.setError("Ingrese el numero DTM");
    }

    @Override
    public void getDtm(ResponseBody responseBody) {
        try {
            String message = responseBody.string();
            message = message.replace((char) 34, (char) 0);
            message = message.replace((char) 93, (char) 0);
            message = message.replace((char) 91, (char) 0);
            String[] data = message.split(",");
            String dtm = data[0].toString();
            if (dtm == "null") {
                Toasty.warning(this, "El DTM no coincide con nuestros registros", Toasty.LENGTH_LONG).show();
                return;
            } else {
                AlertDialog.Builder aleBuilder = new AlertDialog.Builder(SigetActivity.this);
                View mvView = getLayoutInflater().inflate(R.layout.dtm_layout, null);
                TextView tvDtm, tvUnidadEjecutora, tvDestinatario, tvEstado, tvInstruccion, tvObservaciones;
                tvDtm = (TextView) mvView.findViewById(R.id.tv_dtm);
                tvUnidadEjecutora = (TextView) mvView.findViewById(R.id.tv_unidad_ejecutora);
                tvDestinatario = (TextView) mvView.findViewById(R.id.tv_destinatario);
                tvEstado = (TextView) mvView.findViewById(R.id.tv_estado);
                tvInstruccion = (TextView) mvView.findViewById(R.id.tv_instruccion);
                tvObservaciones = (TextView) mvView.findViewById(R.id.tv_observacion);
                tvDtm.setText(data[0]);
                tvUnidadEjecutora.setText(data[8]);
                tvDestinatario.setText(data[1] + "\n" + data[2]);
                tvEstado.setText(data[5] + " " + data[3] + "\n" + data[7]);
                tvInstruccion.setText(data[4]);
                if (TextUtils.isEmpty(data[6])) {
                    tvObservaciones.setText("S/N");
                } else {
                    tvObservaciones.setText(data[6]);
                }
                aleBuilder.setView(mvView);
                AlertDialog dialog = aleBuilder.create();
                dialog.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
