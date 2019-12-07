package elalto.gamea.denuncia.reportar.model;

import android.text.TextUtils;

import java.io.File;
import java.util.HashMap;

import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.TokenManager;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportarInteractorImpl implements ReportarInteractor {
    ApiService service;
    Call<ResponseBody> call;

    @Override
    public void reportar(String distrito, String categoria, String zona, String descripcion, String lat, String lng, File file, TokenManager tokenManager, OnReportarFinishedListener listener) {

        if (TextUtils.isEmpty(distrito)) {
            listener.onDistritoError();
            return;
        }
        if (TextUtils.isEmpty(zona)) {
            listener.onZonaError();
            return;
        }
        if (TextUtils.isEmpty(descripcion)) {
            listener.onDescripcionError();
            return;
        }
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-file"), file);
        MultipartBody.Part partImage = MultipartBody.Part.createFormData("img_denuncia", file.getName(), requestBody);
        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("distrito", RequestBody.create(MediaType.parse("text/plain"), distrito));
        map.put("zona", RequestBody.create(MediaType.parse("text/plain"), zona));
        map.put("descripcion", RequestBody.create(MediaType.parse("text/plain"), descripcion));
        map.put("lat", RequestBody.create(MediaType.parse("text/plain"), lat));
        map.put("lng", RequestBody.create(MediaType.parse("text/plain"), lng));

        call = service.reportar(partImage, map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    listener.onSuccess("Registro exitoso estaremos en contacto con usted");
                } else {
                    if (response.code() == 422 || response.code() == 401) {
                        listener.onFailed("Algunos datos no fueron verificados revisé el formulario");
                    } else {
                        listener.onFailed("Error en el servidor");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onFailed("Error al conectar con el servidor intente nuevamente");
            }
        });
    }
}
