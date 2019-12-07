package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.canchas.entities.CanchaCobro;

public interface CanchaCobroView {
    void showProgressCC();

    void hideProgressCC();

    void populateMapCC(List<CanchaCobro> canchaCobroList);

    void showErrorMessageCC(String message);
}
