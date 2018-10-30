package com.example.project.hci_lab;

//import android.app.Fragment;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.Button;
import android.app.Dialog;

public class sec_1 extends Fragment {


    private static TextView tv;
    static Dialog d ;


    /*EditText Name,father_name;
    String NameHolder,Father_NameHolder;

    public void GetValueFromEditText()
        {

        NameHolder = Name.getText().toString().trim();
        Father_NameHolder = father_name.getText().toString().trim();
        }*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView( inflater, container, savedInstanceState );

        //Name = (EditText) getActivity().findViewById(R.id.editText_name);
        //father_name = (EditText) getActivity().findViewById(R.id.editText_father_name);
        Toast.makeText( getActivity(), "hai......sec1", Toast.LENGTH_LONG ).show();
        View v = inflater.inflate(R.layout.sec1, container, false);


      //  NumberPicker np = v.findViewById(R.id.numberPicker);

        //np.setMinValue(2);
        //np.setMaxValue(20);

        //np.setOnValueChangedListener(onValueChangeListener);
       // return inflater.inflate( R.layout.sec1,container,false );





        tv = (TextView) v.findViewById(R.id.textView1);
        Button b = (Button) v.findViewById(R.id.button11);
        b.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v) {
                show();
            }
        });

        return v;
    }


    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        //Log.i("value is",""+newVal);

    }


    public void show()
    {



        final Dialog d = new Dialog(getActivity());
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(100);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);


       //np.setOnValueChangedListener(Registration.this);


        b1.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(np.getValue()));
                d.dismiss();
            }
        });
        b2.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();


    }


//    NumberPicker.OnValueChangeListener onValueChangeListener =
//            new 	NumberPicker.OnValueChangeListener(){
//                @Override
//                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                    Toast.makeText(getActivity(),
//                            "selected number "+numberPicker.getValue(), Toast.LENGTH_SHORT);
//
//
//                    DatePickerDialog dialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, expire_date_listner, year,month,day);
//                    dialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
//                    dialog.show();
//                }
//            };
}
