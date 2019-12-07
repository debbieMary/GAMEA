package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.canchas.entities.CanchaInfo;

public interface CanchasInfoView {
    void showProgress();

    void hideProgress();

    void populateInfo(List<CanchaInfo> canchaList);

    void showErrorMessage(String message);
}
