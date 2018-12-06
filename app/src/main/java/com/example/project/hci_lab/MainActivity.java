package com.example.project.hci_lab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {



    Button InsertButton;
    ProgressDialog progressDialog;

    Bitmap bmp;
    EditText temp_et_username,temp_et_password;
    String UsernameHolder,PasswordHolder;



   public void GetValueFromEditText1() {

       UsernameHolder = temp_et_username.getText().toString().trim();
       PasswordHolder = temp_et_password.getText().toString().trim();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);



//
//        VideoView videoview = (VideoView) findViewById(R.id.videoView);
//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
//        videoview.setVideoURI(uri);
//        videoview.start();
//
//        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//
//
//            public void onCompletion(MediaPlayer mp) {
//                mp.start(); //need to make transition seamless.
//                }
//
//
//        });


      // Adding click listener to button.

        InsertButton = (Button) findViewById(R.id.buttonLogin);
        temp_et_username = (EditText) findViewById(R.id.editTextUsername);
        temp_et_password = (EditText)findViewById(R.id.editTextPassword);




        InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String HttpUrl = "http://nakshakantha.com/apis/serveyor_validator.php";

                progressDialog = new ProgressDialog(MainActivity.this);

                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Please Wait, We are Verifying your data on Server");
                progressDialog.show();

                StringRequest stringRequest = new StringRequest( Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                progressDialog.dismiss();

                                Log.d("gg", "onResponse: "+ ServerResponse);


                                if(  (ServerResponse.trim()).equals("invalid"))
                                {
                                    Toast.makeText(MainActivity.this,"Invalid User !", Toast.LENGTH_LONG).show();


                                }

                                else
                                {

                                    Intent i = new Intent(MainActivity.this,circle_menu.class);
                                    i.putExtra("server_response", ServerResponse.trim());
                                    startActivity(i);
                                }
                                // reseter();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(MainActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("serveyor_code_sender", UsernameHolder);
                        params.put("password_sender", PasswordHolder);


                        return params;
                    }

                };

                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);

                GetValueFromEditText1();

            }




        });
    }







}