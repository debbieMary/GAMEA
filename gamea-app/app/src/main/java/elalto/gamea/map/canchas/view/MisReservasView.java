package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.network.canchas.entities.MisReservas;

public interface MisReservasView {
    void showProgress();

    void hideProgress();

    void populateMisReservas(List<MisReservas> misReservas);

    void showErrorMessage(String message);
}
