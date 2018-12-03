package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.Response;
import com.example.ruok.controller.SaveOrUpdateUserTask;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import java.util.Date;

import classes.Problem;
import classes.Record;

/**
 * AddRecordActivity
 * Usage: Patient can add a record to a problem.
 *
 * @version 1.1
 */

public class AddRecordActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText doctorAddPatientName;
    private EditText addRecordbodyLocation;
    private EditText addRecordMoreDetail;
    private Button addProblemBack;
    private EditText addRecordLocation;
    private ImageButton addRecordLocationImage;
    private ImageButton addRecordBodyLocationImage;
    private EditText editText;
    private EditText editText23;

    private Problem problem;
    private int problemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        initView();

        getData();
    }

    private void getData() {
        problem = (Problem) getIntent().getSerializableExtra("problem");
        problemIndex = getIntent().getIntExtra("problemIndex", -1);
    }

    private void initView() {
        doctorAddPatientName = (EditText) findViewById(R.id.doctorAddPatientName);
        addRecordbodyLocation = (EditText) findViewById(R.id.addRecordbodyLocation);
        addRecordMoreDetail = (EditText) findViewById(R.id.addRecordMoreDetail);
        addProblemBack = (Button) findViewById(R.id.addProblemBack);
        addRecordLocation = (EditText) findViewById(R.id.addRecordLocation);
        addRecordLocationImage = (ImageButton) findViewById(R.id.addRecordLocationImage);
        addRecordBodyLocationImage = (ImageButton) findViewById(R.id.addRecordBodyLocationImage);
        editText = (EditText) findViewById(R.id.editText);
        editText23 = (EditText) findViewById(R.id.editText23);

        addProblemBack.setOnClickListener(this);
        addRecordLocationImage.setOnClickListener(this);
        addRecordBodyLocationImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addProblemBack:// save
                save();
                break;
            case R.id.addRecordLocationImage:// location
                startActivity(new Intent(AddRecordActivity.this, GeolocationActivity.class));
                break;
            case R.id.addRecordBodyLocationImage://photo
                startActivity(new Intent(AddRecordActivity.this, BodyLocationActivity.class));
                break;
        }
    }

    /**
     * sava data and back
     */
    private void save() {
        String title = editText.getText().toString();
        String detail = editText23.getText().toString();

        final Record record = new Record();
        record.setId(System.currentTimeMillis() + "");
        record.setRecordTitle(title);
        record.setDetail(detail);
        record.setDate(new Date());

        record.setLocation("");
        record.setBodyLocation("");

        problem.addRecord(record);

        JsonUser user = (JsonUser) SpUtil.getCurrentUser();
        user.getProblems().remove(problemIndex);
        user.getProblems().add(problem);


        SaveOrUpdateUserTask task = new SaveOrUpdateUserTask();
        task.execute(user);
        task.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(AddRecordActivity.this, result, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(AddRecordActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }


}
