package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class toilet_facility_22 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.toilet_facility_design_22 );
    }

    public void btn_22_submit_function(View v)
    {
        Intent i = new Intent(toilet_facility_22.this,affordable_clean_energy_23.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
