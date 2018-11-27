package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruok.R;

/**
 * GeolocationActivity
 * Usage: Startup page for google map
 *
 * @version 1.1
 */
public class GeolocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geolocation);
    }
}
