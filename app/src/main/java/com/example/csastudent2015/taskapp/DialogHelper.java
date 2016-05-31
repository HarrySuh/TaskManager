package com.example.csastudent2015.taskapp;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by csastudent2015 on 5/10/16.
 */
public class DialogHelper {
    public static AlertDialog createErrorDialog(Context context, String title, String message){
        return new AlertDialog.Builder(context).setTitle(title).setMessage(message).create();
    }
}
