package com.example.ruok.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * AddProblemActivity
 * Usage: Patient can add a problem. On success, redirect back to ProblemListActivity
 *
 * @version 1.1
 */


public class AddProblemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problem);
    }

    /**
     * back to problem list page
     * @param view
     */
    public void back(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ProblemListActivity.class);
        startActivity(intent);

     }
}
