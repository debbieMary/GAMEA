package elalto.gamea.map.canchas.presenter;

import elalto.network.entities.TokenManager;

public interface HorariosDisponiblesPresenter {
  void getHorariosDisponibles(String id_cancha, String fecha_inicio, String fecha_fin);
  void onDestroy();
}
