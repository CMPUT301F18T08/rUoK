package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

public class CareProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider);
        Intent intent = getIntent();
    }

    public void resetPassword(View view){
        Intent intent_resetPassword = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent_resetPassword);
    }

}
