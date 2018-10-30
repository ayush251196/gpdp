package com.example.project.hci_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class mgnrega_7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.mgnrega_design_7 );

    }

    public void btn_7_submit_function(View v)
    {
        Intent i = new Intent(mgnrega_7.this,skill_development_8.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }

}
