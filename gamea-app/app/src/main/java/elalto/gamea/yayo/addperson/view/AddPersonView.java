package elalto.gamea.yayo.addperson.view;

import android.net.Uri;

public interface AddPersonView {
    void showErrorMessage(String message);
    void showSuccessMessage(String message);
    void resetFormulario();
    void showProgress();
    void hideProgress();
    void setNombresError(String message);
    void setApellidosError(String message);
    void setEdadError(String message);
    void setGeneroError(String message);
    void setCelularError(String message);
    void setDesaparecioError(String message);
    void setDetallesError(String message);
    void setFechaDesaparicionError(String message);

}
