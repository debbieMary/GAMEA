package elalto.gamea.map.modulosPoliciales.view;

import java.util.List;

import elalto.gamea.map.modulosPoliciales.entities.Modulos;

public interface ModulosView {
    void showProgress();

    void hideProgress();

    void populateMap(List<Modulos> modulosList);

    void showErrorMessage(String message);
}
