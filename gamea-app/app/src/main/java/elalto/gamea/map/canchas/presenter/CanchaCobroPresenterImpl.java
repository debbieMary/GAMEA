package elalto.gamea.map.canchas.presenter;

import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.gamea.map.canchas.model.CanchaCobroInteractor;
import elalto.gamea.map.canchas.model.CanchasInteractor;
import elalto.gamea.map.canchas.view.CanchaCobroView;
import elalto.gamea.map.canchas.view.CanchasView;
import elalto.network.entities.TokenManager;

public class CanchaCobroPresenterImpl implements CanchaCobroPresenter, CanchaCobroInteractor.onCobroFinishedListener {
    private CanchaCobroView canchaCobroView;
    private CanchaCobroInteractor canchaCobroInteractor;

    public CanchaCobroPresenterImpl(CanchaCobroView canchaCobroView, CanchaCobroInteractor canchaCobroInteractor) {
        this.canchaCobroView = canchaCobroView;
        this.canchaCobroInteractor = canchaCobroInteractor;
    }


    @Override
    public void onSuccessCC(List<CanchaCobro> canchaCobroList) {
        if (canchaCobroView != null) {
            canchaCobroView.hideProgressCC();
            canchaCobroView.populateMapCC(canchaCobroList);
        }
    }

    @Override
    public void onFailedCC(String message) {
        if (canchaCobroView != null) {
            canchaCobroView.hideProgressCC();
            canchaCobroView.showErrorMessageCC(message);
        }
    }

    @Override
    public void getCobros(TokenManager tokenManager) {
        canchaCobroInteractor.getCobros(tokenManager, this);
        if (canchaCobroView != null) {
            canchaCobroView.showProgressCC();
        }
    }

    @Override
    public void onDestroyCC() {
      canchaCobroView = null;
    }
}
