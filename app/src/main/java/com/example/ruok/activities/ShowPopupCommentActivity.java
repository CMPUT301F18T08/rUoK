package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * ShowPopupCommentActivity
 * Usage: this page is for care provider adding comment for the patient's problem
 * Note: still working
 * @see CareProviderViewListOfRecordsActivity
 * @version 1.1
 */
public class ShowPopupCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_add_comment2);
    }

    public void back(View view) {
        Intent intent = new Intent(ShowPopupCommentActivity.this, CareProviderViewListOfRecordsActivity.class);
        startActivity(intent);
    }
}
