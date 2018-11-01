package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruok.R;

public class BodyLocationActivity extends AppCompatActivity {
    private ImageView body_location_picture;
    private TextView location;
    private ImageView add_more_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_location);
    }
}
