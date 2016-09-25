package com.example.telebook.Helper;

/**
 * Created by iket on 21/9/16.
 */
public class SharedPreference {

    public static final String Base_Url="http://198.168.0.133:8000";

    private static final String KEY_USERNAME="username";
    private static final String PASSWORD="password";
    private static final int KEY_USERID=1;

    public static String getKeyUsername() {
        return KEY_USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static int getKeyUserid() {
        return KEY_USERID;
    }
}
