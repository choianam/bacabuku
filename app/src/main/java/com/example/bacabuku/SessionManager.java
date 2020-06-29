package com.example.bacabuku;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

class SessionManager {
    //    deklarasi sharedpref untuk menyimpan session login
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;

    //    nama untuk tiap shared pref
    public static final String PREF_NAME = "LOGIN";
    public static final String LOGIN_STATUS = "LOGIN_STATUS";
    public static final String USER_ID = "USER_ID";
    public static final String USERNAME = "USERNAME";
    public static final String ID_AKSES = "ID_AKSES";

    //  constructor session manager
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //    fungsi untuk menyimpan session login
    public void createSession(String user_id, String Username, String id_akses) {
        editor.putBoolean(LOGIN_STATUS, true);
        editor.putString(USER_ID, user_id);
        editor.putString(USERNAME, Username);
        editor.putString(ID_AKSES, id_akses);
        editor.apply();
    }

    //    fungsi untuk cek apakah user sudah login
    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN_STATUS, false);
    }

    public void checkLogin(){
        if(!this.isLogin()){
            Intent kembaliLogin = new Intent(context, MainActivity.class);
            context.startActivity(kembaliLogin);
            ((SudahLogin)context).finish();
        }
    }
    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(USER_ID,sharedPreferences.getString(USER_ID,null));
        user.put(USERNAME,sharedPreferences.getString(USERNAME,null));
        user.put(ID_AKSES,sharedPreferences.getString(ID_AKSES,null));
        return user;
    }

    //    fungsi untuk logout
    public void logout() {
        editor.clear();
        editor.commit();

        Intent login = new Intent(context, MainActivity.class);
        context.startActivity(login);
        ((menu) context).finish();
    }

    //    fungsi getter dari atribut class session manager
    public String getUSER_ID() {
        return sharedPreferences.getString(USER_ID, null);
    }

    public String getUSERNAME() {
        return sharedPreferences.getString(USERNAME, null);
    }

    public String getID_AKSES() {
        return sharedPreferences.getString(ID_AKSES, null);
    }
}
