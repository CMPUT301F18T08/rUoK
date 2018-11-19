package com.example.ruok.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ruok.R;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import classes.CareProvider;
import classes.Patient;
import classes.User;


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
    private  RadioButton as_care_provider;
    private RadioGroup gender;
    private String get_gender;
    private RadioGroup user_type;
    private String get_user_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);
        Intent intent = getIntent();


        user_name =(EditText) findViewById(R.id.editText18);
        email = (EditText) findViewById(R.id.emailTextField);
        phone_number= (EditText) findViewById(R.id.phoneNumTextField);
        password = (EditText) findViewById(R.id.passwordTextField);
        confirm_password = (EditText) findViewById(R.id.confirmPasswordTextField);
        gender = (RadioGroup) findViewById(R.id.radio);
        female = (RadioButton) findViewById(R.id.signUpFemale);
        male = (RadioButton) findViewById(R.id.signUpMale);
        as_care_provider = (RadioButton) findViewById(R.id.signUpCareProvider);
        as_patient = (RadioButton) findViewById(R.id.signUpPatient);
        save = (Button)findViewById(R.id.signUpSave);

        user_type = (RadioGroup) findViewById(R.id.radio);




        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.signUpFemale:
                        get_gender = "female";
                        break;
                    case R.id.signUpMale:
                        get_gender = "male";
                        break;
                }
            }
        });

        user_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
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

                if(get_user_type == "patient"){
                    Patient patient = new Patient();
                    patient.setUserName(edit_user_name);
                    patient.setEmail(edit_email);
                    patient.setPhoneNumber(edit_phone_number);
                    patient.setPassword(edit_password);
                    patient.setGender(get_gender);
                    patient.setUserType(get_user_type);
                    user_data.add(patient);
                }
                else if(get_user_type == "care_provider"){
                    CareProvider careProvider = new CareProvider();
                    careProvider.setUserName(edit_user_name);
                    careProvider.setEmail(edit_email);
                    careProvider.setPhoneNumber(edit_phone_number);
                    careProvider.setPassword(edit_password);
                    careProvider.setGender(get_gender);
                    careProvider.setUserType(get_user_type);
                    user_data.add(careProvider);
                }
                //todo: if password == confirm_pssword  encryption??
                if (edit_password.equals(edit_confirm_password) ){
                    saveInFile();
                    Toast.makeText(SignUpActivity.this, "Sign up successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);

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
    private void saveInFile(){
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(user_data, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}