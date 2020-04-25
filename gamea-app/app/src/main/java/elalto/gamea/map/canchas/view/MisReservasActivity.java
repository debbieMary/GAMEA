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
import elalto.gamea.map.canchas.view.Adapters.RecyclerItemClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MisReservasActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        goToPopup(position);
                    }
                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );
    }

    public void goToPopup(int arrayPosition){
        if(misReservasArray.get(arrayPosition).getEstado() == 2){
            Intent i = new Intent(MisReservasActivity.this, PopupCanchaTicket.class );
            i.putExtra("nombre",misReservasArray.get(arrayPosition).getNombre());
            i.putExtra("distrito", misReservasArray.get(arrayPosition).getDistrito()+"");
            i.putExtra("id_reserva", misReservasArray.get(arrayPosition).getId_reserva()+"");
            i.putExtra("fecha",misReservasArray.get(arrayPosition).getFecha());
            i.putExtra("hora_inicio", misReservasArray.get(arrayPosition).getHora_inicio());
            i.putExtra("hora_fin", misReservasArray.get(arrayPosition).getHora_fin());
            i.putExtra("ci_quien_reserva", misReservasArray.get(arrayPosition).getCi_quien_reserva());
            i.putExtra("nombre_reserva", misReservasArray.get(arrayPosition).getNombre_reserva());
            i.putExtra("observaciones" , misReservasArray.get(arrayPosition).getObservaciones());
            startActivity(i);
        }
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
        Toast.makeText(this, message , Toast.LENGTH_LONG).show();
    }
}
