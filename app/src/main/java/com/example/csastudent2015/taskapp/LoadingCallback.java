package com.example.csastudent2015.taskapp;

import android.app.ProgressDialog;
import android.content.Context;

import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

/**
 * Created by csastudent2015 on 2/29/16.
 */
public class LoadingCallback<T> implements AsyncCallback<T>{

    private Context context;
    private ProgressDialog progressDialog;

    public LoadingCallback(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("loading...");
    }

    public LoadingCallback(Context context, String message) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
    }

    @Override
    public void handleResponse(T response) {
        progressDialog.dismiss();
    }

    @Override
    public void handleFault(BackendlessFault fault) {
        progressDialog.dismiss();
        DialogHelper.createErrorDialog(context, "Backendless Fault", fault.getMessage()).show();
    }
    public void showDialog() {
        progressDialog.show();
    }

    public void hideDialog() {
        progressDialog.hide();
    }
}