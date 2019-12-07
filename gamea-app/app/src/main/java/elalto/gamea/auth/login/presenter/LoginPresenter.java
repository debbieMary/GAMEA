package elalto.gamea.auth.login.presenter;

public interface LoginPresenter {
    void validateCredentials(String ci, String password);

    void onDestroy();
}
