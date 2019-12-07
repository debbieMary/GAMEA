package elalto.gamea.artesano.productos.model;

import java.util.List;

import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtProductosInteractorImpl implements ArtProductosInteractor {
    ApiService service;
    Call<List<Producto>> listCall;

    @Override
    public void getProductos(String idCategoria, onProductosFinishedListener listener) {
        service = RetrofitBuilder.createService(ApiService.class);
        listCall = service.getProductos(idCategoria);
        listCall.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailed();
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                listener.onFailed();
            }
        });
    }
}
