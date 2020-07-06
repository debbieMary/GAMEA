package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import elalto.gamea.R;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.CanchasInfoPresenterImpl;
import elalto.gamea.map.canchas.presenter.DeleteReservaPresenter;
import elalto.gamea.map.canchas.presenter.DeleteReservaPresenterImpl;
import elalto.gamea.map.canchas.presenter.HorariosDisponiblesPresenter;
import elalto.gamea.map.canchas.utils.GeneralUtils;
import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.canchas.entities.DeleteReservaResponse;
import elalto.network.entities.TokenManager;

public class DeleteReservaActivity extends Activity implements DeleteReservaView {

    Bundle bundle;
    Integer id_reserva;
    String nombre_cancha;
    GeneralUtils utils = new GeneralUtils();
    TextView deleteMessage;
    private Calendar fechaYhora = Calendar.getInstance();
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
    private String fecha_actual;
    DeleteReservaPresenter deleteReservaPresenter;
    Button btn_delete_reserva;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_reserva);
        int width = utils.get_width(DeleteReservaActivity.this);
        int height = (int) (utils.get_height(DeleteReservaActivity.this) * 0.30);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, height);

        bundle = getIntent().getExtras();
        id_reserva = bundle.getInt("id_reserva");
        nombre_cancha = bundle.getString("nombre_cancha");

        deleteMessage = (TextView) this.findViewById(R.id.txtMessage);
        deleteMessage.setText("¿Está seguro de cancelar la reserva para: " + nombre_cancha + " ?");

        deleteReservaPresenter = new DeleteReservaPresenterImpl(this, new CanchasInteractorImpl());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cancelando Reserva...");
        progressDialog.setCancelable(false);

        btn_delete_reserva = (Button) this.findViewById(R.id.btn_delete_reserva);
        btn_delete_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteReservaById();
            }
        });
    }

    public void deleteReservaById() {
        fecha_actual = fecha.format(fechaYhora.getTime());
        DeleteReservaBody deleteReservaBody = new DeleteReservaBody();
        deleteReservaBody.setEstado(3);
        deleteReservaBody.setFechaUpdate(fecha_actual);
        deleteReservaBody.setIdReserva(id_reserva);
        deleteReservaBody.setIdUsuario("2");
        deleteReservaPresenter.deleteReserva(deleteReservaBody);

    }

    public void closePopup(View view) {
        finish();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void populate(DeleteReservaResponse deleteReservaResponse) {
        Toast.makeText(this, deleteReservaResponse.getMensaje(), Toast.LENGTH_SHORT).show();
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
