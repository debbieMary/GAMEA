package elalto.network.entities;

import java.io.IOException;
import java.lang.annotation.Annotation;

import elalto.network.RetrofitBuilder;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class Utils {
    public static LoginError loginErrorConver(ResponseBody response) {
        Converter<ResponseBody, LoginError> converter = RetrofitBuilder.getRetrofit().responseBodyConverter(LoginError.class, new Annotation[0]);
        LoginError loginError = null;
        try {
            loginError = converter.convert(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginError;
    }

    public static RegisterError registerError(ResponseBody response) {
        Converter<ResponseBody, RegisterError> converter = RetrofitBuilder.getRetrofit().responseBodyConverter(RegisterError.class, new Annotation[0]);
        RegisterError registerError = null;
        try {
            registerError = converter.convert(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registerError;
    }
}
