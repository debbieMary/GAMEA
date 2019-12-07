package elalto.gamea.testviolencia.dondeacudir.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.map.dependencias.adapter.DependenciasAdapter;
import elalto.gamea.map.dependencias.entities.Dependencias;
import elalto.gamea.testviolencia.dondeacudir.AdapterUbicaciones;
import elalto.gamea.testviolencia.dondeacudir.Ubicaciones;
import elalto.gamea.testviolencia.dondeacudir.model.DondeAcudirInteractorImpl;
import elalto.gamea.testviolencia.dondeacudir.presenter.DondeAcudirPresenter;
import elalto.gamea.testviolencia.dondeacudir.presenter.DondeAcudirPresenterImpl;
import es.dmoral.toasty.Toasty;

public class DondeAcudirActivity extends AppCompatActivity implements DondeAcudirView, AdapterUbicaciones.AdapterUbicacionesListener {
    ArrayList<Ubicaciones> ubicacions;
    Toolbar toolbar;
    @BindView(R.id.recicler_ubicaciones)
    RecyclerView recycler_ubicaciones;
    ProgressDialog progressDialog;
    private DondeAcudirPresenter presenter;
    AdapterUbicaciones adapterUbicaciones;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donde_acudir);
        ButterKnife.bind(this);
        presenter = new DondeAcudirPresenterImpl(this, new DondeAcudirInteractorImpl());
        recycler_ubicaciones.setHasFixedSize(true);
        recycler_ubicaciones.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        init();
        presenter.getUbicaciones();
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lugares donde acudir");
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Obteniendo informacion...");
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showErrorMessage(String message) {
        Toasty.warning(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(List<Ubicaciones> ubicacionesList) {
        adapterUbicaciones = new AdapterUbicaciones((ArrayList<Ubicaciones>) ubicacionesList, getApplicationContext(), (AdapterUbicaciones.AdapterUbicacionesListener) this);
        recycler_ubicaciones.setAdapter(adapterUbicaciones);
    }


    @Override
    public void callDependencia(Ubicaciones ubicaciones) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + String.valueOf(ubicaciones.getCelular())));
        startActivity(intent);
    }

    @Override
    public void navigateToMap(Ubicaciones ubicaciones) {
        Toasty.info(this, ubicaciones.getNombre().toString(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MapUbicacionesActivity.class);
        intent.putExtra("ubicaciones", ubicaciones);
        this.startActivity(intent);
    }
}