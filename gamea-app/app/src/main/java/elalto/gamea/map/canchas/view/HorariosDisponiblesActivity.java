package elalto.gamea.map.canchas.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import elalto.gamea.R;
import elalto.gamea.map.canchas.view.Adapters.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class HorariosDisponiblesActivity extends AppCompatActivity {
    Toolbar toolbar;
    Bundle bundle;
    String id_cancha;
    String distrito;
    String nombre_cancha;

    private Calendar fechaYhora = Calendar.getInstance();
    SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");



    String fecha_actual;
    String fecha_manhiana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios_disponibles);
        bundle = getIntent().getExtras();
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("HOARARIOS DISPONIBLES");
        id_cancha = bundle.getString("id_cancha");
        nombre_cancha = bundle.getString("nombre_cancha");
        distrito = bundle.getString("distrito");

        fecha_actual = fecha.format(fechaYhora.getTime());
        fechaYhora.add(Calendar.DATE, 1);
        fecha_manhiana = fecha.format(fechaYhora.getTime());
        Log.e("$$$-FECHA ACTUAL-$$$$$", fecha_actual);
        Log.e("$$$-FECHA MANHIA-$$$$$", fecha_manhiana);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(fecha_actual));
        tabLayout.addTab(tabLayout.newTab().setText(fecha_manhiana));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    public void reservarCancha(View v) {
        Intent i = new Intent(this, ReservarCanchaActivity.class);
        i.putExtra("id_cancha", id_cancha);
        i.putExtra("nombre_cancha", nombre_cancha);
        i.putExtra("distrito", distrito);
        startActivity(i);
    }

}
