package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruok.R;

/**
 * SearchActivity
 * Usage: search function.
 * Note: still working
 *
 * @version 1.1
 */

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_request);
    }
    //todo 会到privider还是patient需要设置
    public void search(View view){
        Intent intent = new Intent(this, CareProviderActivity.class);
        startActivity(intent);
    }
}
