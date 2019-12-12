package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.gamea.map.canchas.entities.Horarios;
import elalto.network.entities.TokenManager;

public interface HorariosDisponiblesInteractor {
  interface onHorariosDisponiblesFinishedListener {
    void onSuccess(List<Horarios> horarios);

    void onFailed(String message);
  }

  void getHorariosDisponibles(String id_cancha, String fecha_inicio, String fecha_fin, HorariosDisponiblesInteractor.onHorariosDisponiblesFinishedListener listener);
}
