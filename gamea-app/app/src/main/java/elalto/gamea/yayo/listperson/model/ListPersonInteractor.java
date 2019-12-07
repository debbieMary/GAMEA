package elalto.gamea.yayo.listperson.model;

import java.util.List;

import elalto.gamea.yayo.listperson.entities.Desaparecido;
import elalto.network.entities.TokenManager;

public interface ListPersonInteractor {
    interface OnLisPersonFinishedListener{
        void onSuccess(List<Desaparecido>desaparecidoList);
        void onFailed(String message);
    }
    void getDesaparecidos(TokenManager tokenManager, OnLisPersonFinishedListener listener);
}
