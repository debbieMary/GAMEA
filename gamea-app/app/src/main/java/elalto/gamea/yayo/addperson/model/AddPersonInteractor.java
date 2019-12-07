package elalto.gamea.yayo.addperson.model;

import java.io.File;

import elalto.network.entities.TokenManager;

public interface AddPersonInteractor {
    interface OnAddPersonFinishedListener {
        void onNombresError(String message);

        void onApellidosError(String message);

        void onEdadError(String message);

        void onGeneroError(String message);

        void onCelularError(String message);

        void onDesaparecioError(String message);

        void onDetallesError(String message);

        void onFechaDesaparicionError(String message);

        void onSucces(String message);

        void onFailed(String message);
    }

    void publicar(String ci, String nombres, String apellidos, String edad, String genero, String tel_contacto, String desaparecio, String detalles, String lat, String lng, String fecha_desaparicion, File compressImage, TokenManager tokenManager, OnAddPersonFinishedListener listener);
}
