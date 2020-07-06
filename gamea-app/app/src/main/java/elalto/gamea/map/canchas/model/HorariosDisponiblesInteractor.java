package elalto.gamea.map.canchas.model;

import java.util.List;

import elalto.gamea.map.canchas.entities.Event;
import elalto.network.canchas.entities.HorariosBody;


public interface HorariosDisponiblesInteractor {
  interface onHorariosDisponiblesFinishedListener {
    void onSuccess(List<Event> horarios);

    void onFailed(String message);
  }

  void getHorariosDisponibles(HorariosBody horariosBody, HorariosDisponiblesInteractor.onHorariosDisponiblesFinishedListener listener);
}
