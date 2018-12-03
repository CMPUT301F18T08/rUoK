package com.example.ruok.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.activities.AddRecordActivity;
import com.example.ruok.adapter.RecordAdapter;
import com.example.ruok.controller.GetUserInfoTask;
import com.example.ruok.controller.Response;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import java.util.ArrayList;
import java.util.List;

import classes.Problem;
import classes.Record;

public class RecordListActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv_record;
    private FloatingActionButton fab_record;
    private Problem problem;
    private int problemIndex;
    private RecordAdapter adapter;
    private List<Record> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {

        GetUserInfoTask task = new GetUserInfoTask(SpUtil.getCurrentUser().getId());
        task.execute();
        task.setResponse(new Response<JsonUser>() {
            @Override
            public void onSuccess(JsonUser result) {
                list.clear();
                list.addAll(result.getProblems().get(problemIndex).getRecords());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(RecordListActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        this.problem = (Problem) getIntent().getSerializableExtra("problem");
        problemIndex = getIntent().getIntExtra("problemIndex", -1);

        list.addAll(problem.getRecords());
        adapter = new RecordAdapter(this, list);
        lv_record.setAdapter(adapter);
    }

    private void initView() {
        lv_record = (ListView) findViewById(R.id.lv_record);
        fab_record = (FloatingActionButton) findViewById(R.id.fab_record);

        fab_record.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_record:
                Intent intent = new Intent(RecordListActivity.this, AddRecordActivity.class);
                intent.putExtra("problem", problem);
                intent.putExtra("problemIndex", problemIndex);
                startActivity(intent);
                finish();
                break;
        }
    }
}
