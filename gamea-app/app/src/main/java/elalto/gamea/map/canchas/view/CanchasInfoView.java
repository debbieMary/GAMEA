package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.network.canchas.entities.CanchaInfo;


public interface CanchasInfoView {
    void showProgress();

    void hideProgress();

    void populateInfo(List<CanchaInfo> canchaList);

    void showErrorMessage(String message);
}
