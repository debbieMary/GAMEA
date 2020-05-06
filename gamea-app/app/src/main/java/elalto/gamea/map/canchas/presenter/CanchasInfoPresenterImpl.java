package elalto.gamea.map.canchas.presenter;

import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.canchas.entities.CanchaInfo;
import elalto.gamea.map.canchas.model.CanchasInfoInteractor;
import elalto.gamea.map.canchas.model.CanchasInteractor;
import elalto.gamea.map.canchas.view.CanchasInfoView;
import elalto.gamea.map.canchas.view.CanchasView;
import elalto.network.entities.TokenManager;

public class CanchasInfoPresenterImpl implements CanchasInfoPresenter, CanchasInfoInteractor.onCanchasInfoFinishedListener {
    private CanchasInfoView canchasInfoView;
    private CanchasInfoInteractor canchasInfoInteractor;

    public CanchasInfoPresenterImpl(CanchasInfoView canchasInfoView, CanchasInfoInteractor canchasInfoInteractor) {
        this.canchasInfoView = canchasInfoView;
        this.canchasInfoInteractor = canchasInfoInteractor;
    }

    @Override
    public void onSuccess(List<CanchaInfo> canchaInfo) {
        if (canchasInfoView != null) {
            canchasInfoView.hideProgress();
            canchasInfoView.populateInfo(canchaInfo);
        }
    }

    @Override
    public void onFailed(String message) {
        if (canchasInfoView != null) {
            canchasInfoView.hideProgress();
            canchasInfoView.showErrorMessage(message);
        }
    }

    @Override
    public void getCanchasInfo(String id_cancha) {
        canchasInfoInteractor.getCanchasInfo(id_cancha, this);
        if (canchasInfoView != null) {
            canchasInfoView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        canchasInfoView = null;
    }
}
