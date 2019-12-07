package elalto.gamea.auth.login.view;

import elalto.network.entities.AccessToken;
import elalto.network.entities.LoginError;

public interface LoginView {
    void showProgress();
    void showError(LoginError loginError);
    void hideProgress();
    void setCiError();
    void setPasswordError();
    void navigateToHome(AccessToken accessToken);
}
