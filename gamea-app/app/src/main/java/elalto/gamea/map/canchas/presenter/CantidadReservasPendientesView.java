package elalto.gamea.map.canchas.presenter;


public interface CantidadReservasPendientesView {
    void showProgressCantidadReservasPendientes();

    void hideProgressCantidadReservasPendientes();

    void populateCantidadReservasPendientes(int cantidad);

    void showErrorMessageCantidadReservasPendientes(String message);

}
