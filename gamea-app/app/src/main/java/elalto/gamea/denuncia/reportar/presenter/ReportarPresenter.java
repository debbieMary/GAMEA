package elalto.gamea.denuncia.reportar.presenter;

import java.io.File;

import elalto.network.entities.TokenManager;

public interface ReportarPresenter {
    void reportar(String distrito, String categoria, String zona, String descripcion, String lat, String lng, File file, TokenManager tokenManager);

    void onDestroy();
}
