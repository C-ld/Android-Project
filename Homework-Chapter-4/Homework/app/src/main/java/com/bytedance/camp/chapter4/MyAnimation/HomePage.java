package com.bytedance.camp.chapter4.MyAnimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class HomePage extends View {

    public HomePage(Context context) {
        this(context,null);
    }

    public HomePage(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HomePage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }
    private void init() {

    }
}
