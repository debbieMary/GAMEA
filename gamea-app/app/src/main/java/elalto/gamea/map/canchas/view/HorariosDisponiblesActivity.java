package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import elalto.gamea.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HorariosDisponiblesActivity extends AppCompatActivity {
    Toolbar toolbar;
    Bundle bundle;
    String id_cancha;
    String distrito;
    String nombre_cancha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios_disponibles);
        bundle= getIntent().getExtras();
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HOARARIOS DISPONIBLES");
        id_cancha=bundle.getString("id_cancha");
        nombre_cancha=bundle.getString("nombre_cancha");
        distrito=bundle.getString("distrito");
    }

   public void reservarCancha(View  v){
       Intent i= new  Intent(this, ReservarCanchaActivity.class);
       i.putExtra("id_cancha",  id_cancha);
       i.putExtra("nombre_cancha",  nombre_cancha);
       i.putExtra("distrito",  distrito);
       startActivity(i);
   }

}
