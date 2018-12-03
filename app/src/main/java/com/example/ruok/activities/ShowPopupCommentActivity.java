package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.Response;
import com.example.ruok.controller.SaveOrUpdateUserTask;
import com.example.ruok.utils.JsonUser;

import java.util.ArrayList;
import java.util.List;

import classes.Problem;

/**
 * ShowPopupCommentActivity
 * Usage: this page is for care provider adding comment for the patient's problem
 * Note: still working
 *
 * @version 1.1
 * @see CareProviderViewListOfRecordsActivity
 */
public class ShowPopupCommentActivity extends AppCompatActivity {

    private EditText doctor_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_add_comment2);
        initView();
    }

    public void back(View view) {
        Intent intent = new Intent(ShowPopupCommentActivity.this, CareProviderViewListOfRecordsActivity.class);
        startActivity(intent);
    }

    private void initView() {
        doctor_comment = (EditText) findViewById(R.id.doctor_comment);
    }

    private void submit() {
        // validate
        String problemTitleTextFieldString = doctor_comment.getText().toString().trim();
        if (TextUtils.isEmpty(problemTitleTextFieldString)) {
            Toast.makeText(this, "problemTitleTextFieldString", Toast.LENGTH_SHORT).show();
            return;
        }
        JsonUser patient = (JsonUser) getIntent().getSerializableExtra("patient");
        int problemIndex = getIntent().getIntExtra("problemIndex", -1);
        ArrayList<Problem> problems = patient.getProblems();
        Problem problem = problems.get(problemIndex);
        List<String> comments = problem.getComments();
        comments.add(problemTitleTextFieldString);

        SaveOrUpdateUserTask task = new SaveOrUpdateUserTask();
        task.execute(patient);
        task.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(ShowPopupCommentActivity.this, result, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(ShowPopupCommentActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveComment(View view) {
        submit();
    }
}
