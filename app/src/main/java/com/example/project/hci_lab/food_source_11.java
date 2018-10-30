package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class food_source_11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.food_source_design_11 );
    }


    public void btn_11_submit_function(View v)
    {
        Intent i = new Intent(food_source_11.this,agriculture_issues_12.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
