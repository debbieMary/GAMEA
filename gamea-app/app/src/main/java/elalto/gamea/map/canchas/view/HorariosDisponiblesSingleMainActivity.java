package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import elalto.gamea.R;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.entities.Event;
import elalto.gamea.map.canchas.presenter.HorariosDisponiblesPresenter;
import elalto.gamea.map.canchas.presenter.HorariosDisponiblesPresenterImpl;
import elalto.gamea.map.canchas.view.Calendar.*;
import elalto.gamea.map.canchas.view.Calendar.data.IEvent;
import elalto.gamea.map.canchas.view.Calendar.decoration.CdvDecorationDefault;

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
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
    String fecha_actual;

    CalendarDayView dayView;
    ArrayList<IEvent> events = new ArrayList<IEvent>();

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

        fecha_actual = fecha.format(fechaYhora.getTime());
        Log.e("$$$$$$$$", fecha_actual);

        dayView = (CalendarDayView) findViewById(R.id.calendar);
        dayView.setLimitTime(7, 20);
        horariosDisponiblesPresenter = new HorariosDisponiblesPresenterImpl(this, new CanchasInteractorImpl());
        horariosDisponiblesPresenter.getHorariosDisponibles(id_cancha, fecha_actual, fecha_actual);

        dayView.setEvents(events);

        ((CdvDecorationDefault) (dayView.getDecoration())).setOnEventClickListener(
                new EventView.OnEventClickListener() {
                    @Override
                    public void onEventClick(EventView view, IEvent data) {
                        Log.e("TAG", "onEventClick:" + data.getName());
                    }

                    @Override
                    public void onEventViewClick(View view, EventView eventView, IEvent data) {
                        Log.e("TAG", "onEventViewClick:" + data.getName());
                        if (data instanceof Event) {
                            // change event (ex: set event color)
                            dayView.setEvents(events);
                        }
                    }
                });
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
    public void populate(List<Event> horariosList) {
        events.addAll(horariosList);

    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}

