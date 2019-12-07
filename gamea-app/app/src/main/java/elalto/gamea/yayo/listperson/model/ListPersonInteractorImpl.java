package elalto.gamea.yayo.listperson.model;

import java.util.List;

import elalto.gamea.yayo.listperson.entities.Desaparecido;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPersonInteractorImpl implements ListPersonInteractor {
    ApiService service;
    Call<List<Desaparecido>> call;

    @Override
    public void getDesaparecidos(TokenManager tokenManager, OnLisPersonFinishedListener listener) {
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
        call = service.getDesaparecidos();
        call.enqueue(new Callback<List<Desaparecido>>() {
            @Override
            public void onResponse(Call<List<Desaparecido>> call, Response<List<Desaparecido>> response) {
                if (response.code() == 200) {
                    listener.onSuccess(response.body());
                } else {

                    listener.onFailed("Algo salio mal");
                }
            }

            @Override
            public void onFailure(Call<List<Desaparecido>> call, Throwable t) {
                listener.onFailed("Error de conexion");
            }
        });
    }
}
