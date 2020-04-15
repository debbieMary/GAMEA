package elalto.gamea.map.canchas.view.Calendar.decoration;

import android.content.Context;
import android.graphics.Rect;



import elalto.gamea.map.canchas.view.Calendar.DayView;
import elalto.gamea.map.canchas.view.Calendar.EventView;
import elalto.gamea.map.canchas.view.Calendar.data.IEvent;

/**
 * Created by FRAMGIA\pham.van.khac on 22/07/2016.
 */
public class CdvDecorationDefault implements CdvDecoration {

    protected Context mContext;

    protected EventView.OnEventClickListener mEventClickListener;


    public CdvDecorationDefault(Context context) {
        this.mContext = context;
    }

    @Override
    public EventView getEventView(IEvent event, Rect eventBound, int hourHeight,
                                  int separateHeight) {
        EventView eventView = new EventView(mContext);
        eventView.setEvent(event);
        eventView.setPosition(eventBound, -hourHeight, hourHeight - separateHeight * 2);
        eventView.setOnEventClickListener(mEventClickListener);
        return eventView;
    }



    @Override
    public DayView getDayView(int hour) {
        DayView dayView = new DayView(mContext);
        dayView.setText(String.format("%1$2s:00", hour));
        return dayView;
    }

    public void setOnEventClickListener(EventView.OnEventClickListener listener) {
        this.mEventClickListener = listener;
    }


}
