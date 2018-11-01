package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ruok.R;

public class AddRecordActivity extends AppCompatActivity {
    private TextView add_record;
    private EditText title;
    private EditText body_location;
    private EditText date;
    private EditText more_detail;
    private Button save;
    private EditText title_hint;
    private EditText detail_hint;
    private EditText location;
    private ImageButton icon_map;
    private ImageButton icon_carmra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        Intent intent = getIntent();
    }
}
