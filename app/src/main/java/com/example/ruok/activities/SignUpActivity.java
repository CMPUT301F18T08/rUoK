package com.example.ruok.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ruok.R;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import com.google.gson.Gson;

import classes.User;
import classes.User.user_data;


public class SignUpActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_sign_up);
        Intent intent = getIntent();


        user_name =(EditText) findViewById(R.id.editText18);
        email = (EditText) findViewById(R.id.editText10);
        phone_number= (EditText) findViewById(R.id.editText11);
        password = (EditText) findViewById(R.id.editText12);
        confirm_password = (EditText) findViewById(R.id.editText16);
        gender = (RadioGroup) findViewById(R.id.radio);
        female = (RadioButton) findViewById(R.id.radioButton3);
        male = (RadioButton) findViewById(R.id.radioButton4);
        as_care_provider = (RadioButton) findViewById(R.id.radioButton2);
        as_patient = (RadioButton) findViewById(R.id.radioButton);
        save = (Button)findViewById(R.id.button3);

        user_type = (RadioGroup) findViewById(R.id.radio2);



        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton3:
                        get_gender = "female";
                        break;
                    case R.id.radioButton4:
                        get_gender = "male";
                        break;
                }
            }
        });

        user_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton:
                        get_user_type = "patient";
                        break;
                    case R.id.radioButton2:
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


                //todo: if password == confirm_pssword
                User new_user = new User(edit_user_name, edit_password, get_gender, edit_email,edit_phone_number,get_user_type);
                user_data.add(new_user);
                saveInFile();

            }
        });
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
