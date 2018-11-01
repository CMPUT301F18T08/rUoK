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
    private EditText username;
    private Button Sign_in_button;
    private Button sign_up_button;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignUp(View view) {
        // Do something in response to button
        Intent intent_SignUp = new Intent(this, SignUpActivity.class);
        startActivity(intent_SignUp);
    }

    public void SignIn(View view){
        EditText userName_input = (EditText) findViewById(R.id.editText);
        EditText password_input = (EditText) findViewById(R.id.editText);
        String userName = userName_input.getText().toString();
        String password = password_input.getText().toString();
        // TODO: 2018/10/29 validate username and password  and databaseissue

        // if user is a care provider
        Intent intent_careprovider = new Intent(this, CareProviderActivity.class);
        intent_careprovider.putExtra(SignInInfo, userName+password);
        startActivity(intent_careprovider);
    }
}
