package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    boolean lock = false;


    private boolean changeLock(){
        if (lock) {lock = false;}
        else {lock = true;}
        return lock;
    }

    private boolean ifLock(){return lock;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ques = findViewById(R.id.ques);
        final TextView txt = findViewById(R.id.tip);

        RadioButton rst = findViewById(R.id.rst);
        rst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(ifLock() == false){txt.setText("Hello World!");}
            }
        });

        Switch Lock = findViewById(R.id.Lock);
        Lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLock();
            }
        });

        ToggleButton TogBu = findViewById(R.id.TogBu);
        TogBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ifLock() == false){txt.setText("change");}
            }
        });

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(ifLock() == false){txt.setText("Hey, what are you waiting for?");}
            }
        });
        ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ifLock() == false){txt.setText("Sorry, no help!");}
            }
        });
    }
}
