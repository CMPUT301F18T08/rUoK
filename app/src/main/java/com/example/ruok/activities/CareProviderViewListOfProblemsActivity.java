package com.example.ruok.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ruok.R;
import com.example.ruok.adapter.NewProblemAdapter;
import com.example.ruok.utils.JsonUser;

import java.util.List;

import classes.Problem;

/**
 * CareProviderViewListOfProblemsActivity
 * Usage: Care provider viewing the list of problems for a patient selected.
 *
 * @version 1.1
 */

public class CareProviderViewListOfProblemsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView careProviderViewListOfRecordsPatient;
    private ListView listView;
    private List<Problem> list;
    private JsonUser jsonUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider_view_list_of_problems);
        initView();

        initData();


    }

    private void initData() {

        jsonUser = (JsonUser) getIntent().getSerializableExtra("patient");
        if (jsonUser != null) {
            //Patient UserName
            String userName = jsonUser.getUserName();
            careProviderViewListOfRecordsPatient.setText("Patient: " + userName);
            //problems
            list = jsonUser.getProblems();
            NewProblemAdapter adapter = new NewProblemAdapter(this, list);
            listView.setAdapter(adapter);
        }
    }

    private void initView() {
        careProviderViewListOfRecordsPatient = (TextView) findViewById(R.id.careProviderViewListOfRecordsPatient);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Problem problem = list.get(position);
        Intent intent = new Intent(this, CareProviderViewListOfRecordsActivity.class);
        intent.putExtra("jsonUser", jsonUser);
        intent.putExtra("problem", problem);
        intent.putExtra("problemIndex", position);
        startActivity(intent);

    }
}
