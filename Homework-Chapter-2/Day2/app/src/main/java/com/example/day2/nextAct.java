package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class nextAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

            Button ret = findViewById(R.id.ret);
            ret.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(nextAct.this, MainActivity.class);
                    Toast.makeText(getApplicationContext(),"loading...",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            });
    }
}
