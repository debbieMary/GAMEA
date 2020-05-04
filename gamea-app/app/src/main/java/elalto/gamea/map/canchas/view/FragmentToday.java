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
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentToday extends Fragment {

    CalendarDayView dayView;
    ArrayList<IEvent> events = new ArrayList<IEvent>();
    View view;
    HorariosDisponiblesActivity hd=  new HorariosDisponiblesActivity();
    String fecha_actual;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_today, container, false);
        fecha_actual= hd.getToday();
        events.addAll(hd.getHorariosReservados(fecha_actual));
        setCalendar();
        return view;
    }


    public  void setCalendar(){

        dayView = (CalendarDayView) view.findViewById(R.id.calendarToday);
        dayView.setLimitTime(7, 20);
        //TODO  filter events
        dayView.setEvents(events);
        ((CdvDecorationDefault) (dayView.getDecoration())).setOnEventClickListener(
                new EventView.OnEventClickListener() {
                    @Override
                    public void onEventClick(EventView view, IEvent data) {
                        Log.e("TAG", "onEventClick:" + data.getObs());
                    }

                    @Override
                    public void onEventViewClick(View view, EventView eventView, IEvent data) {
                        Log.e("TAG", "onEventViewClick:" + data.getObs());
                        if (data instanceof Event) {
                            // change event (ex: set event color)
                            dayView.setEvents(events);
                        }
                    }
                });
    }


    @Override
    public void onStop() {
        events.clear();
        super.onStop();
    }
}