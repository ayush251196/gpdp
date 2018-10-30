package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class health_status_16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.health_status_design_16 );
    }

    public void btn_16_submit_function(View v)
    {
        Intent i = new Intent(health_status_16.this,quality_education_17.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
