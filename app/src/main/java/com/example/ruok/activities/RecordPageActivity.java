package com.example.ruok.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ruok.R;

import org.w3c.dom.Text;

public class RecordPageActivity extends AppCompatActivity {
    private Button animate;
    private Button my_profile;
    private TextView list_Record;
    private ListView listview_record;
    private Button add_record;
    private Button body_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_page);
    }
    public void addRecord(View view) {
        // Do something in response to button
        Intent intent_addRecord = new Intent(this, AddRecordActivity.class);
        startActivity(intent_addRecord);
    }

    public void myProfile(View view){
        Intent intent_myProfile = new Intent(this, AddRecordActivity.class);
        startActivity(intent_myProfile);
    }
}
