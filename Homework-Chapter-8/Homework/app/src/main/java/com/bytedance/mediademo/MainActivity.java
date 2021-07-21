package com.bytedance.mediademo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static int PERMISSION_REQUEST_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button custom = findViewById(R.id.bt_custom_camera);
        Button syscam = findViewById(R.id.bt_system_take_picture);
        Button sysrec = findViewById(R.id.bt_system_record);
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customCamera(v);
                Intent intent = new Intent(MainActivity.this, CustomCameraActivity.class);
                startActivity(intent);
            }
        });
        syscam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                systemTakePicture(v);
            }
        });
        sysrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                systemRecord(v);
            }
        });
    }

    public void systemTakePicture(View view) {
        SystemCameraActivity.startUI(this);
//        TestActivity.startUI(this);
    }

    public void systemRecord(View view) {
        SystemRecordActivity.startUI(this);
    }

    public void customCamera(View view) {
        requestPermission();
    }

    private void recordVideo() {
        CustomCameraActivity.startUI(this);
    }

    private void requestPermission() {
        boolean hasCameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        boolean hasAudioPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED;
        if (hasCameraPermission && hasAudioPermission) {
            recordVideo();
        } else {
            List<String> permission = new ArrayList<String>();
            if (!hasCameraPermission) {
                permission.add(Manifest.permission.CAMERA);
            }
            if (!hasAudioPermission) {
                permission.add(Manifest.permission.RECORD_AUDIO);
            }
            ActivityCompat.requestPermissions(this, permission.toArray(new String[permission.size()]), PERMISSION_REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean hasPermission = true;
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                hasPermission = false;
                break;
            }
        }
        if (hasPermission) {
            recordVideo();
        } else {
            Toast.makeText(this, "权限获取失败", Toast.LENGTH_SHORT).show();
        }
    }

}