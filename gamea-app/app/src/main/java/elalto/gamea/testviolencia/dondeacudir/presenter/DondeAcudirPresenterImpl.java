package elalto.gamea.testviolencia.dondeacudir.presenter;

import java.util.List;

import elalto.gamea.testviolencia.dondeacudir.Ubicaciones;
import elalto.gamea.testviolencia.dondeacudir.model.DondeAcudirInteractor;
import elalto.gamea.testviolencia.dondeacudir.view.DondeAcudirView;

public class DondeAcudirPresenterImpl implements DondeAcudirPresenter, DondeAcudirInteractor.onDondeAcudirFinishedListener {
    private DondeAcudirView dondeAcudirView;
    private DondeAcudirInteractor dondeAcudirInteractor;

    public DondeAcudirPresenterImpl(DondeAcudirView dondeAcudirView, DondeAcudirInteractor dondeAcudirInteractor) {
        this.dondeAcudirView = dondeAcudirView;
        this.dondeAcudirInteractor = dondeAcudirInteractor;
    }


    @Override
    public void onSuccess(List<Ubicaciones> ubicacionesList) {
        if (dondeAcudirView != null) {
            dondeAcudirView.hideProgress();
            dondeAcudirView.setAdapter(ubicacionesList);
        }
    }

    @Override
    public void onFailed(String message) {
        if (dondeAcudirView != null) {
            dondeAcudirView.hideProgress();
            dondeAcudirView.showErrorMessage(message);
        }
    }

    @Override
    public void getUbicaciones() {
        dondeAcudirInteractor.getUbicaciones(this);
        if (dondeAcudirView != null) {
            dondeAcudirView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        dondeAcudirView = null;
    }
}
