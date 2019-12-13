package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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


public class HorariosDisponiblesSingleMainActivity extends AppCompatActivity implements HorariosDisponiblesView {
    Toolbar toolbar;
    Bundle bundle;
    String id_cancha;
    String distrito;
    String nombre_cancha;
    HorariosDisponiblesPresenter horariosDisponiblesPresenter;
    TextView lbl_nombre_cancha;

    private Calendar fechaYhora = Calendar.getInstance();
    ArrayList<Horarios> horarios = new ArrayList<Horarios>();
    ArrayList<String> array_horario_inicio = new ArrayList<String>();
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
        fecha_actual = fecha.format(fechaYhora.getTime());

        lbl_nombre_cancha = (TextView) findViewById(R.id.lbl_nombre_cancha);
        lbl_nombre_cancha.setText(nombre_cancha);
        recyclerView = (RecyclerView) findViewById(R.id.rv_horarios);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HorariosAdapter(horarios, getApplicationContext());
        recyclerView.setAdapter(adapter);

        horariosDisponiblesPresenter = new HorariosDisponiblesPresenterImpl(this, new CanchasInteractorImpl());
        horariosDisponiblesPresenter.getHorariosDisponibles(id_cancha, fecha_actual, fecha_actual);

    }



    public void reservarCancha(View v) {
        Intent i = new Intent(this, ReservarCanchaActivity.class);
        i.putExtra("id_cancha", id_cancha);
        i.putExtra("nombre_cancha", nombre_cancha);
        i.putExtra("distrito", distrito);
        startActivity(i);
        finish();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populate(List<Horarios> horariosList) {
        array_horario_inicio.clear();
        //addHorarioArrayInicio();
        horarios.addAll(horariosList);
        //addMissingHours();

    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this,message , Toast.LENGTH_LONG).show();
    }


    /*public void addHorarioArrayInicio() {
        array_horario_inicio.clear();
        array_horario_inicio.add("07:00");
        array_horario_inicio.add("08:00");
        array_horario_inicio.add("09:00");
        array_horario_inicio.add("10:00");
        array_horario_inicio.add("11:00");
        array_horario_inicio.add("12:00");
        array_horario_inicio.add("13:00");
        array_horario_inicio.add("14:00");
        array_horario_inicio.add("15:00");
        array_horario_inicio.add("16:00");
        array_horario_inicio.add("17:00");
        array_horario_inicio.add("18:00");
        array_horario_inicio.add("19:00");
        array_horario_inicio.add("20:00");
        array_horario_inicio.add("21:00");
        array_horario_inicio.add("22:00");
        array_horario_inicio.add("23:00");

    }*/


    /*public void addMissingHours() {
        for (int k = 0; k < array_horario_inicio.size(); k++) {
            String hora_string = array_horario_inicio.get(k);
            String fecha_reservada = null;
            String hora_reservada = null;
            for (int i = 0; i <= horarios.size(); i++) {
                hora_reservada = horarios.get(i).getHora();
                fecha_reservada = horarios.get(i).getFecha();
            }
            if (!hora_reservada.equals(hora_string)) {
             horarios.add(new Horarios(fecha_reservada, hora_string, "0"));
             Log.e("EEE",hora_string);
            }
        }
        adapter.notifyDataSetChanged();
    }*/
}

