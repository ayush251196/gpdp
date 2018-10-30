package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class agricultural_facility_14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.agricultural_facility_design_14 );
    }

    public void btn_14_submit_function(View v)
    {
        Intent i = new Intent(agricultural_facility_14.this,good_health_15.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
