package elalto.gamea.testviolencia.dondeacudir.model;

import java.util.List;

import elalto.gamea.testviolencia.dondeacudir.Ubicaciones;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DondeAcudirInteractorImpl implements DondeAcudirInteractor {
    ApiService service;
    Call<List<Ubicaciones>> listCall;

    @Override
    public void getUbicaciones(onDondeAcudirFinishedListener listener) {
        service = RetrofitBuilder.createService(ApiService.class);
        listCall = service.getUbicaciones();
        listCall.enqueue(new Callback<List<Ubicaciones>>() {
            @Override
            public void onResponse(Call<List<Ubicaciones>> call, Response<List<Ubicaciones>> response) {
                if (response.code() == 200) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailed("Algo salio mal");
                }
            }

            @Override
            public void onFailure(Call<List<Ubicaciones>> call, Throwable t) {
                listener.onFailed("Error de conexion");
            }
        });
    }
}
