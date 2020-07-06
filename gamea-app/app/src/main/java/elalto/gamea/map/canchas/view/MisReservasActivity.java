package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import elalto.gamea.R;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.MisReservasPresenter;
import elalto.gamea.map.canchas.presenter.MisReservasPresenterImpl;
import elalto.gamea.map.canchas.view.Adapters.MisReservasAdapter;
import elalto.gamea.map.canchas.view.Adapters.RecyclerItemClickListener;
import elalto.network.canchas.entities.MisReservas;
import elalto.network.canchas.entities.MisReservasBody;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MisReservasActivity extends AppCompatActivity  implements MisReservasView {

    Toolbar toolbar;
    MisReservasPresenter misReservasPresenter;
    MisReservasAdapter adapter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<MisReservas> misReservasArray = new ArrayList<MisReservas>();
    public static Integer DELETE_CONTACT_REQUEST = 1;
    MisReservasBody misReservasBody  = new MisReservasBody();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reservas);

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("LISTADO DE MIS RESERVAS");
        recyclerView = (RecyclerView) findViewById(R.id.rv_mis_reservas);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MisReservasAdapter(misReservasArray,getApplicationContext());
        misReservasPresenter = new MisReservasPresenterImpl(this, new CanchasInteractorImpl());
        misReservasBody.setIdUsuario("2");
        misReservasPresenter.getMisReservas(misReservasBody);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(MisReservasActivity.this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        goToPopup(position);
                    }
                    @Override public void onLongItemClick(View view, int position) {
                        goToDeleteReservaDialog(position);
                    }
                })
        );
    }

    public void goToPopup(int arrayPosition){
        if(misReservasArray.get(arrayPosition).getEstado() == 2){
            Intent i = new Intent(MisReservasActivity.this, PopupCanchaTicket.class );
            i.putExtra("nombre",misReservasArray.get(arrayPosition).getNombre());
            i.putExtra("distrito", misReservasArray.get(arrayPosition).getDistrito()+"");
            i.putExtra("id_reserva", misReservasArray.get(arrayPosition).getIdReserva()+"");
            i.putExtra("fecha",misReservasArray.get(arrayPosition).getFecha());
            i.putExtra("hora_inicio", misReservasArray.get(arrayPosition).getHoraInicio());
            i.putExtra("hora_fin", misReservasArray.get(arrayPosition).getHoraFin());
            i.putExtra("ci_quien_reserva", misReservasArray.get(arrayPosition).getCiQuienReserva());
            i.putExtra("nombre_reserva", misReservasArray.get(arrayPosition).getNombreReserva());
            i.putExtra("observaciones" , misReservasArray.get(arrayPosition).getObservaciones());
            i.putExtra("total" , ""+ misReservasArray.get(arrayPosition).getTotal());
            startActivity(i);
        }
    }


    public void goToDeleteReservaDialog(int arrayPosition){
        if(misReservasArray.get(arrayPosition).getEstado() == 1){
            Intent i=  new Intent(MisReservasActivity.this, DeleteReservaActivity.class);
            i.putExtra("id_reserva", misReservasArray.get(arrayPosition).getIdReserva());
            i.putExtra("nombre_cancha", misReservasArray.get(arrayPosition).getNombre());
            startActivityForResult(i, DELETE_CONTACT_REQUEST);
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

    @Override
    protected void onDestroy() {
        misReservasArray.clear();
        adapter.notifyDataSetChanged();
        super.onDestroy();
    }


    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == DELETE_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Intent intent=  new Intent(MisReservasActivity.this, MisReservasActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
