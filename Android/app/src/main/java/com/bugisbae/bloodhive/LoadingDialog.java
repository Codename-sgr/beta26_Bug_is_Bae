package com.bugisbae.bloodhive;

import android.app.Activity;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

public class LoadingDialog {
    public Activity activity;
    public AlertDialog alertDialog;
    String message;

    public LoadingDialog(Activity activity){
        this.activity=activity;
    }

    public void startLoadingDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder((activity));

        LayoutInflater inflater=activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading_dialog,null));
        builder.setCancelable(false);

        alertDialog=builder.create();
        alertDialog.show();
    }

    public void dismissDialog(){
        alertDialog.dismiss();
    }

    public void message(String s) {
        alertDialog.setMessage(message);
    }
}
