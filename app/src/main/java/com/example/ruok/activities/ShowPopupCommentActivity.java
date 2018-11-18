package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;
public class ShowPopupCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_add_comment2);
    }

    public void back(View view) {
        Intent intent = new Intent(ShowPopupCommentActivity.this, CareProviderViewListOfProblemsActivity.class);
        startActivity(intent);
    }
}
