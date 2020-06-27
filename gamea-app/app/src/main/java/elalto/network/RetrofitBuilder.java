package elalto.network;

import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import elalto.network.entities.TokenManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    //http://172.16.100.28/gamea-serve/api/
    //http://172.16.200.4/gamea-serve/public/api/
    private static final String BASE_URL = "http://web.elalto.gob.bo/api/";

    private final static OkHttpClient client = buildClient();
    private final static Retrofit retrofit = buildRetrofit(client);

    private static OkHttpClient buildClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder()
                                .addHeader("Accept", "application/json")
                                .header("Connection", "close");
                        request = builder.build();
                        return chain.proceed(request);
                    }
                });
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        return builder.build();
    }

    private static Retrofit buildRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T createService(Class<T> service) {
        return retrofit.create(service);
    }

    public static <T>T createServiceWhitAuth(Class<T> service, TokenManager tokenManager){
        OkHttpClient newClient = client.newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                if (tokenManager.getToken().getAccess_token()!=null){
                    builder.addHeader("Authorization", "Bearer "+tokenManager.getToken().getAccess_token())
                            .addHeader("Accept", "application/json")
                            .header("Connection", "close");
                }
                request = builder.build();
                return chain.proceed(request);
            }
        }).authenticator(CustomAuthenticator.getInstance(tokenManager)).build();
        Retrofit newRetrofit = retrofit.newBuilder().client(newClient).build();
        return newRetrofit.create(service);
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
