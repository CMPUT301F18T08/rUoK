package com.example.ruok.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.Response;
import com.example.ruok.controller.SaveOrUpdateUserTask;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

/**
 * PatientProfileActivity
 * Usage: show the patient profile. the patient can edit phone number and email address.
 *
 * @version 1.1
 */


public class PatientProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private Button myProfileSave;
    private RadioButton signUpFemale;
    private RadioButton signUpMale;
    private RadioGroup radio;
    private EditText editUserName;
    private EditText editPhoneNumber;
    private EditText editEmail;
    // editUserName signUpFemale signUpMale editPhoneNumber editEmail myProfileSave

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        initView();

        initData();
    }

    private void initData() {
        JsonUser user = SpUtil.getCurrentUser();
        editUserName.setText(user.getUserName());
        editEmail.setText(user.getEmail());
        editPhoneNumber.setText(user.getPhoneNumber());
        if ("male".equals(user.getGender())) {
            signUpMale.setChecked(true);
            signUpFemale.setChecked(false);
        } else {
            signUpMale.setChecked(false);
            signUpFemale.setChecked(true);
        }
    }

    private void initView() {
        myProfileSave = (Button) findViewById(R.id.myProfileSave);
        signUpFemale = (RadioButton) findViewById(R.id.signUpFemale);
        signUpMale = (RadioButton) findViewById(R.id.signUpMale);
        radio = (RadioGroup) findViewById(R.id.radio);
        editUserName = (EditText) findViewById(R.id.editUserName);
        editPhoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        editEmail = (EditText) findViewById(R.id.editEmail);

        myProfileSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myProfileSave:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String editUserNameString = editUserName.getText().toString().trim();
        if (TextUtils.isEmpty(editUserNameString)) {
            Toast.makeText(this, "UserName", Toast.LENGTH_SHORT).show();
            return;
        }

        String editPhoneNumberString = editPhoneNumber.getText().toString().trim();
        if (TextUtils.isEmpty(editPhoneNumberString)) {
            Toast.makeText(this, "PhoneNumber", Toast.LENGTH_SHORT).show();
            return;
        }

        String editEmailString = editEmail.getText().toString().trim();
        if (TextUtils.isEmpty(editEmailString)) {
            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
            return;
        }
        String gender = signUpMale.isChecked() ? "male" : "female";

        JsonUser user = SpUtil.getCurrentUser();
        user.setUserName(editUserNameString);
        user.setPhoneNumber(editPhoneNumberString);
        user.setEmail(editEmailString);
        user.setGender(gender);
        SaveOrUpdateUserTask task = new SaveOrUpdateUserTask();
        task.execute(user);
        task.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(PatientProfileActivity.this, "success", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(PatientProfileActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
