package com.example.telebook.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by iket on 27/9/16.
 */
public class SharedPrefs {

    // Shared preferences file name
    public static final String PREF_NAME = "NiceEyesData";
    public static final String KEY_SHOW_NOTIFICATION = "KeyNotification";
    public static final String KEY_COLOR_ID = "ColorIdKey";
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_IS_LOGGED_IN = "logIn";
    public static final String KEY_VIBRATION= "vibration";




    public static String TAG = "Shared Preference";
    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    public SharedPrefs(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setShowNotification(boolean isLoggedIn) {
        editor.putBoolean(KEY_SHOW_NOTIFICATION, isLoggedIn);
        editor.commit();
    }

    public void setVibration(boolean isLoggedIn) {
        editor.putBoolean(KEY_VIBRATION, isLoggedIn);
        editor.commit();
    }

    public void setKeyIsLoggedIn(boolean login)
    {
        editor.putBoolean(KEY_IS_LOGGED_IN,login);
        editor.commit();
    }

    public void setKeyUserId(int userID)
    {
        editor.putInt(KEY_USER_ID,userID);
        editor.commit();
    }
    public  int getKeyUserId()
    {
        return pref.getInt(KEY_USER_ID,2001);
    }
    public boolean isLoggedIn()
    {
        return pref.getBoolean(KEY_IS_LOGGED_IN,false);
    }

    public boolean showNotification() {
        return pref.getBoolean(KEY_SHOW_NOTIFICATION, true);
    }

    public boolean showVibration() {
        return pref.getBoolean(KEY_VIBRATION, true);
    }
    public void setUsername(String username) {

        editor.putString(KEY_USER_NAME, username);
        Log.d("Response1",username);
        editor.commit();

    }
    public String getUserName()
    {
        Log.d("Response2",pref.getString(KEY_USER_NAME," User "));
        return pref.getString(KEY_USER_NAME," User ");
    }



    public int getColor() {
        return pref.getInt(KEY_COLOR_ID, 0);
    }

    public void setColorId(int colorId) {

        editor.putInt(KEY_COLOR_ID, colorId);
        editor.commit();
    }


}