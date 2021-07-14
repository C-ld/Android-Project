package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import static android.animation.ValueAnimator.*;

public class Ch3Ex1Activity extends AppCompatActivity {
    private LottieAnimationView animationView;
    private CheckBox loopCheckBox;
    private SeekBar seekBar;
    private ValueAnimator anim;

    boolean lock;

    int pri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex1);

        animationView = findViewById(R.id.animation_view);
        loopCheckBox = findViewById(R.id.loop_checkbox);
        seekBar = findViewById(R.id.seekbar);

        lock = false;
        pri = 0;

        anim = ValueAnimator.ofInt(0,100);
        anim.setRepeatCount(INFINITE);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(RESTART);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator animation){
                if(lock==false){
                    seekBar.setProgress(pri+(int)animation.getAnimatedValue());
                }
                Log.d("TAG", "setTime");
            }
        });


        animationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.d("TAG", "onAnimationStart: "+animationView.getDuration());
                anim.setDuration(animationView.getDuration());
                anim.start();
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                pri = 0;
                anim.end();
                anim.start();
            }
        });

        lock = false;

        loopCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 当选中自动播放的时候，开始播放 lottie 动画，同时禁止手动修改进度
                    animationView.playAnimation();
                    seekBar.setEnabled(false);
                } else {
                    // 当去除自动播放时，停止播放 lottie 动画，同时允许手动修改进度
                    animationView.pauseAnimation();
                    seekBar.setEnabled(true);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO ex1-2: 这里应该调用哪个函数呢
                // 提示1：可以参考 https://airbnb.io/lottie/#/android?id=custom-animators
                // 提示2：SeekBar 的文档可以把鼠标放在 OnProgressChanged 中间，并点击 F1 查看，
                // 或者到官网查询 https://developer.android.google.cn/reference/android/widget/SeekBar.OnSeekBarChangeListener.html#onProgressChanged(android.widget.SeekBar,%20int,%20boolean
                animationView.setProgress(progress/100f);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                lock = true;
                Log.d("TAG", "onStartTrackingTouch: "+animationView.getDuration());
                animationView.pauseAnimation();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pri = seekBar.getProgress();
                lock = false;
                animationView.playAnimation();
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("TAG", "onResume: "+animationView.getDuration());
    }
}
