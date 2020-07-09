package elalto.gamea.map.canchas.presenter;

import elalto.network.canchas.entities.IdUsuarioBody;
import elalto.network.canchas.entities.ListarUserBody;

public interface UserCanchasPresenter {
    void getUser(ListarUserBody listarUserBody);
    void onDestroy();
}
