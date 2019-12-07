package elalto.gamea.testviolencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import elalto.gamea.R;
import elalto.gamea.testviolencia.contacto.view.ContactoActivity;
import elalto.gamea.testviolencia.dondeacudir.view.DondeAcudirActivity;

public class ConocePrevieneActivity extends AppCompatActivity {
    LinearLayout linear_info_violencia, linear_caso_violencia, linear_acudir_violencia, linear_comunicate;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conoce_previene);
        init();
    }
    private void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("¿Conoce y previene?");
        linear_info_violencia = (LinearLayout)findViewById(R.id.linear_info_violencia);
        linear_caso_violencia = (LinearLayout)findViewById(R.id.linear_caso_violencia);
        linear_acudir_violencia = (LinearLayout)findViewById(R.id.linear_acudir_violencia);
        linear_comunicate = (LinearLayout)findViewById(R.id.linear_comunicate);
        linear_info_violencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConocePrevieneActivity.this,InfoViolenciaActivity.class));
            }
        });
        linear_caso_violencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConocePrevieneActivity.this, CasoViolenciaActivity.class));
            }
        });
        linear_acudir_violencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConocePrevieneActivity.this, DondeAcudirActivity.class));
            }
        });
        linear_comunicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConocePrevieneActivity.this, ContactoActivity.class));
            }
        });
    }
}
