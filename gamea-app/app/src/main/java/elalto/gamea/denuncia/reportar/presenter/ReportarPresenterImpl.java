package elalto.gamea.denuncia.reportar.presenter;

import java.io.File;

import elalto.gamea.denuncia.reportar.model.ReportarInteractor;
import elalto.gamea.denuncia.reportar.view.ReportarView;
import elalto.network.entities.TokenManager;

public class ReportarPresenterImpl implements ReportarPresenter, ReportarInteractor.OnReportarFinishedListener {
    private ReportarView reportarView;
    private ReportarInteractor reportarInteractor;

    public ReportarPresenterImpl(ReportarView reportarView, ReportarInteractor reportarInteractor) {
        this.reportarView = reportarView;
        this.reportarInteractor = reportarInteractor;
    }

    @Override
    public void onSuccess(String message) {
        if (reportarView != null) {
            reportarView.showSuccessMessage(message);
            reportarView.hideProgress();
            reportarView.resetForm();
        }
    }

    @Override
    public void onFailed(String message) {
        if (reportarView != null) {
            reportarView.showErrorMessage(message);
            reportarView.hideProgress();
        }
    }

    @Override
    public void onDistritoError() {
        if (reportarView != null) {
            reportarView.setErrorDistrito("El distrito es obligatorio");
            reportarView.hideProgress();
        }
    }

    @Override
    public void onZonaError() {
        if (reportarView != null) {
            reportarView.setErrorZona("La zona es obligatoria");
            reportarView.hideProgress();
        }
    }

    @Override
    public void onDescripcionError() {
        if (reportarView != null) {
            reportarView.setErrorDetalle("El campo detalle es obligatorio");
            reportarView.hideProgress();
        }
    }

    @Override
    public void reportar(String distrito, String categoria, String zona, String descripcion, String lat, String lng, File file, TokenManager tokenManager) {
        if (reportarView != null) {
            reportarView.showProgress();
        }
        reportarView.resetErrors();
        reportarInteractor.reportar(distrito, categoria, zona, descripcion, lat, lng, file, tokenManager, this);
    }

    @Override
    public void onDestroy() {
        reportarView = null;
    }
}
