package elalto.gamea.map.canchas.model;


import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import elalto.gamea.map.canchas.entities.Event;
import elalto.network.canchas.ApiServiceCanchas;
import elalto.network.canchas.ApiUtilsCanchas;
import elalto.network.canchas.entities.CanchaCobroResponse;
import elalto.network.canchas.entities.CanchaInfoBody;
import elalto.network.canchas.entities.CanchaInfoResponse;
import elalto.network.canchas.entities.CantidadReservasResponse;
import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.canchas.entities.DeleteReservaResponse;
import elalto.network.canchas.entities.ListadoCanchasResponse;
import elalto.network.canchas.entities.IdUsuarioBody;
import elalto.network.canchas.entities.MisReservasResponse;
import elalto.network.canchas.entities.ReservaBody;
import elalto.network.canchas.entities.ReservaResponse;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CanchasInteractorImpl implements CanchasInteractor, CanchaCobroInteractor,
        CanchasInfoInteractor, CanchaReservaInteractor, MisReservasInteractor,
        HorariosDisponiblesInteractor, CantidadReservasPendientesInteractor, DeleteReservaInteractor {

    List<Event> event =  new ArrayList<Event>();


    public static final String URL_RESERVAS = "https://api-game-bo.herokuapp.com/reservas/";
    public static final String get_cantidad_mis_reservas_pendientes = "cantidadReservasPendientes";
    public static final String get_horarios_por_fecha = "listarReservasPorRangofecha";


    ApiServiceCanchas apiService;
    private final String TAG="[CANCHAS_SERVICE]";
    public static final String TOKEN= "R2FtZWE6Q2FuY2hhcw==";


    @Override
    public void getCanchas(TokenManager tokenManager, onCanchasFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<ListadoCanchasResponse> call = apiService.getListadoCanchas(TOKEN);
        call.enqueue(new Callback<ListadoCanchasResponse>() {
            @Override
            public void onResponse(Call<ListadoCanchasResponse> call, Response<ListadoCanchasResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"SUCCESS!!!: "+  response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ListadoCanchasResponse> call, Throwable t) {
                Log.e(TAG,"ERROR!!! Services version: "+  t.getMessage());
                listener.onFailed(t.getMessage());
            }

        });
    }



    @Override
    public void getCanchasInfo(String id_cancha, onCanchasInfoFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<CanchaInfoResponse> call = apiService.getCanchaInfo(TOKEN, getCanchaInfoBody(id_cancha) );
        call.enqueue(new Callback<CanchaInfoResponse>() {
            @Override
            public void onResponse(Call<CanchaInfoResponse> call, Response<CanchaInfoResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"SUCCESS!!!: "+  response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<CanchaInfoResponse> call, Throwable t) {
                Log.e(TAG,"ERROR!!! Services version: "+  t.getMessage());
                listener.onFailed(t.getMessage());
            }

        });
    }


    public CanchaInfoBody getCanchaInfoBody(String id_cancha){
        CanchaInfoBody canchaInfoBody=  new CanchaInfoBody();
        canchaInfoBody.setIdCancha(id_cancha);
        return canchaInfoBody;
    }


    @Override
    public void getCobros(TokenManager tokenManager, onCobroFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<CanchaCobroResponse> call = apiService.getListadoCobros(TOKEN);
        call.enqueue(new Callback<CanchaCobroResponse>() {
            @Override
            public void onResponse(Call<CanchaCobroResponse> call, Response<CanchaCobroResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"SUCCESS!!!: "+  response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<CanchaCobroResponse> call, Throwable t) {
                Log.e(TAG,"ERROR!!! Services version: "+  t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }


    @Override
    public void saveCanchasReserva(ReservaBody reservaBody, onCanchasReservaFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<ReservaResponse> call = apiService.saveReserva(TOKEN, reservaBody);
        call.enqueue(new Callback<ReservaResponse>() {
            @Override
            public void onResponse(Call<ReservaResponse> call, Response<ReservaResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"SUCCESS!!!: "+  response.body().getMensaje());
                    listener.onSuccess(response.body().getMensaje());
                }
            }

            @Override
            public void onFailure(Call<ReservaResponse> call, Throwable t) {
                Log.e(TAG,"ERROR!!! Services version: "+  t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }


    @Override
    public void getMisReservas(IdUsuarioBody idUsuarioBody, onMisReservasFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<MisReservasResponse> call = apiService.getMisReservas(TOKEN, idUsuarioBody);
        call.enqueue(new Callback<MisReservasResponse>() {
            @Override
            public void onResponse(Call<MisReservasResponse> call, Response<MisReservasResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"SUCCESS!!!: "+  response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<MisReservasResponse> call, Throwable t) {
                Log.e(TAG,"ERROR!!! Services version: "+  t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }

    @Override
    public void getHorariosDisponibles(String id_cancha, String fecha_inicio, String fecha_fin, onHorariosDisponiblesFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        event.clear();
        try {
            URL url = new URL(URL_RESERVAS + get_horarios_por_fecha);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestProperty("Authorization", TOKEN);
            client.setRequestMethod("POST");
            client.connect();
            String json = setBodyHorarios(id_cancha, fecha_inicio, fecha_fin);
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            String output = json;
            writer.write(output);
            writer.flush();
            writer.close();

            InputStream input;
            int status = client.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK) {
                input = client.getErrorStream();
            } else {
                input = client.getInputStream();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            Log.e("HORARIOS DISPONIBLES", result.toString());
            JSONObject horariosJson = new JSONObject(result.toString());
            getHorariosList(horariosJson);
            listener.onSuccess(event);

        } catch (NullPointerException e) {
            listener.onFailed(e.getMessage());
            e.printStackTrace();
        } catch (JSONException e) {
            listener.onFailed( e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            listener.onFailed( e.getMessage());
            e.printStackTrace();
        }
    }


    public String setBodyHorarios(String id_cancha, String fecha_inicio, String fecha_fin) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_cancha", id_cancha);
            jsonObject.put("fecha_inicio", fecha_inicio);
            jsonObject.put("fecha_fin", fecha_fin);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("JSON", jsonObject.toString());
        return jsonObject.toString();
    }


    private void getHorariosList(JSONObject horariosJson) {
        try {
            JSONArray data = horariosJson.getJSONArray("data");
            Log.e("HORARIOS DATA", data.toString());
            setHorariosArrayList(data);
            /**/
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void setHorariosArrayList(JSONArray data) {
        try {

                for (int j = 0; j < data.length(); j++) {
                    JSONObject horariosDisponiblesObject = data.getJSONObject(j);
                    String fecha = horariosDisponiblesObject.getString("fecha").split("T")[0];
                    int horaInicio = Integer.parseInt(horariosDisponiblesObject.getString("hora_inicio").split(":")[0]);
                    int horaFin = Integer.parseInt(horariosDisponiblesObject.getString("hora_fin").split(":")[0]);
                    int id_reserva = Integer.parseInt(horariosDisponiblesObject.getString("id_reserva").split(":")[0]);
                    String observaciones = "Reservado";//horariosDisponiblesObject.getString("observaciones");

                    Calendar timeStart = Calendar.getInstance();
                    timeStart.set(Calendar.HOUR_OF_DAY, horaInicio);
                    timeStart.set(Calendar.MINUTE, 0);
                    Calendar timeEnd = (Calendar) timeStart.clone();
                    timeEnd.set(Calendar.HOUR_OF_DAY, horaFin);
                    timeEnd.set(Calendar.MINUTE, 0);
                    event.add(new Event (id_reserva, timeStart, timeEnd, observaciones, fecha, 123));
                }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /*@Override
    public void getCantidadReservasPendientes(String id_usuario, onCantidadReservasPendientesFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            URL url = new URL(URL_RESERVAS + get_cantidad_mis_reservas_pendientes);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestProperty("Authorization", TOKEN);
            client.setRequestMethod("POST");
            client.connect();
            String json = "";
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            String output = json;
            writer.write(output);
            writer.flush();
            writer.close();

            InputStream input;
            int status = client.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK) {
                input = client.getErrorStream();
            } else {
                input = client.getInputStream();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            Log.e("ReservasPendientes", result.toString());
            JSONObject reservasPendientesJson = new JSONObject(result.toString());
            int cantidad= getCantidadReservasPendientesInt(reservasPendientesJson);
            listener.onSuccessCantidadReservasPendientes(cantidad);
        } catch (NullPointerException e) {
            listener.onFailedCantidadReservasPendientes("Error");
            e.printStackTrace();
        } catch (JSONException e) {
            listener.onFailedCantidadReservasPendientes("Error");
            e.printStackTrace();
        } catch (Exception e) {
            listener.onFailedCantidadReservasPendientes("Error");
            e.printStackTrace();
        }
    }*/


    @Override
    public void getCantidadReservasPendientes(IdUsuarioBody idUsuarioBody, onCantidadReservasPendientesFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<CantidadReservasResponse> call = apiService.getCantidadPendientes(TOKEN, idUsuarioBody);
        call.enqueue(new Callback<CantidadReservasResponse>() {
            @Override
            public void onResponse(Call<CantidadReservasResponse> call, Response<CantidadReservasResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"SUCCESS!!!: "+  response.body().getData());
                    listener.onSuccessCantidadReservasPendientes(response.body().getData().get(0).getCantidad());
                }
            }
            @Override
            public void onFailure(Call<CantidadReservasResponse> call, Throwable t) {
                Log.e(TAG,"ERROR!!! Services version: "+  t.getMessage());
                listener.onFailedCantidadReservasPendientes(t.getMessage());
            }
        });
    }



    @Override
    public void deleteReservaCancha(DeleteReservaBody deleteReservaBody, final onDeleteReservaFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<DeleteReservaResponse> call = apiService.deleteReserva(TOKEN, deleteReservaBody);
        call.enqueue(new Callback<DeleteReservaResponse>() {
            @Override
            public void onResponse(Call<DeleteReservaResponse> call, Response<DeleteReservaResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,"SUCCESS!!!: "+  response.body().getMensaje());
                    listener.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<DeleteReservaResponse> call, Throwable t) {
                Log.e(TAG,"ERROR!!! Services version: "+  t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }

}
