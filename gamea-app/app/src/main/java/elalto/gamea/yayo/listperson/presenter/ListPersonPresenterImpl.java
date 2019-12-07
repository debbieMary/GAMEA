package elalto.gamea.yayo.listperson.presenter;

import java.util.List;

import elalto.gamea.yayo.listperson.entities.Desaparecido;
import elalto.gamea.yayo.listperson.model.ListPersonInteractor;
import elalto.gamea.yayo.listperson.view.ListPersonView;
import elalto.network.entities.TokenManager;

public class ListPersonPresenterImpl implements ListPersonPresenter, ListPersonInteractor.OnLisPersonFinishedListener {
    private ListPersonView listPersonView;
    private ListPersonInteractor listPersonInteractor;

    public ListPersonPresenterImpl(ListPersonView listPersonView, ListPersonInteractor listPersonInteractor) {
        this.listPersonView = listPersonView;
        this.listPersonInteractor = listPersonInteractor;
    }

    @Override
    public void getDesaparecidos(TokenManager tokenManager) {
        listPersonView.showProgress();
        listPersonInteractor.getDesaparecidos(tokenManager, this);
    }

    @Override
    public void onSuccess(List<Desaparecido> desaparecidoList) {
        listPersonView.hideProgress();
        listPersonView.setAdapter(desaparecidoList);
    }

    @Override
    public void onFailed(String message) {
        listPersonView.hideProgress();
        listPersonView.showError(message);
        listPersonView.back();
    }

    @Override
    public void onDestroy() {
        listPersonView = null;
    }
}
