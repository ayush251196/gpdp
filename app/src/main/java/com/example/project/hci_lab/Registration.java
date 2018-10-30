package com.example.project.hci_lab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;



import android.widget.Toast;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;



public class Registration extends AppCompatActivity  {

        /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */


        // Creating EditText.
        public static String snipper_QualificationHolder,snipper_BloodHolder,Issudate_Holder,Expiredate_Holder,DateofJoing_Holder;
        Integer empty_checker_counter =0;
        String empty_checker_message="";

        EditText Name,father_name,mother_name,address,pin,
                Phone,emergency_phone,email,aadhaar,remark;

        RadioGroup radioGrouporganization;

        ImageView self_photo;
        Button InsertButton;




        // Creating Volley RequestQueue.
         RequestQueue requestQueue;

        // Creating Progress dialog.
        ProgressDialog progressDialog;

        // Create string variable to hold the tool's Value.
        String NameHolder,Father_NameHolder,Moher_NameHolder,AddressHolder,PinHolder,
                PhoneHolder,Emergency_PhoneHolder,EmailHolder,AadhaarHolder,RemarkHolder;

        // Storing server url into String variable.
        String HttpUrl = "http://www.sebaloy.in/apis/userinput.php";
       // String HttpUrl1 = "http://www.sebaloy.in/apis/insert_image.php";


        private SectionsPagerAdapter mSectionsPagerAdapter;

        private ViewPager mViewPager;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registration );



        //radioGrouporganization = (RadioGroup) findViewById(R.id.radioOrganization);*/

        progressDialog = new ProgressDialog(Registration.this);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(Registration.this);

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager() );

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById( R.id.container );
        mViewPager.setAdapter( mSectionsPagerAdapter );

        TabLayout tabLayout = (TabLayout) findViewById( R.id.tabs );

        mViewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ) );
        tabLayout.addOnTabSelectedListener( new TabLayout.ViewPagerOnTabSelectedListener( mViewPager ) );



        // for buttom

         FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetValueFromEditText();
                if(empty_checker()==true) {

                    progressDialog.setMessage( "Please Wait, We are Inserting Your Data on Server" );
                    progressDialog.show();





                    StringRequest stringRequest = new StringRequest( Request.Method.POST, HttpUrl,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String ServerResponse) {

                                    // Hiding the progress dialog after all task complete.
                                    progressDialog.dismiss();

                                    // Showing response message coming from server.
                                    Toast.makeText( Registration.this, ServerResponse, Toast.LENGTH_LONG ).show();
                                    reseter();

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError volleyError) {

                                    // Hiding the progress dialog after all task complete.
                                    progressDialog.dismiss();

                                    // Showing error message if something goes wrong.
                                    Toast.makeText( Registration.this, volleyError.toString(), Toast.LENGTH_LONG ).show();

                                }
                            } ) {
                        @Override
                        protected Map<String, String> getParams() {

                            // Creating Map String Params.
                            Map<String, String> params = new HashMap<String, String>();

                            // Adding All values to Params.
                            params.put( "name_sender", NameHolder );
                            params.put( "father_name_sender", Father_NameHolder );
                            params.put( "mother_name_sender", Moher_NameHolder );
                            params.put( "address_sender", AddressHolder );
                            params.put( "pin_sender", PinHolder );
                            params.put( "phone_sender", PhoneHolder );
                            params.put( "emergency_phone_sender", Emergency_PhoneHolder );
                            params.put( "email_sender", EmailHolder );
                            params.put( "aadhar_sender", AadhaarHolder );
                            params.put( "remark_sender", RemarkHolder );

                            // String uploadImage = getStringImage();
                            //  params.put("image",uploadImage );
                            return params;
                        }

                    };

                    // Creating RequestQueue.
                    RequestQueue requestQueue = Volley.newRequestQueue( Registration.this );

                    // Adding the StringRequest object into requestQueue.
                    requestQueue.add( stringRequest );

                }

            }
        } );


    }

    // finish on create
public boolean empty_checker()
{
    empty_checker_message="";
    empty_checker_counter=0;

    if(NameHolder.equals(""))
    {
        empty_checker_message=empty_checker_message+"1. Please put your Name\n";

    }else
    {
        empty_checker_counter=empty_checker_counter +1;
    }
    if(Father_NameHolder.equals(""))
    {
        empty_checker_message=empty_checker_message+"2. Please put your Name\n";

    }else
    {
        empty_checker_counter=empty_checker_counter +1;
    }

    if(snipper_QualificationHolder.equals("Choose Qualification"))
        {
        empty_checker_message=empty_checker_message+"3. Please select the Qualification\n";

        }else
            {
            empty_checker_counter=empty_checker_counter +1;
            }
    if(snipper_BloodHolder.equals("Choose Blood Group"))
        {
        empty_checker_message=empty_checker_message+"4. Please select the Blood Group\n";

        }else{
                empty_checker_counter=empty_checker_counter +1;
            }




    if(empty_checker_counter==4)
    {
     return true;
    }
    else
    {
        Toast.makeText(Registration.this, empty_checker_message, Toast.LENGTH_LONG).show();
      return false;
    }
}

    public void reseter()
    {
        Name.getText().clear();
        father_name.getText().clear();
        mother_name.getText().clear();
        address.getText().clear();
        pin.setText("");
        Phone.setText("");
        emergency_phone.setText("");
        email.setText("");
        aadhaar.setText("");
        remark.setText("");
    }
    public void GetValueFromEditText(){
        // Toast.makeText(Registration.this, "Start button....", Toast.LENGTH_LONG).show();
        Name = (EditText) findViewById(R.id.editText_name);
        father_name = (EditText) findViewById(R.id.editText_father_name);
        mother_name = (EditText) findViewById(R.id.editText_Mother_Name);
        address = (EditText) findViewById(R.id.editText_Address);
        pin = (EditText) findViewById(R.id.editText_pin);
        Phone = (EditText) findViewById(R.id.editText_Phone);
        emergency_phone = (EditText) findViewById(R.id.editText_emergency);
        email = (EditText) findViewById(R.id.editText_email);
        aadhaar = (EditText) findViewById(R.id.editText_aadhar);
        remark = (EditText) findViewById(R.id.editText_remark);



        NameHolder = Name.getText().toString().trim();
        Father_NameHolder = father_name.getText().toString().trim();
        Moher_NameHolder = mother_name.getText().toString().trim();
        AddressHolder = address.getText().toString().trim();
        PinHolder = pin.getText().toString().trim();
        PhoneHolder= Phone.getText().toString().trim();
        Emergency_PhoneHolder = emergency_phone.getText().toString().trim();
        EmailHolder = email.getText().toString().trim();
        AadhaarHolder = aadhaar.getText().toString().trim();
        RemarkHolder = remark.getText().toString().trim();

        // organizationHolder = ((RadioButton) findViewById(radioGrouporganization.getCheckedRadioButtonId())).getText().toString();
        // Toast.makeText(Registration.this, "End button...."+NameHolder+"..."+Father_NameHolder, Toast.LENGTH_LONG).show();

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_registration, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
        //}
        Toast.makeText(getApplicationContext(), "menu item id=...."+id, Toast.LENGTH_LONG ).show();
        return super.onOptionsItemSelected( item );
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt( ARG_SECTION_NUMBER, sectionNumber );
            fragment.setArguments( args );
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate( R.layout.fragment_registration, container, false );
            TextView textView = (TextView) rootView.findViewById( R.id.section_label );
            textView.setText( getString( R.string.section_format, getArguments().getInt( ARG_SECTION_NUMBER ) ) );
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super( fm );
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {


            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance( position + 1 );

            Toast.makeText(getApplicationContext(), "position =...."+position, Toast.LENGTH_LONG ).show();
            switch(position){

                case 0:
                    Toast.makeText(getApplicationContext(), "hai.case0.....sec1", Toast.LENGTH_LONG ).show();
                    sec_1 sec1=new sec_1();
                    return sec1;

                case 1:
                    Toast.makeText(getApplicationContext(), "hai..case1....sec2", Toast.LENGTH_LONG ).show();
                    sec_2 sec2=new sec_2();
                    return sec2;

                case 2:
                    Toast.makeText(getApplicationContext(), "hai..case2....sec3", Toast.LENGTH_LONG ).show();
                    sec_3 sec3=new sec_3();
                    return sec3;
                case 3:
                    Toast.makeText(getApplicationContext(), "hai..case3....sec4", Toast.LENGTH_LONG ).show();
                    sec_4 sec4=new sec_4();
                    return sec4;

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }
    }
}
