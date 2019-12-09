package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.MisReservas;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.MisReservasPresenter;
import elalto.gamea.map.canchas.presenter.MisReservasPresenterImpl;
import elalto.gamea.map.canchas.view.Adapters.BaseRecyclerViewAdapter;
import elalto.gamea.map.canchas.view.Adapters.MisReservasAdapter;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MisReservasActivity extends AppCompatActivity  implements MisReservasView {

    Toolbar toolbar;
    MisReservasPresenter misReservasPresenter;
    MisReservasAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<MisReservas> misReservasArray = new ArrayList<MisReservas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reservas);

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("LISTADO DE MIS RESERVAS");

        recyclerView= (RecyclerView) findViewById(R.id.rv_mis_reservas);
        adapter = new MisReservasAdapter(MisReservasActivity.this);
        misReservasArray.add(new MisReservas("Stadium",
                         "4",
                35,
                642,
                2,
                "2019-12-08T00:00:00.000Z",
                "17:00:00",
                 "18:00:00",
                "8330965",
                "Debbie Zuleta",
                "reserva Debbie mobile",
                1,
                 1,
                "2019-12-08T00:00:00.000Z",
                 "2019-12-08T00:00:00.000Z"
                )
        );
        adapter.addNormalObjects(misReservasArray);
        adapter.notifyDataSetChanged();
        adapter.setListener(new BaseRecyclerViewAdapter.ObjectRecyclerListener<MisReservas>() {
            @Override
            public void onObjectSelectListener(int position, MisReservas object) {
                final String nombre= object.getNombre();
                Log.e("nombre elegido", nombre);
            }
        });
        recyclerView.setAdapter(adapter);

       /* misReservasPresenter = new MisReservasPresenterImpl(this, new CanchasInteractorImpl());
        misReservasPresenter.getMisReservas("2");*/


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
        Toast.makeText(this, misReservas.get(0).getNombre(), Toast.LENGTH_LONG).show();
        adapter.addNormalObjects(misReservasArray);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "Error" , Toast.LENGTH_LONG).show();
    }
}
