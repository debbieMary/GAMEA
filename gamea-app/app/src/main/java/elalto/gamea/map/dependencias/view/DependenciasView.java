package elalto.gamea.map.dependencias.view;

import java.util.List;

import elalto.gamea.map.dependencias.entities.Dependencias;

public interface DependenciasView {
    void showProgress();

    void hideProgress();

    void navigateToBack();

    void showErrorMessage(String message);

    void getDependencias(List<Dependencias> dependencias);
}
