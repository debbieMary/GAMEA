package elalto.gamea.testviolencia.dondeacudir.view;

import java.util.List;

import elalto.gamea.testviolencia.dondeacudir.Ubicaciones;

public interface DondeAcudirView {
    void showProgress();
    void hideProgress();
    void showErrorMessage(String message);
    void setAdapter(List<Ubicaciones> ubicacionesList);
}
