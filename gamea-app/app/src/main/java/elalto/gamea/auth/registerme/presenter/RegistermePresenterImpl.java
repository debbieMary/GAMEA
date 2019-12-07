package elalto.gamea.auth.registerme.presenter;

import elalto.gamea.auth.registerme.model.RegistermeInteractor;
import elalto.gamea.auth.registerme.view.RegisterView;
import elalto.network.entities.AccessToken;
import elalto.network.entities.RegisterError;

public class RegistermePresenterImpl implements RegistermePresenter, RegistermeInteractor.OnRegistermeFinishedListener {
    private RegisterView registerView;
    private RegistermeInteractor registermeInteractor;

    public RegistermePresenterImpl(RegisterView registerView, RegistermeInteractor registermeInteractor) {
        this.registerView = registerView;
        this.registermeInteractor = registermeInteractor;
    }

    @Override
    public void registerme(String ci, String nombres, String apellidos, String celular, String email, String distrito, String zona, String direccion, String password, String password_confirmation) {

        registermeInteractor.registerme(ci, nombres, apellidos, celular, email, distrito, zona, direccion, password, password_confirmation, this);
    }

    @Override
    public void onCiError() {
        if (registerView != null) {
            registerView.setCiError();
        }
    }

    @Override
    public void onNombresError() {
        if (registerView != null) {
            registerView.setNombresError();
        }
    }

    @Override
    public void onApellidosError() {
        if (registerView != null) {
            registerView.setApellidosError();
        }
    }

    @Override
    public void onCelularError() {
        if (registerView != null) {
            registerView.setCelularError();
        }
    }

    @Override
    public void onEmailError() {

    }

    @Override
    public void onDistritoError() {
        if (registerView != null) {
            registerView.setDistritoError();
        }
    }

    @Override
    public void onZonaError() {

    }

    @Override
    public void onDireccionError() {

    }

    @Override
    public void onPasswordError() {
        if (registerView != null) {
            registerView.setPasswordError();
        }
    }

    @Override
    public void onPasswordConfirmationError() {
        if (registerView != null) {
            registerView.setPasswordConfirmationError();
        }
    }

    @Override
    public void onSuccess(AccessToken accessToken) {
        if (registerView != null){
            registerView.navigateToHome(accessToken);
        }
    }

    @Override
    public void onFailed(RegisterError registerError) {
        if (registerView!=null){
            registerView.showError(registerError);
        }
    }

    @Override
    public void onDestroy() {
        registerView = null;
    }
}
