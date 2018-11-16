package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ruok.R;

import classes.CareProvider;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String SignInInfo = "DEFAULT";
    private Button sign_in_button;
    private Button sign_up_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign_up_button = (Button) findViewById(R.id.SignUp);
        sign_in_button = (Button) findViewById(R.id.SignIn);

    }

    public void SignUp(View view) {
        // Do something in response to button

        sign_up_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    public void SignIn(View view){
        sign_in_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText userName_input = (EditText) findViewById(R.id.userName);
                EditText password_input = (EditText) findViewById(R.id.password);
                String userName = userName_input.getText().toString();
                String password = password_input.getText().toString();
                // TODO: 2018/10/29 validate username and password  and databaseissue
                //get the user type

                // if user is a care provider
                Intent intent_careprovider = new Intent(MainActivity.this, CareProviderActivity.class);
                intent_careprovider.putExtra("USERNAME", userName);
                startActivity(intent_careprovider);

                // if user is a patient
                Intent intent_patient = new Intent(MainActivity.this, ProblemListActivity.class);
                intent_patient.putExtra("USERNAME", userName);
                startActivity(intent_patient);



            }
        });

    }
}