package com.bytedance.camp.chapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.bytedance.camp.chapter4.R;

public class MyAnim extends AppCompatActivity {

    protected final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch(msg.what){
                case 1:
                    View v1 = findViewById(R.id.load);
                    RelativeLayout v2 = findViewById(R.id.page);
                    ObjectAnimator anim1 = ObjectAnimator.ofFloat(v1,"alpha",1,0);
                    anim1.setDuration(1000);
                    anim1.setInterpolator(new AccelerateInterpolator());
                    anim1.start();
                    ObjectAnimator anim2 = ObjectAnimator.ofFloat(v2,"alpha",0,1);
                    anim2.setDuration(1000);
                    anim2.setInterpolator(new AccelerateInterpolator());
                    anim2.start();
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(anim1,anim2);
                    animatorSet.start();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_anim);
        handler.sendMessageDelayed(Message.obtain(handler,1),2000);
    }
}
