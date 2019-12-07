package elalto.gamea.recaudaciones.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.recaudaciones.entities.PatentePublicidad;
import elalto.gamea.recaudaciones.inmueble.view.InmuebleActivity;
import elalto.gamea.recaudaciones.patente.view.PatenteActivity;
import elalto.gamea.recaudaciones.patentepublicidad.view.PatentePublicidadActivity;
import elalto.gamea.recaudaciones.vehiculo.view.VehiculoActivity;

public class RecaudacionesActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.linear_vehiculo)
    LinearLayout linearVehiculo;
    @BindView(R.id.linear_inmueble)
    LinearLayout linearInmueble;
    @BindView(R.id.linear_patente)
    LinearLayout linearPatente;
    @BindView(R.id.linear_patente_publicidad)
    LinearLayout linearPatentePublicidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recaudaciones);
        ButterKnife.bind(this);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("RECAUDACIONES");
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.linear_vehiculo)
    public void navigateToConsultaTramite() {
        Intent intent = new Intent(this, VehiculoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.linear_inmueble)
    public void navigateToConsultaInmueble() {
        Intent intent = new Intent(this, InmuebleActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.linear_patente)
    public void navigateToPatente() {
        Intent intent = new Intent(this, PatenteActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.linear_patente_publicidad)
    public void navigateToPatenePublicidad(){
        Intent intent = new Intent(this, PatentePublicidadActivity.class);
        startActivity(intent);
    }
}
