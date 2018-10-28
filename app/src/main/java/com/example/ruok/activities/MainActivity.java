package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ruok.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String SignInInfo = "DEFAULT";
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
        Intent intent_SignIn = new Intent(this, SignUpActivity.class);
        EditText userName_input = (EditText) findViewById(R.id.editText);
        EditText password_input = (EditText) findViewById(R.id.editText);
        String userName = userName_input.getText().toString();
        String password = password_input.getText().toString();
        intent_SignIn.putExtra(SignInInfo, userName+password);
        startActivity(intent_SignIn);
    }
}
