package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.gamea.map.canchas.entities.Event;


public interface HorariosDisponiblesInteractor {
  interface onHorariosDisponiblesFinishedListener {
    void onSuccess(List<Event> horarios);

    void onFailed(String message);
  }

  void getHorariosDisponibles(String id_cancha, String fecha_inicio, String fecha_fin, HorariosDisponiblesInteractor.onHorariosDisponiblesFinishedListener listener);
}
