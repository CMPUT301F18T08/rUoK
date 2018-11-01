package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ruok.R;

public class FrontAndBackPhotoActivity extends AppCompatActivity {
    private ImageView back_front;
    private Button goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_and_back_photo);
    }
}
