package elalto.gamea.denuncia.misreportes.view;

import java.util.List;

import elalto.gamea.denuncia.misreportes.entities.Denuncia;

public interface MisReportesView {
    void showProgress();

    void hideProgress();

    void showErrorMessage(String message);

    void setAdapter(List<Denuncia> denunciaList);
}
