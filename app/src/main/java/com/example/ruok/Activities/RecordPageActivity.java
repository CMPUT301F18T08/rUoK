package com.example.ruok.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * RecordPageActivity
 * Usage: user can add record to a problem, view geolocation, view and edit user progile
 *
 * @version 1.1
 */

public class RecordPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_page);
    }
    public void addRecord(View view) {
        // Do something in response to button
        Intent intent_addRecord = new Intent(this, AddRecordActivity.class);
        startActivity(intent_addRecord);
    }

    public void myProfile(View view){
        Intent intent_myProfile = new Intent(this, PatientProfileActivity.class);
        startActivity(intent_myProfile);
    }

    public void viewGeoLocation(View view){
        Intent intent = new Intent(this, GeolocationActivity.class);
        startActivity(intent);
    }
    /*public void upLoadphoto(View view){
        Intent intent = new Intent(this, AddPhotoActivity.class);
        startActivity(intent);
    }*/    //photoIntent in bodylocation
}
