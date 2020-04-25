package elalto.gamea.map.canchas.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import elalto.gamea.R;

public class PopupCanchaTicket extends Activity {

	Bundle bundle;

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
		getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
		bundle= getIntent().getExtras();

		lbl_nombre= (TextView) this.findViewById(R.id.lbl_nombre);
		lbl_nombre.setText(bundle.getString("nombre"));

		lbl_distrito= (TextView) this.findViewById(R.id.lbl_distrito);
        lbl_distrito.setText(bundle.getString("distrito"));

		lbl_id_reserva= (TextView) this.findViewById(R.id.lbl_id_reserva);
		lbl_id_reserva.setText(bundle.getString("id_reserva"));

		lbl_fecha= (TextView) this.findViewById(R.id.lbl_fecha);
		lbl_fecha.setText(bundle.getString("fecha").split("T")[0]);

		lbl_hora_inicio= (TextView) this.findViewById(R.id.lbl_hora_inicio);
		lbl_hora_inicio.setText(bundle.getString("hora_inicio"));

		lbl_hora_fin= (TextView) this.findViewById(R.id.lbl_hora_fin);
		lbl_hora_fin.setText(bundle.getString("hora_fin"));

		lbl_ci_quien_reserva= (TextView) this.findViewById(R.id.lbl_ci_quien_reserva);
		lbl_ci_quien_reserva.setText(bundle.getString("ci_quien_reserva"));

		lbl_nombre_reserva= (TextView) this.findViewById(R.id.lbl_nombre_reserva);
		lbl_nombre_reserva.setText(bundle.getString("nombre_reserva"));

		lbl_observaciones= (TextView) this.findViewById(R.id.lbl_observaciones);
		lbl_observaciones.setText(bundle.getString("observaciones"));

	}


    public void closePopup(View v){
	    finish();
    }

}
