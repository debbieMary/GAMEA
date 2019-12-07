package elalto.gamea.catastro.consulta_tramite.presenter;

import elalto.gamea.catastro.consulta_tramite.entities.Tramite;
import elalto.gamea.catastro.consulta_tramite.model.ConsultaTramiteInteractor;
import elalto.gamea.catastro.consulta_tramite.view.ConsultaTramiteView;

public class ConsultaTramitePresenterImpl implements ConsultaTramitePresenter, ConsultaTramiteInteractor.onConsultaTramiteFinishedListener {
    private ConsultaTramiteView consultaTramiteView;
    private ConsultaTramiteInteractor consultaTramiteInteractor;

    public ConsultaTramitePresenterImpl(ConsultaTramiteView consultaTramiteView, ConsultaTramiteInteractor consultaTramiteInteractor) {
        this.consultaTramiteView = consultaTramiteView;
        this.consultaTramiteInteractor = consultaTramiteInteractor;
    }

    @Override
    public void onSuccess(Tramite tramite) {
        if (consultaTramiteView != null) {
            consultaTramiteView.hideProgress();
            consultaTramiteView.getDtm(tramite);
        }
    }

    @Override
    public void setErrorConsulta(String message) {
        if (consultaTramiteView != null) {
            consultaTramiteView.hideProgress();
            consultaTramiteView.setErrorConsulta(message);
        }
    }

    @Override
    public void onFailed(String message) {
        if (consultaTramiteView != null) {
            consultaTramiteView.showErrorMessage(message);
        }
    }

    @Override
    public void getConsultaTramite(String tramite, String tipo) {
        consultaTramiteView.showProgress();
        consultaTramiteInteractor.getTramite(tramite, tipo, this);
    }

    @Override
    public void onDestroy() {
        consultaTramiteView = null;
    }
}
