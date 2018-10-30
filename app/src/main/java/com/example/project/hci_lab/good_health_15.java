package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class good_health_15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.good_health_design_15 );
    }

    public void btn_15_submit_function(View v)
    {
        Intent i = new Intent(good_health_15.this,health_status_16.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
