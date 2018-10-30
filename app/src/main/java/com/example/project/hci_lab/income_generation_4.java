package com.example.project.hci_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class income_generation_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.income_generation_design_4 );
      //  Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
       // setSupportActionBar( toolbar );



    }

    public void btn_4_submit_function(View v)
    {
        Intent i = new Intent(income_generation_4.this,shg_5.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }

}
