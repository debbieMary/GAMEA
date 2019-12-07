package elalto.gamea.yayo.listperson.view;

import java.util.List;

import elalto.gamea.yayo.listperson.entities.Desaparecido;

public interface ListPersonView {
    void showProgress();

    void hideProgress();

    void showError(String message);

    void setAdapter(List<Desaparecido> desaparecidoList);

    void back();
}
