package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class agriculture_issues_12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.agriculture_issues_design_12 );
    }

    public void btn_12_submit_function(View v)
    {
        Intent i = new Intent(agriculture_issues_12.this,irrigation_facility_13.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }



}
