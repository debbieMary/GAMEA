package elalto.gamea.recaudaciones.vehiculo.presenter;

import elalto.gamea.recaudaciones.entities.Vehiculo;
import elalto.gamea.recaudaciones.vehiculo.model.VehiculoInteractor;
import elalto.gamea.recaudaciones.vehiculo.view.VehiculoView;
import elalto.network.entities.TokenManager;

public class VehiculoPresenterImpl implements VehiculoPresenter, VehiculoInteractor.onVehiculoFinishedListener {
    private VehiculoView vehiculoView;
    private VehiculoInteractor vehiculoInteractor;

    public VehiculoPresenterImpl(VehiculoView vehiculoView, VehiculoInteractor vehiculoInteractor) {
        this.vehiculoView = vehiculoView;
        this.vehiculoInteractor = vehiculoInteractor;
    }

    @Override
    public void onSuccess(Vehiculo vehiculo) {
        if (vehiculoView != null) {
            vehiculoView.hideProgress();
            vehiculoView.showResponse(vehiculo);
        }
    }

    @Override
    public void onFailed(String message) {
        if (vehiculoView != null) {
            vehiculoView.hideProgress();
            vehiculoView.showErrorMessage(message);
        }
    }

    @Override
    public void getVehiculo(String tipo_doc, String nro_doc, TokenManager tokenManager) {
        vehiculoInteractor.findVehiculo(tipo_doc, nro_doc, tokenManager, this);
        if (vehiculoView != null) {
            vehiculoView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        vehiculoView = null;
    }
}
