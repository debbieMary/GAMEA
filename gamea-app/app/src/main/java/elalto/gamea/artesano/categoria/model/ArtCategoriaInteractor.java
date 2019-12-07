package elalto.gamea.artesano.categoria.model;

import java.util.List;

public interface ArtCategoriaInteractor {
    interface OnCategoriaFinishedListener{
        void onSuccess(List<Categoria> categorias);
        void onFailed();
    }

    void getCategorias(OnCategoriaFinishedListener listener);
}
