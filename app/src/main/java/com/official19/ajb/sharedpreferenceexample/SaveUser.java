package com.official19.ajb.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;

public class SaveUser {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    SaveUser(Context context){
        this.context=context;
        sharedPreferences = context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    boolean saveInfo(String name, String branch, String year, String sem){
        editor.putString("Name", name);
        editor.putString("Branch", branch);
        editor.putString("Year", year);
        editor.putString("Semster", sem);
        editor.putBoolean("infoSaved", true);
        editor.apply();
        return editor.commit();
    }

    void displayInfo(){
        String name = sharedPreferences.getString("Name", "");
        String branch = sharedPreferences.getString("Branch", "");
        String year = sharedPreferences.getString("Year", "");
        String semster = sharedPreferences.getString("Semster", "");
        boolean infodsaved = sharedPreferences.getBoolean("infoSaved",false);
        Print(name, branch+" "+year+" "+semster+" "+infodsaved);
    }

    String getName(){
        return sharedPreferences.getString("Name", "");
    }

    boolean getUser(){
        return sharedPreferences.getBoolean("infoSaved", false);
    }

    void removeUser(){
        editor.clear().commit();
    }

    private void Print(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
