package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class domestic_water_status_21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.domestic_water_status_design_21 );
    }

    public void btn_21_submit_function(View v)
    {
        Intent i = new Intent(domestic_water_status_21.this,toilet_facility_22.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}




