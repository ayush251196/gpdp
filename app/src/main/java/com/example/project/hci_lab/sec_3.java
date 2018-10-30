package com.example.project.hci_lab;

//import android.app.Fragment;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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

import static com.example.project.hci_lab.Registration.snipper_BloodHolder;
import static com.example.project.hci_lab.Registration.snipper_QualificationHolder;

public class sec_3 extends Fragment implements AdapterView.OnItemSelectedListener {

    public
    Spinner spinner_district_temp;


    String HttpUrl_district = "http://www.sebaloy.in/apis/display_district_subdivision_block.php";
    RequestQueue requestQueue;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView( inflater, container, savedInstanceState );
        View v = inflater.inflate(R.layout.sec3, container, false);

        spinner_district_temp = (Spinner) v.findViewById( R.id.spinner_district );
        //spinner_Blood = (Spinner) v.findViewById( R.id.spinner_blood );

        spinner_district_temp.setOnItemSelectedListener(this);
        // spinner_Blood.setOnItemSelectedListener(this);

        // Spinner Drop down elements



        Toast.makeText( getActivity(), "hai......sec3", Toast.LENGTH_LONG ).show();


        StringRequest stringRequest = new StringRequest( Request.Method.POST, HttpUrl_district,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {



                        List<String> categories = new ArrayList<String>();
                        categories.add("Automobile");
                        categories.add("Business Services");
                        categories.add("Computers");
                        categories.add("Education");
                        categories.add("Personal");
                        categories.add("Travel");


                        String[] result = ServerResponse.split("<br>");
                        for (String s : result) {
                          // Toast.makeText( getActivity(), s, Toast.LENGTH_LONG ).show();
                            categories.add(s);
                        }




                        // Creating adapter for spinner
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

                        // Drop down layout style - list view with radio button
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        // attaching data adapter to spinner
                        spinner_district_temp.setAdapter(dataAdapter);
                       // spinner_district_temp.getChildCount();

                        Toast.makeText( getActivity(), categories.get( 3 )+"....."+dataAdapter.getItem( 3 )+"..."+ spinner_district_temp.getCount()+"..."+spinner_district_temp.getChildCount(), Toast.LENGTH_LONG ).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.


                        // Showing error message if something goes wrong.
                        Toast.makeText( getActivity(), volleyError.toString(), Toast.LENGTH_LONG ).show();

                    }
                } ) {


            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                  params.put( "item", "district#nochoice" );


                // params.put( "father_name_sender", Father_NameHolder );
                //params.put( "mother_name_sender", Moher_NameHolder );
                // params.put( "address_sender", AddressHolder );
                // params.put( "pin_sender", PinHolder );
                //params.put( "phone_sender", PhoneHolder );
                //params.put( "emergency_phone_sender", Emergency_PhoneHolder );
                // params.put( "email_sender", EmailHolder );
                //params.put( "aadhar_sender", AadhaarHolder );
              //  params.put( "remark_sender", "33" );

                // String uploadImage = getStringImage();
                //  params.put("image",uploadImage );
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue( getActivity() );

        // Adding the StringRequest object into requestQueue.
        requestQueue.add( stringRequest );










        return inflater.inflate( R.layout.sec3,container,false );

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        // snipper_QualificationHolder = parent.getItemAtPositio
        // (position).toString();

      //  snipper_QualificationHolder = spinner_Qualification.getSelectedItem().toString();
       // snipper_BloodHolder = spinner_Blood.getSelectedItem().toString();

        // Showing selected spinner item
        // Toast.makeText(parent.getContext(), "Qualification: " + snipper_QualificationHolder+" Blood= "+snipper_BloodHolder, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }





}
