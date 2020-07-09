package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.network.canchas.entities.CanchaCobro;
import elalto.network.canchas.entities.UserCanchas;

public interface UserCanchasView {
    void showProgress();

    void hideProgress();

    void populateUser(List<UserCanchas> userCanchas);

    void showErrorMessage(String message);
}
