package elalto.gamea.denuncia.misreportes.model;

import java.util.List;

import elalto.gamea.denuncia.misreportes.entities.Denuncia;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisReportesInteractorImpl implements MisReportesInteractor {
    ApiService service;
    Call<List<Denuncia>> listCall;

    @Override
    public void getReportes(TokenManager tokenManager, OnMisReportesFinishedListener listener) {
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
        listCall = service.getDenuncias();
        listCall.enqueue(new Callback<List<Denuncia>>() {
            @Override
            public void onResponse(Call<List<Denuncia>> call, Response<List<Denuncia>> response) {
                if (response.code() == 200) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailed("Algo salio mal");
                }
            }

            @Override
            public void onFailure(Call<List<Denuncia>> call, Throwable t) {
                listener.onFailed("Error de conexion");
            }
        });
    }
}
