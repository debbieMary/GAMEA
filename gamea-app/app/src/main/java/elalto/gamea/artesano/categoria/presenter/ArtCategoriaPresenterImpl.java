package elalto.gamea.artesano.categoria.presenter;

import java.util.List;

import elalto.gamea.artesano.categoria.model.ArtCategoriaInteractor;
import elalto.gamea.artesano.categoria.model.Categoria;
import elalto.gamea.artesano.categoria.view.ArtCategoriaView;

public class ArtCategoriaPresenterImpl implements ArtCategoriaPresenter, ArtCategoriaInteractor.OnCategoriaFinishedListener {

    private ArtCategoriaView artCategoriaView;
    private ArtCategoriaInteractor artCategoriaInteractor;

    public ArtCategoriaPresenterImpl(ArtCategoriaView artCategoriaView, ArtCategoriaInteractor artCategoriaInteractor) {
        this.artCategoriaView = artCategoriaView;
        this.artCategoriaInteractor = artCategoriaInteractor;
    }

    @Override
    public void onSuccess(List<Categoria> categorias) {
        if (artCategoriaView != null) {
            artCategoriaView.hideProgress();
            artCategoriaView.getCategorias(categorias);
        }
    }

    @Override
    public void onFailed() {
        if (artCategoriaView != null) {
            artCategoriaView.navigateToBack();
            artCategoriaView.hideProgress();
        }
    }

    @Override
    public void getCategorias() {
        if (artCategoriaView != null) {
            artCategoriaView.showProgress();
            artCategoriaInteractor.getCategorias(this);
        }
    }

    @Override
    public void onDestroy() {
        artCategoriaView = null;
    }
}
