package elalto.gamea.testviolencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import elalto.gamea.R;
import elalto.gamea.splash.SplashActivity;

public class TestViolenciaActivity extends AppCompatActivity {
    ImageView img_bullying, img_relacion_violenta, img_acoso, img_conoce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_violencia);
        init();
    }

    private void init() {
        img_bullying = (ImageView) findViewById(R.id.img_bullying);
        img_bullying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tipo", "bullying");
                startActivity(new Intent(TestViolenciaActivity.this, SplashActivity.class).putExtras(bundle));
            }
        });

        img_relacion_violenta = (ImageView) findViewById(R.id.img_relacion_violenta);
        img_relacion_violenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tipo", "relacion_violenta");
                startActivity(new Intent(TestViolenciaActivity.this, SplashActivity.class).putExtras(bundle));
            }
        });

        img_acoso = (ImageView) findViewById(R.id.img_acoso);
        img_acoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tipo", "acoso");
                startActivity(new Intent(TestViolenciaActivity.this, SplashActivity.class).putExtras(bundle));
            }
        });
        img_conoce = (ImageView) findViewById(R.id.img_conoce);
        img_conoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestViolenciaActivity.this, ConocePrevieneActivity.class));
            }
        });

    }
}
