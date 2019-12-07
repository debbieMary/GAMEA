package elalto.network;

import java.util.List;
import java.util.Map;

import elalto.gamea.artesano.categoria.model.Categoria;
import elalto.gamea.artesano.productos.model.Producto;
import elalto.gamea.catastro.consulta_tramite.entities.Tramite;
import elalto.gamea.denuncia.misreportes.entities.Denuncia;
import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.dependencias.entities.Dependencias;
import elalto.gamea.map.hospitales.entities.HospitalPoint;
import elalto.gamea.map.modulosPoliciales.entities.Modulos;
import elalto.gamea.recaudaciones.entities.Inmueble;
import elalto.gamea.recaudaciones.entities.Patente;
import elalto.gamea.recaudaciones.entities.PatentePublicidad;
import elalto.gamea.recaudaciones.entities.Vehiculo;
import elalto.gamea.testviolencia.dondeacudir.Ubicaciones;
import elalto.gamea.yayo.listperson.entities.Desaparecido;
import elalto.network.entities.AccessToken;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface ApiService {

    @POST("auth/login")
    @FormUrlEncoded
    Call<AccessToken> login(@Field("ci") String ci, @Field("password") String password);

    @GET("auth/logout")
    Call<ResponseBody> logout();

    @GET("auth/refresh")
    Call<AccessToken> refresh();

    @POST("register_me")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("ci") String ci, @Field("nombres") String nombres, @Field("apellidos") String apellidos, @Field("celular") String celular, @Field("email") String email, @Field("distrito") String distrito, @Field("direccion") String direccion, @Field("password") String password, @Field("password_confirmation") String password_confirmation);

    //ARTESANO ROUTES
    @GET("artesano/get_categorias")
    Call<List<Categoria>> getCategorias();

    @GET("artesano/get_productos")
    Call<List<Producto>> getProductos(@Query("idCategoria") String idCategoria);

    //YAYO
    @Multipart
    @POST("yayo/save_desaparecido")
    Call<ResponseBody> publicarDesaparecido(@Part MultipartBody.Part imagen, @PartMap Map<String, RequestBody> partMap);

    @GET("yayo/get_desaparecidos")
    Call<List<Desaparecido>> getDesaparecidos();

    //DENUNCIAS ROUTES
    @Multipart
    @POST("denuncia/save_denuncia")
    Call<ResponseBody> reportar(@Part MultipartBody.Part imagen, @PartMap Map<String, RequestBody> partMap);

    @GET("denuncia/get_denuncia")
    Call<List<Denuncia>> getDenuncias();

    //MAPS DATA
    @GET("maps/get_hospitals")
    Call<List<HospitalPoint>> getHospitals();

    @GET("maps/get_modulos_policiales")
    Call<List<Modulos>> getModulos();

    @GET("maps/get_canchas")
    Call<List<Cancha>> getCanchas();

    @GET("maps/get_dependencias")
    Call<List<Dependencias>> getDependencias();

    //SIGET
    @GET("consultarDtm.php")
    Call<ResponseBody> findDtm(@Query("cod_dtm") String cod_dtm);

    //CATASTRO
    @POST("catastrogamea/c_busqueda_tramite/get_tramite_android")
    @FormUrlEncoded
    Call<Tramite> getTramite(@Field("tramite") String tramite, @Field("tipo") String tipo);

    //SUGERENCIA
    @POST("denuncia/save_sugerencia")
    @FormUrlEncoded
    Call<ResponseBody> sendSugerencia(@Field("sugerencia") String sugerencia);

    //RECAUDACIONES
    @POST("recaudaciones/find_deuda_vehiculos")
    @FormUrlEncoded
    Call<Vehiculo> findVehiculo(@Field("tipo_doc") String tipo_doc, @Field("nro_doc") String nro_doc);

    @POST("recaudaciones/find_deuda_inmueble")
    @FormUrlEncoded
    Call<Inmueble> findInmueble(@Field("tipo_doc") String tipo_doc, @Field("nro_doc") String nro_doc);

    @POST("recaudaciones/find_deuda_patente")
    @FormUrlEncoded
    Call<Patente> findPatente(@Field("tipo_doc") String tipo_doc, @Field("nro_doc") String nro_doc);

    @POST("recaudaciones/find_deuda_patente_publicidad")
    @FormUrlEncoded
    Call<PatentePublicidad> findPatentePublicidad(@Field("tipo_doc") String tipo_doc, @Field("nro_doc") String nro_doc);

    //ENVIAR MENSAJE TEST VIOLENCIA
    @POST("volar_alto/save_mensaje")
    @FormUrlEncoded
    Call<ResponseBody> saveMensaje(@Field("mensaje") String mensaje, @Field("email") String email, @Field("lat") Double lat, @Field("lng") Double lng);


    @GET("volar_alto/get_puntos")
    Call<List<Ubicaciones>> getUbicaciones();
}
