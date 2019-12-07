package elalto.gamea.map.dependencias.model;

import java.util.List;

import elalto.gamea.map.dependencias.entities.Dependencias;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DependenciasInteractorImpl implements DependenciasInteractor {
    ApiService service;
    Call<List<Dependencias>> listCall;

    @Override
    public void getDependencias(onDependenciasFinishedListener listener) {
        service = RetrofitBuilder.createService(ApiService.class);
        listCall = service.getDependencias();
        listCall.enqueue(new Callback<List<Dependencias>>() {
            @Override
            public void onResponse(Call<List<Dependencias>> call, Response<List<Dependencias>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailed("Error en el servidor " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Dependencias>> call, Throwable t) {
                listener.onFailed("Revise su conexion a internet");
            }
        });
    }
}
