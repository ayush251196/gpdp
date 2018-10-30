package com.example.project.hci_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class skill_development_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.skill_development_design_8 );
    }


    public void btn_8_submit_function(View v)
    {
        Intent i = new Intent(skill_development_8.this,zero_hunger_9.class);
        //i.putExtra("server_response", ServerResponse.trim());
        startActivity(i);
    }
}
