package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ruok.R;

public class CareProviderViewRecordDetailsActivity extends AppCompatActivity {
    private EditText Record;
    private EditText name_parient;
    private EditText Doctor;
    private EditText date;
    private EditText comment;
    private EditText location;
    private EditText body_location;
    private Button add_comment;
    private Button goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider_view_record_details);
    }

}
