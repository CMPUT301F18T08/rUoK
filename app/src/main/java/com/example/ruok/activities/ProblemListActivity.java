package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.adapter.ProblemAdapter;
import com.example.ruok.controller.AddProblemController;
import com.example.ruok.controller.Response;
import com.example.ruok.utils.SpUtil;

import classes.Patient;
import classes.Problem;
import classes.User;

import static com.example.ruok.activities.MainActivity.display_username;

/**
 * ProblemListActivity
 * Usage: show all the problems for a patient.
 *
 * @version 1.1
 */

public class ProblemListActivity extends AppCompatActivity {

    private Button reset_button;
    private Button search_button;
    private Button problem_button;
    private ListView problemlist;
    private Problem problems;

    private ProblemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_page);
        TextView display = (TextView) findViewById(R.id.problemPagePatient);
        display.setText(display_username);


        reset_button = (Button) findViewById(R.id.problemPageResetPassword2);
        search_button = (Button) findViewById(R.id.problemPageSearch);
        problem_button = (Button) findViewById(R.id.addProblemButton);
        problemlist = (ListView) findViewById(R.id.problemPageListView);

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProblemListActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProblemListActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        problem_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProblemListActivity.this, AddProblemActivity.class);
                startActivity(intent);
            }
        });


        initData();

    }

    private void initData() {
        User user = SpUtil.getCurrentUser();
        if (user instanceof Patient) {
            Patient p = (Patient) user;
            adapter = new ProblemAdapter(this, p);
            problemlist.setAdapter(adapter);
        }

        adapter.setListener(new ProblemAdapter.OnItemClickListener() {
            @Override
            public void onDelete(Patient patient) {
                delete(patient);
            }

            @Override
            public void onEdit(Patient patient, int position) {
                Toast.makeText(ProblemListActivity.this, "edit " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void delete(Patient patient) {
        AddProblemController apc = new AddProblemController();
        apc.execute((Runnable) patient);
        apc.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                initData();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(ProblemListActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }
}