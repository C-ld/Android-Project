package com.bytedance.camp.chapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public static int ifcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ifcons = 0;

        Switch sw = findViewById(R.id.consecutive);
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifcons = 1-ifcons;
            }
        });

        Button btn = findViewById(R.id.myBut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyAnim.class);
                startActivity(intent);
            }
        });
    }
}
