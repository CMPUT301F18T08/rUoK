package com.example.ruok.ui.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.activities.AddProblemActivity;
import com.example.ruok.adapter.NewProblemAdapter;
import com.example.ruok.controller.GetUserInfoTask;
import com.example.ruok.controller.Response;
import com.example.ruok.controller.SaveOrUpdateUserTask;
import com.example.ruok.ui.RecordListActivity;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import java.util.List;

import classes.Problem;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProblemFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView problem_list;
    private FloatingActionButton fab_add;
    private NewProblemAdapter adapter;
    private List<Problem> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_problem, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        problem_list = (ListView) view.findViewById(R.id.problem_list);
        fab_add = (FloatingActionButton) view.findViewById(R.id.fab_add);

        fab_add.setOnClickListener(this);

        problem_list.setOnItemClickListener(this);
    }

    private void initData() {
        JsonUser user = SpUtil.getCurrentUser();
        GetUserInfoTask task = new GetUserInfoTask(user.getId());
        task.execute();
        task.setResponse(new Response<JsonUser>() {
            @Override
            public void onSuccess(JsonUser user) {
                list = user.getProblems();
                adapter = new NewProblemAdapter(getContext(), list);
                problem_list.setAdapter(adapter);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add:
                startActivity(new Intent(getContext(), AddProblemActivity.class));
                break;
        }
    }

    /**
     * 列表点击
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
        String[] items = {"View", "Edit", "Delete"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Operation")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        switch (i) {
                            case 0://View
                                Problem problem = list.get(position);
                                Intent intent = new Intent(getContext(), RecordListActivity.class);
                                intent.putExtra("problem", problem);
                                intent.putExtra("problemIndex", position);
                                startActivity(intent);
                                break;
                            case 1://Edit
                                Intent editIntent = new Intent(getContext(), AddProblemActivity.class);
                                editIntent.putExtra("problem", list.get(position));
                                editIntent.putExtra("index", position);
                                startActivity(editIntent);
                                break;
                            case 2://Delete
                                JsonUser currentUser = SpUtil.getCurrentUser();
                                currentUser.getProblems().remove(position);
                                SaveOrUpdateUserTask task = new SaveOrUpdateUserTask();
                                task.execute(currentUser);
                                task.setResponse(new Response<String>() {
                                    @Override
                                    public void onSuccess(String result) {
                                        Toast.makeText(getContext(), "delete success", Toast.LENGTH_SHORT).show();
                                        initData();
                                    }

                                    @Override
                                    public void onError(String errorMsg) {
                                        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;
                        }
                    }
                })
                .create().show();
    }
}
