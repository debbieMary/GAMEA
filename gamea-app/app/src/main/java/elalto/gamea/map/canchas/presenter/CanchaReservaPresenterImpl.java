package elalto.gamea.map.canchas.presenter;

import java.util.List;

import elalto.gamea.map.canchas.entities.CanchaInfo;
import elalto.gamea.map.canchas.model.CanchaReservaInteractor;
import elalto.gamea.map.canchas.model.CanchasInfoInteractor;
import elalto.gamea.map.canchas.view.CanchaReservaView;
import elalto.gamea.map.canchas.view.CanchasInfoView;

public class CanchaReservaPresenterImpl implements CanchaReservaPresenter, CanchaReservaInteractor.onCanchasReservaFinishedListener {
    private CanchaReservaView canchaReservaView;
    private CanchaReservaInteractor canchaReservaInteractor;

    public CanchaReservaPresenterImpl(CanchaReservaView canchaReservaView, CanchaReservaInteractor canchaReservaInteractor) {
        this.canchaReservaView = canchaReservaView;
        this.canchaReservaInteractor = canchaReservaInteractor;
    }

    @Override
    public void onSuccess(String message) {
        if (canchaReservaView != null) {
            canchaReservaView.hideProgress();
            canchaReservaView.populateMessage(message);
        }
    }

    @Override
    public void onFailed(String message) {
        if (canchaReservaView != null) {
            canchaReservaView.hideProgress();
            canchaReservaView.showErrorMessage(message);
        }
    }


    @Override
    public void saveCanchasReserva(String reserva) {
        canchaReservaInteractor.saveCanchasReserva(reserva, this);
        if (canchaReservaView != null) {
            canchaReservaView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        canchaReservaView = null;
    }
}
