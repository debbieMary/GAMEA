package elalto.gamea.map.hospitales.view;

import java.util.List;

import elalto.gamea.map.hospitales.entities.HospitalPoint;

public interface HospitalView {
    void showProgress();

    void hideProgress();

    void populateMap(List<HospitalPoint> hospitalPoints);

    void showErrorMessage(String message);
}
