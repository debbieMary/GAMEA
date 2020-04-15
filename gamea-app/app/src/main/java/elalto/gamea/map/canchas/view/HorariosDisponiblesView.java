package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.gamea.map.canchas.entities.Horarios;
import elalto.gamea.map.canchas.model.Event;

public interface HorariosDisponiblesView {
    void showProgress();

    void hideProgress();

    void populate(List<Event> horariosList);

    void showErrorMessage(String message);
}
