package com.example.project.hci_lab;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;

public class life_below_water_26 extends AppCompatActivity {
    private  SQLiteDatabase sqLiteDatabase;
    private Mydatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.life_below_water_design_26 );
    }
     ArrayList<String> data=new ArrayList<>();
    public void btn_26_submit_function(View v) {
//                  sqLitedb=openOrCreateDatabase( "gpdp_databse", Context.MODE_PRIVATE,null );
//                 // sqLitedb=openOrCreateDatabase( "test_databse", Context.MODE_PRIVATE,null );
//
//                 // SQLiteDatabase db = getWritableDatabase();
//
//
//                 // sqLitedb=getWritableDatabase();
//                 // sqLitedb=
//                 // "CREATE TABLE Items (id INTEGER PRIMARY KEY
//                 // AUTOINCREMENT,name TEXT, description TEXT)";
//
//                  Log.e("Error","inserted.......");
//
//                 // sqLitedb.execSQL( "insert into gpdp_user(slno,name,userid,password,role,email) values(25,'20test name','20_malay','test password',5,'test@gmail.com');" );
//
//                  Toast.makeText(this,"record save success fully....!",Toast.LENGTH_SHORT).show();
//
//                  Log.e("Error","inserted.......2");
//
//
//                  Cursor c=sqLitedb.rawQuery("select * from gpdp_user",null);
//                  StringBuffer buffer=new StringBuffer();
//
//                  Log.e("Error","inserted.......3");
//
//
//                  while(c.moveToNext())
//                  {
//
//                    buffer.append( "sl no="+c.getString(1)+"\n" );
//                      buffer.append( "name="+c.getString(2 )+"\n" );
//                      buffer.append( "user id="+c.getString(3 )+"\n" );
//                      buffer.append( "password="+c.getString(4 )+"\n" );
//
//                     // buffer.append( "role="+c.getString(5 )+"\n" );
//                     // buffer.append( "email="+c.getString(6 )+"\n\n=========\n\n" );
//
//
//
//
//                  }
//
//                  Log.e("Error","inserted.......4");
//
//                  Toast.makeText(this,  getDatabasePath("gpdp_databse").toString()+"kkkk"+buffer.toString(),Toast.LENGTH_SHORT).show();
//
//       // Intent i = new Intent(life_below_water_26.this,peace_justice_institution_27.class);
//        //i.putExtra("server_response", ServerResponse.trim();
//        //startActivity(i);
        Log.i("Log","button pressed");
        mydatabase=new Mydatabase(this);
        sqLiteDatabase=mydatabase.getWritableDatabase();
        LinearLayout linearLayout=findViewById(R.id.linear_layout_lbw);
        int childCount=linearLayout.getChildCount();
        for(int i=0;i<childCount;i++){
            Log.i("i", String.valueOf(i));
            View view=linearLayout.getChildAt(i);
            if(view.getClass()==LinearLayout.class && i!=3){
                LinearLayout item=(LinearLayout)view;
                RadioGroup rg=(RadioGroup)item.getChildAt(item.getChildCount()-1);
                int id=rg.getCheckedRadioButtonId();
                RadioButton rb=findViewById(id);
                data.add(rb.getText().toString());
                Toast.makeText(this,rb.getText(),Toast.LENGTH_SHORT).show();

            }if(i==3){
                LinearLayout ll=(LinearLayout)view;
                for(int j=0;j<ll.getChildCount();j++){
                    Log.i("j", String.valueOf(j));
                    View vv=ll.getChildAt(j);
                    if(vv.getClass()==RadioGroup.class){
                        RadioGroup temp=(RadioGroup)vv;
                        int id=temp.getCheckedRadioButtonId();
                        RadioButton rb=findViewById(id);
                        data.add(rb.getText().toString());
                        Toast.makeText(this,rb.getText(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        ContentValues contentValues=new ContentValues();
        contentValues.put("pond_or_lake_y_n",data.get(0));
        contentValues.put("excavated_under_govt_y_n",data.get(1));
        contentValues.put("water_round_the_year_y_n",data.get(2));
        contentValues.put("fishery_y_n",data.get(3));
        contentValues.put("drinking_y_n",data.get(4));
        contentValues.put("domestic_y_n",data.get(5));
        contentValues.put("irrigation_y_n",data.get(6));
        contentValues.put("social_prog_y_n",data.get(7));
        contentValues.put("flood_y_n",data.get(8));
        contentValues.put("wastes_dumped_y_n",data.get(9));
        contentValues.put("required_reexcavation_y_n",data.get(10));
        contentValues.put("any_requirement_for_improvement_y_n","null");
        contentValues.put("family_id","null");
        sqLiteDatabase.insert("gpdp_lbw",null,contentValues);
        sqLiteDatabase.close();

        sqLiteDatabase=mydatabase.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.query("gpdp_lbw",null,null,null,null,null,null);
        cursor.moveToFirst();
        Log.i("databasec1",cursor.getString(cursor.getColumnIndex("pond_or_lake_y_n")));
        Log.i("databasec2",cursor.getString(cursor.getColumnIndex("excavated_under_govt_y_n")));
        Log.i("databasec3",cursor.getString(cursor.getColumnIndex("water_round_the_year_y_n")));
        Log.i("databasec4",cursor.getString(cursor.getColumnIndex("fishery_y_n")));


    }

}
