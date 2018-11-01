package com.example.ruok.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ruok.R;

public class RecordDetailActicity extends AppCompatActivity {
    private Button edit_button;
    private Button delete_button;
    private ImageView body_location_picture;
    private EditText doctor;
    private EditText date;
    private EditText more_detail;
    private Button back;
    private EditText body_location;
    private EditText location;
    private EditText Comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_detail_acticity);
    }
}
