package com.example.project.hci_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class loan_status_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.loan_status_design_6);
      //  Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
      //  setSupportActionBar( toolbar );



    }

    public void btn_6_submit_function(View v)
    {
        Intent i = new Intent(loan_status_6.this,mgnrega_7.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }

}
