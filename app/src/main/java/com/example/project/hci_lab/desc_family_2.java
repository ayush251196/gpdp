package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class desc_family_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.desc_family_design_2 );

    }

    public void btn_2_submit_function(View v)
    {
        Intent i = new Intent(desc_family_2.this,end_poverty_3.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}


