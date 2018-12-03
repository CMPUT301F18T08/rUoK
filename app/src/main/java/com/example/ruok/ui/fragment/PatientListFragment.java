package com.example.ruok.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.adapter.PatientAdapter;
import com.example.ruok.controller.GetUserInfoTask;
import com.example.ruok.controller.Response;
import com.example.ruok.ui.SearchAddPatientActivity;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientListFragment extends Fragment implements View.OnClickListener {


    private ListView patient_list;
    private FloatingActionButton fab_add;
    private PatientAdapter adapter;
    private List<JsonUser> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_patient_list, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        patient_list = (ListView) view.findViewById(R.id.patient_list);
        fab_add = (FloatingActionButton) view.findViewById(R.id.fab_add);

        fab_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add:
                // startActivity(new Intent(getContext(), AddPatientActivity.class));
                startActivity(new Intent(getContext(), SearchAddPatientActivity.class));

                break;
        }
    }

    private void initData() {
        JsonUser user = SpUtil.getCurrentUser();
        GetUserInfoTask task = new GetUserInfoTask(user.getId());
        task.execute();
        task.setResponse(new Response<JsonUser>() {
            @Override
            public void onSuccess(JsonUser user) {
                list = user.getPatients();
                adapter = new PatientAdapter(getContext(), list);
                patient_list.setAdapter(adapter);
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }
}
