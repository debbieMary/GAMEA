package elalto.gamea.auth.login.model;

import elalto.network.entities.AccessToken;
import elalto.network.entities.LoginError;

public interface LoginInteractor {
    interface OnLoginFinishedListener {
        void onCierror();

        void onPasswordError();

        void onSuccess(AccessToken accessToken);

        void onFailed(LoginError loginError);
    }

    void login(String ci, String password, OnLoginFinishedListener listener);
}
