package elalto.gamea.map.modulosPoliciales.presenter;

import java.util.List;

import elalto.gamea.map.modulosPoliciales.entities.Modulos;
import elalto.gamea.map.modulosPoliciales.model.ModulosInteractor;
import elalto.gamea.map.modulosPoliciales.view.ModulosView;
import elalto.network.entities.TokenManager;

public class ModulosPresenterImpl implements ModulosPresenter, ModulosInteractor.onModulosFinishedListener {
    private ModulosView modulosView;
    private ModulosInteractor modulosInteractor;

    public ModulosPresenterImpl(ModulosView modulosView, ModulosInteractor modulosInteractor) {
        this.modulosView = modulosView;
        this.modulosInteractor = modulosInteractor;
    }

    @Override
    public void onSuccess(List<Modulos> modulosList) {
        if (modulosView != null) {
            modulosView.hideProgress();
            modulosView.populateMap(modulosList);
        }
    }

    @Override
    public void onFailed(String message) {
        if (modulosView != null) {
            modulosView.hideProgress();
            modulosView.showErrorMessage(message);
        }
    }

    @Override
    public void getModulos(TokenManager tokenManager) {
        modulosInteractor.getModulos(tokenManager, this);
        if (modulosView != null) {
            modulosView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        modulosView = null;
    }
}
