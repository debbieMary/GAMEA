package elalto.gamea.map.canchas.model;


import android.util.Log;

import org.json.JSONException;

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
    public static final String URL_BASE = "";
    public static final String URL_SECOND = "";
    public static final String listar_canchas = "";
    public static final String info_canchas = "";
    public static final String listar_cobros = "";

    @Override
    public void getCanchas(TokenManager tokenManager, onCanchasFinishedListener listener) {
        URL url = new URL(URL_BASE + listar_canchas);
        HttpURLConnection client = (HttpURLConnection) url.openConnection();
        client.setDoOutput(true);
        client.setDoInput(true);
        client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        client.setRequestMethod("POST");

        client.connect();

        String json = null;


        json = devuelve_cadena_json();

        Log.d("doInBackground(Request)", json);

        OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
        String output = json;
        writer.write(output);
        writer.flush();
        writer.close();

        InputStream input = client.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        Log.d("doInBackground(Resp)", result.toString());


        JSONObject resultado = new JSONObject(result.toString());
        System.out.println("$$$$$$$$$$$$$$$$ " + resultado.toString());


        mensaje = resultado.getString("mensaje");
        System.out.println(mensaje);


        if (mensaje.equals("usuario_incorrecto")) {
            servidor = "no";


        } else {

            nombres = resultado.getString("nombres");
            apellidos = resultado.getString("apellidos");
            id = resultado.getString("idPersona");
            fs.guardar_id_telefono(activity, id_telefono);
            fs.guardar_nombres_apellidos(activity, nombres + " " + apellidos);
            fs.guardar_id_usuario(activity, id);
            servidor = "si";
        }
    }


        catch(
    NullPointerException e)

    {
        servidor = "problemas_de_conexion";
    } catch(
    JSONException e)

    {
        Log.e("log_tag", "Error parsing data " + e.toString());
        e.printStackTrace();
    } catch(
    Exception e)

    {
        e.printStackTrace();
    }

}


    @Override
    public void getCanchasInfo(String id_cancha, onCanchasInfoFinishedListener listener) {

    }

    @Override
    public void getCobros(TokenManager tokenManager, onCobroFinishedListener listener) {

    }


}
