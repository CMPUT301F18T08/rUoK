package com.example.ruok.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.Response;
import com.example.ruok.controller.SaveOrUpdateUserTask;
import com.example.ruok.controller.SearchPatientsTask;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2018-12-01.
 */
public class SearchAddPatientActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView addPatientText;
    private AutoCompleteTextView doctorAddPatientName;
    private Button addPatientBack;
    private List<JsonUser> list = new ArrayList<>();
    private int selectIndex = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_add_patient);
        initView();
        getData();
    }

    private void getData() {
        SearchPatientsTask task = new SearchPatientsTask();
        task.execute();
        task.setResponse(new Response<List<JsonUser>>() {
            @Override
            public void onSuccess(List<JsonUser> result) {
                if (result != null) {
                    list.clear();
                    list.addAll(result);
                    String[] names = new String[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        names[i] = list.get(i).getUserName();
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchAddPatientActivity.this, android.R.layout.simple_list_item_1, names);
                    doctorAddPatientName.setAdapter(adapter);

                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    private void initView() {
        addPatientText = (TextView) findViewById(R.id.addPatientText);
        doctorAddPatientName = (AutoCompleteTextView) findViewById(R.id.doctorAddPatientName);
        addPatientBack = (Button) findViewById(R.id.addPatientBack);

        addPatientBack.setOnClickListener(this);

        doctorAddPatientName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectIndex = i;
//                Toast.makeText(SearchAddPatientActivity.this, list.get(i).getUserName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addPatientBack:
                save();
                break;
        }
    }

    private void save() {
        if (selectIndex == -1) {
            Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
            return;
        }
        JsonUser currentUser = SpUtil.getCurrentUser();
        currentUser.getPatients().add(list.get(selectIndex));

        SaveOrUpdateUserTask task = new SaveOrUpdateUserTask();
        task.execute(currentUser);
        task.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(SearchAddPatientActivity.this, "success", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(SearchAddPatientActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
