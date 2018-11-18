package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ruok.R;

public class PatientProfileActivity extends AppCompatActivity {
    private Button save_button;
    private EditText edit_user_name;
    private EditText edit_phone_number;
    private EditText edit_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        Intent intent = getIntent();
        //todo no original information
        save_button = (Button)findViewById(R.id.myProfileSave);
        edit_user_name = (EditText) findViewById(R.id.editUserName);
        edit_phone_number = (EditText) findViewById(R.id.editPhoneNumber);
        edit_email = (EditText) findViewById(R.id.editEmail);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientProfileActivity.this, ProblemListActivity.class);
                startActivity(intent);

            }
        });
        }
}
