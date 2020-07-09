package elalto.gamea.map.canchas.model;


import android.util.Log;

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
import elalto.network.canchas.entities.HorarioReservado;
import elalto.network.canchas.entities.HorariosBody;
import elalto.network.canchas.entities.HorariosResponse;
import elalto.network.canchas.entities.ListadoCanchasResponse;
import elalto.network.canchas.entities.IdUsuarioBody;
import elalto.network.canchas.entities.ListarUserBody;
import elalto.network.canchas.entities.ListarUserResponse;
import elalto.network.canchas.entities.MisReservasResponse;
import elalto.network.canchas.entities.ReservaBody;
import elalto.network.canchas.entities.ReservaResponse;
import elalto.network.entities.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CanchasInteractorImpl implements CanchasInteractor, CanchaCobroInteractor,
        CanchasInfoInteractor, CanchaReservaInteractor, MisReservasInteractor,
        HorariosDisponiblesInteractor, CantidadReservasPendientesInteractor, DeleteReservaInteractor,  UserCanchasInteractor {


    ApiServiceCanchas apiService;
    private final String TAG = "[CANCHAS_SERVICE]";
    public static final String TOKEN = "R2FtZWE6Q2FuY2hhcw==";


    @Override
    public void getCanchas(TokenManager tokenManager, onCanchasFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<ListadoCanchasResponse> call = apiService.getListadoCanchas(TOKEN);
        call.enqueue(new Callback<ListadoCanchasResponse>() {
            @Override
            public void onResponse(Call<ListadoCanchasResponse> call, Response<ListadoCanchasResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ListadoCanchasResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
                listener.onFailed(t.getMessage());
            }

        });
    }


    @Override
    public void getCanchasInfo(String id_cancha, onCanchasInfoFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<CanchaInfoResponse> call = apiService.getCanchaInfo(TOKEN, getCanchaInfoBody(id_cancha));
        call.enqueue(new Callback<CanchaInfoResponse>() {
            @Override
            public void onResponse(Call<CanchaInfoResponse> call, Response<CanchaInfoResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<CanchaInfoResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
                listener.onFailed(t.getMessage());
            }

        });
    }


    public CanchaInfoBody getCanchaInfoBody(String id_cancha) {
        CanchaInfoBody canchaInfoBody = new CanchaInfoBody();
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
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<CanchaCobroResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
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
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(response.body().getMensaje());
                }
            }

            @Override
            public void onFailure(Call<ReservaResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
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
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<MisReservasResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }

    @Override
    public void getHorariosDisponibles(HorariosBody horariosBody, onHorariosDisponiblesFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<HorariosResponse> call = apiService.getHorarios(TOKEN, horariosBody);
        call.enqueue(new Callback<HorariosResponse>() {
            @Override
            public void onResponse(Call<HorariosResponse> call, Response<HorariosResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(setHorariosEvent(response.body().getData()));
                }
            }

            @Override
            public void onFailure(Call<HorariosResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }


    public List<Event> setHorariosEvent(List<HorarioReservado> horarioReservados) {
        List<Event> event = new ArrayList<Event>();
        for (int i = 0; i < horarioReservados.size(); i++) {
            String fecha = horarioReservados.get(i).getFecha().split("T")[0];
            int horaInicio = Integer.parseInt(horarioReservados.get(i).getHoraInicio().split(":")[0]);
            int horaFin = Integer.parseInt(horarioReservados.get(i).getHoraFin().split(":")[0]);
            int id_reserva = horarioReservados.get(i).getIdReserva();
            String observaciones = "Reservado";

            Calendar timeStart = Calendar.getInstance();
            timeStart.set(Calendar.HOUR_OF_DAY, horaInicio);
            timeStart.set(Calendar.MINUTE, 0);
            Calendar timeEnd = (Calendar) timeStart.clone();
            timeEnd.set(Calendar.HOUR_OF_DAY, horaFin);
            timeEnd.set(Calendar.MINUTE, 0);
            event.add(new Event(id_reserva, timeStart, timeEnd, observaciones, fecha, 123));
        }
        return event;
    }

    @Override
    public void getCantidadReservasPendientes(IdUsuarioBody idUsuarioBody, onCantidadReservasPendientesFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<CantidadReservasResponse> call = apiService.getCantidadPendientes(TOKEN, idUsuarioBody);
        call.enqueue(new Callback<CantidadReservasResponse>() {
            @Override
            public void onResponse(Call<CantidadReservasResponse> call, Response<CantidadReservasResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getData());
                    listener.onSuccessCantidadReservasPendientes(response.body().getData().get(0).getCantidad());
                }
            }

            @Override
            public void onFailure(Call<CantidadReservasResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
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
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<DeleteReservaResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }

    @Override
    public void getUserCanchas(ListarUserBody listarUserBody, onFinishedListener listener) {
        apiService = ApiUtilsCanchas.getCanchasService();
        Call<ListarUserResponse> call = apiService.getUser(TOKEN, listarUserBody);
        call.enqueue(new Callback<ListarUserResponse>() {
            @Override
            public void onResponse(Call<ListarUserResponse> call, Response<ListarUserResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "SUCCESS!!!: " + response.body().getMensaje());
                    listener.onSuccess(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ListarUserResponse> call, Throwable t) {
                Log.e(TAG, "ERROR!!! Services version: " + t.getMessage());
                listener.onFailed(t.getMessage());
            }
        });
    }
}
