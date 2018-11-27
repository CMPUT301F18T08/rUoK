package com.example.ruok.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * RecordDetailActivity
 * Usage: show the record detail for patient
 * @version 1.1
 */

public class RecordDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
    }
    public void back(View view){
        Intent intent_myProfile = new Intent(this, RecordPageActivity.class);
        startActivity(intent_myProfile);
    }
}
