package com.example.project.hci_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class shg_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.shg_design_5 );
       // Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        //setSupportActionBar( toolbar );


    }


    public void btn_5_submit_function(View v)
    {
        Intent i = new Intent(shg_5.this,loan_status_6.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }

}
