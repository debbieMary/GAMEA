package elalto.gamea.map.canchas.presenter;

import java.util.List;

import elalto.gamea.map.canchas.entities.Event;
import elalto.gamea.map.canchas.model.DeleteReservaInteractor;
import elalto.gamea.map.canchas.model.HorariosDisponiblesInteractor;
import elalto.gamea.map.canchas.view.DeleteReservaView;
import elalto.gamea.map.canchas.view.HorariosDisponiblesView;
import elalto.network.canchas.entities.DeleteReservaBody;
import elalto.network.canchas.entities.DeleteReservaResponse;

public class DeleteReservaPresenterImpl implements DeleteReservaPresenter, DeleteReservaInteractor.onDeleteReservaFinishedListener{
    private DeleteReservaView deleteReservaView;
    private DeleteReservaInteractor deleteReservaInteractor;

    public DeleteReservaPresenterImpl(DeleteReservaView deleteReservaView,
                                      DeleteReservaInteractor deleteReservaInteractor) {
        this.deleteReservaView = deleteReservaView;
        this.deleteReservaInteractor = deleteReservaInteractor;
    }


    @Override
    public void onSuccess(DeleteReservaResponse deleteReservaResponse) {
        if (deleteReservaView != null) {
            deleteReservaView.hideProgress();
            deleteReservaView.populate(deleteReservaResponse);
        }
    }

    @Override
    public void onFailed(String message) {
        if (deleteReservaView != null) {
            deleteReservaView.hideProgress();
            deleteReservaView.showErrorMessage(message);
        }
    }

    @Override
    public void deleteReserva(DeleteReservaBody deleteReservaBody) {
        deleteReservaInteractor.deleteReservaCancha(deleteReservaBody, this);
        if (deleteReservaView != null) {
            deleteReservaView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        deleteReservaView = null;
    }
}
