package elalto.gamea.testviolencia.dondeacudir.model;

import java.util.List;

import elalto.gamea.testviolencia.dondeacudir.Ubicaciones;

public interface DondeAcudirInteractor {
    interface onDondeAcudirFinishedListener {
        void onSuccess(List<Ubicaciones> ubicacionesList);
        void onFailed(String message);
    }
    void getUbicaciones(onDondeAcudirFinishedListener listener);
}
