package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import elalto.gamea.R;

public class DeleteReservaActivity extends AppCompatActivity {

    Bundle bundle;
    Integer id_reserva;
    String nombre_cancha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_reserva);
        bundle = getIntent().getExtras();
        id_reserva= bundle.getInt("id_reserva");
        nombre_cancha= bundle.getString("nombre_cancha");
        Toast.makeText(this, id_reserva +" "+ nombre_cancha, Toast.LENGTH_LONG).show();
    }
}
