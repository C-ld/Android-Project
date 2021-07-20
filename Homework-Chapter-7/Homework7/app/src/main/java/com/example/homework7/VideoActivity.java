package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    String mockUrl = "https://stream7.iqilu.com/10339/upload_transcode/202002/18/20200218114723HDu3hhxqIT.mp4";

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.vv_detail);
        videoView.setVideoURI(Uri.parse(mockUrl));
        videoView.setMediaController(new MediaController(this));
        videoView.start();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        // TODO Auto-generated method stub
//        super.onConfigurationChanged(newConfig);
////        setContentView(R.layout.activity_video);
//        //videoView.seekTo();
////        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
////        {
////            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
////        }
////        else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
////        {
////            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
////        }
//    }
}
