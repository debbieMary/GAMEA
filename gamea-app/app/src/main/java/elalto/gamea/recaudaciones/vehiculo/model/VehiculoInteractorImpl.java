package elalto.gamea.recaudaciones.vehiculo.model;

import android.text.TextUtils;

import elalto.gamea.recaudaciones.entities.Vehiculo;
import elalto.gamea.recaudaciones.vehiculo.presenter.VehiculoPresenter;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehiculoInteractorImpl implements VehiculoInteractor {
    ApiService service;
    Call<Vehiculo> vehiculoCall;

    @Override
    public void findVehiculo(String tipo_doc, String nro_doc, TokenManager tokenManager, onVehiculoFinishedListener listener) {
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
                vehiculoCall = service.findVehiculo(tipo_doc, nro_doc);
                vehiculoCall.enqueue(new Callback<Vehiculo>() {
                    @Override
                    public void onResponse(Call<Vehiculo> call, Response<Vehiculo> response) {
                        if (response.code() == 200) {
                            listener.onSuccess(response.body());
                        } else {
                            if (response.code() == 204){
                                listener.onFailed("No se encontro registros");
                            }else{
                                listener.onFailed("Algo salio mal");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Vehiculo> call, Throwable t) {
                        listener.onFailed("Error de conexion");
                    }
                });
            }
        }, 300);
    }
}
