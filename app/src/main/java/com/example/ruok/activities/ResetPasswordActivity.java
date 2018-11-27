package com.example.ruok.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ruok.R;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static com.example.ruok.activities.SignUpActivity.FILENAME;

/**
 * ResetPasswordActivity
 * Usage: reset password
 * @version 1.1
 */

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText new_password;
    private EditText confirm_password;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        Intent intent = getIntent();

        //todo old password do not know
        new_password = (EditText) findViewById(R.id.passwordTextField);
        confirm_password = (EditText) findViewById(R.id.confirmPasswordTextField);
        save = (Button)findViewById(R.id.careProviderAddAPatient);}

    public void save(View view){


                String edit_password = new_password.getText().toString();
                String edit_confirm_password = confirm_password.getText().toString();



                if (edit_password.equals(edit_confirm_password) ){
                    saveInFile();
                    Toast.makeText(ResetPasswordActivity.this, "change successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPasswordActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(ResetPasswordActivity.this, "Passwords entered don't match!", Toast.LENGTH_SHORT).show();
                }
            }
    private void saveInFile(){
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(SignUpActivity.user_data, out);
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
