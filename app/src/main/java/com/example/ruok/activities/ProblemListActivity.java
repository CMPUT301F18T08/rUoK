package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ruok.R;

public class ProblemListActivity extends AppCompatActivity {
    private EditText patient;
    private Button search_button;
    private Button resetPassword_Button;
    private ListView list_problem;
    private TextView problem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_page);
    }
}
