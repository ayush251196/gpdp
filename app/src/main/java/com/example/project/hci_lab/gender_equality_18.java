package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class gender_equality_18 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.gender_equality_design_18 );
    }

    public void btn_18_submit_function(View v)
    {
        Intent i = new Intent(gender_equality_18.this,women_empowerment_19.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }

}
