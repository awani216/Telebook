package com.example.telebook.Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by iket on 21/9/16.
 */
public class SharedPreference {

    public static final String Base_Url="http://198.168.0.133:8000";
    private static final String PREF_NAME = "Data";
    private static final String KEY_USERNAME="username";
    private static final String PASSWORD="password";
    private static final int KEY_USERID=1;


    static SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    public SharedPreference(Context _context) {

        this._context = _context;
        pref =_context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setUsername(String username) {

        editor.putString(KEY_USERNAME, username);
        editor.commit();

    }

    public void setPassword(String password) {

        editor.putString(PASSWORD, password);
        editor.commit();

    }

    public void setUserid(int userid) {

        editor.putInt(String.valueOf(KEY_USERID), userid);
        editor.commit();

    }

    public static int getKeyUserid() {
        return pref.getInt(String.valueOf(KEY_USERID),01);
    }

    public static String getPASSWORD() {
        return pref.getString(PASSWORD,"");
    }

    public static String getKeyUsername() {
        return pref.getString(KEY_USERNAME,"");
    }
}
