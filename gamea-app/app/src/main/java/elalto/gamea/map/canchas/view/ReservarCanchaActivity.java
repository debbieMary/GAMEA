package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.Event;
import elalto.gamea.map.canchas.entities.Horas;
import elalto.gamea.map.canchas.model.CanchasInteractorImpl;
import elalto.gamea.map.canchas.presenter.CanchaReservaPresenter;
import elalto.gamea.map.canchas.presenter.CanchaReservaPresenterImpl;
import elalto.gamea.map.canchas.presenter.CantidadReservasPendientesPresenter;
import elalto.gamea.map.canchas.presenter.CantidadReservasPendientesPresenterImpl;
import elalto.gamea.map.canchas.presenter.CantidadReservasPendientesView;
import elalto.gamea.map.canchas.utils.GeneralUtils;
import elalto.network.canchas.entities.IdUsuarioBody;
import elalto.network.canchas.entities.ReservaBody;

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


public class ReservarCanchaActivity extends AppCompatActivity implements CanchaReservaView , CantidadReservasPendientesView {

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
    CantidadReservasPendientesPresenter cantidadReservasPendientesPresenter;
    ArrayList<String> array_horario_inicio = new ArrayList<String>();
    ArrayList<String> array_horario_fin = new ArrayList<String>();
    ArrayList<Event> events = new ArrayList<Event>();
    ArrayList<Horas> horas = new ArrayList<Horas>();
    GeneralUtils utils = new GeneralUtils();
    int inicio_global = 7;
    int fin_global = 23;
    Integer precio_hora;
    HorariosDisponiblesActivity horariosDisponiblesActivity=  new HorariosDisponiblesActivity();
    IdUsuarioBody idUsuarioBody= new IdUsuarioBody();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_cancha);
        setHorariosSpinner();
        setHorasArrayInit();

        cantidadReservasPendientesPresenter = new CantidadReservasPendientesPresenterImpl(this, new CanchasInteractorImpl());
        idUsuarioBody.setIdUsuario("2");
        cantidadReservasPendientesPresenter.getCantidadReservasPendientes(idUsuarioBody);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("RESERVA DE CANCHA");
        canchaReservaPresenter = new CanchaReservaPresenterImpl(this, new CanchasInteractorImpl());
        sp_horario_inicio = (Spinner) this.findViewById(R.id.sp_horario_inicio);
        sp_horario_fin = (Spinner) this.findViewById(R.id.sp_horario_fin);
        bundle = getIntent().getExtras();
        id_cancha = bundle.getString("id_cancha");
        nombre_cancha = bundle.getString("nombre_cancha");
        distrito = bundle.getString("distrito");
        precio_hora= bundle.getInt("precio_hora");
        fecha_reserva = bundle.getString("fecha_reserva");
        events = (ArrayList<Event>) bundle.getSerializable("event");
        if (events != null && events.size() > 0) {
            llenarDisponibilidad();
        }

        txt_observaciones = (EditText) this.findViewById(R.id.txt_observaciones);

        lbl_nombre_cancha = (TextView) this.findViewById(R.id.lbl_nombre_cancha);
        lbl_nombre_cancha.setText(nombre_cancha);

        lbl_fecha_reserva = (TextView) this.findViewById(R.id.lbl_fecha_reserva);
        lbl_fecha_reserva.setText(utils.transformDate(fecha_reserva.replace("/", "-")));

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


    public void setHorariosSpinner() {
        for (int i = inicio_global; i < fin_global; i++) {
            if (i < 10) {
                array_horario_inicio.add("0" + i + ":00");
            } else {
                array_horario_inicio.add(i + ":00");
            }
        }
        array_horario_fin.addAll(array_horario_inicio);
        array_horario_fin.remove(0);
        selected_hora_inicio = array_horario_inicio.get(0);
        selected_hora_fin = array_horario_fin.get(0);
    }

    private void setHorasArrayInit() {
        for (int i = inicio_global; i < fin_global; i++) {
            horas.add(new Horas(i, 0));
        }
    }

    private void llenarDisponibilidad() {
        for (int i = 0; i < events.size(); i++) {
            SimpleDateFormat dateformat = new SimpleDateFormat("kk:mm");
            Integer hora_inicio = Integer.parseInt(dateformat.format(events.get(i).getStartTime().getTime()).split(":")[0]);
            Integer hora_fin = Integer.parseInt(dateformat.format(events.get(i).getEndTime().getTime()).split(":")[0]);
            cambiarEstadoDeDisponibilidad(hora_inicio, hora_fin);
        }
    }

    private void cambiarEstadoDeDisponibilidad(int hora_inicio, int hora_fin) {
        for (int i = 0; i < horas.size(); i++) {
            if (horas.get(i).getHora() >= hora_inicio && horas.get(i).getHora() < hora_fin) {
                horas.get(i).setEstadoHora(1);
            }
        }
    }

    public void reservarCancha(View v) {
        if(validarHoras()){
            if (verificarDisponibilidad()) {
                canchaReservaPresenter.saveCanchasReserva(getReservaBody());
            } else {
                Toast.makeText(this, "El horario que usted quiere reservar se encuentra ocupado", Toast.LENGTH_SHORT).show();
                finish();
            }
        }else{
            Toast.makeText(this, "Horario inválido", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private Integer getPrecioTotal() {
        Integer precioTotal= 0 ;
        precioTotal= precio_hora;
        Integer index=0;
        for(int i = Integer.parseInt(selected_hora_inicio.split(":")[0]);  i < Integer.parseInt(selected_hora_fin.split(":")[0]); i++){
            if(index<1){
                precioTotal=  precioTotal;
            }else{
                precioTotal= precioTotal+ precioTotal;
            }
            index++;
        }
        return precioTotal;
    }

    private boolean validarHoras() {
        boolean status = true;
        Integer inicio= Integer.parseInt(selected_hora_inicio.split(":")[0]);
        Integer fin = Integer.parseInt(selected_hora_fin.split(":")[0]);
        if(inicio >= fin){
         status= false;
        }
        return status;
    }

    private boolean verificarDisponibilidad() {
        boolean status= true;
        for (int i = 0; i < horas.size(); i++) {
            if (horas.get(i).getHora() >= Integer.parseInt(selected_hora_inicio.split(":")[0])
                    && horas.get(i).getHora() < Integer.parseInt(selected_hora_fin.split(":")[0])) {
               if(horas.get(i).getEstadoHora()==1){
                   status= false;
               }
            }
        }
        return status;
    }




    public ReservaBody getReservaBody() {
        ReservaBody reservaBody =  new ReservaBody();
        reservaBody.setIdCancha(id_cancha);
        reservaBody.setIdUsuario("2");
        reservaBody.setFechaReserva(fecha_reserva);
        reservaBody.setHoraInicio(selected_hora_inicio);
        reservaBody.setHoraFin(selected_hora_fin);
        reservaBody.setCiQuienReserva("8330962");
        reservaBody.setObservaciones(txt_observaciones.getText().toString());
        reservaBody.setModoRegistro("1");
        reservaBody.setNombreReserva("Debbie Zuleta");
        reservaBody.setEstado("1");
        reservaBody.setTotal(getPrecioTotal());
        return reservaBody;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void populateMessage(String message) {
        horariosDisponiblesActivity.activityStatic.finish();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, HorariosDisponiblesActivity.class);
        i.putExtra("id_cancha", id_cancha);
        i.putExtra("nombre_cancha", nombre_cancha);
        i.putExtra("distrito", distrito);
        startActivity(i);
        finish();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        array_horario_inicio.clear();
        array_horario_fin.clear();
        events.clear();
        horas.clear();
        super.onDestroy();
    }

    @Override
    public void showProgressCantidadReservasPendientes() {

    }

    @Override
    public void hideProgressCantidadReservasPendientes() {

    }

    @Override
    public void populateCantidadReservasPendientes(int cantidad) {
        if(cantidad >= 2){
            Toast.makeText(this, "No puedes tener más de dos reservas pendientes", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void showErrorMessageCantidadReservasPendientes(String message) {
       Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
       finish();
    }
}
