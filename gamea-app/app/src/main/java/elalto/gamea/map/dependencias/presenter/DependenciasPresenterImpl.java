package elalto.gamea.map.dependencias.presenter;

import java.util.List;

import elalto.gamea.map.dependencias.entities.Dependencias;
import elalto.gamea.map.dependencias.model.DependenciasInteractor;
import elalto.gamea.map.dependencias.view.DependenciasView;

public class DependenciasPresenterImpl implements DependenciasPresenter, DependenciasInteractor.onDependenciasFinishedListener {
    private DependenciasView dependenciasView;
    private DependenciasInteractor dependenciasInteractor;

    public DependenciasPresenterImpl(DependenciasView dependenciasView, DependenciasInteractor dependenciasInteractor) {
        this.dependenciasView = dependenciasView;
        this.dependenciasInteractor = dependenciasInteractor;
    }

    @Override
    public void onSuccess(List<Dependencias> dependencias) {
        if (dependenciasView != null) {
            dependenciasView.hideProgress();
            dependenciasView.getDependencias(dependencias);
        }
    }

    @Override
    public void onFailed(String message) {
        if (dependenciasView != null) {
            dependenciasView.navigateToBack();
            dependenciasView.hideProgress();
            dependenciasView.showErrorMessage(message);
        }
    }

    @Override
    public void getDependencias() {
        if (dependenciasView != null) {
            dependenciasView.showProgress();
            dependenciasInteractor.getDependencias(this);
        }
    }

    @Override
    public void onDestroy() {
        dependenciasView = null;
    }
}
