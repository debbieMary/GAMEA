package elalto.gamea.yayo.addperson.presenter;

import java.io.File;

import elalto.gamea.yayo.addperson.model.AddPersonInteractor;
import elalto.gamea.yayo.addperson.view.AddPersonView;
import elalto.network.entities.TokenManager;

public class AddPersonPresenterImpl implements AddPersonPresenter, AddPersonInteractor.OnAddPersonFinishedListener {
    private AddPersonView addPersonView;
    private AddPersonInteractor addPersonInteractor;

    public AddPersonPresenterImpl(AddPersonView addPersonView, AddPersonInteractor addPersonInteractor) {
        this.addPersonView = addPersonView;
        this.addPersonInteractor = addPersonInteractor;
    }

    @Override
    public void publicar(String ci, String nombres, String apellidos, String edad, String genero, String tel_contacto, String desaparecio, String detalles, String lat, String lng, String fecha_desaparicion, File compressImage, TokenManager tokenManager) {
        addPersonView.showProgress();
        addPersonInteractor.publicar(ci, nombres, apellidos, edad, genero, tel_contacto, desaparecio, detalles, lat, lng, fecha_desaparicion, compressImage, tokenManager, this);
    }

    @Override
    public void destroy() {
        addPersonView = null;
    }

    @Override
    public void onNombresError(String message) {
        if (addPersonView != null) {
            addPersonView.setNombresError(message);
            addPersonView.hideProgress();
        }
    }

    @Override
    public void onApellidosError(String message) {
        if (addPersonView != null) {
            addPersonView.setApellidosError(message);
        }
    }

    @Override
    public void onEdadError(String message) {
        if (addPersonView != null) {
            addPersonView.setEdadError(message);
        }
    }

    @Override
    public void onGeneroError(String message) {
        if (addPersonView != null) {
            addPersonView.setGeneroError(message);
        }
    }

    @Override
    public void onCelularError(String message) {
        if (addPersonView != null) {
            addPersonView.setCelularError(message);
        }
    }

    @Override
    public void onDesaparecioError(String message) {
        if (addPersonView != null) {
            addPersonView.setDesaparecioError(message);
        }
    }

    @Override
    public void onDetallesError(String message) {
        if (addPersonView != null) {
            addPersonView.setDetallesError(message);
        }
    }

    @Override
    public void onFechaDesaparicionError(String message) {
        if (addPersonView != null) {
            addPersonView.setFechaDesaparicionError(message);
        }
    }

    @Override
    public void onSucces(String message) {
        addPersonView.resetFormulario();
        addPersonView.hideProgress();
        addPersonView.showSuccessMessage(message);
    }

    @Override
    public void onFailed(String message) {
        addPersonView.hideProgress();
        addPersonView.showErrorMessage(message);
    }
}
