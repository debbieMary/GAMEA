package elalto.gamea.yayo.addperson.model;


import android.text.TextUtils;
import android.util.Log;

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

public class AddPersonInteractorImpl implements AddPersonInteractor {
    ApiService service;
    Call<ResponseBody> call;

    @Override
    public void publicar(String ci, String nombres, String apellidos, String edad, String genero, String tel_contacto, String desaparecio, String detalles, String lat, String lng, String fecha_desaparicion, File compressImage, TokenManager tokenManager, OnAddPersonFinishedListener listener) {
        if (TextUtils.isEmpty(nombres)) {
            listener.onNombresError("El nombre es obligatorio.");
            return;
        }
        if (TextUtils.isEmpty(apellidos)) {
            listener.onApellidosError("El aepllido es obligatorio");
            return;
        }
        if (TextUtils.isEmpty(edad)) {
            listener.onEdadError("La edad es obligatorio");
            return;
        }
        if (TextUtils.isEmpty(genero)) {
            listener.onGeneroError("El genero es obligatorio");
            return;
        }
        if (TextUtils.isEmpty(tel_contacto)) {
            listener.onCelularError("El telefono es obligatorio");
            return;
        }
        if (TextUtils.isEmpty(desaparecio)) {
            listener.onDesaparecioError("Campo obligatorio");
            return;
        }
        if (TextUtils.isEmpty(detalles)) {
            listener.onDetallesError("Campo obligatorio");
            return;
        }

        if (TextUtils.isEmpty(fecha_desaparicion)) {
            listener.onFechaDesaparicionError("Campo obligatorio");
            return;
        }
        service = RetrofitBuilder.createServiceWhitAuth(ApiService.class, tokenManager);

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-file"), compressImage);
        MultipartBody.Part partImage = MultipartBody.Part.createFormData("imageupload", compressImage.getName(), requestBody);
        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("ci_desaparecido", RequestBody.create(MediaType.parse("text/plain"), ci));
        map.put("nombres_desaparecidos", RequestBody.create(MediaType.parse("text/plain"), nombres));
        map.put("apellidos_desaparecidos", RequestBody.create(MediaType.parse("text/plain"), apellidos));
        map.put("edad", RequestBody.create(MediaType.parse("text/plain"), edad));
        map.put("genero", RequestBody.create(MediaType.parse("text/plain"), genero));
        map.put("tel_contacto", RequestBody.create(MediaType.parse("text/plain"), tel_contacto));
        map.put("desaparecio_inmediaziones", RequestBody.create(MediaType.parse("text/plain"), desaparecio));
        map.put("detalles", RequestBody.create(MediaType.parse("text/plain"), detalles));
        map.put("lat", RequestBody.create(MediaType.parse("text/plain"), lat));
        map.put("lng", RequestBody.create(MediaType.parse("text/plain"), lng));
        map.put("fecha_desaparicion", RequestBody.create(MediaType.parse("text/plain"), fecha_desaparicion));
        call = service.publicarDesaparecido(partImage, map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200){
                        listener.onSucces("Publicado estaremos en contacto con usted.!!");
                    }
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
