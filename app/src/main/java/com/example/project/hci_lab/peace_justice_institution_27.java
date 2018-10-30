package com.example.project.hci_lab;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class peace_justice_institution_27 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    SQLiteDatabase sqLitedb;
    RadioButton rb;
    HashMap<String,String> reason_name_id=new HashMap<>();

    String murder_Holder,murder_Holder_justice,murder_justice_no_reason_Holder,
            rape_Holder,rape_Holder_justice,rape_justice_no_reason_Holder,
            kidnap_Holder,kidnap_Holder_justice,kidnap_justice_no_reason_Holder,
            domestic_violence_Holder,domestic_violence_Holder_justice,domestic_violence_justice_no_reason_Holder,
            communal_violence_Holder,communal_violence_Holder_justice,communal_violence_justice_no_reason_Holder,
            robbery_Holder,robbery_Holder_justice,robbery_justice_no_reason_Holder,
            child_abuse_Holder,child_abuse_Holder_justice,child_abuse_justice_no_reason_Holder,
             unfair_labour_Holder,unfair_labour_Holder_justice,unfair_labour_justice_no_reason_Holder,
            racial_discrimination_Holder,racial_discrimination_Holder_justice,racial_discrimination_justice_no_reason_Holder,
            discrimination_gender_Holder,discrimination_gender_Holder_justice,discrimination_gender_justice_no_reason_Holder,
            mantel_health_Holder,mantel_health_Holder_justice,mantel_health_justice_no_reason_Holder,
            bribery_Holder,bribery_Holder_justice,bribery_justice_no_reason_Holder,
            any_other_Holder,any_other_Holder_justice,any_other_justice_no_reason_Holder;



    // Creating Progress dialog.
    ProgressDialog progressDialog;

    Spinner spinner_murder_justice_no_reason,spinner_rape_justice_no_reason,spinner_kidnap_justice_no_reason,spinner_domestic_violence_justice_no_reason,
            spinner_communal_violence_justice_no_reason,spinner_robbery_justice_no_reason,spinner_child_abuse_justice_no_reason,spinner_unfair_labour_justice_no_reason,
            spinner_racial_discrimination_justice_no_reason,spinner_discrimination_gender_justice_no_reason,spinner_mantel_health_justice_no_reason,
            spinner_bribery_justice_no_reason,spinner_any_other_justice_no_reason;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.peace_justice_institution_design_27 );

        tools_intializor();
        tools_loader();
    }




    public void tools_intializor() {


        //------------13 Radio Button group x2=26 radio group-------------

        RadioGroup rg_murder = (RadioGroup) findViewById(R.id.radio_group_murder_27);
        RadioGroup rg_murder_justice = (RadioGroup) findViewById(R.id.radio_group_murder_justice_27);

        RadioGroup rg_rape = (RadioGroup) findViewById(R.id.radio_group_rape_27);
        RadioGroup rg_rape_justice = (RadioGroup) findViewById(R.id.radio_group_rape_justice_27);

        RadioGroup rg_kidnap = (RadioGroup) findViewById(R.id.radio_group_kidnap_27);
        RadioGroup rg_kidnap_justice = (RadioGroup) findViewById(R.id.radio_group_kidnap_justice_27);

        RadioGroup rg_domestic_violence = (RadioGroup) findViewById(R.id.radio_group_murder_27);
        RadioGroup rg_domestic_violence_justice = (RadioGroup) findViewById(R.id.radio_group_domestic_violence_justice_27);

        RadioGroup rg_communal_violence = (RadioGroup) findViewById(R.id.radio_group_communal_violence_27);
        RadioGroup rg_communal_violence_justice = (RadioGroup) findViewById(R.id.radio_group_communal_violence_justice_27);

        RadioGroup rg_group_robbery = (RadioGroup) findViewById(R.id.radio_group_robbery_27);
        RadioGroup rg_group_robbery_justice = (RadioGroup) findViewById(R.id.radio_group_robbery_justice_27);

        RadioGroup rg_child_abuse = (RadioGroup) findViewById(R.id.radio_group_child_abuse_27);
        RadioGroup rg_child_abuse_justice = (RadioGroup) findViewById(R.id.radio_group_child_abuse_justice_27);

        RadioGroup rg_unfair_labour = (RadioGroup) findViewById(R.id.radio_group_unfair_labour_27);
        RadioGroup rg_unfair_labour_justice = (RadioGroup) findViewById(R.id.radio_group_unfair_labour_justice_27);

        RadioGroup rg_racial_discrimination = (RadioGroup) findViewById(R.id.radio_group_racial_discrimination_27);
        RadioGroup rg_racial_discrimination_justice = (RadioGroup) findViewById(R.id.radio_group_racial_discrimination_justice_27);

        RadioGroup rg_gender_discrimination = (RadioGroup) findViewById(R.id.radio_group_gender_discrimination_27);
        RadioGroup rg_gender_discrimination_justice = (RadioGroup) findViewById(R.id.radio_group_gender_discrimination_justice_27);

        RadioGroup rg_group_mantel_health = (RadioGroup) findViewById(R.id.radio_group_mantel_health_27);
        RadioGroup rg_group_mantel_health_justice = (RadioGroup) findViewById(R.id.radio_group_mantel_health_justice_27);


        RadioGroup rg_group_bribery = (RadioGroup) findViewById(R.id.radio_group_bribery_27);
        RadioGroup rg_group_bribery_justice = (RadioGroup) findViewById(R.id.radio_group_bribery_justice_27);


        RadioGroup rg_group_any_other = (RadioGroup) findViewById(R.id.radio_group_any_other_27);
        RadioGroup rg_group_any_other_justice = (RadioGroup) findViewById(R.id.radio_group_any_other_justice_27);



        //------------13 spinner group-------------
        spinner_murder_justice_no_reason = (Spinner) findViewById( R.id.spinner_murder_justice_no_reason_27);
        spinner_rape_justice_no_reason= (Spinner) findViewById( R.id.spinner_rape_justice_no_reason_27);
        spinner_kidnap_justice_no_reason= (Spinner) findViewById( R.id.spinner_kidnap_justice_no_reason_27);
        spinner_domestic_violence_justice_no_reason= (Spinner) findViewById( R.id.spinner_domestic_violence_justice_no_reason_27);
        spinner_communal_violence_justice_no_reason= (Spinner) findViewById( R.id.spinner_communal_violence_justice_no_reason_27);
        spinner_robbery_justice_no_reason= (Spinner) findViewById( R.id.spinner_robbery_justice_no_reason_27);
        spinner_child_abuse_justice_no_reason= (Spinner) findViewById( R.id.spinner_child_abuse_justice_no_reason_27);
        spinner_unfair_labour_justice_no_reason= (Spinner) findViewById( R.id.spinner_unfair_labour_justice_no_reason_27);
        spinner_racial_discrimination_justice_no_reason= (Spinner) findViewById( R.id.spinner_racial_discrimination_justice_no_reason_27);
        spinner_discrimination_gender_justice_no_reason= (Spinner) findViewById( R.id.spinner_discrimination_gender_justice_no_reason_27);
        spinner_mantel_health_justice_no_reason= (Spinner) findViewById( R.id.spinner_mantel_health_justice_no_reason_27);
        spinner_bribery_justice_no_reason= (Spinner) findViewById( R.id.spinner_bribery_justice_no_reason_27);
        spinner_any_other_justice_no_reason= (Spinner) findViewById( R.id.spinner_any_other_justice_no_reason_27);


        spinner_murder_justice_no_reason.setOnItemSelectedListener(this);
        spinner_rape_justice_no_reason.setOnItemSelectedListener(this);
        spinner_kidnap_justice_no_reason.setOnItemSelectedListener(this);
        spinner_domestic_violence_justice_no_reason.setOnItemSelectedListener(this);
        spinner_communal_violence_justice_no_reason.setOnItemSelectedListener(this);
        spinner_robbery_justice_no_reason.setOnItemSelectedListener(this);
        spinner_child_abuse_justice_no_reason.setOnItemSelectedListener(this);
        spinner_unfair_labour_justice_no_reason.setOnItemSelectedListener(this);
        spinner_racial_discrimination_justice_no_reason.setOnItemSelectedListener(this);
        spinner_discrimination_gender_justice_no_reason.setOnItemSelectedListener(this);
        spinner_mantel_health_justice_no_reason.setOnItemSelectedListener(this);
        spinner_bribery_justice_no_reason.setOnItemSelectedListener(this);
        spinner_any_other_justice_no_reason.setOnItemSelectedListener(this);

//------------13 Radio Button group x2=26 radio group-------------

        radio_group_controller( rg_murder );
        radio_group_controller( rg_murder_justice);

        radio_group_controller( rg_rape );
        radio_group_controller( rg_rape_justice);

        radio_group_controller( rg_kidnap );
        radio_group_controller( rg_kidnap_justice);


        radio_group_controller( rg_domestic_violence );
        radio_group_controller( rg_domestic_violence_justice);

        radio_group_controller( rg_communal_violence );
        radio_group_controller( rg_communal_violence_justice);

        radio_group_controller( rg_group_robbery );
        radio_group_controller( rg_group_robbery_justice);

        radio_group_controller( rg_child_abuse );
        radio_group_controller( rg_child_abuse_justice);

        radio_group_controller( rg_unfair_labour );
        radio_group_controller( rg_unfair_labour_justice);

        radio_group_controller( rg_racial_discrimination );
        radio_group_controller( rg_racial_discrimination_justice);

        radio_group_controller( rg_gender_discrimination );
        radio_group_controller( rg_gender_discrimination_justice);

        radio_group_controller( rg_group_mantel_health );
        radio_group_controller( rg_group_mantel_health_justice);

        radio_group_controller( rg_group_bribery );
        radio_group_controller( rg_group_bribery_justice);

        radio_group_controller( rg_group_any_other );
        radio_group_controller( rg_group_any_other_justice);

//
    }

    private void radio_group_controller(final RadioGroup rg)
    {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                 @Override
                                                 public void onCheckedChanged(RadioGroup group, int checkedId)
                                                 {

                                                     rb = (RadioButton) findViewById(checkedId);




                                                     switch (group.getId())
                                                     {
                                                         case R.id.radio_group_murder_27:
                                                             murder_Holder=rb.getText().toString();


                                                             Toast.makeText(getBaseContext(),"Muder="+ murder_Holder, Toast.LENGTH_SHORT).show();

                                                             if(murder_Holder.equals( "No" )) {
                                                                 TextView tv_murder = (TextView) findViewById( R.id.tv_murder_justice_27 );
                                                                 tv_murder.setVisibility( View.INVISIBLE );

                                                                 RadioGroup myRadioGroup = (RadioGroup) findViewById( R.id.radio_group_murder_justice_27 );
                                                                 myRadioGroup.setVisibility( View.INVISIBLE );

                                                                 TextView murder_justice_reason = (TextView) findViewById( R.id.tv_murder_justice_no_reason_27 );
                                                                 murder_justice_reason.setVisibility( View.INVISIBLE );

                                                                 Spinner spinner_murder_justice_reason = (Spinner) findViewById( R.id.spinner_murder_justice_no_reason_27 );
                                                                 spinner_murder_justice_reason.setVisibility( View.INVISIBLE );
                                                             }
                                                             else
                                                             {
                                                                 TextView murder = (TextView) findViewById( R.id.tv_murder_justice_27 );
                                                                 murder.setVisibility( View.VISIBLE );

                                                                 RadioGroup myRadioGroup = (RadioGroup) findViewById( R.id.radio_group_murder_justice_27 );
                                                                 myRadioGroup.setVisibility( View.VISIBLE );
                                                             }

                                                             break;

                                                        case R.id.radio_group_murder_justice_27:
                                                            murder_Holder_justice=rb.getText().toString();
                                                            Toast.makeText(getBaseContext(), "Muder justice="+murder_Holder_justice, Toast.LENGTH_SHORT).show();

                                                            if(murder_Holder_justice.equals( "Yes" )) {
                                                                TextView murder_justice_reason = (TextView) findViewById( R.id.tv_murder_justice_no_reason_27 );
                                                                murder_justice_reason.setVisibility( View.INVISIBLE );

                                                                Spinner spinner_murder_justice_reason = (Spinner) findViewById( R.id.spinner_murder_justice_no_reason_27 );
                                                                spinner_murder_justice_reason.setVisibility( View.INVISIBLE );
                                                            }
                                                            else
                                                            {
                                                                TextView murder_justice_reason = (TextView) findViewById( R.id.tv_murder_justice_no_reason_27 );
                                                                murder_justice_reason.setVisibility( View.VISIBLE );

                                                                Spinner spinner_murder_justice_reason = (Spinner) findViewById( R.id.spinner_murder_justice_no_reason_27 );
                                                                spinner_murder_justice_reason.setVisibility( View.VISIBLE );
                                                            }
                                                            break;
//
//
                                                         case R.id.radio_group_rape_27:
                                                             rape_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), "Rape="+rape_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                          case R.id.radio_group_rape_justice_27:
                                                              rape_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), "Rape Justice="+rape_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_kidnap_27:
                                                             kidnap_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), "kidnap="+kidnap_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_kidnap_justice_27:
                                                             kidnap_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), "kidnap justice="+kidnap_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_domestic_violence_27:
                                                             domestic_violence_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), domestic_violence_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_domestic_violence_justice_27:
                                                             domestic_violence_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), domestic_violence_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_communal_violence_27:
                                                             communal_violence_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), communal_violence_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_communal_violence_justice_27:
                                                             communal_violence_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), communal_violence_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_robbery_27:
                                                             robbery_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), robbery_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_robbery_justice_27:
                                                             robbery_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), robbery_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_child_abuse_27:
                                                             child_abuse_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), child_abuse_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_child_abuse_justice_27:
                                                             child_abuse_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), child_abuse_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_unfair_labour_27:
                                                             unfair_labour_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), unfair_labour_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_unfair_labour_justice_27:
                                                             unfair_labour_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), unfair_labour_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_racial_discrimination_27:
                                                             racial_discrimination_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), racial_discrimination_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_racial_discrimination_justice_27:
                                                             racial_discrimination_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), racial_discrimination_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_gender_discrimination_27:
                                                             discrimination_gender_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), discrimination_gender_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_gender_discrimination_justice_27:
                                                             discrimination_gender_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), discrimination_gender_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_mantel_health_27:
                                                             mantel_health_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), mantel_health_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_mantel_health_justice_27:
                                                             mantel_health_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), mantel_health_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_bribery_27:
                                                             bribery_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), bribery_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_bribery_justice_27:
                                                             bribery_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), bribery_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_any_other_27:
                                                             any_other_Holder=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), any_other_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;

                                                         case R.id.radio_group_any_other_justice_27:
                                                             any_other_Holder_justice=rb.getText().toString();
                                                             Toast.makeText(getBaseContext(), any_other_Holder_justice+" "+checkedId, Toast.LENGTH_SHORT).show();
                                                             break;



                                                     }
//                                                     if(group.getId()==R.id.radio_group_murder_27)
//                                                     {
//                                                         Toast.makeText(getBaseContext(), murder_Holder+" "+checkedId, Toast.LENGTH_SHORT).show();
//
//                                                     }
//                                                    // RadioButton radioButton_murder;

                                                      }
                                             }
        );

    }







    //for spinner

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        murder_justice_no_reason_Holder=  reason_name_id.get( spinner_murder_justice_no_reason.getSelectedItem().toString());

        rape_justice_no_reason_Holder= reason_name_id.get( spinner_rape_justice_no_reason.getSelectedItem().toString());

        kidnap_justice_no_reason_Holder= reason_name_id.get( spinner_kidnap_justice_no_reason.getSelectedItem().toString());
        domestic_violence_justice_no_reason_Holder= reason_name_id.get( spinner_domestic_violence_justice_no_reason.getSelectedItem().toString());
        communal_violence_justice_no_reason_Holder= reason_name_id.get( spinner_communal_violence_justice_no_reason.getSelectedItem().toString());
        robbery_justice_no_reason_Holder= reason_name_id.get( spinner_robbery_justice_no_reason.getSelectedItem().toString());
        child_abuse_justice_no_reason_Holder= reason_name_id.get( spinner_child_abuse_justice_no_reason.getSelectedItem().toString());
        unfair_labour_justice_no_reason_Holder= reason_name_id.get( spinner_unfair_labour_justice_no_reason.getSelectedItem().toString());
        racial_discrimination_justice_no_reason_Holder= reason_name_id.get( spinner_racial_discrimination_justice_no_reason.getSelectedItem().toString());
        discrimination_gender_justice_no_reason_Holder= reason_name_id.get( spinner_discrimination_gender_justice_no_reason.getSelectedItem().toString());
        mantel_health_justice_no_reason_Holder= reason_name_id.get( spinner_mantel_health_justice_no_reason.getSelectedItem().toString());
        bribery_justice_no_reason_Holder= reason_name_id.get( spinner_bribery_justice_no_reason.getSelectedItem().toString());
        any_other_justice_no_reason_Holder= reason_name_id.get( spinner_any_other_justice_no_reason.getSelectedItem().toString());

        //Toast.makeText(getBaseContext(), murder_justice_no_reason_Holder+rape_justice_no_reason_Holder+kidnap_justice_no_reason_Holder, Toast.LENGTH_SHORT).show();


    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }




    private void tools_loader()
    {


        sqLitedb=openOrCreateDatabase( "gpdp_database", Context.MODE_PRIVATE,null );


        Cursor c=sqLitedb.rawQuery("select * from gpdp_incident_justice_reason_2_27",null);
        StringBuffer buffer=new StringBuffer();

         List<String> reason_list = new ArrayList<String>();
        reason_list.add("Choose Reason");


        while(c.moveToNext())
        {   String id=c.getString( 0 ).trim();
            String name=c.getString( 1 ).trim();
            reason_list.add(name);
            reason_name_id.put( name,id );
            Log.e("loop",".......................5"+name);
        }

         // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, reason_list);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       // Log.e("Error","inserted.......................5");

        // attaching data adapter to spinner
        spinner_murder_justice_no_reason.setAdapter(dataAdapter);
        spinner_rape_justice_no_reason.setAdapter(dataAdapter);
        spinner_kidnap_justice_no_reason.setAdapter(dataAdapter);
        spinner_domestic_violence_justice_no_reason.setAdapter(dataAdapter);
        spinner_communal_violence_justice_no_reason.setAdapter(dataAdapter);
        spinner_robbery_justice_no_reason.setAdapter(dataAdapter);
        spinner_child_abuse_justice_no_reason.setAdapter(dataAdapter);
        spinner_unfair_labour_justice_no_reason.setAdapter(dataAdapter);
        spinner_racial_discrimination_justice_no_reason.setAdapter(dataAdapter);
        spinner_discrimination_gender_justice_no_reason.setAdapter(dataAdapter);
        spinner_mantel_health_justice_no_reason.setAdapter(dataAdapter);
        spinner_bribery_justice_no_reason.setAdapter(dataAdapter);
        spinner_any_other_justice_no_reason.setAdapter(dataAdapter);

        //Toast.makeText(this,  buffer.toString(),Toast.LENGTH_SHORT).show();
    }





    private void databse_inserter(String incident_id,int incident_occure_or_not,int received_justice,String reason,String bencode)
    {
        sqLitedb.execSQL( "insert into gpdp_peace_justice_institution_27(incident_id,y_n,received_justice,if_n_why,ben_code) values('"+incident_id+"',"+incident_occure_or_not+","+received_justice+",'"+reason+"','"+bencode+"');" );

    }

    private void databse_displayer(String bencode)
    {
        Cursor c=sqLitedb.rawQuery("select * from gpdp_peace_justice_institution_27 where ben_code='"+bencode+"'",null);
        StringBuffer buffer=new StringBuffer();

        Log.e("Error","inserted.......3");


        while(c.moveToNext())
        {

            buffer.append( "incident ID= "+c.getString(0)+"\n" );
            buffer.append( "Occured or NOt= "+c.getString(1 )+"\n" );
            buffer.append( "Get Justice= "+c.getString(2 )+"\n" );
            buffer.append( "Reason ="+c.getString(3 )+"\n" );
            buffer.append( "Ben Code ="+c.getString(4 )+"\n" );

            // buffer.append( "role="+c.getString(5 )+"\n" );
            buffer.append( "\n ========= \n\n" );




        }




       // Toast.makeText(this,  buffer.toString(),Toast.LENGTH_SHORT).show();

    }

    //submit button

    public void btn_27_submit_function(View v)
    {

        GetValueFromEditText();


        if(empty_checker()==true) {


            sqLitedb=openOrCreateDatabase( "gpdp_database", Context.MODE_PRIVATE,null );


         //  Log.e("Error","inserted.......");

           // databse_inserter("I02",1,0,"no politicle power","BE001A");

            Log.e("Error","inserted.......2");
            Toast.makeText(this,"record save success fully....!",Toast.LENGTH_SHORT).show();

            Log.e("Error","inserted.......3");

            databse_displayer("BE001A");

            Log.e("Error","inserted.......4");


            // Intent i = new Intent(life_below_water_26.this,peace_justice_institution_27.class);
            //i.putExtra("server_response", ServerResponse.trim();
            //startActivity(i);


        }





    }


    public boolean empty_checker()
    {

       String empty_checker_message="";
        int empty_checker_counter=0;

//        if(NameHolder.equals(""))
//        {
//            empty_checker_message=empty_checker_message+"1. Please put your Name\n";
//
//        }else
//        {
//            empty_checker_counter=empty_checker_counter +1;
//        }
//        if(Father_NameHolder.equals(""))
//        {
//            empty_checker_message=empty_checker_message+"2. Please put your Name\n";
//
//        }else
//        {
//            empty_checker_counter=empty_checker_counter +1;
//        }
//
//        if(snipper_QualificationHolder.equals("Choose Qualification"))
//        {
//            empty_checker_message=empty_checker_message+"3. Please select the Qualification\n";
//
//        }else
//        {
//            empty_checker_counter=empty_checker_counter +1;
//        }
//        if(snipper_BloodHolder.equals("Choose Blood Group"))
//        {
//            empty_checker_message=empty_checker_message+"4. Please select the Blood Group\n";
//
//        }else{
//            empty_checker_counter=empty_checker_counter +1;
//        }
//
//


        if(empty_checker_counter==0)
        {
            return true;
        }
        else
        {
            Toast.makeText(peace_justice_institution_27.this, empty_checker_message, Toast.LENGTH_LONG).show();
            return false;
        }
    }


    public void reseter()
    {
//        Name.getText().clear();
//        father_name.getText().clear();
//        mother_name.getText().clear();
//        address.getText().clear();
//        pin.setText("");
//        Phone.setText("");
//        emergency_phone.setText("");
//        email.setText("");
//        aadhaar.setText("");
//        remark.setText("");
    }







        public void GetValueFromEditText(){


        // Toast.makeText(Registration.this, "Start button....", Toast.LENGTH_LONG).show();
//       EditText Name = (EditText) findViewById(R.id.editText_name);
//        father_name = (EditText) findViewById(R.id.editText_father_name);
//        mother_name = (EditText) findViewById(R.id.editText_Mother_Name);
//        address = (EditText) findViewById(R.id.editText_Address);
//        pin = (EditText) findViewById(R.id.editText_pin);
//        Phone = (EditText) findViewById(R.id.editText_Phone);
//        emergency_phone = (EditText) findViewById(R.id.editText_emergency);
//        email = (EditText) findViewById(R.id.editText_email);
//        aadhaar = (EditText) findViewById(R.id.editText_aadhar);
//        remark = (EditText) findViewById(R.id.editText_remark);


//        NameHolder = Name.getText().toString().trim();
//        Father_NameHolder = father_name.getText().toString().trim();
//        Moher_NameHolder = mother_name.getText().toString().trim();
//        AddressHolder = address.getText().toString().trim();
//        PinHolder = pin.getText().toString().trim();
//        PhoneHolder= Phone.getText().toString().trim();
//        Emergency_PhoneHolder = emergency_phone.getText().toString().trim();
//        EmailHolder = email.getText().toString().trim();
//        AadhaarHolder = aadhaar.getText().toString().trim();
//        RemarkHolder = remark.getText().toString().trim();

        // organizationHolder = ((RadioButton) findViewById(radioGrouporganization.getCheckedRadioButtonId())).getText().toString();
        // Toast.makeText(Registration.this, "End button...."+NameHolder+"..."+Father_NameHolder, Toast.LENGTH_LONG).show();

    }


}
