package com.example.project.hci_lab;


import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link My_dialog_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//COPY THIS
public class My_dialog_fragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final int multiple_permission_request_code = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean cam_perm = false, ext_store_r = false, ext_store_w = false;
    private Button button1, button2;
    private ImageView imageView;
    private ImageView ben_image;
    private View rootView;
    private ImageView activityview;
    private Bitmap selectedImage;
    private Context context;
    private final String UPLOAD_URL = "http://nakshakantha.com/apis/beneficiary_image_uploader.php";

    public interface data_exchanger{
        void someListener(Uri selectedImageUri);

    }
    data_exchanger d;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {

            Uri uri=data.getData();
            Log.i("camera_uri",uri.toString());
           // selectedImage = (Bitmap) data.getExtras().get("data");
            try {
                selectedImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
//            imageView.setImageBitmap(selectedImage);
            ben_image.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.malay_color_white));
            ben_image.setImageBitmap(selectedImage);
            Drawable drawable=new BitmapDrawable( getResources(),selectedImage );
            ben_image.setBackground( drawable);
            d.someListener(uri);
            getDialog().dismiss();
            //uploadBitmap(selectedImage);
        } else if (requestCode == RESULT_LOAD_IMAG && resultCode == Activity.RESULT_OK && data != null) {
            // try{
            final Uri imageUri = data.getData();

            Log.i("ben image uri",imageUri.toString());
            try {
                selectedImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
            } catch (IOException e) {
                Toast.makeText(getActivity(), "You haven't pick any Image", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

            //  final InputStream imageStream=getContentResolver().openInputStream(imageUri);
            //   selectedImage= BitmapFactory.decodeStream(imageStream);
            //imageView.setImageBitmap(selectedImage);
            ben_image.setImageBitmap(selectedImage);
            Drawable drawable=new BitmapDrawable(getResources(),selectedImage );
            ben_image.setBackground( drawable);
            d.someListener(imageUri);
            getDialog().dismiss();
           // activityview.setImageBitmap(selectedImage);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            d = (data_exchanger) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }
    public void uploadBitmap(Bitmap bitmap,Context context,final String ben_code) {
//        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Uploading ,please wait...");
//        progressDialog.show();
        Toast.makeText( context,UPLOAD_URL,Toast.LENGTH_SHORT ).show();
        //converting image to base64 string
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        final String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

        //sending image to server
        StringRequest request = new StringRequest(Request.Method.POST, UPLOAD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // progressDialog.dismiss();
                //Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // progressDialog.dismiss();
//                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            //adding parameters to send
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<>();
                parameters.put("image", imageString);
                parameters.put( "img_name",ben_code);
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }


    private static final int CAMERA_REQUEST = 1888;
    private static final int RESULT_LOAD_IMAG = 10;

    public My_dialog_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageUploadFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static My_dialog_fragment newInstance(String param1, String param2) {
        My_dialog_fragment fragment = new My_dialog_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private final int camera_permission = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.dialog_box,null);
        context=getActivity();
        setviews(rootView);
        return  rootView;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();

    }

    protected  void setviews(View rootView){
        ben_image=getActivity().findViewById(R.id.ben_image);
        button1=rootView.findViewById(R.id.cap);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_REQUEST);
            }
        });
        button2=rootView.findViewById(R.id.chose);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent=new Intent().setAction(Intent.ACTION_GET_CONTENT).setType("image/*");
                startActivityForResult(photoPickerIntent,RESULT_LOAD_IMAG);
                //uploadBitmap(selectedImage);
            }
        });
      //  button3=rootView.findViewById(R.id.upload);


//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(selectedImage!=null)
//                    uploadBitmap(selectedImage,getActivity());
//                else{
//                    Toast.makeText(getActivity(),"Please choose the image",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }


}
