package elalto.gamea.recaudaciones.inmueble.presenter;

import elalto.gamea.recaudaciones.entities.Inmueble;
import elalto.gamea.recaudaciones.inmueble.model.InmuebleInteractor;
import elalto.gamea.recaudaciones.inmueble.view.InmuebleView;
import elalto.network.entities.TokenManager;

public class InmueblePresenterImpl implements InmueblePresenter, InmuebleInteractor.onInmuebleFinishedListener {
    private InmuebleView inmuebleView;
    private InmuebleInteractor inmuebleInteractor;

    public InmueblePresenterImpl(InmuebleView inmuebleView, InmuebleInteractor inmuebleInteractor) {
        this.inmuebleView = inmuebleView;
        this.inmuebleInteractor = inmuebleInteractor;
    }

    @Override
    public void onSuccess(Inmueble inmueble) {
        if (inmuebleView != null) {
            inmuebleView.hideProgress();
            inmuebleView.showResponse(inmueble);
        }
    }

    @Override
    public void onFailed(String message) {
        if (inmuebleView != null) {
            inmuebleView.hideProgress();
            inmuebleView.showErrorMessage(message);
        }
    }

    @Override
    public void findInmueble(String tipo_doc, String nro_doc, TokenManager tokenManager) {
        inmuebleInteractor.findInmueble(tipo_doc, nro_doc, tokenManager, this);
        if (inmuebleView != null) {
            inmuebleView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        inmuebleView = null;
    }
}
