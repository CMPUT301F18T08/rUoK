package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruok.R;

public class ResetPasswordActivity extends AppCompatActivity {
    private TextView reset_password;
    private EditText new_password;
    private EditText confirm_password;
    private Button save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        Intent intent = getIntent();
    }
}
