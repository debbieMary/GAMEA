package elalto.gamea.map.canchas.model;
import java.util.List;
import elalto.network.canchas.entities.CanchaCobro;
import elalto.network.entities.TokenManager;

public interface CanchaCobroInteractor {
  interface onCobroFinishedListener {
    void onSuccess(List<CanchaCobro> canchaList);

    void onFailed(String message);
  }

  void getCobros(TokenManager tokenManager, elalto.gamea.map.canchas.model.CanchaCobroInteractor.onCobroFinishedListener listener);
}
