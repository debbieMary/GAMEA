package elalto.gamea.siget.presenter;

import elalto.gamea.siget.model.SigetInteractor;
import elalto.gamea.siget.view.SigetView;
import okhttp3.ResponseBody;

public class SigetPresenterImpl implements SigetPresenter, SigetInteractor.OnSigetFinishedListener {
    private SigetView sigetView;
    private SigetInteractor sigetInteractor;

    public SigetPresenterImpl(SigetView sigetView, SigetInteractor sigetInteractor) {
        this.sigetView = sigetView;
        this.sigetInteractor = sigetInteractor;
    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        if (sigetView != null) {
            sigetView.hideProgress();
            sigetView.getDtm(responseBody);
        }
    }

    @Override
    public void onSetErrorDTM() {
        if (sigetView != null) {
            sigetView.setErrorDtm();
            sigetView.hideProgress();
        }
    }

    @Override
    public void onFailed(String messge) {
        if (sigetView != null) {
            sigetView.hideProgress();
            sigetView.showErrorMessage(messge);
        }
    }

    @Override
    public void getDtm(String dtm) {
        sigetView.showProgress();
        sigetInteractor.getDtm(dtm, this);
    }

    @Override
    public void onDestroy() {
        sigetView = null;
    }
}
