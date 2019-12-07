package elalto.gamea.testviolencia.contacto.presenter;

import elalto.gamea.testviolencia.contacto.model.ContactoInteractor;
import elalto.gamea.testviolencia.contacto.view.ContactoView;
import elalto.network.entities.TokenManager;

public class ContactoPresenterImpl implements ContactoPresenter, ContactoInteractor.onContactoFinishedListener {
    private ContactoView contactoView;
    private ContactoInteractor contactoInteractor;

    public ContactoPresenterImpl(ContactoView contactoView, ContactoInteractor contactoInteractor) {
        this.contactoView = contactoView;
        this.contactoInteractor = contactoInteractor;
    }

    @Override
    public void onSuccess(String message) {
        if (contactoView != null) {
            contactoView.hideProgress();
            contactoView.showResponse(message);
        }
    }

    @Override
    public void onFailed(String message) {
        if (contactoView != null) {
            contactoView.hideProgress();
            contactoView.showErrorMessage(message);
        }
    }

    @Override
    public void send_mensaje(String mensaje, String email, Double lat, Double lng, TokenManager tokenManager) {
        if (contactoView != null) {
            contactoView.showProgress();
            contactoInteractor.enviarMensaje(mensaje, email, lat, lng, tokenManager, this);
        }
    }

    @Override
    public void onDestroy() {
        contactoView = null;
    }
}
