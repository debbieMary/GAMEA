package elalto.gamea.siget.model;

import okhttp3.ResponseBody;

public interface SigetInteractor {
    interface OnSigetFinishedListener {
        void onSuccess(ResponseBody responseBody);
        void onSetErrorDTM();
        void onFailed(String messge);
    }

    void getDtm(String dtm, OnSigetFinishedListener listener);
}
