package elalto.gamea.map.canchas.presenter;

import elalto.network.entities.TokenManager;

public interface CanchasPresenter {
    void getCanchas(TokenManager tokenManager);

    void onDestroy();
}
