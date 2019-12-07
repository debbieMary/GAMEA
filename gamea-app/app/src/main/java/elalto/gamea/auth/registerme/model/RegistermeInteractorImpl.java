package elalto.gamea.auth.registerme.model;

import android.text.TextUtils;

import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.AccessToken;
import elalto.network.entities.RegisterError;
import elalto.network.entities.TokenManager;
import elalto.network.entities.Utils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistermeInteractorImpl implements RegistermeInteractor {
    ApiService service;
    Call<AccessToken> call;
    @Override
    public void registerme(String ci, String nombres, String apellidos, String celular, String email, String distrito, String zona, String direccion, String password, String password_confirmation, OnRegistermeFinishedListener listener) {
        if (TextUtils.isEmpty(ci)) {
            listener.onCiError();
            return;
        }
        if (TextUtils.isEmpty(nombres)) {
            listener.onNombresError();
            return;
        }
        if (TextUtils.isEmpty(apellidos)) {
            listener.onApellidosError();
            return;
        }
        if (TextUtils.isEmpty(celular)) {
            listener.onCelularError();
            return;
        }
        if (TextUtils.isEmpty(distrito)) {
            listener.onDistritoError();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            return;
        }
        if (TextUtils.isEmpty(password_confirmation)) {
            listener.onPasswordConfirmationError();
            return;
        }

        service = RetrofitBuilder.createService(ApiService.class);
        call = service.register(ci, nombres, apellidos, celular, email, distrito, direccion, password, password_confirmation);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else if (response.code() == 422 || response.code() == 401) {
                    listener.onFailed(registerError(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {

            }
        });
    }

    private RegisterError registerError(ResponseBody response) {
        RegisterError registerError = Utils.registerError(response);
        return registerError;
    }
}
