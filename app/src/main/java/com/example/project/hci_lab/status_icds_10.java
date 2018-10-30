package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class status_icds_10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.status_icds_design_10 );
    }

    public void btn_10_submit_function(View v)
    {
        Intent i = new Intent(status_icds_10.this,food_source_11.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
