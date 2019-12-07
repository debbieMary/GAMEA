package elalto.gamea.artesano.productos.view;

import java.util.List;

import elalto.gamea.artesano.productos.model.Producto;

public interface ArtProductosView {
    void showProgress();

    void hideProgress();

    void navigateToBack();

    void getProductos(List<Producto> productoList);
}
