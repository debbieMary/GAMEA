package elalto.gamea.denuncia.misreportes.model;

import java.util.List;

import elalto.gamea.denuncia.misreportes.entities.Denuncia;
import elalto.network.entities.TokenManager;

public interface MisReportesInteractor {
    interface OnMisReportesFinishedListener {
        void onSuccess(List<Denuncia> denuncias);

        void onFailed(String message);
    }

    void getReportes(TokenManager tokenManager, OnMisReportesFinishedListener listener);
}
