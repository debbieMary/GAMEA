package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.Event;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.HorariosDisponiblesPresenter;
import elalto.gamea.map.canchas.presenter.HorariosDisponiblesPresenterImpl;
import elalto.gamea.map.canchas.utils.GeneralUtils;
import elalto.gamea.map.canchas.view.Adapters.PagerAdapter;
import elalto.gamea.map.canchas.view.Calendar.data.IEvent;
import elalto.network.canchas.entities.HorariosBody;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class HorariosDisponiblesActivity extends AppCompatActivity implements HorariosDisponiblesView {
    Toolbar toolbar;
    Bundle bundle;
    String id_cancha;
    String distrito;
    String nombre_cancha;
    Integer precio_hora;

    private Calendar fechaYhora = Calendar.getInstance();
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");

    public static String fecha_actual;
    public static String fecha_manhiana;
    public static int eventColor;
    String fecha_reserva;

    int posicion_fecha = 0;

    GeneralUtils utils = new GeneralUtils();
    ProgressDialog progressDialog;
    public static ArrayList<Event> events = new ArrayList<Event>();
    HorariosDisponiblesPresenter horariosDisponiblesPresenter;
    public static Activity activityStatic;
    HorariosBody horariosBody = new HorariosBody();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios_disponibles);


        activityStatic = HorariosDisponiblesActivity.this;

        bundle = getIntent().getExtras();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HORARIOS DISPONIBLES");

        eventColor = getResources().getColor(R.color.eventColor);

        id_cancha = bundle.getString("id_cancha");
        nombre_cancha = bundle.getString("nombre_cancha");
        distrito = bundle.getString("distrito");
        precio_hora = bundle.getInt("precio_hora");

        fecha_actual = fecha.format(fechaYhora.getTime());
        fecha_reserva = fecha_actual;
        fechaYhora.add(Calendar.DATE, 1);
        fecha_manhiana = fecha.format(fechaYhora.getTime());


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Obteniendo información...");
        progressDialog.setCancelable(false);


        horariosDisponiblesPresenter = new HorariosDisponiblesPresenterImpl(this, new CanchasInteractorImpl());

        horariosBody.setIdCancha(id_cancha);
        horariosBody.setFechaInicio(fecha_actual);
        horariosBody.setFechaFin(fecha_manhiana);
        horariosDisponiblesPresenter.getHorariosDisponibles(horariosBody);

    }


    public void reservarCancha(View v) {
        Intent i = new Intent(this, ReservarCanchaActivity.class);
        i.putExtra("id_cancha", id_cancha);
        i.putExtra("nombre_cancha", nombre_cancha);
        i.putExtra("distrito", distrito);
        i.putExtra("fecha_reserva", fecha_reserva);
        i.putExtra("precio_hora", precio_hora);
        i.putExtra("event", getHorariosReservados(fecha_reserva));
        startActivity(i);
    }

    public String getToday() {
        return fecha_actual;
    }

    public String getTomorrow() {
        return fecha_manhiana;
    }

    public void setFragment() {

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(utils.transformDate(fecha_actual.replace("/", "-"))));
        tabLayout.addTab(tabLayout.newTab().setText(utils.transformDate(fecha_manhiana.replace("/", "-"))));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                posicion_fecha = tab.getPosition();
                if (posicion_fecha == 0) {
                    fecha_reserva = fecha_actual;
                } else {
                    fecha_reserva = fecha_manhiana;
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    public ArrayList<Event> getHorariosReservados(String fecha_elegida) {
        ArrayList<Event> eventsByDate = new ArrayList<Event>();
        for (int i = 0; i < events.size(); i++) {
            if (fecha_elegida.equals(events.get(i).getDate().replace("-", "/"))) {
                eventsByDate.add(
                        new Event(
                                (int) events.get(i).getId(),
                                events.get(i).getStartTime(),
                                events.get(i).getEndTime(),
                                events.get(i).getObs(),
                                events.get(i).getDate(),
                                eventColor)
                );
            }
        }

        return eventsByDate;
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
    public void populate(List<Event> horariosList) {
        events.addAll(horariosList);
        setFragment();
    }

    @Override
    public void showErrorMessage(String message) {
        setFragment();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        events.clear();
        super.onDestroy();
    }

}
