package elalto.network.canchas;



import elalto.network.canchas.entities.CanchaCobroResponse;
import elalto.network.canchas.entities.CanchaInfoBody;
import elalto.network.canchas.entities.CanchaInfoResponse;
import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.canchas.entities.DeleteReservaResponse;
import elalto.network.canchas.entities.ListadoCanchasResponse;
import elalto.network.canchas.entities.ReservaBody;
import elalto.network.canchas.entities.ReservaResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiServiceCanchas {

    @GET("canchas/listartodos")
    Call<ListadoCanchasResponse> getListadoCanchas(@Header("Authorization") String authHeader);

    @GET("cobros/listarCobros")
    Call<CanchaCobroResponse> getListadoCobros(@Header("Authorization") String authHeader);

    @POST("canchas/listarPorId")
    Call<CanchaInfoResponse> getCanchaInfo( @Header("Authorization") String authHeader, @Body CanchaInfoBody canchaInfoBody);

    @POST("reservas/reservar")
    Call<ReservaResponse> saveReserva(@Header("Authorization") String authHeader, @Body ReservaBody reservaBody);

    @PUT("reservas/aprobar")
    Call<DeleteReservaResponse> deleteReserva(@Header("Authorization") String authHeader, @Body DeleteReservaBody deleteReservaBody);
}
