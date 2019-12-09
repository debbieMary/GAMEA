package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.MisReservas;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.MisReservasPresenter;
import elalto.gamea.map.canchas.presenter.MisReservasPresenterImpl;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MisReservasActivity extends AppCompatActivity  implements MisReservasView {

    Toolbar toolbar;
    MisReservasPresenter misReservasPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reservas);

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("LISTADO DE MIS RESERVAS");

        misReservasPresenter = new MisReservasPresenterImpl(this, new CanchasInteractorImpl());
        misReservasPresenter.getMisReservas("2");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populateMisReservas(List<MisReservas> misReservas) {
        Toast.makeText(this, "Success" , Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "Error" , Toast.LENGTH_LONG).show();
    }
}
