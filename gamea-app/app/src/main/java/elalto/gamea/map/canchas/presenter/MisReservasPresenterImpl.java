package elalto.gamea.map.canchas.presenter;

import java.util.List;

import elalto.gamea.map.canchas.model.MisReservasInteractor;
import elalto.gamea.map.canchas.view.MisReservasView;
import elalto.network.canchas.entities.MisReservas;
import elalto.network.canchas.entities.IdUsuarioBody;

public class MisReservasPresenterImpl implements MisReservasPresenter, MisReservasInteractor.onMisReservasFinishedListener {
    private MisReservasView misReservasView;
    private MisReservasInteractor misReservasInteractor;

    public MisReservasPresenterImpl(MisReservasView misReservasView, MisReservasInteractor misReservasInteractor) {
        this.misReservasView = misReservasView;
        this.misReservasInteractor = misReservasInteractor;
    }


    @Override
    public void onSuccess(List<MisReservas> misReservas) {
        if (misReservasView != null) {
            misReservasView.hideProgress();
            misReservasView.populateMisReservas(misReservas);
        }
    }

    @Override
    public void onFailed(String message) {
        if (misReservasView != null) {
            misReservasView.hideProgress();
            misReservasView.showErrorMessage(message);
        }
    }



    @Override
    public void getMisReservas(IdUsuarioBody idUsuarioBody) {
        misReservasInteractor.getMisReservas(idUsuarioBody, this);
        if (misReservasView != null) {
            misReservasView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        misReservasView = null;
    }
}
