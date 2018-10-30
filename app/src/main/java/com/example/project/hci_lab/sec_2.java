package com.example.project.hci_lab;


import android.graphics.Color;

import android.support.v4.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.app.Dialog;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;


import static com.example.project.hci_lab.Registration.DateofJoing_Holder;
import static com.example.project.hci_lab.Registration.Expiredate_Holder;
import static com.example.project.hci_lab.Registration.Issudate_Holder;
import static com.example.project.hci_lab.Registration.snipper_QualificationHolder;
import static com.example.project.hci_lab.Registration.snipper_BloodHolder;

public class sec_2 extends Fragment implements AdapterView.OnItemSelectedListener {


    public
    static String TAG="MainActivity";
    Spinner spinner_Qualification;
    Spinner spinner_Blood;

    private
    TextView tv_issue_date,tv_expire_date,tv_date_of_joining;
    DatePickerDialog.OnDateSetListener issue_date_listner,expire_date_listner,date_of_joining_listner;






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView( inflater, container, savedInstanceState );



        View v = inflater.inflate(R.layout.sec2, container, false);

        Toast.makeText( getActivity(), "hellow......sec2", Toast.LENGTH_LONG ).show();

        tv_issue_date=(TextView) v.findViewById( R.id.tv_issue_Date );
        tv_expire_date=(TextView) v.findViewById( R.id.tv_expire_Date );
        tv_date_of_joining=(TextView) v.findViewById( R.id.tv_Date_of_joining );


        tv_issue_date.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, issue_date_listner, year,month,day);
                dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
                dialog.show();

            }
        } );



        tv_expire_date.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, expire_date_listner, year,month,day);
                dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
                dialog.show();

            }
        } );


        tv_date_of_joining.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, date_of_joining_listner, year,month,day);
                dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
                dialog.show();

            }
        } );




        issue_date_listner = new DatePickerDialog.OnDateSetListener(){

                @Override
                 public void onDateSet(DatePicker datePicker,int year,int month,int day){
                    month=month+1;
                    Log.d(TAG,"onDateSet :mm/dd/yyy:"+month+"/"+day+"/"+year);

                    Issudate_Holder=year+"-"+month+"-"+day;


                    tv_issue_date.setText("Issue date : "+Issudate_Holder );
                }
        };


        expire_date_listner = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker datePicker,int year,int month,int day){
                month=month+1;
                Log.d(TAG,"onDateSet :mm/dd/yyy:"+month+"/"+day+"/"+year);
                Expiredate_Holder=year+"-"+month+"-"+day;

                tv_expire_date.setText("Expire Date  : "+Expiredate_Holder );
            }
        };


        date_of_joining_listner = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker datePicker,int year,int month,int day){
                month=month+1;
                Log.d(TAG,"onDateSet :mm/dd/yyy:"+month+"/"+day+"/"+year);
                DateofJoing_Holder=year+"-"+month+"-"+day;
                tv_date_of_joining.setText("Date of Joining  : "+DateofJoing_Holder );
            }
        };







      spinner_Qualification = (Spinner) v.findViewById( R.id.spinner_qualification );
     spinner_Blood = (Spinner) v.findViewById( R.id.spinner_blood );


        //findViewById(R.id.spinner_qualification);

        // Spinner click listener
        spinner_Qualification.setOnItemSelectedListener(this);
        spinner_Blood.setOnItemSelectedListener(this);


        /*
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_Qualification.setAdapter(dataAdapter);



*/



        return v;


       // return inflater.inflate( R.layout.sec2,container,false );

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
       // snipper_QualificationHolder = parent.getItemAtPosition(position).toString();

        snipper_QualificationHolder = spinner_Qualification.getSelectedItem().toString();
        snipper_BloodHolder = spinner_Blood.getSelectedItem().toString();

        // Showing selected spinner item
       // Toast.makeText(parent.getContext(), "Qualification: " + snipper_QualificationHolder+" Blood= "+snipper_BloodHolder, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
