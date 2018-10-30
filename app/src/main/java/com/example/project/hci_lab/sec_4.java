package com.example.project.hci_lab;

//import android.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.drm.ProcessedData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class sec_4 extends Fragment {
    private final int camera_permission=100;
    private final int external_storage_permission=101;
    private Button button1,button2,button3;
    private ImageView imageView;
    private Bitmap selectedImage;
    private ProgressDialog progressDialog;
    private final String UPLOAD_URL="http://www.sebaloy.in/p1.php";
   // private final String UPLOAD_URL="http://192.168.43.230/p1.php";




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST && resultCode== Activity.RESULT_OK){
            selectedImage=(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(selectedImage);
            //uploadBitmap(selectedImage);
        }
        else if(requestCode==RESULT_LOAD_IMAG && resultCode==Activity.RESULT_OK&&data!=null){
            // try{
            final Uri imageUri=data.getData();
            try {
                selectedImage= MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),imageUri);
            } catch (IOException e) {
                Toast.makeText(getActivity(),"You haven't pick any Image",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
           // Log.i("imageUri",imageUri.toString());
            //  final InputStream imageStream=getContentResolver().openInputStream(imageUri);
            //   selectedImage= BitmapFactory.decodeStream(imageStream);
            imageView.setImageBitmap(selectedImage);
        }
    }



    private void uploadBitmap(Bitmap bitmap){
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Uploading ,please wait...");
        progressDialog.show();

        //converting image to base64 string
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,50,baos);
        byte[] imageBytes=baos.toByteArray();
        final String imageString= Base64.encodeToString(imageBytes,Base64.DEFAULT);

        //sending image to server
        StringRequest request=new StringRequest(Request.Method.POST,UPLOAD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            //adding parameters to send
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> parameters=new HashMap<>();
                parameters.put("image",imageString);
                return parameters;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }

    //
    private static final int CAMERA_REQUEST=1888;
    private static final int RESULT_LOAD_IMAG=10;


    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

//    public boolean checkPermissionREAD_EXTERNAL_STORAGE(
//            final Context context) {
//        int currentAPIVersion = Build.VERSION.SDK_INT;
//        if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(context,
//                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                if (ActivityCompat.shouldShowRequestPermissionRationale(
//                        (Activity) context,
//                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    showDialog("External storage", context,Manifest.permission.READ_EXTERNAL_STORAGE);
//
//                } else {
//                    ActivityCompat
//                            .requestPermissions(
//                                    (Activity) context,
//                                    new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
//                                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
//                }
//                return false;
//            } else {
//                return true;
//            }
//
//        } else {
//            return true;
//        }
//    }


//    public void showDialog(final String msg, final Context context,
//                           final String permission) {
//        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
//        alertBuilder.setCancelable(true);
//        alertBuilder.setTitle("Permission necessary");
//        alertBuilder.setMessage(msg + " permission is necessary");
//        alertBuilder.setPositiveButton(android.R.string.yes,
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        ActivityCompat.requestPermissions((Activity) context,
//                                new String[] { permission },
//                                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
//                    }
//                });
//        AlertDialog alert = alertBuilder.create();
//        alert.show();
//    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case camera_permission:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
                    startActivityForResult( cameraIntent, CAMERA_REQUEST );
                } else {
                    Toast.makeText(getActivity(), "GET_ACCOUNTS Denied", Toast.LENGTH_SHORT).show();
                }
                break;

            case external_storage_permission:
                if(grantResults[1]==PackageManager.PERMISSION_GRANTED) {
                    Intent photoPickerIntent = new Intent().setAction( Intent.ACTION_GET_CONTENT ).setType( "image/*" );
                    startActivityForResult( photoPickerIntent, RESULT_LOAD_IMAG );
                }
                    else{
                        Toast.makeText( getActivity(),"Please grant the permission!",Toast.LENGTH_SHORT ).show();
                    }


            default:
                super.onRequestPermissionsResult(requestCode, permissions,
                        grantResults);
        }
    }





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView( inflater, container, savedInstanceState );
        Toast.makeText( getActivity(), "hai......sec4", Toast.LENGTH_LONG ).show();
        View rootview=inflater.inflate( R.layout.sec4,container,false );

       // if (checkPermissionREAD_EXTERNAL_STORAGE(getActivity())) {
            imageView=rootview.findViewById(R.id.imageView);
            button1=rootview.findViewById(R.id.cap);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        // No explanation needed; request the permission
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{android.Manifest.permission.CAMERA},camera_permission);

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    }else {
                        Intent cameraIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
                        startActivityForResult( cameraIntent, CAMERA_REQUEST );
                    }
                }
            });

            button2=rootview.findViewById(R.id.chose);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                        // No explanation needed; request the permission
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{android.Manifest.permission.CAMERA},external_storage_permission);

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.

                    }else {
                        Intent photoPickerIntent = new Intent().setAction( Intent.ACTION_GET_CONTENT ).setType( "image/*" );
                        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMAG );
                        Toast.makeText( getActivity(),"choose fron gallery",Toast.LENGTH_SHORT ).show();

                        //uploadBitmap(selectedImage);
                    }
                }
            });
            button3=rootview.findViewById(R.id.upload);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selectedImage!=null)
                        uploadBitmap(selectedImage);
                    else{
                        Toast.makeText(getActivity(),"Please choose the image",Toast.LENGTH_SHORT).show();
                    }
                }
            });




        return rootview;

    }
}
