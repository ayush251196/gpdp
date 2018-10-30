package com.example.project.hci_lab;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class video_activity extends AppCompatActivity {

    VideoView videoview = (VideoView) findViewById(R.id.videoView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
       // setContentView( R.layout.video_display_1 );

        //VideoView videoview = (VideoView) findViewById(R.id.videoView);

        //Video Loop
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            public void onCompletion(MediaPlayer mp) {
                mp.start(); //need to make transition seamless.
                mp.setLooping( true );

            }
            /*

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
            */


        });

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
        videoview.setVideoURI(uri);
        videoview.requestFocus();
        videoview.start();
    }
}
