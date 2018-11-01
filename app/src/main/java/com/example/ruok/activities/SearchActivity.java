package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruok.R;

public class SearchActivity extends AppCompatActivity {
    private TextView search;
    private EditText keywords;
    private EditText search_body_location;
    private EditText search_geolocation;
    private Button search_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_request);
    }
}
