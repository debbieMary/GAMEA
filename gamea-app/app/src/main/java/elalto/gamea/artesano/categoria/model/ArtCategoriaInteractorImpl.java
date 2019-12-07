package elalto.gamea.artesano.categoria.model;


import android.util.Log;

import java.util.List;

import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtCategoriaInteractorImpl implements ArtCategoriaInteractor {
    ApiService service;
    Call<List<Categoria>> listCall;

    @Override
    public void getCategorias(OnCategoriaFinishedListener listener) {
        service = RetrofitBuilder.createService(ApiService.class);
        listCall = service.getCategorias();
        listCall.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailed();
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                listener.onFailed();
            }
        });
    }
}
