package elalto.gamea.yayo.addperson.presenter;


import java.io.File;

import elalto.network.entities.TokenManager;

public interface AddPersonPresenter {
    void publicar(String ci, String nombres, String apellidos, String edad, String genero, String tel_contacto, String desaparecio, String detalles, String lat, String lng, String fecha_desaparicion, File compressImage, TokenManager tokenManager);

    void destroy();
}
