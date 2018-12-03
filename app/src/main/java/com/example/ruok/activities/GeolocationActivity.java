package com.example.ruok.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import com.example.ruok.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import classes.Problem;
import classes.Record;

/**
 * GeolocationActivity
 * Usage: Startup page for google map
 *
 * @version 1.1
 */
public class GeolocationActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Problem problem = (Problem) getIntent().getSerializableExtra("problem");
        if (problem != null) {
            ArrayList<Record> records = problem.getRecords();
            if (records != null) {
                for (int i = 0; i < records.size(); i++) {
                    Double latitude = records.get(i).getLatitude();
                    Double longitude = records.get(i).getLongitude();
                    // Add a marker in Sydney and move the camera
                    LatLng sydney = new LatLng(latitude, longitude);
                    mMap.addMarker(new MarkerOptions().position(sydney).title(records.get(i).getRecordTitle()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                }
            }
        }


    }
}
