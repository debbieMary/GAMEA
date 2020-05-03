package elalto.gamea.map.canchas.entities;

import java.io.Serializable;
import java.util.Calendar;

import elalto.gamea.map.canchas.view.Calendar.data.IEvent;

/**
 * Created by FRAMGIA\pham.van.khac on 07/07/2016.
 */
public class Event implements IEvent , Serializable {

    public int mId;
    public Calendar mStartTime;
    public Calendar mEndTime;
    public String mObs;
    public String mDate;
    public int mColor;

    public Event() {

    }

    public Event(int mId, Calendar mStartTime, Calendar mEndTime, String mObs, String mDate,
                 int mColor) {
        this.mId = mId;
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mObs = mObs;
        this.mDate = mDate;
        this.mColor = mColor;
    }

    public long getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public Calendar getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Calendar startTime) {
        this.mStartTime = startTime;
    }

    public Calendar getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Calendar endTime) {
        this.mEndTime = endTime;
    }

    public String getObs() {
        return mObs;
    }

    public void setObs(String obs) {
        this.mObs = obs;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date ) {
        this.mDate = date;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }
}