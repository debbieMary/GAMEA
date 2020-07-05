package elalto.gamea.map.canchas.view;

import java.util.List;


public interface CanchaReservaView {
    void showProgress();

    void hideProgress();

    void populateMessage(String message);

    void showErrorMessage(String message);
}
