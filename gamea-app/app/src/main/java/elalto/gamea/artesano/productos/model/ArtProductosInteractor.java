package elalto.gamea.artesano.productos.model;

import java.util.List;

public interface ArtProductosInteractor {
    interface onProductosFinishedListener {
        void onSuccess(List<Producto> productos);

        void onFailed();
    }

    void getProductos(String idCategoria, onProductosFinishedListener listener);
}
