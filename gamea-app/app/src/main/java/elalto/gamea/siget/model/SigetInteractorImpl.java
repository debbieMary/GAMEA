package elalto.gamea.siget.model;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import elalto.network.ApiService;
import elalto.network.SigetRetrofitBuilder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigetInteractorImpl implements SigetInteractor {
    ApiService service;
    Call<ResponseBody> call;

    @Override
    public void getDtm(String dtm, OnSigetFinishedListener listener) {
        if (TextUtils.isEmpty(dtm)) {
            listener.onSetErrorDTM();
            return;
        }
        service = SigetRetrofitBuilder.createService(ApiService.class);
        call = service.findDtm(dtm);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                new android.os.Handler().postDelayed(
                      new Runnable() {
                          public void run() {
                              listener.onSuccess(response.body());
                          }
                      },
                      1500);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onFailed("Error al conectar al servidor");
            }
        });

    }
}
