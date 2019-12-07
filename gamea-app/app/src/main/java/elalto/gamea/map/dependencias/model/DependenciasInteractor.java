package elalto.gamea.map.dependencias.model;

import java.util.List;

import elalto.gamea.map.dependencias.entities.Dependencias;

public interface DependenciasInteractor {
    interface onDependenciasFinishedListener {
        void onSuccess(List<Dependencias> dependencias);

        void onFailed(String message);
    }

    void getDependencias(onDependenciasFinishedListener listener);
}
