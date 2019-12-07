package elalto.network.entities;

import android.content.SharedPreferences;

public class TokenManager {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private static TokenManager INSTACE = null;

    private TokenManager(SharedPreferences prefs) {
        this.prefs = prefs;
        this.editor = prefs.edit();
    }

    public static synchronized TokenManager getInstance(SharedPreferences prefs) {
        if (INSTACE == null) {
            INSTACE = new TokenManager(prefs);
        }
        return INSTACE;
    }

    public void saveToken(AccessToken token){
        editor.putString("ACCESS_TOKEN",token.getAccess_token()).commit();

    }

    public void deleteToken(){
        editor.remove("ACCESS_TOKEN").commit();
    }

    public AccessToken getToken(){
        AccessToken token = new AccessToken();
        token.setAccess_token(prefs.getString("ACCESS_TOKEN",null));
        return token;
    }
}
