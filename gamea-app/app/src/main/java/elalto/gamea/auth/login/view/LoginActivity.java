package elalto.gamea.auth.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import elalto.gamea.R;
import elalto.gamea.auth.login.model.LoginInteractorImpl;
import elalto.gamea.auth.login.presenter.LoginPresenter;
import elalto.gamea.auth.login.presenter.LoginPresenterImpl;
import elalto.gamea.auth.registerme.view.RegisterMeActivity;
import elalto.gamea.home.view.HomeActivity;
import elalto.network.entities.AccessToken;
import elalto.network.entities.LoginError;
import elalto.network.entities.TokenManager;

public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.til_ci)
    TextInputLayout til_ci;
    @BindView(R.id.til_password)
    TextInputLayout til_password;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.txv_register)
    TextView txv_resgister;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private LoginPresenter presenter;

    TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenterImpl(this, new LoginInteractorImpl());
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        if (tokenManager.getToken().getAccess_token() != null) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @OnClick(R.id.btn_login)
    public void login(View view) {
        til_ci.setError(null);
        til_password.setError(null);
        presenter.validateCredentials(til_ci.getEditText().getText().toString(), til_password.getEditText().getText().toString());
    }

    @OnClick(R.id.txv_register)
    public void navigate_register() {
        Intent intent = new Intent(this, RegisterMeActivity.class);
        startActivity(intent);

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(LoginError loginError) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_error,(ViewGroup)findViewById(R.id.toast_error));

        TextView toastText = layout.findViewById(R.id.toast_message);
        toastText.setText(loginError.getError());
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.BOTTOM,0,30);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setCiError() {
        til_ci.setError("Nro. de CI requerido");
    }

    @Override
    public void setPasswordError() {
        til_password.setError("Password requerido");
    }

    @Override
    public void navigateToHome(AccessToken accessToken) {
        tokenManager.saveToken(accessToken);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
