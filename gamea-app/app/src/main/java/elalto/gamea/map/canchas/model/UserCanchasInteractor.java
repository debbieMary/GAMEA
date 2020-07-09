package elalto.gamea.map.canchas.model;

import android.service.autofill.UserData;

import java.util.List;

import elalto.network.canchas.entities.ListarUserBody;
import elalto.network.canchas.entities.UserCanchas;

public interface UserCanchasInteractor {
    interface onFinishedListener {
        void onSuccess(List<UserCanchas> userData);

        void onFailed(String message);
    }

    void getUserCanchas(ListarUserBody listarUserBody, onFinishedListener listener);
}
