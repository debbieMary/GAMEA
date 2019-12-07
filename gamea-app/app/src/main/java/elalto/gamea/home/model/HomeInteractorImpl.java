package elalto.gamea.home.model;

import android.text.TextUtils;
import android.util.Log;

import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.AccessToken;
import elalto.network.entities.TokenManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractorImpl implements HomeInteractor {
    ApiService service;
    Call<ResponseBody> call;

    @Override
    public void logout(TokenManager tokenManager, OnLogoutFinishedListener listener) {
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
        call = service.logout();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                tokenManager.deleteToken();
                listener.onSuccess();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("__ERROR__", call.request().body().toString());
            }
        });
    }

    @Override
    public void sendSugerencia(TokenManager tokenManager, String sugerencia, onSendFinishedListener listener) {
        if (TextUtils.isEmpty(sugerencia)){
            listener.onErrorSend("Debe ingresar una sugerencia");
            return;
        }
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
        call = service.sendSugerencia(sugerencia);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                listener.onSuccessSend("Gracias por enviarnos su sugerencia.");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onErrorSend("Error al conectar con el servidor");
            }
        });
    }
}
