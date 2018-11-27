package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * AddRecordActivity
 * Usage: Patient can add a record to a problem.
 *
 * @version 1.1
 */

public class AddRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        Intent intent = getIntent();
    }

    /**
     * save info and go to record page
     * @param view
     */
    public void save_record(View view){
        Intent intent = new Intent(this, RecordPageActivity.class);
        startActivity(intent);
    }
}
