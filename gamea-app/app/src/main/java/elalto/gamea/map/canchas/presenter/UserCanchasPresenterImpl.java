package elalto.gamea.map.canchas.presenter;

import java.util.List;

import elalto.gamea.map.canchas.model.UserCanchasInteractor;
import elalto.gamea.map.canchas.view.UserCanchasView;
import elalto.network.canchas.entities.ListarUserBody;
import elalto.network.canchas.entities.UserCanchas;

public class UserCanchasPresenterImpl implements UserCanchasPresenter, UserCanchasInteractor.onFinishedListener {
    private UserCanchasView userCanchasView;
    private UserCanchasInteractor userCanchasInteractor;

    public UserCanchasPresenterImpl(UserCanchasView userCanchasView, UserCanchasInteractor userCanchasInteractor) {
        this.userCanchasView = userCanchasView;
        this.userCanchasInteractor = userCanchasInteractor;
    }


    @Override
    public void onSuccess(List<UserCanchas> userData) {
        if (userCanchasView != null) {
            userCanchasView.hideProgress();
            userCanchasView.populateUser(userData);
        }
    }


    @Override
    public void onFailed(String message) {
        if (userCanchasView != null) {
            userCanchasView.hideProgress();
            userCanchasView.showErrorMessage(message);
        }
    }


    @Override
    public void getUser(ListarUserBody listarUserBody) {
        userCanchasInteractor.getUserCanchas(listarUserBody, this);
        if (userCanchasView != null) {
            userCanchasView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        userCanchasView = null;
    }
}
