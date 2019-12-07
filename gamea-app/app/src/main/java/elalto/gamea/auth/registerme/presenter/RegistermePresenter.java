package elalto.gamea.auth.registerme.presenter;

public interface RegistermePresenter {
    void registerme(String ci, String nombres, String apellidos, String celular, String email, String distrito, String zona, String direccion, String password, String password_confirmation);

    void onDestroy();
}
