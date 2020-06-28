package elalto.network.canchas;



import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.canchas.entities.DeleteReservaResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiServiceCanchas {

    //get all configurations server
    /*@GET("app/getConfigs/")
    Call<ServerConfigurations> getServerConfigurarions();

    //register user
    @POST("user/register/")
    Call<UserData> getUserId(@Body UserRegistration userRegistration);

    //register user symptoms
    @POST("user-symptom/register/")
    Call<EmptyResponse> addUserSymptom(@Body UserSymptom userSymptom);*/

    @PUT("reservas/aprobar")
    Call<DeleteReservaResponse> deleteReserva(@Header("Authorization") String authHeader, @Body DeleteReservaBody deleteReservaBody);
}
