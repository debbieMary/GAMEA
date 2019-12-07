package elalto.gamea.siget.view;

import okhttp3.ResponseBody;

public interface SigetView {
    void showProgress();
    void hideProgress();
    void showErrorMessage(String message);
    void setErrorDtm();
    void getDtm(ResponseBody responseBody);

}
