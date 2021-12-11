package com.example.videoplayerapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public  static String url = "https://firebasestorage.googleapis.com/v0/b/login-286eb.appspot.com/o/music%2FRobin%20-%2021723.mp4?alt=media&token=98fb49b1-ec11-411b-bf63-c2efa994e832";
    VideoView videoView;
    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init
        videoView = findViewById(R.id.video_view);
        play = findViewById(R.id.play);


      play.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              MediaController mediaController = new MediaController(MainActivity.this);
              videoView.setMediaController(mediaController);
              Uri uri = Uri.parse(url);
              videoView.setVideoURI(uri);

              videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                  @Override
                  public void onPrepared(MediaPlayer mp) {
                      mp.start();
                  }
              });




          }
      });


    }


}