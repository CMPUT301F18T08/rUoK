package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ruok.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import classes.Problem;

public class ProblemListActivity extends AppCompatActivity {

    private Button reset_button;
    private Button search_button;
    private Button problem_button;
    private RecyclerView problemlist;
    private Adapter adapter;
    private Problem problems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_page);

        reset_button = (Button) findViewById(R.id.problemPageResetPassword2);
        search_button = (Button) findViewById(R.id.problemPageSearch);
        problem_button = (Button) findViewById(R.id.addProblemButton);

        reset_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProblemListActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        search_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProblemListActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        problem_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProblemListActivity.this, AddProblemActivity.class);
                startActivity(intent);
            }
        });

        String userName = getIntent().getStringExtra("USERNAME");
        //put this username to the textview
        TextView usernameTextView = (TextView)findViewById(R.id.problemPageProblem);
        usernameTextView.setText(userName);

        //todo from here
        problems = new Problem(this);
        //load data
        adapter.setData(problems);
    }
}