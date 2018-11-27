package com.example.ruok.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * CareProviderViewListOfRecordsActivity
 * Usage: Care provider viewing the records list for a problem. Care provider can add a comment to this problem.
 *
 * @version 1.1
 */
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
    public void popupComment(View view) {
        Intent intent = new Intent(this, ShowPopupCommentActivity.class);
        startActivity(intent);
    }
}
