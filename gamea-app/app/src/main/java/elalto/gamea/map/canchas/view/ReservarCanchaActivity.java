package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.Event;
import elalto.gamea.map.canchas.entities.Horas;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.CanchaReservaPresenter;
import elalto.gamea.map.canchas.presenter.CanchaReservaPresenterImpl;
import elalto.gamea.map.canchas.utils.GeneralUtils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ReservarCanchaActivity extends AppCompatActivity implements CanchaReservaView {

    Toolbar toolbar;
    Bundle bundle;
    String id_cancha;
    String nombre_cancha;
    String distrito;
    String fecha_reserva;
    Spinner sp_horario_inicio;
    Spinner sp_horario_fin;
    ArrayAdapter<String> horario_inicio_adapter;
    ArrayAdapter<String> horario_fin_adapter;
    TextView lbl_nombre_cancha;
    TextView lbl_fecha_reserva;
    String selected_hora_inicio;
    String selected_hora_fin;
    EditText txt_observaciones;
    CanchaReservaPresenter canchaReservaPresenter;
    ArrayList<String> array_horario_inicio = new ArrayList<String>();
    ArrayList<String> array_horario_fin = new ArrayList<String>();
    ArrayList<Event> events = new ArrayList<Event>();
    ArrayList<Horas> horas =  new ArrayList<Horas>();
    GeneralUtils utils= new GeneralUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_cancha);
        setHorarios();
        setHorasInit();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("RESERVA DE CANCHA");
        canchaReservaPresenter = new CanchaReservaPresenterImpl(this, new CanchasInteractorImpl());
        sp_horario_inicio = (Spinner) this.findViewById(R.id.sp_horario_inicio);
        sp_horario_fin = (Spinner) this.findViewById(R.id.sp_horario_fin);
        bundle = getIntent().getExtras();
        id_cancha = bundle.getString("id_cancha");
        nombre_cancha = bundle.getString("nombre_cancha");
        distrito = bundle.getString("distrito");
        fecha_reserva = bundle.getString("fecha_reserva");
        events= (ArrayList<Event>) bundle.getSerializable("event");
        if(events != null && events.size() >0){
            llenarDisponibilidad();
        }

        txt_observaciones = (EditText) this.findViewById(R.id.txt_observaciones);

        lbl_nombre_cancha = (TextView) this.findViewById(R.id.lbl_nombre_cancha);
        lbl_nombre_cancha.setText(nombre_cancha);

        lbl_fecha_reserva = (TextView) this.findViewById(R.id.lbl_fecha_reserva);
        lbl_fecha_reserva.setText(utils.transformDate(fecha_reserva.replace("/","-")));

        horario_inicio_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, array_horario_inicio);
        horario_inicio_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_horario_inicio.setAdapter(horario_inicio_adapter);
        sp_horario_inicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                selected_hora_inicio = array_horario_inicio.get(arg0.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        horario_fin_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, array_horario_fin);
        horario_fin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_horario_fin.setAdapter(horario_fin_adapter);
        sp_horario_fin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                selected_hora_fin = array_horario_fin.get(arg0.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    private void llenarDisponibilidad() {
        for(int i=0 ; i < events.size() ; i++){

            SimpleDateFormat dateformat = new SimpleDateFormat("kk:mm");
            Integer hora_inicio= Integer.parseInt(dateformat.format(events.get(i).getStartTime().getTime()).split(":")[0]);
            Integer hora_fin = Integer.parseInt(dateformat.format(events.get(i).getEndTime().getTime()).split(":")[0]);

            System.out.println("lalalala");
            cambiarEstadoDeDisponibilidad(hora_inicio, hora_fin);
        }
    }

    private void cambiarEstadoDeDisponibilidad(int hora_inicio, int hora_fin) {
      for( int i= hora_inicio ; i< hora_fin; i++){
              horas.get(i);

      }
        Log.e("lalala", horas.toString());
    }

    private void setHorasInit() {
        for (int i = 7 ;  i < 23; i++){
          horas.add(new Horas(i, 0));
        }
    }


    public void setHorarios() {
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
        array_horario_fin.addAll(array_horario_inicio);
        array_horario_fin.remove(0);
        selected_hora_inicio = array_horario_inicio.get(0);
        selected_hora_fin = array_horario_fin.get(0);
    }

    public void reservarCancha(View v) {
        canchaReservaPresenter.saveCanchasReserva(getStringJson());
    }

    public String getStringJson() {
        JSONObject jsonReserva = new JSONObject();
        try {
            jsonReserva.put("id_cancha", id_cancha);
            jsonReserva.put("id_usuario", "2");
            jsonReserva.put("fecha_reserva", fecha_reserva);
            jsonReserva.put("hora_inicio", selected_hora_inicio);
            jsonReserva.put("hora_fin", selected_hora_fin);
            jsonReserva.put("ci_quien_reserva", "8330965");
            jsonReserva.put("observaciones", txt_observaciones.getText().toString());
            jsonReserva.put("modo_registro", "1");
            jsonReserva.put("nombre_reserva", "Debbie Zuleta");
            jsonReserva.put("estado", "1");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Toast.makeText(this, jsonReserva.toString(), Toast.LENGTH_SHORT).show();
        return jsonReserva.toString();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populateMessage(String message) {

        Toast.makeText(this,message , Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, HorariosDisponiblesActivity.class);
        i.putExtra("id_cancha", id_cancha);
        i.putExtra("nombre_cancha", nombre_cancha);
        i.putExtra("distrito", distrito);
        startActivity(i);
        finish();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this,message , Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
