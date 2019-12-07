package elalto.gamea.map.hospitales.presenter;

import elalto.network.entities.TokenManager;

public interface HospitalPresenter {
    void getHospitales(TokenManager tokenManager);

    void onDestroy();
}
