package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.chapter3.homework.fragment.DataSet;
import com.example.chapter3.homework.fragment.MyAdapter;
import com.example.chapter3.homework.fragment.TestData;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {


    private List<TestData> list = new ArrayList<>();
    RecyclerView recyclerView;
    View tmp;
    LottieAnimationView animation;
    //TextView tw;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        tmp = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animation = tmp.findViewById(R.id.animation_view);

        list = DataSet.getData();
        recyclerView = tmp.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);
        return tmp;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            //animation.setAlpha(0);

            ObjectAnimator anim1 = ObjectAnimator.ofFloat(animation,"alpha",1,0);
            anim1.setDuration(1000);
            anim1.setInterpolator(new AccelerateInterpolator());
            ObjectAnimator anim2 = ObjectAnimator.ofFloat(recyclerView,"alpha",0,1);
            anim2.setDuration(1000);
            anim2.setInterpolator(new AccelerateInterpolator());
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(anim1,anim2);
            animatorSet.start();
            }
        }, 5000);
    }
}
