package elalto.gamea.artesano.productos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import elalto.gamea.R;
import elalto.gamea.artesano.categoria.model.ArtCategoriaInteractorImpl;
import elalto.gamea.artesano.categoria.view.ArtCategoriaActivity;
import elalto.gamea.artesano.productos.adapters.ProductoAdapter;
import elalto.gamea.artesano.productos.model.ArtProductosInteractorImpl;
import elalto.gamea.artesano.productos.model.Producto;
import elalto.gamea.artesano.productos.presenter.ArtProductosPresenter;
import elalto.gamea.artesano.productos.presenter.ArtProductosPresenterImpl;


public class ArtProductosActivity extends AppCompatActivity implements ArtProductosView {
    private ArtProductosPresenter presenter;
    ProgressDialog progressDialog;
    RecyclerView rvProductos;
    ProductoAdapter productoAdapter;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_productos);
        presenter = new ArtProductosPresenterImpl(this, new ArtProductosInteractorImpl());
        rvProductos = (RecyclerView) findViewById(R.id.rv_productos);
        rvProductos.setHasFixedSize(true);
        rvProductos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Intent intent = getIntent();
        String idCategoria = intent.getStringExtra("idCategoria");
        presenter.getProductos(idCategoria);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(ArtProductosActivity.this);
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
        Toast.makeText(this, "Alog salio mal intente nuevamente", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void getProductos(List<Producto> productoList) {
        productoAdapter = new ProductoAdapter(productoList, this);
        rvProductos.setAdapter(productoAdapter);
    }
}
