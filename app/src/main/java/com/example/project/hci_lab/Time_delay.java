package com.example.project.hci_lab;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Time_delay extends AsyncTask{
    private ProgressDialog pd;
    private Context context;
    public Time_delay(ProgressDialog progressDialog,Context context) {
        pd=progressDialog;
        this.context=context;
    }

    @Override
    protected void onPreExecute() {
        pd.show(context,"","Please wait..");
    }

    @Override
    protected void onPostExecute(Object o) {
        pd.dismiss();
    }

    @Override
    protected void onCancelled(Object o) {
        pd.dismiss();
        super.onCancelled(o);
    }

    @Override
    protected void onCancelled() {
        pd.dismiss();
        super.onCancelled();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Timer timer=new Timer();
        long intMillseconds=20;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pd.dismiss();
            }
        },intMillseconds);
        return null;
    }
}
