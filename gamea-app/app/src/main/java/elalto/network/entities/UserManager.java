package elalto.network.entities;

import android.content.Context;
import android.content.SharedPreferences;


public class UserManager {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public void saveCi(Context context, String ci) {
        prefs = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.putString("ci", ci);
        editor.commit();

    }


    public String getCi(Context context) {
        prefs = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor = prefs.edit();
        String ci= prefs.getString("ci", null);
        return ci!= null  ? ci : "";
    }


    public void deleteUserData(Context context) {
        prefs = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.clear();
        editor.commit();
    }


    public void saveIdUser(Context context, Integer id_user)
    {

        prefs=context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor= prefs.edit();
        editor.putInt("id_user", id_user);
        editor.commit();

    }
    public Integer getIdUser(Context context)
    {
        prefs =context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor = prefs.edit();
        Integer id_user=  prefs.getInt("id_user",0);
        return (id_user != 0) ? id_user : 0;
    }



    public void saveUserName(Context context, String userName)
    {
        prefs=context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor= prefs.edit();
        editor.putString("userName", userName);
        editor.commit();

    }
    public String getUserName(Context context)
    {
        prefs =context.getSharedPreferences("UserData", Context.MODE_PRIVATE);
        editor = prefs.edit();
        String  userName=  prefs.getString("userName",null);
        return userName != null ? userName : null;
    }

   /* public void  deleteIdUser(Context context)
    {
        prefs =context.getSharedPreferences("identification", Context.MODE_PRIVATE);
        editor = prefs.edit();
        editor.clear();
        editor.commit();
    }*/
}