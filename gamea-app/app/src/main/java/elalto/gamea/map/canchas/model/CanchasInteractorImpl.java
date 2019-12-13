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
import java.util.Comparator;
import java.util.List;

import elalto.gamea.map.canchas.entities.Cancha;
import elalto.gamea.map.canchas.entities.CanchaCobro;
import elalto.gamea.map.canchas.entities.CanchaInfo;
import elalto.gamea.map.canchas.entities.Horarios;
import elalto.gamea.map.canchas.entities.MisReservas;
import elalto.network.entities.TokenManager;

public class CanchasInteractorImpl implements CanchasInteractor, CanchaCobroInteractor,
        CanchasInfoInteractor, CanchaReservaInteractor, MisReservasInteractor,
        HorariosDisponiblesInteractor {

    List<Cancha> canchas = new ArrayList<Cancha>();
    List<CanchaInfo> canchaInfo = new ArrayList<CanchaInfo>();
    List<CanchaCobro> canchaCobro = new ArrayList<CanchaCobro>();
    List<MisReservas> misReservas = new ArrayList<MisReservas>();
    List<Horarios> horarios = new ArrayList<Horarios>();
    public static final String URL_BASE = "https://api-game-bo.herokuapp.com/canchas/";
    public static final String URL_SECOND = "https://api-game-bo.herokuapp.com/cobros/";
    public static final String URL_THIRD = "https://api-game-bo.herokuapp.com/reservas/";
    public static final String listar_canchas = "listartodos";
    public static final String info_canchas = "listarPorId";
    public static final String listar_cobros = "listarCobros";
    public static final String reservar_cancha = "reservar";
    public static final String get_mis_reservas = "misReservas";
    public static final String get_horarios_por_fecha = "listarReservasPorfecha";

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

    private void getCanchas(JSONObject jsonCanchas) {
        try {
            JSONArray data = jsonCanchas.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject canchaObject = data.getJSONObject(i);
                Log.e("data", canchaObject.toString());
                canchas.add(new Cancha(
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

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getCanchasInfo(String id_cancha, onCanchasInfoFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        canchaInfo.clear();
        try {
            URL url = new URL(URL_BASE + info_canchas);
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
            Log.e("CanchaInfo", result.toString());
            JSONObject resultCanchainfo = new JSONObject(result.toString());
            getCanchaInfo(resultCanchainfo);
            Log.e("########", canchaInfo.toString());
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


    public String setIdCancha(String id_cancha) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_cancha", id_cancha);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


    private void getCanchaInfo(JSONObject canchaInfoParameter) {
        try {
            JSONArray data = canchaInfoParameter.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject canchaInfoObject = data.getJSONObject(i);
                Log.e("data", canchaInfoObject.toString());
                canchaInfo.add(new CanchaInfo(
                                canchaInfoObject.getInt("id_cancha"),
                                canchaInfoObject.getString("nombre"),
                                canchaInfoObject.getString("categoria"),
                                canchaInfoObject.getDouble("longitud"),
                                canchaInfoObject.getDouble("latitud"),
                                canchaInfoObject.getString("tipo_escenario_deportivo"),
                                canchaInfoObject.getString("tiene_perimetral"),
                                canchaInfoObject.getString("tiene_tinglado_techo"),
                                canchaInfoObject.getString("tipo_pavimento"),
                                canchaInfoObject.getString("se_encuentra"),
                                canchaInfoObject.getString("administrado_por"),
                                canchaInfoObject.getString("graderias"),
                                canchaInfoObject.getString("banos"),
                                canchaInfoObject.getString("camerinos"),
                                canchaInfoObject.getString("acceso_libre"),
                                canchaInfoObject.getString("quien_realizo"),
                                canchaInfoObject.getString("estado"),
                                canchaInfoObject.getString("distrito"),
                                canchaInfoObject.getString("direccion"),
                                canchaInfoObject.getString("telefono"),
                                canchaInfoObject.getString("foto1"),
                                canchaInfoObject.getString("foto2"),
                                canchaInfoObject.getString("foto3"),
                                canchaInfoObject.getString("fecha_Alta"),
                                canchaInfoObject.getString("usuario_alta"),
                                canchaInfoObject.getString("hora_inicio"),
                                canchaInfoObject.getString("hora_fin")
                        )
                );
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getCobros(TokenManager tokenManager, onCobroFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        canchas.clear();
        try {
            URL url = new URL(URL_SECOND + listar_cobros);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestMethod("GET");
            client.connect();
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

    public void getCobrosObject(JSONObject cobrosJsonObject) {
        try {
            JSONArray data = cobrosJsonObject.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject canchaObject = data.getJSONObject(i);
                Log.e("data", canchaObject.toString());
                canchaCobro.add(new CanchaCobro(
                                canchaObject.getInt("id_cobro"),
                                canchaObject.getString("nombre_cobro"),
                                canchaObject.getDouble("latitud"),
                                canchaObject.getDouble("longitud"),
                                canchaObject.getString("telefono"),
                                canchaObject.getString("direccion")
                        )

                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCanchasReserva(String reserva, onCanchasReservaFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            URL url = new URL(URL_THIRD + reservar_cancha);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestMethod("POST");
            client.connect();
            String json = reserva;
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
            Log.e("CanchaReserva", result.toString());
            JSONObject jsonObject = new JSONObject(result.toString());
            if (jsonObject.getBoolean("resultado")) {
                listener.onSuccess("Reserva de cancha exitoso");
            } else {
                listener.onSuccess("Algo salió mal al reservar la cancha");
            }
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

    @Override
    public void getMisReservas(String id_usuario, onMisReservasFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        misReservas.clear();
        try {
            URL url = new URL(URL_THIRD + get_mis_reservas);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            client.setRequestMethod("POST");
            client.connect();
            String json = setIdUsuario(id_usuario);
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
            Log.e("MisReservas", result.toString());
            JSONObject resultMisReservas = new JSONObject(result.toString());
            getMisReservas(resultMisReservas);
            listener.onSuccess(misReservas);
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

    public String setIdUsuario(String id_usuario) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_usuario", id_usuario);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


    public void getMisReservas(JSONObject resultMisReservasObject) {
        try {
            JSONArray data = resultMisReservasObject.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject misReservasObject = data.getJSONObject(i);
                misReservas.add(new MisReservas(
                        misReservasObject.getString("nombre"),
                        misReservasObject.getString("distrito"),
                        misReservasObject.getInt("id_reserva"),
                        misReservasObject.getInt("id_cancha"),
                        misReservasObject.getInt("id_usuario"),
                        misReservasObject.getString("fecha"),
                        misReservasObject.getString("hora_inicio"),
                        misReservasObject.getString("hora_fin"),
                        misReservasObject.getString("ci_quien_reserva"),
                        misReservasObject.getString("nombre_reserva"),
                        misReservasObject.getString("observaciones"),
                        misReservasObject.getInt("modo_registro"),
                        misReservasObject.getInt("estado"),
                        misReservasObject.getString("fecha_alta"),
                        misReservasObject.getString("fecha_update")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getHorariosDisponibles(String id_cancha, String fecha_inicio, String fecha_fin, onHorariosDisponiblesFinishedListener listener) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        horarios.clear();
        try {
            URL url = new URL(URL_THIRD + get_horarios_por_fecha);
            HttpURLConnection client = (HttpURLConnection) url.openConnection();
            client.setDoOutput(true);
            client.setDoInput(true);
            client.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
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
            Log.e("########", "****************************");
            listener.onSuccess(horarios);

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


    public String setBodyHorarios(String id_cancha, String fecha_inicio, String fecha_fin) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_cancha", id_cancha);
            jsonObject.put("fecha", fecha_inicio);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("JSON", jsonObject.toString());
        return jsonObject.toString();
    }


    private void getHorariosList(JSONObject horariosJson) {
        try {
            JSONArray data = horariosJson.getJSONArray("data");
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

                    for (int i = horaInicio; i < horaFin; i++) {
                        String hora = Integer.toString(i).length() == 1 ? "0" + Integer.toString(i) : Integer.toString(i);
                        horarios.add(new Horarios(fecha, hora + ":00", "1"));
                    }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
