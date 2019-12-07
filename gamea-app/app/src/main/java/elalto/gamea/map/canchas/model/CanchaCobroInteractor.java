package elalto.gamea.map.canchas.model;
import java.util.List;
import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.network.entities.TokenManager;

public interface CanchaCobroInteractor {
  interface onCobroFinishedListener {
    void onSuccessCC(List<CanchaCobro> canchaList);

    void onFailedCC(String message);
  }

  void getCobros(TokenManager tokenManager, elalto.gamea.map.canchas.model.CanchaCobroInteractor.onCobroFinishedListener listener);
}
