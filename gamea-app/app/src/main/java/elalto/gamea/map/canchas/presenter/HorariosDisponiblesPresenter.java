package elalto.gamea.map.canchas.presenter;


import elalto.network.canchas.entities.HorariosBody;

public interface HorariosDisponiblesPresenter {
  void getHorariosDisponibles(HorariosBody horariosBody);
  void onDestroy();
}
