package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ruok.R;

public class PatientProfileActivity extends AppCompatActivity {
    private Button edit_phonenumber;
    private Button edit_email;
    private TextView my_profile;
    private EditText user_name;
    private RadioButton female;
    private RadioButton male;
    private EditText phone_number;
    private Button save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        Intent intent = getIntent();
    }
}
