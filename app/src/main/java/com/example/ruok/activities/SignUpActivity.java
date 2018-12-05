package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.RegisterController;
import com.example.ruok.controller.Response;
import com.example.ruok.utils.JsonUser;

import java.util.ArrayList;

import classes.User;

/**
 * SignUpActivity
 * Usage: user sign up page
 *
 * @version 1.1
 */

public class SignUpActivity extends AppCompatActivity {
    public static ArrayList<User> user_data = new ArrayList<User>();
    public static final String FILENAME = "file.sav";
    private EditText user_name;
    private RadioButton female;
    private RadioButton male;
    private EditText email;
    private EditText password;
    private EditText confirm_password;
    private Button save;
    private EditText phone_number;
    private RadioButton as_patient;
    private RadioButton as_care_provider;
    private RadioGroup gender;
    private String get_gender;
    private RadioGroup user_type;
    private String get_user_type = "patient";

    private JsonUser jsonUser = new JsonUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);
        Intent intent = getIntent();


        user_name = (EditText) findViewById(R.id.editText18);
        email = (EditText) findViewById(R.id.emailTextField);
        phone_number = (EditText) findViewById(R.id.phoneNumTextField);
        password = (EditText) findViewById(R.id.passwordTextField);
        confirm_password = (EditText) findViewById(R.id.confirmPasswordTextField);
        gender = (RadioGroup) findViewById(R.id.radio);
        female = (RadioButton) findViewById(R.id.signUpFemale);
        male = (RadioButton) findViewById(R.id.signUpMale);
        as_care_provider = (RadioButton) findViewById(R.id.signUpCareProvider);
        as_patient = (RadioButton) findViewById(R.id.signUpPatient);
        save = (Button) findViewById(R.id.signUpSave);

        user_type = (RadioGroup) findViewById(R.id.radio2);


        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.signUpFemale:
                        get_gender = "female";
                        break;
                    case R.id.signUpMale:
                        get_gender = "male";
                        break;
                }
            }
        });

        user_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.signUpPatient:
                        get_user_type = "patient";
                        break;
                    case R.id.signUpCareProvider:
                        get_user_type = "care_provider";
                        break;
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String edit_user_name = user_name.getText().toString();
                String edit_email = email.getText().toString();
                String edit_phone_number = phone_number.getText().toString();
                String edit_password = password.getText().toString();
                String edit_confirm_password = confirm_password.getText().toString();

                jsonUser.setUserName(edit_user_name);
                jsonUser.setEmail(edit_email);
                jsonUser.setPhoneNumber(edit_phone_number);
//                jsonUser.setPassword(edit_password);
                jsonUser.setGender(get_gender);
                jsonUser.setUserType(get_user_type);

                if (edit_password.equals(edit_confirm_password)) {
                    submitToES();

                } else {
                    Toast.makeText(SignUpActivity.this, "Passwords entered don't match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void Back(View view) {
        // Do something in response to back button
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);

    }

    private void submitToES() {

        RegisterController rc = new RegisterController();
        rc.execute(jsonUser);
        rc.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(SignUpActivity.this, result, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(SignUpActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}