package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ruok.R;

import static com.example.ruok.activities.MainActivity.display_username;


public class CareProviderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider);
        Intent intent = getIntent();
        //display_username = getIntent().getStringExtra("USERNAME");
        TextView display = (TextView)findViewById(R.id.careProviderName);
        display.setText(display_username);

    }
 //todo 检查他病人的profile
    public void resetPassword(View view){
        Intent intent_resetPassword = new Intent(this, ResetPasswordActivity.class);
        startActivity(intent_resetPassword);
    }

    public void addAPatient(View view){
        Intent intent = new Intent(this, AddPatientActivity.class);
        startActivity(intent);
    }

    public void search(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }


}
