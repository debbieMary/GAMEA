package elalto.network;

import java.util.List;
import elalto.gamea.map.canchas.entities.Cancha;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCanchaService {

    @GET("listartodos")
    Call<List<Cancha>> getCanchas();
}
