package elalto.gamea.map.canchas.presenter;

import java.util.List;

import elalto.gamea.map.canchas.model.CanchasInteractor;
import elalto.gamea.map.canchas.view.CanchasView;
import elalto.network.canchas.entities.Cancha;
import elalto.network.entities.TokenManager;

public class CanchasPresenterImpl implements CanchasPresenter, CanchasInteractor.onCanchasFinishedListener {
    private CanchasView canchasView;
    private CanchasInteractor canchasInteractor;

    public CanchasPresenterImpl(CanchasView canchasView, CanchasInteractor canchasInteractor) {
        this.canchasView = canchasView;
        this.canchasInteractor = canchasInteractor;
    }

    @Override
    public void onSuccess(List<Cancha> canchaList) {
        if (canchasView != null) {
            canchasView.hideProgress();
            canchasView.populateMap(canchaList);
        }
    }

    @Override
    public void onFailed(String message) {
        if (canchasView != null) {
            canchasView.hideProgress();
            canchasView.showErrorMessage(message);
        }
    }

    @Override
    public void getCanchas(TokenManager tokenManager) {
        canchasInteractor.getCanchas(tokenManager, this);
        if (canchasView != null) {
            canchasView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        canchasView = null;
    }
}
