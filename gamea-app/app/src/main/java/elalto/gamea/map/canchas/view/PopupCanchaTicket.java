package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.MisReservas;

public class PopupCanchaTicket extends Activity {

	Bundle bundle;
	//ArrayList<MisReservas> misReservas= new ArrayList<MisReservas>();
	//int position;

	TextView lbl_nombre;
	TextView lbl_distrito;
	TextView lbl_id_reserva;
	TextView lbl_fecha;
	TextView lbl_hora_inicio;
	TextView lbl_hora_fin;
	TextView lbl_ci_quien_reserva;
	TextView lbl_nombre_reserva;
	TextView lbl_observaciones;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_cancha_ticket);
		getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
		bundle= getIntent().getExtras();

		lbl_nombre= (TextView) this.findViewById(R.id.lbl_nombre);
		lbl_nombre.setText(bundle.getString("nombre"));

		lbl_distrito= (TextView) this.findViewById(R.id.lbl_distrito);
        lbl_nombre.setText(bundle.getString("distrito"));

		lbl_id_reserva= (TextView) this.findViewById(R.id.lbl_id_reserva);
		lbl_id_reserva.setText(bundle.getString("id_reserva"));

		lbl_fecha= (TextView) this.findViewById(R.id.lbl_fecha);
		lbl_fecha.setText(bundle.getString("fecha"));
	}



    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup_cancha_ticket);
        getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }*/
}
