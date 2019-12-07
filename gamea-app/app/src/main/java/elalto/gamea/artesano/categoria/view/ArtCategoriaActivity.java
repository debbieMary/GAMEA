package elalto.gamea.artesano.categoria.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.artesano.categoria.adapters.CategoriaAdapter;
import elalto.gamea.artesano.categoria.model.ArtCategoriaInteractorImpl;
import elalto.gamea.artesano.categoria.model.Categoria;
import elalto.gamea.artesano.categoria.presenter.ArtCategoriaPresenter;
import elalto.gamea.artesano.categoria.presenter.ArtCategoriaPresenterImpl;
import elalto.gamea.home.view.HomeActivity;

public class ArtCategoriaActivity extends AppCompatActivity implements ArtCategoriaView {
    private ArtCategoriaPresenter presenter;
    RecyclerView rvCategorias;
    CategoriaAdapter categoriaAdapter;
    ProgressDialog progressDialog;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_categoria);
        presenter = new ArtCategoriaPresenterImpl(this, new ArtCategoriaInteractorImpl());
        ButterKnife.bind(this);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Plataforma Artesanal Productiva");
        setSupportActionBar(toolbar);
        rvCategorias = (RecyclerView) findViewById(R.id.rv_categoria);
        rvCategorias.setHasFixedSize(true);
        rvCategorias.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        presenter.getCategorias();
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(ArtCategoriaActivity.this);
        progressDialog.setTitle("Cargando");
        progressDialog.setMessage("Obteniendo informacion...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void navigateToBack() {
        finish();
    }


    @Override
    public void getCategorias(List<Categoria> categoriaList) {
        categoriaAdapter = new CategoriaAdapter(categoriaList, this);
        rvCategorias.setAdapter(categoriaAdapter);
    }
}
