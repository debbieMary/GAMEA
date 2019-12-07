package elalto.gamea.recaudaciones.patentepublicidad.presenter;

import elalto.gamea.recaudaciones.entities.PatentePublicidad;
import elalto.gamea.recaudaciones.patentepublicidad.model.PatentePublicidadInteractor;
import elalto.gamea.recaudaciones.patentepublicidad.view.PatentePublicidadView;
import elalto.network.entities.TokenManager;

public class PatentePublicidadPresenterImpl implements PatentePublicidadPresenter, PatentePublicidadInteractor.onPatentePublicidadFinishedListener {
    private PatentePublicidadView patentePublicidadView;
    private PatentePublicidadInteractor patentePublicidadInteractor;

    public PatentePublicidadPresenterImpl(PatentePublicidadView patentePublicidadView, PatentePublicidadInteractor patentePublicidadInteractor) {
        this.patentePublicidadView = patentePublicidadView;
        this.patentePublicidadInteractor = patentePublicidadInteractor;
    }

    @Override
    public void onSuccess(PatentePublicidad patentePublicidad) {
        if (patentePublicidadView != null) {
            patentePublicidadView.hideProgress();
            patentePublicidadView.showResponse(patentePublicidad);
        }
    }

    @Override
    public void onFailed(String message) {
        if (patentePublicidadView != null) {
            patentePublicidadView.hideProgress();
            patentePublicidadView.showErrorMessage(message);
        }
    }

    @Override
    public void findPatente(String tipo_doc, String nro_doc, TokenManager tokenManager) {
        patentePublicidadInteractor.findPatentePublicidad(tipo_doc, nro_doc, tokenManager, this);
        if (patentePublicidadView != null) {
            patentePublicidadView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        patentePublicidadView = null;
    }
}
