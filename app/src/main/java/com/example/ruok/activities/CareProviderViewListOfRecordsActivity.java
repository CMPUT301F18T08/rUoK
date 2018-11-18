package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

public class CareProviderViewListOfRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider_view_list_of_records);
    }

    public void viewGeolocation(View view) {
        // Do something in response to button
        Intent intent = new Intent(CareProviderViewListOfRecordsActivity.this, GeolocationActivity.class);
        startActivity(intent);

    }
}
