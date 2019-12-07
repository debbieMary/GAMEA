package elalto.gamea.home.model;

import elalto.network.entities.AccessToken;
import elalto.network.entities.TokenManager;

public interface HomeInteractor {
    interface OnLogoutFinishedListener{
        void onSuccess();
    }

    interface onSendFinishedListener{
        void onSuccessSend(String message);
        void onErrorSend(String message);
    }
    void logout(TokenManager tokenManager, OnLogoutFinishedListener listener);

    void sendSugerencia(TokenManager tokenManager, String sugerencia,  onSendFinishedListener listener);
}
