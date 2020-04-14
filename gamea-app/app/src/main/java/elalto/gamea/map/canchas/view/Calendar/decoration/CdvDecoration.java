package elalto.gamea.map.canchas.view.Calendar.decoration;

import android.graphics.Rect;


import elalto.gamea.map.canchas.view.Calendar.DayView;
import elalto.gamea.map.canchas.view.Calendar.EventView;
import elalto.gamea.map.canchas.view.Calendar.PopupView;
import elalto.gamea.map.canchas.view.Calendar.data.IEvent;
import elalto.gamea.map.canchas.view.Calendar.data.IPopup;

/**
 * Created by FRAMGIA\pham.van.khac on 22/07/2016.
 */
public interface CdvDecoration {

    EventView getEventView(IEvent event, Rect eventBound, int hourHeight, int seperateHeight);

    PopupView getPopupView(IPopup popup, Rect eventBound, int hourHeight, int seperateHeight);

    DayView getDayView(int hour);
}
