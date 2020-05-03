package elalto.gamea.map.canchas.utils;

import android.app.Activity;
import android.util.DisplayMetrics;



public class GeneralUtils {

    public int get_width(Activity act)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        return  width;
    }

    public int get_height(Activity  act)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        return  height;
    }

    public String transformDate(String fecha){
        return fecha.split("-")[2]+"/"+ fecha.split("-")[1]+"/"+fecha.split("-")[0];
    }

}
