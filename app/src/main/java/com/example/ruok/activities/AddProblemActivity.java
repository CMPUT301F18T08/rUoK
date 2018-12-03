package com.example.ruok.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.Response;
import com.example.ruok.controller.SaveOrUpdateUserTask;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import java.util.Date;

import classes.Problem;

/**
 * AddProblemActivity
 * Usage: Patient can add or edit a problem. On success, redirect back to ProblemListActivity
 *
 * @version 1.1
 */


public class AddProblemActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView addProblemText;
    private Button addProblemBack;
    private Button addProblemSave2;
    private EditText et_title;
    private EditText et_description;
    private Problem problem;
    private int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_problem);
        initView();

        initData();
    }

    private void initData() {
        problem = (Problem) getIntent().getSerializableExtra("problem");
        index = getIntent().getIntExtra("index", -1);
        if (problem != null) {
            addProblemText.setText("Edit Problem");
            et_title.setText(problem.getTitle());
            et_description.setText(problem.getDescription());
        }
    }


    private void initView() {
        addProblemText = findViewById(R.id.addProblemText);
        addProblemBack = (Button) findViewById(R.id.addProblemBack);
        addProblemSave2 = (Button) findViewById(R.id.addProblemSave2);
        et_title = (EditText) findViewById(R.id.et_title);
        et_description = (EditText) findViewById(R.id.et_description);

        addProblemBack.setOnClickListener(this);
        addProblemSave2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addProblemBack:
                //back to problem list page
                finish();
                break;
            case R.id.addProblemSave2:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String title = et_title.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "title ", Toast.LENGTH_SHORT).show();
            return;
        }

        String description = et_description.getText().toString().trim();
        if (TextUtils.isEmpty(description)) {
            Toast.makeText(this, "description ", Toast.LENGTH_SHORT).show();
            return;
        }


        JsonUser user = SpUtil.getCurrentUser();

        if (index >= 0) { //edit problem
            problem.setDate(new Date());
            problem.setTitle(title);
            problem.setDescription(description);
            user.getProblems().remove(index);
            user.getProblems().add(problem);
        } else { //add problem
            problem = new Problem();
            problem.setDate(new Date());
            problem.setTitle(title);
            problem.setDescription(description);

            user.getProblems().add(problem);
        }

        SaveOrUpdateUserTask task = new SaveOrUpdateUserTask();
        task.execute(user);
        task.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                if (index < 0) {
                    Toast.makeText(AddProblemActivity.this, "add successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddProblemActivity.this, "Edit successful", Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(AddProblemActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
