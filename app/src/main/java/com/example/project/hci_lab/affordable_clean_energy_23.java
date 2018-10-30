package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class affordable_clean_energy_23 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.affordable_clean_energy_design_23 );
    }

    public void btn_23_submit_function(View v)
    {
        Intent i = new Intent(affordable_clean_energy_23.this,climate_action_24.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
