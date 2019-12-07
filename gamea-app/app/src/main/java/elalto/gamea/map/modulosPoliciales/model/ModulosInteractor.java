package elalto.gamea.map.modulosPoliciales.model;

import java.util.List;

import elalto.gamea.map.modulosPoliciales.entities.Modulos;
import elalto.network.entities.TokenManager;

public interface ModulosInteractor {
    interface onModulosFinishedListener {
        void onSuccess(List<Modulos> modulosList);

        void onFailed(String message);
    }

    void getModulos(TokenManager tokenManager, onModulosFinishedListener listener);
}
