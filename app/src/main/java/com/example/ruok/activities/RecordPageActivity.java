package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

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
        Intent intent_myProfile = new Intent(this, AddRecordActivity.class);
        startActivity(intent_myProfile);
    }
}
