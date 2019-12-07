package elalto.gamea.auth.login.presenter;

import elalto.gamea.auth.login.model.LoginInteractor;
import elalto.gamea.auth.login.view.LoginView;
import elalto.network.entities.AccessToken;
import elalto.network.entities.LoginError;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void validateCredentials(String ci, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(ci, password, this);
    }

    @Override
    public void onCierror() {
        if (loginView != null) {
            loginView.setCiError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(AccessToken accessToken) {
        if (loginView != null) {
            loginView.navigateToHome(accessToken);
            loginView.hideProgress();
        }
    }

    @Override
    public void onFailed(LoginError loginError) {
        if (loginView != null) {
            loginView.showError(loginError);
            loginView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
