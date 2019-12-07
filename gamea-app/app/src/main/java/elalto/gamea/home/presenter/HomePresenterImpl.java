package elalto.gamea.home.presenter;

import elalto.gamea.home.model.HomeInteractor;
import elalto.gamea.home.view.HomeView;
import elalto.network.entities.TokenManager;

public class HomePresenterImpl implements HomePresenter, HomeInteractor.OnLogoutFinishedListener, HomeInteractor.onSendFinishedListener {
    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresenterImpl(HomeView homeView, HomeInteractor homeInteractor) {
        this.homeView = homeView;
        this.homeInteractor = homeInteractor;
    }

    @Override
    public void logout(TokenManager tokenManager) {
        if (homeView != null) {
        }
        homeInteractor.logout(tokenManager, this);

    }

    @Override
    public void sendSugerencia(TokenManager tokenManager, String sugerencia) {
        homeInteractor.sendSugerencia(tokenManager, sugerencia, this);
    }

    @Override
    public void onSuccess() {
        if (homeView != null) {
            homeView.logout();
        }
    }

    @Override
    public void onDestroy() {
        homeView = null;
    }

    @Override
    public void onSuccessSend(String message) {
        homeView.succesSend(message);
    }

    @Override
    public void onErrorSend(String message) {
        homeView.errorSend(message);
    }
}
