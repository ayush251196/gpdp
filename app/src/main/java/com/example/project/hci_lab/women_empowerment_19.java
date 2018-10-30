package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class women_empowerment_19 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.women_empowerment_design_19 );
    }

    public void btn_19_submit_function(View v)
    {
        Intent i = new Intent(women_empowerment_19.this,drinking_water_status_20.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
