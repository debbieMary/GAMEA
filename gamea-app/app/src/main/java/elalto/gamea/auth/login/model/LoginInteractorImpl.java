package elalto.gamea.auth.login.model;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

import elalto.network.ApiService;
import elalto.network.RetrofitBuilder;
import elalto.network.entities.AccessToken;
import elalto.network.entities.LoginError;
import elalto.network.entities.Utils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginInteractorImpl implements LoginInteractor {
    ApiService service;
    Call<AccessToken> call;
    @Override
    public void login(String ci, String password, OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(ci)) {
                    listener.onCierror();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    return;
                }

                service = RetrofitBuilder.createService(ApiService.class);
                call = service.login(ci,password);
                call.enqueue(new Callback<AccessToken>() {
                    @Override
                    public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                        if (response.isSuccessful()){
                            listener.onSuccess(response.body());
                        }else {
                            if (response.code() == 422 || response.code() == 401 || response.code() == 402) {
                                listener.onFailed(loginError(response.errorBody()));
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<AccessToken> call, Throwable t) {
                    }
                });
            }
        }, 1000);
    }

    private void decodeToken(String token){
        try {
            String[] split = token.split("\\.");
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
            Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }

    private LoginError loginError(ResponseBody response) {
        LoginError loginError = Utils.loginErrorConver(response);
        return loginError;
    }
}
