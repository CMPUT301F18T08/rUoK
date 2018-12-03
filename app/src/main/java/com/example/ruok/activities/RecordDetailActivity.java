package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.ruok.R;

import java.text.SimpleDateFormat;

import classes.Patient;
import classes.Record;

/**
 * RecordDetailActivity
 * Usage: show the record detail for patient
 *
 * @version 1.1
 */

public class RecordDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editDoctor;
    private EditText editdate;
    private EditText editComment;
    private EditText editMoreDetail;
    private ImageButton addRecordLocationImage;
    private ImageButton addRecordBodyLocationImage;
    //editDoctor editdate editComment editMoreDetail

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail);
        initView();
        initData();
    }

    private void initData() {
        Patient patient = (Patient) getIntent().getSerializableExtra("patient");
        Record record = (Record) getIntent().getSerializableExtra("record");
        int recordIndex = getIntent().getIntExtra("recordIndex", -1);

        editMoreDetail.setText(record.getDetail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = sdf.format(record.getDate());
        editdate.setText(date);
        String bodyLocation = record.getBodyLocation();
        if (bodyLocation != null) {
            if (bodyLocation.equals("head")) {
                addRecordBodyLocationImage.setImageResource(R.mipmap.ic_body_head);
            } else if (bodyLocation.equals("hand")) {
                addRecordBodyLocationImage.setImageResource(R.mipmap.ic_body_hand);
            } else if (bodyLocation.equals("arm")) {
                addRecordBodyLocationImage.setImageResource(R.mipmap.ic_body_right_arm);

            } else if (bodyLocation.equals("chest")) {
                addRecordBodyLocationImage.setImageResource(R.mipmap.ic_body_chest);
            } else if (bodyLocation.equals("abdomen")) {
                addRecordBodyLocationImage.setImageResource(R.mipmap.ic_body_fubu);

            } else if (bodyLocation.equals("leg")) {
                addRecordBodyLocationImage.setImageResource(R.mipmap.ic_body_leg);

            } else if (bodyLocation.equals("foot")) {
                addRecordBodyLocationImage.setImageResource(R.mipmap.ic_body_foot);
            }
        }

    }

    public void back(View view) {
        Intent intent_myProfile = new Intent(this, RecordPageActivity.class);
        startActivity(intent_myProfile);
    }

    private void initView() {
        editDoctor = (EditText) findViewById(R.id.editDoctor);
        editdate = (EditText) findViewById(R.id.editdate);
        editComment = (EditText) findViewById(R.id.editComment);
        editMoreDetail = (EditText) findViewById(R.id.editMoreDetail);
        addRecordLocationImage = (ImageButton) findViewById(R.id.addRecordLocationImage);
        addRecordBodyLocationImage = (ImageButton) findViewById(R.id.addRecordBodyLocationImage);

        addRecordLocationImage.setOnClickListener(this);
        addRecordBodyLocationImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addRecordLocationImage:
                startActivity(new Intent(RecordDetailActivity.this, GeolocationActivity.class));
                break;
            case R.id.addRecordBodyLocationImage:

                break;
        }
    }

}
