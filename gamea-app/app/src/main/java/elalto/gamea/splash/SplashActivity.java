package elalto.gamea.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import elalto.gamea.R;
import elalto.gamea.testviolencia.AcosoSexualActivity;
import elalto.gamea.testviolencia.BullyingActivity;
import elalto.gamea.testviolencia.RelacionViolentaActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Bundle bundle = getIntent().getExtras();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (bundle.get("tipo").toString()) {
                    case "bullying":
                        startActivity(new Intent(SplashActivity.this, BullyingActivity.class));
                        break;
                    case "relacion_violenta":
                        startActivity(new Intent(SplashActivity.this, RelacionViolentaActivity.class));
                        break;
                    case "acoso":
                        startActivity(new Intent(SplashActivity.this, AcosoSexualActivity.class
                        ));
                        break;
                    default:
                        break;
                }
                finish();
            }
        }, 1000);
    }
}
