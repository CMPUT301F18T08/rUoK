package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ruok.R;
import com.example.ruok.adapter.RecordAdapter;
import com.example.ruok.utils.JsonUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Problem;
import classes.Record;

/**
 * CareProviderViewListOfRecordsActivity
 * Usage: Care provider viewing the records list for a problem. Care provider can add a comment to this problem.
 *
 * @version 1.1
 */
public class CareProviderViewListOfRecordsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private EditText careProviderViewListOfRecordsTextView, careProviderViewListOfRecordsPatient;
    private ListView careProviderViewListOfRecordsListView, list_comments;
    private RecordAdapter adapter;
    private JsonUser patient;
    private Problem problem;
    private int problemIndex;
    private List<Record> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider_view_list_of_records);
        initView();
        initData();
    }

    private void initData() {
        patient = (JsonUser) getIntent().getSerializableExtra("jsonUser");
        problem = (Problem) getIntent().getSerializableExtra("problem");
        problemIndex = getIntent().getIntExtra("problemIndex", -1);

        careProviderViewListOfRecordsPatient.setText("Patient:" + patient.getUserName());
        careProviderViewListOfRecordsTextView.setText("Viewing records for " + problem.getTitle());


        list = problem.getRecords();
        adapter = new RecordAdapter(this, list);
        careProviderViewListOfRecordsListView.setAdapter(adapter);

        List<String> comments = problem.getComments();
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.activity_list_item, comments);

        list_comments.setAdapter(aa);

    }

    private void initView() {
        careProviderViewListOfRecordsPatient = findViewById(R.id.careProviderViewListOfRecordsPatient);
        careProviderViewListOfRecordsTextView = findViewById(R.id.careProviderViewListOfRecordsTextView);
        careProviderViewListOfRecordsListView = findViewById(R.id.careProviderViewListOfRecordsListView);
        list_comments = findViewById(R.id.list_comments);

        careProviderViewListOfRecordsListView.setOnItemClickListener(this);
    }

    public void viewGeolocation(View view) {
        // Do something in response to button
        Intent intent = new Intent(CareProviderViewListOfRecordsActivity.this, GeolocationActivity.class);
        intent.putExtra("Problem",problem);
        startActivity(intent);

    }

    public void popupComment(View view) {

        Intent intent = new Intent(this, ShowPopupCommentActivity.class);
        intent.putExtra("patient",patient);
        intent.putExtra("problemIndex",problemIndex);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this, RecordDetailActivity.class);
        intent.putExtra("record", list.get(position));
        intent.putExtra("patient", patient);
        intent.putExtra("recordIndex", position);
        startActivity(intent);
    }
}
