package elalto.gamea.map.canchas.view;

import android.os.Bundle;
import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.Event;
import elalto.gamea.map.canchas.view.Calendar.CalendarDayView;
import elalto.gamea.map.canchas.view.Calendar.EventView;
import elalto.gamea.map.canchas.view.Calendar.data.IEvent;
import elalto.gamea.map.canchas.view.Calendar.decoration.CdvDecorationDefault;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class FragmentTomorrow extends Fragment {

    CalendarDayView dayView;
    ArrayList<IEvent> events = new ArrayList<IEvent>();
    View view;
    HorariosDisponiblesActivity hd=  new HorariosDisponiblesActivity();
    String fecha_manhiana;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tomorrow, container, false);
        fecha_manhiana= hd.getTomorrow();
        Log.e("lalala", "manhiana "  +  fecha_manhiana);
        events.addAll(hd.getHorariosReservados(fecha_manhiana));
        setCalendar();
        return view;
    }


    public  void setCalendar(){

        dayView = (CalendarDayView) view.findViewById(R.id.calendarTomorrow);
        dayView.setLimitTime(7, 20);
        //TODO  filter events
        dayView.setEvents(events);
        ((CdvDecorationDefault) (dayView.getDecoration())).setOnEventClickListener(
                new EventView.OnEventClickListener() {
                    @Override
                    public void onEventClick(EventView view, IEvent data) {
                        Log.e("TAG", "onEventClick:" + data.getName());
                    }

                    @Override
                    public void onEventViewClick(View view, EventView eventView, IEvent data) {
                        Log.e("TAG", "onEventViewClick:" + data.getName());
                        if (data instanceof Event) {
                            // change event (ex: set event color)
                            dayView.setEvents(events);
                        }
                    }
                });
    }
}