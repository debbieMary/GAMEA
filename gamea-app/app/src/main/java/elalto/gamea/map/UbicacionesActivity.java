package elalto.gamea.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import elalto.gamea.R;
import elalto.gamea.map.canchas.view.CanchasFragment;
import elalto.gamea.map.dependencias.view.DependenciasFragment;
import elalto.gamea.map.hospitales.view.HospitalesFragment;
import elalto.gamea.map.modulosPoliciales.view.ModulosFragment;

public class UbicacionesActivity extends AppCompatActivity {
    HospitalesFragment hospitalesFragment;
    CanchasFragment canchasFragment;
    ModulosFragment modulosFragment;
    DependenciasFragment dependenciasFragment;
    Bundle bundle;
    BottomNavigationView ubicaciones;
    BottomNavigationView ubicacionesConSoloCanchas;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.hospitales:
                    setFragment(hospitalesFragment);
                    return true;
                case R.id.canchas:
                    setFragment(canchasFragment);
                    return true;
                case R.id.modulos:
                    setFragment(modulosFragment);
                    return true;
                case R.id.gamea:
                    setFragment(dependenciasFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        bundle= getIntent().getExtras();
        ubicacionesConSoloCanchas = (BottomNavigationView) this.findViewById(R.id.nav_view_just_with_canchas);
        ubicaciones = (BottomNavigationView) this.findViewById(R.id.nav_view);

        hospitalesFragment = new HospitalesFragment();
        canchasFragment = new CanchasFragment();
        modulosFragment = new ModulosFragment();
        dependenciasFragment = new DependenciasFragment();
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        if(bundle.getString("goTo").equals("canchasMap")){
            ubicacionesConSoloCanchas.setVisibility(View.VISIBLE);
            navView.setSelectedItemId(R.id.canchas);

        }else if(bundle.getString("goTo").equals("completeMap")){
            ubicaciones.setVisibility(View.VISIBLE);
            navView.setSelectedItemId(R.id.hospitales);
        }

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_maps, fragment);
        fragmentTransaction.commit();
    }
}
