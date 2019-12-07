package elalto.gamea.map.canchas.presenter;

import elalto.network.entities.TokenManager;

public interface CanchaCobroPresenter {
  void getCobros(TokenManager tokenManager);
  void onDestroyCC();
}
