package elalto.gamea.map.modulosPoliciales.presenter;

import elalto.network.entities.TokenManager;

public interface ModulosPresenter {
    void getModulos(TokenManager tokenManager);

    void onDestroy();
}
