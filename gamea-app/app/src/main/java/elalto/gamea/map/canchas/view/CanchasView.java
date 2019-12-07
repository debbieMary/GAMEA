package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;

public interface CanchasView {
    void showProgress();

    void hideProgress();

    void populateMap(List<Cancha> canchaList);

    void showErrorMessage(String message);
}
