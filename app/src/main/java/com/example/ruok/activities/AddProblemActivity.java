package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

public class AddProblemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problem2);
    }

    public void back(View view) {
        // Do something in response to button
        Intent intent = new Intent(AddProblemActivity.this, ProblemListActivity.class);
        startActivity(intent);

    }
}
