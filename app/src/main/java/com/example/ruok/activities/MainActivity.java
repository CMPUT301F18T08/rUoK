package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.LoginController;
import com.example.ruok.controller.Response;
import com.example.ruok.ui.HomeActivity;
import com.example.ruok.utils.JsonUser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * MainActivity
 * Usage: handling sign in and signup.
 *
 * @version 1.1
 */
public class MainActivity extends AppCompatActivity {
    public static final String SignInInfo = "DEFAULT";
    public static final String FILENAME = "file.sav";
    private Button sign_in_button;
    private Button sign_up_button;
    public static String display_username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign_up_button = (Button) findViewById(R.id.SignUp);
        sign_in_button = (Button) findViewById(R.id.SignIn);


    }


    public void SignUp(View view) {
        // Do something in response to button
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);

    }

    public void SignIn(View view) {
        EditText userName_input = (EditText) findViewById(R.id.userName);
        EditText password_input = (EditText) findViewById(R.id.password);
        final String userName = userName_input.getText().toString();
        String password = password_input.getText().toString();
        display_username = userName;
        LoginController lc = new LoginController();
        lc.execute(userName, password);
        lc.setResponse(new Response<JsonUser>() {
            @Override
            public void onSuccess(JsonUser result) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();

              /*  String userType = result.getUserType();
                if ("patient".equals(userType)) {
                    Intent intent_patient = new Intent(MainActivity.this, HomeActivity.class);
                    intent_patient.putExtra("USERNAME", userName);
                    startActivity(intent_patient);
                    finish();
                } else {
                    Intent intent_careprovider = new Intent(MainActivity.this, CareProviderActivity.class);
                    intent_careprovider.putExtra("USERNAME", userName);
                    startActivity(intent_careprovider);
                    finish();
                }*/
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            //Type listType = new TypeToken<ArrayList<feels>>(){}.getType();
            //Counts = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}