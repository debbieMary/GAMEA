package elalto.gamea.map.modulosPoliciales.model;

import java.util.List;

import elalto.gamea.map.hospitales.entities.HospitalPoint;
import elalto.gamea.map.modulosPoliciales.entities.Modulos;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModulosInteractorImpl implements ModulosInteractor {
    ApiService service;
    Call<List<Modulos>> listCall;

    @Override
    public void getModulos(TokenManager tokenManager, onModulosFinishedListener listener) {
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
        listCall = service.getModulos();
        listCall.enqueue(new Callback<List<Modulos>>() {
            @Override
            public void onResponse(Call<List<Modulos>> call, Response<List<Modulos>> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        listener.onSuccess(response.body());
                    } else {
                        listener.onFailed("Algo salio mal");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Modulos>> call, Throwable t) {
                listener.onFailed("Error de conexion");
            }
        });
    }
}
