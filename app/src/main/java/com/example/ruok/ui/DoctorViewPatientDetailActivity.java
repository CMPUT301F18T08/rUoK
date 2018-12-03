package com.example.ruok.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruok.R;
import com.example.ruok.utils.JsonUser;

public class DoctorViewPatientDetailActivity extends AppCompatActivity {

    private TextView tv_title;
    private EditText et_username;
    private EditText et_gender;
    private EditText et_email;
    private EditText et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view_patient_detail);
        initView();
        initData();
    }

    @SuppressLint("SetTextI18n")
    private void initData() {
        JsonUser patient = (JsonUser) getIntent().getSerializableExtra("patient");
        if (patient != null) {
            et_username.setText(getResources().getString(R.string.user_name) + patient.getUserName());
            et_email.setText(getResources().getString(R.string.email) + patient.getEmail());
            et_gender.setText(getResources().getString(R.string.gender) + patient.getGender());
            et_phone.setText("Phone Number: " + patient.getPhoneNumber());
        }
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        et_username = (EditText) findViewById(R.id.et_username);
        et_gender = (EditText) findViewById(R.id.et_gender);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
    }

}
