package elalto.gamea.map.hospitales.model;

import java.util.List;

import elalto.gamea.map.hospitales.entities.HospitalPoint;
import elalto.network.entities.TokenManager;

public interface HospitalInteractor {
    interface onHospitalFinishedListener {
        void onSuccess(List<HospitalPoint> hospitalPoints);

        void onFailed(String message);
    }

    void getHospitals(TokenManager tokenManager, onHospitalFinishedListener listener);
}
