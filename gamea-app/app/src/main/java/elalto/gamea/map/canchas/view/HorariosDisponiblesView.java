package elalto.gamea.map.canchas.view;

import java.util.List;

import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.gamea.map.canchas.entities.Horarios;

public interface HorariosDisponiblesView {
    void showProgress();

    void hideProgress();

    void populate(List<Horarios> horariosList);

    void showErrorMessage(String message);
}
