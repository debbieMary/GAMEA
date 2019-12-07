package elalto.gamea.map.hospitales.model;

import java.util.List;

import elalto.gamea.map.hospitales.entities.HospitalPoint;
import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalInteractorImpl implements HospitalInteractor {
    ApiService service;
    Call<List<HospitalPoint>> listCall;

    @Override
    public void getHospitals(TokenManager tokenManager, onHospitalFinishedListener listener) {
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
        listCall = service.getHospitals();
        listCall.enqueue(new Callback<List<HospitalPoint>>() {
            @Override
            public void onResponse(Call<List<HospitalPoint>> call, Response<List<HospitalPoint>> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        listener.onSuccess(response.body());
                    } else {
                        listener.onFailed("Algo salio mal");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<HospitalPoint>> call, Throwable t) {
                listener.onFailed("Error de conexion");
            }
        });
    }
}
