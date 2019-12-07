package elalto.gamea.map.canchas.model;


import android.os.StrictMode;
import android.util.Log;

import com.google.gson.JsonObject;

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
import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.gamea.map.canchas.entities.CanchaInfo;
import elalto.network.entities.TokenManager;

public class CanchasInteractorImpl implements CanchasInteractor, CanchaCobroInteractor, CanchasInfoInteractor {

    List<Cancha> canchas = new ArrayList<Cancha>();
    List<CanchaInfo> canchaInfo = new ArrayList<CanchaInfo>();
    List<CanchaCobro> canchaCobro = new ArrayList<CanchaCobro>();
    public static final String URL_BASE = "https://api-game-bo.herokuapp.com/canchas/";
    public static final String URL_SECOND = "https://api-game-bo.herokuapp.com/cobros/";
    public static final String listar_canchas = "listartodos";
    public static final String info_canchas = "listarPorId";
    public static final String listar_cobros = "listarCobros";

    @Override
    public void getCanchas(TokenManager tokenManager, onCanchasFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        canchas.clear();
        try {
            URL url = new URL(URL_BASE + listar_canchas);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            //client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestMethod("GET");
            client.connect();
            /*String json = "";
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            String output = json;
            writer.write(output);
            writer.flush();
            writer.close();*/
            InputStream input = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            Log.d("Canchas list", result.toString());
            JSONObject resultadoCanchas = new JSONObject(result.toString());
            getCanchas(resultadoCanchas);
            listener.onSuccess(canchas);
        } catch (NullPointerException e) {
            listener.onFailed("Error");
            e.printStackTrace();
        } catch (JSONException e) {
            listener.onFailed("Error");
            e.printStackTrace();
        } catch (Exception e) {
            listener.onFailed("Error");
            e.printStackTrace();
        }
    }

    private void getCanchas(JSONObject jsonCanchas){
        try{
            JSONArray data =  jsonCanchas.getJSONArray("data");
            for(int i=0 ; i < data.length(); i++ )
            {
                JSONObject canchaObject= data.getJSONObject(i);
                Log.e("data", canchaObject.toString());
                canchas.add( new Cancha(
                         canchaObject.getInt("id_cancha"),
                         canchaObject.getString("nombre"),
                        canchaObject.getDouble("longitud"),
                        canchaObject.getDouble("latitud"),
                        canchaObject.getString("distrito"),
                        canchaObject.getString("direccion"),
                        canchaObject.getString("telefono")

                        )

                );
            }

        }catch (JSONException e){
            e.printStackTrace();
        }


    }


    @Override
    public void getCanchasInfo(String id_cancha, onCanchasInfoFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        canchas.clear();
        try {
            URL url = new URL(URL_BASE+ info_canchas);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestMethod("POST");
            client.connect();
            String json = setIdCancha(id_cancha);
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
            String output = json;
            writer.write(output);
            writer.flush();
            writer.close();

            InputStream input;
            int status = client.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK)  {
                input = client.getErrorStream();
            }
            else  {
                input = client.getInputStream();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            Log.d("CanchaInfo", result.toString());
            JSONObject resultadoCobros = new JSONObject(result.toString());
            getCobrosObject(resultadoCobros);
            listener.onSuccess(canchaInfo);
        } catch (NullPointerException e) {
            listener.onFailed("Error");
            e.printStackTrace();
        } catch (JSONException e) {
            listener.onFailed("Error");
            e.printStackTrace();
        } catch (Exception e) {
            listener.onFailed("Error");
            e.printStackTrace();
        }
    }


    public String setIdCancha(String id_cancha){
        JSONObject jsonObject =  new JSONObject();
        try {
            jsonObject.put("id_cancha", id_cancha);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public void getCobros(TokenManager tokenManager, onCobroFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        canchas.clear();
        try {
            URL url = new URL(URL_SECOND+ listar_cobros);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestMethod("GET");
            client.connect();
            InputStream input;
            int status = client.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK)  {
                input = client.getErrorStream();
            }
            else  {
                input = client.getInputStream();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            Log.d("Cobros", result.toString());
            JSONObject resultadoCobros = new JSONObject(result.toString());
            getCobrosObject(resultadoCobros);
            listener.onSuccessCC(canchaCobro);
        } catch (NullPointerException e) {
            listener.onFailedCC("Error");
            e.printStackTrace();
        } catch (JSONException e) {
            listener.onFailedCC("Error");
            e.printStackTrace();
        } catch (Exception e) {
            listener.onFailedCC("Error");
            e.printStackTrace();
        }
    }

    public void getCobrosObject(JSONObject cobrosJsonObject){
        try{
            JSONArray data =  cobrosJsonObject.getJSONArray("data");
            for(int i=0 ; i < data.length(); i++ )
            {
                JSONObject canchaObject= data.getJSONObject(i);
                Log.e("data", canchaObject.toString());
                canchaCobro.add( new CanchaCobro(
                                canchaObject.getInt("id_cobro"),
                                canchaObject.getString("nombre_cobro"),
                                canchaObject.getDouble("latitud"),
                                canchaObject.getDouble("longitud"),
                                canchaObject.getString("telefono"),
                                canchaObject.getString("direccion")
                        )

                );
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
