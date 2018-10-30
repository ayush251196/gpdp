package com.example.project.hci_lab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import static java.lang.Thread.sleep;

public class circle_menu extends AppCompatActivity {

    String arrayName[]={"insert","display","update","document"};
    String cm_surveyor_code,cm_surveyor_name,cm_surveyor_district,cm_surveyor_subdivision,cm_surveyor_block,cm_surveyor_gp_vc_name,
            cm_surveyor_gp_vc_type,cm_server_response,recive_self_image,cm_tv_surveyor_gp_vc_type_holder;


    Bitmap bmp;
    ImageView iv_self_photo;
    private NetworkImageView imageView;
    private ImageLoader imageLoader;

    TextView cm_tv_surveyor_name,cm_tv_surveyor_code,cm_tv_surveyor_district,cm_tv_surveyor_subdivision,cm_tv_surveyor_block,
            cm_tv_surveyor_gp_vc_name;


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


    public void intialization_tools()
    {
        cm_tv_surveyor_code = (TextView) findViewById(R.id.tv_surveyor_code);
        cm_tv_surveyor_name = (TextView) findViewById(R.id.tv_name_menu);
        cm_tv_surveyor_district = (TextView) findViewById(R.id.tv_district_menu);
        cm_tv_surveyor_subdivision = (TextView) findViewById(R.id.tv_subdivision_menu);
        cm_tv_surveyor_block = (TextView) findViewById(R.id.tv_block_menu);
        cm_tv_surveyor_gp_vc_name = (TextView) findViewById(R.id.tv_gp_vc_name_menu);

        imageView = (NetworkImageView) findViewById(R.id.imageView1);
        iv_self_photo = (ImageView)findViewById(R.id.imageView1);



    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.design_circle_menu);



        intialization_tools();

        //temp_surveyor_code = getIntent().getStringExtra("surveyor_code");
       cm_server_response=getIntent().getStringExtra("server_response");

       // $send_self_image."#".$send_name."#".$send_code."#".$send_district."#".$send_subdivision."#".$send_block."#".$send_gp_vc_name."#".$send_gp_vc_type;
        String[] parts = cm_server_response.split("\\#");

        recive_self_image=parts[0];

        byte[] image = Base64.decode(recive_self_image.getBytes(),Base64.DEFAULT);
        bmp = BitmapFactory.decodeByteArray(image,0,image.length);

        iv_self_photo.setVisibility( View.VISIBLE);
        iv_self_photo.setImageBitmap(bmp);

        loadImage(recive_self_image);

        //temp_tv_name.setText(cm_surveyor_name);

        cm_tv_surveyor_name.setText(parts[1]);
        cm_tv_surveyor_code.setText("Surveyor Code: "+ parts[2]);

        cm_tv_surveyor_district.setText("District : "+parts[3]);

        cm_tv_surveyor_subdivision.setText("Subdivision : "+parts[4]);
        cm_tv_surveyor_block.setText("Block : "+parts[5]);
        cm_tv_surveyor_gp_vc_name.setText("GP/VC : "+parts[6]);

        cm_tv_surveyor_gp_vc_type_holder=parts[7];
        cm_surveyor_code=parts[2];


        CircleMenu circleMenu=(CircleMenu) findViewById( R.id.circle_menu_1 );
        circleMenu.setMainMenu( Color.parseColor( "#E59866" ), R.drawable.gpdp_logo,R.drawable.ic_remove )
                .addSubMenu(Color.parseColor( "#2980B9" ), R.drawable.add_user)
                .addSubMenu(Color.parseColor( "#ff0000" ), R.drawable.display_user)
                .addSubMenu(Color.parseColor( "#F1C40F" ), R.drawable.update_user)
                .addSubMenu(Color.parseColor( "#58D68D" ), R.drawable.document)

                .setOnMenuSelectedListener( new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {

                        Intent k=null ;
                       // Toast.makeText( circle_menu.this, "you Selected :" +arrayName[i], Toast.LENGTH_SHORT ).show();

                        switch(i){
                            case 0:
                                k = new Intent(circle_menu.this,basic_info.class);
                                k.putExtra("cm_server_response", cm_server_response.trim());
                                break;
                            case 1:
                                 k = new Intent(circle_menu.this,Display_info.class);
                                 break;
                            case 2:
                                //Do this and this:        break;
                            default: //For all other cases, do this        break;
                        }


                       // sleep(5000);
                        startActivity(k);

                    }
                } );


    }
}
