package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.gamea.map.canchas.entities.Event;
import elalto.network.canchas.entities.DeleteReservaResponse;

public interface DeleteReservaView {
    void showProgress();

    void hideProgress();

    void populate(DeleteReservaResponse deleteReservaResponse);

    void showErrorMessage(String message);
}
