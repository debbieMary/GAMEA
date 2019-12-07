package elalto.gamea.map.hospitales.presenter;

import java.util.List;

import elalto.gamea.map.hospitales.entities.HospitalPoint;
import elalto.gamea.map.hospitales.model.HospitalInteractor;
import elalto.gamea.map.hospitales.view.HospitalView;
import elalto.network.entities.TokenManager;

public class HospitalPresenterImpl implements HospitalPresenter, HospitalInteractor.onHospitalFinishedListener {
    private HospitalView hospitalView;
    private HospitalInteractor hospitalInteractor;

    public HospitalPresenterImpl(HospitalView hospitalView, HospitalInteractor hospitalInteractor) {
        this.hospitalView = hospitalView;
        this.hospitalInteractor = hospitalInteractor;
    }

    @Override
    public void getHospitales(TokenManager tokenManager) {
        hospitalInteractor.getHospitals(tokenManager, this);
        if (hospitalView != null) {
            hospitalView.showProgress();
        }
    }



    @Override
    public void onSuccess(List<HospitalPoint> hospitalPoints) {
        if (hospitalView != null) {
            hospitalView.hideProgress();
            hospitalView.populateMap(hospitalPoints);
        }
    }

    @Override
    public void onFailed(String message) {
        if (hospitalView != null) {
            hospitalView.hideProgress();
            hospitalView.showErrorMessage(message);
        }
    }
    @Override
    public void onDestroy() {
        hospitalView = null;
    }
}
