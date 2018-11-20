package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ruok.R;

import classes.BodyLocation;


public class ViewBodyLocationPhotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_location);
    }

    public void addBodyPhoto(View view){
        Intent intent_addBodyPhoto = new Intent(ViewBodyLocationPhotosActivity.this, AddPhotoActivity.class);
        startActivity(intent_addBodyPhoto);
    }
    public void browseBodyLocationPhoto(View view) {
        Intent intent = new Intent(this, BodyLocationActivity.class);
        startActivity(intent);
    }

}