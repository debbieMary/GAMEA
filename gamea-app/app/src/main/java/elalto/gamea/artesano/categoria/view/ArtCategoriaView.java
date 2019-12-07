package elalto.gamea.artesano.categoria.view;

import java.util.List;

import elalto.gamea.artesano.categoria.model.Categoria;

public interface ArtCategoriaView {
    void showProgress();

    void hideProgress();

    void navigateToBack();

    void getCategorias(List<Categoria> categoriaList);
}
