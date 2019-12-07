package elalto.gamea.home.presenter;

import elalto.network.entities.TokenManager;

public interface HomePresenter {
    void logout(TokenManager tokenManager);
    void sendSugerencia(TokenManager tokenManager, String sugerencia);
    void onDestroy();
}
