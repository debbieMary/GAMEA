package elalto.gamea.yayo.listperson.presenter;

import elalto.network.entities.TokenManager;

public interface ListPersonPresenter {
    void getDesaparecidos(TokenManager tokenManager);

    void onDestroy();
}
