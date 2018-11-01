package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ruok.R;

public class CareProviderActivity extends AppCompatActivity {
    private Button add_patient;
    private EditText care_provider_name;
    private Button search;
    private Button reset_password;
    private ListView list_patientname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider);
        Intent intent = getIntent();
    }

    public void resetPassword(View view){
        Intent intent_resetPassword = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent_resetPassword);
    }

}
