package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ruok.R;

public class SignUpActivity extends AppCompatActivity {
    private EditText user_name;
    private RadioButton female;
    private RadioButton male;
    private EditText email;
    private EditText password;
    private EditText confirm_password;
    private Button save;
    private EditText phone_number;
    private RadioButton as_patient;
    private  RadioButton as_care_provider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Intent intent = getIntent();

    }
}
