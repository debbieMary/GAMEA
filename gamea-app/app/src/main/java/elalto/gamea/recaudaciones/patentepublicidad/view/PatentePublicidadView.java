package elalto.gamea.recaudaciones.patentepublicidad.view;

import elalto.gamea.recaudaciones.entities.PatentePublicidad;

public interface PatentePublicidadView {
    void showProgress();

    void hideProgress();

    void showResponse(PatentePublicidad patentePublicidad);

    void showErrorMessage(String message);
}
