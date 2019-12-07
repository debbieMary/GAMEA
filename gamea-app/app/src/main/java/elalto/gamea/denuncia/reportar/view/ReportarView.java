package elalto.gamea.denuncia.reportar.view;

public interface ReportarView {
    void showProgress();

    void hideProgress();

    void showSuccessMessage(String message);

    void showErrorMessage(String message);

    void setErrorDistrito(String message);

    void setErrorZona(String message);

    void setErrorDetalle(String message);

    void setErrorLatLng(String message);

    void resetForm();

    void resetErrors();
}
