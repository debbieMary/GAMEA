package elalto.gamea.testviolencia.contacto.model;

import android.text.TextUtils;

import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactoInteractorImpl implements ContactoInteractor {
    ApiService service;
    Call<ResponseBody> call;

    @Override
    public void enviarMensaje(String mensaje, String email, Double lat, Double lng, TokenManager tokenManager, onContactoFinishedListener listener) {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(mensaje)) {
                    listener.onFailed("Ingrese el mensaje.");
                }
                service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
                call = service.saveMensaje(mensaje, email, lat, lng);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() == 200) {
                            listener.onSuccess("Mensaje Enviado-");
                        } else {
                            listener.onFailed("Algo salio mal");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        listener.onFailed("Error de conexion.");
                    }
                });
            }
        }, 300);
    }
}
