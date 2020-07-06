package elalto.gamea.map.canchas.presenter;


import elalto.gamea.map.canchas.model.CantidadReservasPendientesInteractor;
import elalto.network.canchas.entities.IdUsuarioBody;

public class CantidadReservasPendientesPresenterImpl implements CantidadReservasPendientesPresenter , CantidadReservasPendientesInteractor.onCantidadReservasPendientesFinishedListener {

    private CantidadReservasPendientesView cantidadReservasPendientesView;
    private CantidadReservasPendientesInteractor cantidadReservasPendientesInteractor;

    public CantidadReservasPendientesPresenterImpl(CantidadReservasPendientesView cantidadReservasPendientesView,
                                                   CantidadReservasPendientesInteractor cantidadReservasPendientesInteractor) {
        this.cantidadReservasPendientesView = cantidadReservasPendientesView;
        this.cantidadReservasPendientesInteractor = cantidadReservasPendientesInteractor;
    }

    @Override
    public void onSuccessCantidadReservasPendientes(int cantidad) {
        if (cantidadReservasPendientesView != null) {
            cantidadReservasPendientesView.hideProgressCantidadReservasPendientes();
            cantidadReservasPendientesView.populateCantidadReservasPendientes(cantidad);
        }
    }

    @Override
    public void onFailedCantidadReservasPendientes(String message) {
        if (cantidadReservasPendientesView != null) {
            cantidadReservasPendientesView.hideProgressCantidadReservasPendientes();
            cantidadReservasPendientesView.showErrorMessageCantidadReservasPendientes(message);
        }
    }

    @Override
    public void getCantidadReservasPendientes(IdUsuarioBody id_usuario) {
        cantidadReservasPendientesInteractor.getCantidadReservasPendientes(id_usuario, this);
        if (cantidadReservasPendientesView != null) {
            cantidadReservasPendientesView.hideProgressCantidadReservasPendientes();
        }
    }

    @Override
    public void onDestroy() {
        cantidadReservasPendientesView= null;
    }
}
