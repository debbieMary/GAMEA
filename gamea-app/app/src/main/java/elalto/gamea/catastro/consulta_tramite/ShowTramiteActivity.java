package elalto.gamea.catastro.consulta_tramite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;


import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.catastro.consulta_tramite.adapter.PageTramiteAdapter;
import elalto.gamea.catastro.consulta_tramite.entities.Tramite;


public class ShowTramiteActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tramite);
        ButterKnife.bind(this);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("SEGUIMIENTO DE TRAMITES CATASTRO");
        setSupportActionBar(toolbar);
        Tramite tramite = (Tramite) getIntent().getExtras().getSerializable("tramite");

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("TRAMITE"));
        tabLayout.addTab(tabLayout.newTab().setText("FLUJO DEL TRAMITE"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) findViewById(R.id.pager);

        PageTramiteAdapter pageTramiteAdapter = new PageTramiteAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), tramite);
        viewPager.setAdapter(pageTramiteAdapter);
        tabLayout.setOnTabSelectedListener(this);

    }


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
}
