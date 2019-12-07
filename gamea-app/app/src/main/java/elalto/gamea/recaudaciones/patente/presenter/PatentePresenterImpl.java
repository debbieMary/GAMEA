package elalto.gamea.recaudaciones.patente.presenter;

import elalto.gamea.recaudaciones.entities.Patente;
import elalto.gamea.recaudaciones.patente.model.PatenteInteractor;
import elalto.gamea.recaudaciones.patente.view.PatenteView;
import elalto.network.entities.TokenManager;

public class PatentePresenterImpl implements PatentePresenter, PatenteInteractor.onPatenteFinishedListener {
    private PatenteView patenteView;
    private PatenteInteractor patenteInteractor;

    public PatentePresenterImpl(PatenteView patenteView, PatenteInteractor patenteInteractor) {
        this.patenteView = patenteView;
        this.patenteInteractor = patenteInteractor;
    }

    @Override
    public void onSuccess(Patente patente) {
        if (patenteView != null) {
            patenteView.hideProgress();
            patenteView.showResponse(patente);
        }
    }

    @Override
    public void onFailed(String message) {
        if (patenteView != null) {
            patenteView.hideProgress();
            patenteView.showErrorMessage(message);
        }
    }

    @Override
    public void findPatente(String tipo_doc, String nro_doc, TokenManager tokenManager) {
        patenteInteractor.findPatente(tipo_doc, nro_doc, tokenManager, this);
        if (patenteView != null) {
            patenteView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        patenteView = null;
    }
}
