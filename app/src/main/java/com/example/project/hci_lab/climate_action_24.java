package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class climate_action_24 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.climate_action_design_24 );
    }

    public void btn_24_submit_function(View v)
    {
        Intent i = new Intent(climate_action_24.this,disaster_protected_center_25.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
