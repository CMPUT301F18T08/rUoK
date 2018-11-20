package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * FrontAndBackPhotoActivity
 * Usage: Handling photo
 *
 * @version 1.1
 */
public class FrontAndBackPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_and_back_photo);
        Intent intent = getIntent();
    }

    public void addFrontPhoto(View view) {
        Intent intent_addFrontBodyPhoto = new Intent(this, AddPhotoActivity.class);
        startActivity(intent_addFrontBodyPhoto);
    }

    public void pointBodyLocation(View view) {
        Intent intent_addBackBodyPhoto = new Intent(this, AddPhotoActivity.class);
        startActivity(intent_addBackBodyPhoto);
    }
}