package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.gamea.map.canchas.entities.CanchaInfo;

public interface CanchaReservaView {
    void showProgress();

    void hideProgress();

    void populateMessage(String message);

    void showErrorMessage(String message);
}
