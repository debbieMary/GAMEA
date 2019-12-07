package elalto.gamea.recaudaciones.patentepublicidad.model;

import android.text.TextUtils;

import elalto.gamea.recaudaciones.entities.PatentePublicidad;
import elalto.gamea.recaudaciones.inmueble.model.InmuebleInteractor;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatentePublicidadInteractorImpl implements PatentePublicidadInteractor {
    ApiService service;
    Call<PatentePublicidad> call;

    @Override
    public void findPatentePublicidad(String tipo_doc, String nro_doc, TokenManager tokenManager, PatentePublicidadInteractor.onPatentePublicidadFinishedListener listener) {
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
                call = service.findPatentePublicidad(tipo_doc, nro_doc);
                call.enqueue(new Callback<PatentePublicidad>() {
                    @Override
                    public void onResponse(Call<PatentePublicidad> call, Response<PatentePublicidad> response) {
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
                    public void onFailure(Call<PatentePublicidad> call, Throwable t) {
                        listener.onFailed("Error de conexion");
                    }
                });
            }
        }, 300);
    }
}
