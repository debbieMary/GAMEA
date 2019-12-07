package elalto.gamea.denuncia.misreportes.presenter;

import java.util.List;

import elalto.gamea.denuncia.misreportes.entities.Denuncia;
import elalto.gamea.denuncia.misreportes.model.MisReportesInteractor;
import elalto.gamea.denuncia.misreportes.view.MisReportesView;
import elalto.network.entities.TokenManager;

public class MisReportesPresenterImpl implements MisReportesPresenter, MisReportesInteractor.OnMisReportesFinishedListener {
    private MisReportesView misReportesView;
    private MisReportesInteractor reportesInteractor;

    public MisReportesPresenterImpl(MisReportesView misReportesView, MisReportesInteractor reportesInteractor) {
        this.misReportesView = misReportesView;
        this.reportesInteractor = reportesInteractor;
    }

    @Override
    public void getReportes(TokenManager tokenManager) {
        reportesInteractor.getReportes(tokenManager, this);
        misReportesView.showProgress();
    }

    @Override
    public void onDestroy() {
        misReportesView = null;
    }


    @Override
    public void onSuccess(List<Denuncia> denuncias) {
        if (misReportesView != null) {
            misReportesView.hideProgress();
            misReportesView.setAdapter(denuncias);
        }
    }

    @Override
    public void onFailed(String message) {
        misReportesView.showErrorMessage(message);
        misReportesView.hideProgress();
    }
}
