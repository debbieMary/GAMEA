package elalto.gamea.catastro.consulta_tramite.model;

import android.text.TextUtils;

import elalto.gamea.catastro.consulta_tramite.entities.Tramite;
import elalto.network.ApiService;
import elalto.network.CatastroRetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultaTramiteInteractorImpl implements ConsultaTramiteInteractor {
    ApiService service;
    Call<Tramite> call;

    @Override
    public void getTramite(String tramite, String tipo, onConsultaTramiteFinishedListener listener) {
        if (TextUtils.isEmpty(tramite)) {
            listener.setErrorConsulta("Ingrese su número de tramite");
            return;
        }
        service = CatastroRetrofitBuilder.createService(ApiService.class);
        call = service.getTramite(tramite, tipo);
        call.enqueue(new Callback<Tramite>() {
            @Override
            public void onResponse(Call<Tramite> call, Response<Tramite> response) {
                new android.os.Handler().postDelayed(
                      new Runnable() {
                          public void run() {
                              listener.onSuccess(response.body());
                          }
                      },
                      1500);
            }

            @Override
            public void onFailure(Call<Tramite> call, Throwable t) {
                listener.onFailed("Error al conectar al servidor");
            }
        });
    }
}
