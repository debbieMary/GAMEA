package elalto.gamea.recaudaciones.patentepublicidad.model;

import elalto.gamea.recaudaciones.entities.PatentePublicidad;
import elalto.gamea.recaudaciones.inmueble.model.InmuebleInteractor;
import elalto.network.entities.TokenManager;

public interface PatentePublicidadInteractor {
    interface onPatentePublicidadFinishedListener {
        void onSuccess(PatentePublicidad patentePublicidad);

        void onFailed(String message);
    }
    void findPatentePublicidad(String tipo_doc, String nro_doc, TokenManager tokenManager, onPatentePublicidadFinishedListener listener);
}
