package elalto.network.canchas;



import elalto.network.canchas.entities.CanchaCobroResponse;
import elalto.network.canchas.entities.CanchaInfoBody;
import elalto.network.canchas.entities.CanchaInfoResponse;
import elalto.network.canchas.entities.CantidadReservasResponse;
import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.canchas.entities.DeleteReservaResponse;
import elalto.network.canchas.entities.HorariosBody;
import elalto.network.canchas.entities.HorariosResponse;
import elalto.network.canchas.entities.ListadoCanchasResponse;
import elalto.network.canchas.entities.IdUsuarioBody;
import elalto.network.canchas.entities.MisReservasResponse;
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

    @POST("reservas/misReservas")
    Call<MisReservasResponse> getMisReservas(@Header("Authorization") String authHeader, @Body IdUsuarioBody misReservaBody);

    @POST("reservas/listarReservasPorRangofecha")
    Call<HorariosResponse> getHorarios(@Header("Authorization") String authHeader, @Body HorariosBody horariosBody);


    @POST("reservas/cantidadReservasPendientes")
    Call<CantidadReservasResponse> getCantidadPendientes(@Header("Authorization") String authHeader, @Body IdUsuarioBody misReservaBody);

    @PUT("reservas/aprobar")
    Call<DeleteReservaResponse> deleteReserva(@Header("Authorization") String authHeader, @Body DeleteReservaBody deleteReservaBody);
}
