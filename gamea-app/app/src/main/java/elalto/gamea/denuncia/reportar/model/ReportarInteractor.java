package elalto.gamea.denuncia.reportar.model;

import java.io.File;

import elalto.network.entities.TokenManager;

public interface ReportarInteractor {
    interface OnReportarFinishedListener {
        void onSuccess(String message);

        void onFailed(String message);

        void onDistritoError();

        void onZonaError();

        void onDescripcionError();
    }

    void reportar(String distrito, String categoria, String zona, String descripcion, String lat, String lng, File file, TokenManager tokenManager, OnReportarFinishedListener listener);
}
