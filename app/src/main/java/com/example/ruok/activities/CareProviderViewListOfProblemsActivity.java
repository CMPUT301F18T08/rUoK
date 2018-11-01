package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ruok.R;

public class CareProviderViewListOfProblemsActivity extends AppCompatActivity {
    private EditText patient_name;
    private ListView list_problem;
    private TextView problem_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider_view_list_of_problems);
    }
}
