package elalto.gamea.auth.registerme.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.auth.registerme.model.RegistermeInteractorImpl;
import elalto.gamea.auth.registerme.presenter.RegistermePresenter;
import elalto.gamea.auth.registerme.presenter.RegistermePresenterImpl;
import elalto.gamea.home.view.HomeActivity;
import elalto.network.entities.AccessToken;
import elalto.network.entities.UserManager;
import elalto.network.entities.RegisterError;
import elalto.network.entities.TokenManager;

public class RegisterMeActivity extends AppCompatActivity implements RegisterView {
    @BindView(R.id.btn_register_me)
    Button btnRegisterMe;
    @BindView(R.id.til_ci)
    TextInputLayout tilCi;
    @BindView(R.id.til_nombres)
    TextInputLayout tilNombres;
    @BindView(R.id.til_apellidos)
    TextInputLayout tilApellidos;
    @BindView(R.id.til_celular)
    TextInputLayout tilCelular;
    @BindView(R.id.til_email)
    TextInputLayout tilEmail;
    @BindView(R.id.til_distrito)
    TextInputLayout tilDistrito;
    @BindView(R.id.til_zona)
    TextInputLayout tilZona;
    @BindView(R.id.til_direccion)
    TextInputLayout tilDireccion;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.til_password_confirm)
    TextInputLayout tilPasswordConfirm;
    private RegistermePresenter presenter;
    TokenManager tokenManager;
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_me);
        ButterKnife.bind(this);
        presenter = new RegistermePresenterImpl(this, new RegistermeInteractorImpl());
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        userManager = new UserManager();
        if (tokenManager.getToken().getAccess_token() != null) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick(R.id.btn_register_me)
    public void registerme() {
        resetError();
        presenter.registerme(tilCi.getEditText().getText().toString(), tilNombres.getEditText().getText().toString(), tilApellidos.getEditText().getText().toString(), tilCelular.getEditText().getText().toString(), tilEmail.getEditText().getText().toString(), tilDistrito.getEditText().getText().toString(), tilZona.getEditText().getText().toString(), tilDireccion.getEditText().getText().toString(), tilPassword.getEditText().getText().toString(), tilPasswordConfirm.getEditText().getText().toString());
    }

    @Override
    public void setCiError() {
        tilCi.setError("Nro. de CI obligatorio");
    }

    @Override
    public void setNombresError() {
        tilNombres.setError("El nombre es obligatorio");
    }

    @Override
    public void setApellidosError() {
        tilApellidos.setError("El apellido es obligatorio");
    }

    @Override
    public void setCelularError() {
        tilCelular.setError("El nro de celular es obligatorio");
    }

    @Override
    public void setEmailError() {

    }

    @Override
    public void setDistritoError() {
        tilDistrito.setError("El distrito es obligatorio");
    }

    @Override
    public void setZonaError() {

    }

    @Override
    public void setDireccionError() {

    }

    @Override
    public void setPasswordError() {
        tilPassword.setError("La contraseña es obligatoria");
    }

    @Override
    public void setPasswordConfirmationError() {
        tilPasswordConfirm.setError("Repita su contraseña");
    }

    @Override
    public void navigateToHome(AccessToken accessToken) {
        tokenManager.saveToken(accessToken);
        userManager.saveCi(this,tilCi.getEditText().getText().toString());
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showError(RegisterError registerError) {
        RegisterError.ErrorsBean errors = registerError.getErrors();
        String ciError = (errors.getCi() != null) ? errors.getCi().get(0) : null;
        String passwordError = (errors.getPassword() != null) ? errors.getPassword().get(0) : null;
        String emailError = (errors.getEmail() != null) ? errors.getEmail().get(0) : null;
        String celular = (errors.getCelular() != null) ? errors.getCelular().get(0) : null;

        if (!TextUtils.isEmpty(ciError)) {
            Toast.makeText(this, ciError, Toast.LENGTH_SHORT).show();
        }
        if (!TextUtils.isEmpty(passwordError)) {
            Toast.makeText(this, passwordError, Toast.LENGTH_SHORT).show();
        }
        if (!TextUtils.isEmpty(emailError)) {
            Toast.makeText(this, emailError, Toast.LENGTH_SHORT).show();
        }
        if (!TextUtils.isEmpty(celular)) {
            Toast.makeText(this, celular, Toast.LENGTH_SHORT).show();
        }
    }

    void resetError() {
        tilCi.setError(null);
        tilNombres.setError(null);
        tilApellidos.setError(null);
        tilCelular.setError(null);
        tilEmail.setError(null);
        tilDistrito.setError(null);
        tilZona.setError(null);
        tilDireccion.setError(null);
        tilPassword.setError(null);
        tilPasswordConfirm.setError(null);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
