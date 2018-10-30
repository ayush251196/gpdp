package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class drinking_water_status_20 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.drinking_water_status_design_20 );
    }

    public void btn_20_submit_function(View v)
    {
        Intent i = new Intent(drinking_water_status_20.this,domestic_water_status_21.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
