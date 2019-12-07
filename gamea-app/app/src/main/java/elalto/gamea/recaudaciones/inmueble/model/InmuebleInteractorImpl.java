package elalto.gamea.recaudaciones.inmueble.model;

import android.text.TextUtils;

import elalto.gamea.recaudaciones.entities.Inmueble;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmuebleInteractorImpl implements InmuebleInteractor {
    ApiService service;
    Call<Inmueble> call;

    @Override
    public void findInmueble(String tipo_doc, String nro_doc, TokenManager tokenManager, onInmuebleFinishedListener listener) {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(tipo_doc)) {
                    listener.onFailed("Elija un tipo de documento");
                    return;
                }
                if (TextUtils.isEmpty(nro_doc)) {
                    listener.onFailed("Ingrese el número de documento");
                    return;
                }

                service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
                call = service.findInmueble(tipo_doc, nro_doc);
                call.enqueue(new Callback<Inmueble>() {
                    @Override
                    public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                        if (response.code() == 200) {
                            listener.onSuccess(response.body());
                        } else {
                            if (response.code() == 204) {
                                listener.onFailed("No se encontro registros");
                            } else {
                                listener.onFailed("Algo salio mal");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Inmueble> call, Throwable t) {
                        listener.onFailed("Error de conexion");
                    }
                });
            }
        }, 300);
    }
}
