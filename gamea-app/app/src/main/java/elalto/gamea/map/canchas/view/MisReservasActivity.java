package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.MisReservas;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.MisReservasPresenter;
import elalto.gamea.map.canchas.presenter.MisReservasPresenterImpl;
import elalto.gamea.map.canchas.view.Adapters.MisReservas2Adapter;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MisReservasActivity extends AppCompatActivity  implements MisReservasView {

    Toolbar toolbar;
    MisReservasPresenter misReservasPresenter;
    MisReservas2Adapter adapter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<MisReservas> misReservasArray = new ArrayList<MisReservas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reservas);

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("LISTADO DE MIS RESERVAS");
        recyclerView = (RecyclerView) findViewById(R.id.rv_mis_reservas);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MisReservas2Adapter(misReservasArray,getApplicationContext());
        misReservasPresenter = new MisReservasPresenterImpl(this, new CanchasInteractorImpl());
        misReservasPresenter.getMisReservas("2");
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populateMisReservas(List<MisReservas> misReservas) {
        misReservasArray.clear();
        misReservasArray.addAll(misReservas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "Error" , Toast.LENGTH_LONG).show();
    }
}
