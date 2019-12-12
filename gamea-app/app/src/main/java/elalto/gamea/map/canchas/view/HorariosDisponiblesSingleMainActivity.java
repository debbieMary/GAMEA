package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.Horarios;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.HorariosDisponiblesPresenter;
import elalto.gamea.map.canchas.presenter.HorariosDisponiblesPresenterImpl;
import elalto.gamea.map.canchas.view.Adapters.HorariosAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class HorariosDisponiblesSingleMainActivity extends AppCompatActivity implements HorariosDisponiblesView{
    Toolbar toolbar;
    Bundle bundle;
    String id_cancha;
    String distrito;
    String nombre_cancha;
    HorariosDisponiblesPresenter horariosDisponiblesPresenter;
    TextView lbl_nombre_cancha;

    private Calendar fechaYhora = Calendar.getInstance();ArrayList<Horarios> horarios= new ArrayList<Horarios>();
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
    String fecha_actual;

    HorariosAdapter adapter;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios_disponibles_single_main);

        bundle = getIntent().getExtras();
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HOARARIOS DISPONIBLES");
        id_cancha = bundle.getString("id_cancha");
        nombre_cancha = bundle.getString("nombre_cancha");
        distrito = bundle.getString("distrito");
        fecha_actual= fecha.format(fechaYhora.getTime());
        addHorarios();


        lbl_nombre_cancha= (TextView) findViewById(R.id.lbl_nombre_cancha);
        lbl_nombre_cancha.setText(nombre_cancha);
        recyclerView = (RecyclerView) findViewById(R.id.rv_horarios);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HorariosAdapter(horarios,getApplicationContext());
        recyclerView.setAdapter(adapter);

        horariosDisponiblesPresenter = new HorariosDisponiblesPresenterImpl(this, new CanchasInteractorImpl());
        horariosDisponiblesPresenter.getHorariosDisponibles(id_cancha, fecha_actual, fecha_actual);

    }


    public void addHorarios() {
       horarios.add(new Horarios(fecha_actual, "08:00", "1"));
       horarios.add(new Horarios(fecha_actual, "09:00", "1"));
       horarios.add(new Horarios(fecha_actual, "10:00", "0"));
       horarios.add(new Horarios(fecha_actual, "11:00", "1"));
       horarios.add(new Horarios(fecha_actual, "12:00", "0"));
       horarios.add(new Horarios(fecha_actual, "13:00", "0"));
       horarios.add(new Horarios(fecha_actual, "14:00", "1"));
       horarios.add(new Horarios(fecha_actual, "15:00", "1"));
       horarios.add(new Horarios(fecha_actual, "16:00", "0"));
       horarios.add(new Horarios(fecha_actual, "17:00", "1"));
       horarios.add(new Horarios(fecha_actual, "19:00", "1"));
       horarios.add(new Horarios(fecha_actual, "20:00", "1"));
    }

    public void reservarCancha(View v) {
        Intent i = new Intent(this, ReservarCanchaActivity.class);
        i.putExtra("id_cancha", id_cancha);
        i.putExtra("nombre_cancha", nombre_cancha);
        i.putExtra("distrito", distrito);
        startActivity(i);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populate(List<Horarios> horariosList) {

    }

    @Override
    public void showErrorMessage(String message) {

    }
}
