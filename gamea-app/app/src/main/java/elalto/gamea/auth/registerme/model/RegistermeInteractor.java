package elalto.gamea.auth.registerme.model;

import elalto.network.entities.AccessToken;
import elalto.network.entities.RegisterError;

public interface RegistermeInteractor {
    interface OnRegistermeFinishedListener {
        void onCiError();

        void onNombresError();

        void onApellidosError();

        void onCelularError();

        void onEmailError();

        void onDistritoError();

        void onZonaError();

        void onDireccionError();

        void onPasswordError();

        void onPasswordConfirmationError();

        void onSuccess(AccessToken accessToken);

        void onFailed(RegisterError registerError);
    }

    void registerme(String ci, String nombres, String apellidos, String celular, String email, String distrito, String zona, String direccion, String password, String password_confirmation, OnRegistermeFinishedListener listener);
}
