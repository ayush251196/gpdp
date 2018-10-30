package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class disaster_protected_center_25 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.disaster_protected_center_design_25 );
    }

    public void btn_25_submit_function(View v)
    {
        Intent i = new Intent(disaster_protected_center_25.this,life_below_water_26.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
