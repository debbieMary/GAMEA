package elalto.gamea.auth.registerme.view;

import elalto.network.entities.AccessToken;
import elalto.network.entities.RegisterError;

public interface RegisterView {
    void setCiError();
    void setNombresError();
    void setApellidosError();
    void setCelularError();
    void setEmailError();
    void setDistritoError();
    void setZonaError();
    void setDireccionError();
    void setPasswordError();
    void setPasswordConfirmationError();
    void navigateToHome(AccessToken accessToken);
    void showError(RegisterError registerError);
}
