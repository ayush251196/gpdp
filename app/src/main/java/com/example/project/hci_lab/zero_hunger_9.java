package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class zero_hunger_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.zero_hunger_design_9 );
    }

    public void btn_9_submit_function(View v)
    {
        Intent i = new Intent(zero_hunger_9.this,status_icds_10.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
