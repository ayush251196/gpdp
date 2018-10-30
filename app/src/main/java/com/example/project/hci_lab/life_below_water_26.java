package com.example.project.hci_lab;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class life_below_water_26 extends AppCompatActivity {

    SQLiteDatabase sqLitedb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.life_below_water_design_26 );
    }

    public void btn_26_submit_function(View v)

              {

                  sqLitedb=openOrCreateDatabase( "gpdp_databse", Context.MODE_PRIVATE,null );
                 // sqLitedb=openOrCreateDatabase( "test_databse", Context.MODE_PRIVATE,null );

                 // SQLiteDatabase db = getWritableDatabase();


                 // sqLitedb=getWritableDatabase();
                 // sqLitedb=
                 // "CREATE TABLE Items (id INTEGER PRIMARY KEY
                 // AUTOINCREMENT,name TEXT, description TEXT)";

                  Log.e("Error","inserted.......");

                 // sqLitedb.execSQL( "insert into gpdp_user(slno,name,userid,password,role,email) values(25,'20test name','20_malay','test password',5,'test@gmail.com');" );

                  Toast.makeText(this,"record save success fully....!",Toast.LENGTH_SHORT).show();

                  Log.e("Error","inserted.......2");


                  Cursor c=sqLitedb.rawQuery("select * from gpdp_user",null);
                  StringBuffer buffer=new StringBuffer();

                  Log.e("Error","inserted.......3");


                  while(c.moveToNext())
                  {

                    buffer.append( "sl no="+c.getString(1)+"\n" );
                      buffer.append( "name="+c.getString(2 )+"\n" );
                      buffer.append( "user id="+c.getString(3 )+"\n" );
                      buffer.append( "password="+c.getString(4 )+"\n" );

                     // buffer.append( "role="+c.getString(5 )+"\n" );
                     // buffer.append( "email="+c.getString(6 )+"\n\n=========\n\n" );




                  }

                  Log.e("Error","inserted.......4");

                  Toast.makeText(this,  getDatabasePath("gpdp_databse").toString()+"kkkk"+buffer.toString(),Toast.LENGTH_SHORT).show();

       // Intent i = new Intent(life_below_water_26.this,peace_justice_institution_27.class);
        //i.putExtra("server_response", ServerResponse.trim();
        //startActivity(i);
    }
}
