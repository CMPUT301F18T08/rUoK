package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ruok.R;

public class CareProviderViewListOfRecordsActivity extends AppCompatActivity {
    private EditText view_record;
    private EditText patient;
    private ListView list_recoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider_view_list_of_records);
    }
}
