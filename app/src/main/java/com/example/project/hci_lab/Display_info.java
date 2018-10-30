package com.example.project.hci_lab;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class Display_info extends AppCompatActivity {
    ProgressDialog progressDialog;

    Bitmap bmp;
    ImageView iv_self_photo;

    TextView temp_tv_aadhaar,temp_tv_volunteers_code,temp_tv_name,temp_tv_father_name,temp_tv_mother_name,temp_tv_qualification,
            temp_tv_department,temp_tv_designation,temp_tv_address,temp_tv_email,temp_tv_phone,temp_tv_blood,temp_tv_doj,temp_tv_issue,
            temp_tv_expire,temp_tv_sebaloy_post,temp_tv_sebaloy_post_level,temp_tv_card_number;

    String s,temp_password,temp_id;

    private NetworkImageView imageView;
    private ImageLoader imageLoader;



    private void loadImage( String image_url ){
        String url = image_url.trim();
        if(url.equals("")){
            Toast.makeText(this,"Please enter a URL",Toast.LENGTH_LONG).show();
            return;
        }

        imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext()).getImageLoader();

        imageLoader.get(url, ImageLoader.getImageListener(imageView,R.drawable.sky1, android.R.drawable.ic_dialog_alert));
        imageView.setImageUrl(url, imageLoader);
    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        //s = getIntent().getStringExtra("id");
        temp_id = getIntent().getStringExtra("id");
              imageView = (NetworkImageView) findViewById(R.id.imageView1);




       // Toast.makeText(this, temp_id, Toast.LENGTH_SHORT).show();

        iv_self_photo = (ImageView)findViewById(R.id.imageView1);
        temp_tv_name = (TextView)findViewById(R.id.tv_name);
        temp_tv_father_name=(TextView)findViewById(R.id.tv_father);
        temp_tv_mother_name=(TextView)findViewById(R.id.tv_mother);
        temp_tv_qualification=(TextView)findViewById(R.id.tv_qualification);
        temp_tv_designation=(TextView)findViewById(R.id.tv_designation);
        temp_tv_address=(TextView)findViewById(R.id.tv_address);
        temp_tv_email=(TextView)findViewById(R.id.tv_email);
        temp_tv_phone=(TextView)findViewById(R.id.tv_phone);
        temp_tv_blood=(TextView)findViewById(R.id.tv_blood);
        temp_tv_doj=(TextView)findViewById(R.id.tv_doj);
        temp_tv_expire=(TextView)findViewById(R.id.tv_expire);

        temp_tv_aadhaar=(TextView)findViewById(R.id.tv_aadhaar);
        temp_tv_volunteers_code=(TextView)findViewById(R.id.tv_volunteers_code);

        temp_tv_department=(TextView)findViewById(R.id.tv_depertment);
        temp_tv_issue=(TextView)findViewById(R.id.tv_issue_Date);
        temp_tv_sebaloy_post=(TextView)findViewById(R.id.tv_sebaloy_post);
        temp_tv_sebaloy_post_level=(TextView)findViewById(R.id.tv_sebaloy_post_level);
        temp_tv_card_number=(TextView)findViewById(R.id.tv_card_number);


       // String HttpUrl = "http://www.sebaloy.in/apis/display_image.php";
        String HttpUrl = "http://www.sebaloy.in/apis/display_info.php";

        progressDialog = new ProgressDialog(Display_info.this);

                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Please Wait, We are fatching your data from Server");
              progressDialog.show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                String recive_self_image,recive_name,recive_father_name,recive_mother_name,recive_qualification,
                                        recive_designation,recive_address,recive_email,recive_phone,recive_blood,recive_doj,recive_expire,
                                        recive_aadhaar,recive_volunteers_code,recive_issue_date,recive_depertment,recive_sebaloy_post,
                                        recive_sebaloy_post_level,recive_card_number;


                                // Hiding the progress dialog after all task complete.
                               progressDialog.dismiss();


                                Log.d("gg", "onResponse: "+ ServerResponse);

                                //Toast.makeText(Display_info.this, ServerResponse, Toast.LENGTH_SHORT).show();
                                String[] parts = ServerResponse.split("\\#");

                                recive_self_image=parts[0];
                                recive_name=parts[1];
                                recive_father_name = parts[4];
                                recive_mother_name = parts[5];
                                recive_qualification = parts[19];

                                recive_designation = parts[26];

                                recive_address = parts[8];
                                recive_email = parts[9];
                                recive_phone = parts[10]+" / "+ parts[18];
                                recive_blood = parts[11];
                                recive_doj = parts[12];
                                recive_expire = parts[13];
                                recive_aadhaar=parts[14];
                                recive_volunteers_code=parts[15];

                                recive_issue_date = parts[16];
                                recive_depertment = parts[25];
                                recive_sebaloy_post=parts[2];
                                recive_sebaloy_post_level=parts[3];
                                recive_card_number=parts[17];

                                // Showing response message coming from server.
                               // Toast.makeText(MainActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                               // reseter();



                                byte[] image = Base64.decode(recive_self_image.getBytes(),Base64.DEFAULT);
                                bmp = BitmapFactory.decodeByteArray(image,0,image.length);

                                iv_self_photo.setVisibility(View.VISIBLE);
                              iv_self_photo.setImageBitmap(bmp);

                                loadImage(recive_self_image);

                                temp_tv_name.setText(recive_name);
                                temp_tv_father_name.setText("Father Name : "+recive_father_name);
                                temp_tv_mother_name.setText("Mother Name : "+recive_mother_name);
                                temp_tv_qualification.setText("Qualification : "+recive_qualification);
                                temp_tv_designation.setText("Designation : "+recive_designation);
                                temp_tv_address.setText("Address : "+recive_address);
                                temp_tv_email.setText("Email : "+recive_email);
                                temp_tv_phone.setText("Contact No : "+recive_phone);
                                temp_tv_blood.setText("Blood Group : "+recive_blood);
                                temp_tv_doj.setText("Date of Joining : "+recive_doj);
                                temp_tv_expire.setText("Expire Date : "+recive_expire);
                                temp_tv_aadhaar.setText("Aadhaar Number : "+recive_aadhaar);
                                temp_tv_volunteers_code.setText("Volunteers Code : "+recive_volunteers_code);

                                temp_tv_department.setText("Depertment : "+recive_depertment);
                                temp_tv_issue.setText("Issue Date : "+recive_issue_date);
                                temp_tv_sebaloy_post.setText("Post in Sebaloy : "+recive_sebaloy_post);
                                temp_tv_sebaloy_post_level.setText("Post level : "+recive_sebaloy_post_level);
                                temp_tv_card_number.setText("Present Card Number : "+recive_card_number);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(Display_info.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        params.put("id", temp_id);


                        return params;
                    }

                };

                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(Display_info.this);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);




    }
}
