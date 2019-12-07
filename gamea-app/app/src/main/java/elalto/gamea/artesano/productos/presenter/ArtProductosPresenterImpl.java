package elalto.gamea.artesano.productos.presenter;

import java.util.List;

import elalto.gamea.artesano.categoria.model.ArtCategoriaInteractor;
import elalto.gamea.artesano.productos.model.ArtProductosInteractor;
import elalto.gamea.artesano.productos.model.Producto;
import elalto.gamea.artesano.productos.view.ArtProductosView;

public class ArtProductosPresenterImpl implements ArtProductosPresenter, ArtProductosInteractor.onProductosFinishedListener {
    private ArtProductosView artProductosView;
    private ArtProductosInteractor artProductosInteractor;

    public ArtProductosPresenterImpl(ArtProductosView artProductosView, ArtProductosInteractor artProductosInteractor) {
        this.artProductosView = artProductosView;
        this.artProductosInteractor = artProductosInteractor;
    }

    @Override
    public void onSuccess(List<Producto> productos) {
        if (artProductosView != null) {
            artProductosView.hideProgress();
            artProductosView.getProductos(productos);
        }
    }

    @Override
    public void onFailed() {
        if (artProductosView != null) {
            artProductosView.hideProgress();
            artProductosView.navigateToBack();
        }
    }

    @Override
    public void getProductos(String idCategoria) {
        if (artProductosView != null) {
            artProductosView.showProgress();
            artProductosInteractor.getProductos(idCategoria, this);
        }
    }

    @Override
    public void onDestroy() {
        artProductosView = null;
    }
}
