package com.example.project.hci_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class end_poverty_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.end_poverty_design_3 );


            }

    public void btn_3_submit_function(View v)
    {
        Intent i = new Intent(end_poverty_3.this,income_generation_4.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }

}
