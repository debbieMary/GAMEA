package elalto.gamea.denuncia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import elalto.gamea.R;
import elalto.gamea.denuncia.misreportes.view.MisReportesFragment;
import elalto.gamea.denuncia.reportar.view.ReportarFragment;

public class DenunciaActivity extends AppCompatActivity {
    ReportarFragment reportarFragment;
    MisReportesFragment misReportesFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.reportar:
                    setFragment(reportarFragment);
                    return true;
                case R.id.misreportes:
                    setFragment(misReportesFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        reportarFragment = new ReportarFragment();
        misReportesFragment = new MisReportesFragment();
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.reportar);
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}