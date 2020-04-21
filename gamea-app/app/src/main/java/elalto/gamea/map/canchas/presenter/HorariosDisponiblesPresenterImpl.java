package elalto.gamea.map.canchas.presenter;

import android.util.Log;

import java.util.List;

import elalto.gamea.map.canchas.entities.Event;
import elalto.gamea.map.canchas.model.HorariosDisponiblesInteractor;
import elalto.gamea.map.canchas.view.HorariosDisponiblesView;

public class HorariosDisponiblesPresenterImpl implements HorariosDisponiblesPresenter, HorariosDisponiblesInteractor.onHorariosDisponiblesFinishedListener{
    private HorariosDisponiblesView horariosDisponiblesCobroView;
    private HorariosDisponiblesInteractor horariosDisponiblesInteractor;

    public HorariosDisponiblesPresenterImpl(HorariosDisponiblesView horariosDisponiblesCobroView,
                                            HorariosDisponiblesInteractor horariosDisponiblesInteractor) {
        this.horariosDisponiblesCobroView = horariosDisponiblesCobroView;
        this.horariosDisponiblesInteractor = horariosDisponiblesInteractor;
    }


    @Override
    public void onSuccess(List<Event> horarios) {
        Log.e("hola hola",horarios.size()+"");
        Log.e("hola hola",horarios+"");
        if (horariosDisponiblesCobroView != null) {
            horariosDisponiblesCobroView.hideProgress();
            horariosDisponiblesCobroView.populate(horarios);
        }
    }

    @Override
    public void onFailed(String message) {
        if (horariosDisponiblesCobroView != null) {
            horariosDisponiblesCobroView.hideProgress();
            horariosDisponiblesCobroView.showErrorMessage(message);
        }
    }

    @Override
    public void getHorariosDisponibles(String id_cancha, String fecha_inicio, String fecha_fin) {
        horariosDisponiblesInteractor.getHorariosDisponibles(id_cancha,  fecha_inicio, fecha_fin, this);
        if (horariosDisponiblesCobroView != null) {
            horariosDisponiblesCobroView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        horariosDisponiblesCobroView = null;
    }
}
