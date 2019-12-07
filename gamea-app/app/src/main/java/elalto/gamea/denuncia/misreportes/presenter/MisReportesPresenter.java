package elalto.gamea.denuncia.misreportes.presenter;

import elalto.network.entities.TokenManager;

public interface MisReportesPresenter {
    void getReportes(TokenManager tokenManager);

    void onDestroy();
}
