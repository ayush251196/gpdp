package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class irrigation_facility_13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.irrigation_facility_design_13 );
    }

    public void btn_13_submit_function(View v)
    {
       Intent i = new Intent(irrigation_facility_13.this,agricultural_facility_14.class);
        //i.putExtra("server_response", ServerResponse.trim());
       startActivity(i);
    }

}
