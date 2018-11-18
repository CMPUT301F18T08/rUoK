package com.example.ruok.activities;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruok.R;

import java.util.ArrayList;
import java.util.List;

import classes.Problem;


public class ProblemListAdapter extends RecyclerView.Adapter<Adapter.item_holder> {


    private List<Problem> LIST = new ArrayList<>();
    private Listener listener;


    public void setData(List<Emotion> list) {
        this.LIST = list;
        notifyDataSetChanged();
    }

    public List<Emotion> getData() {
        return LIST;
    }


    @Override
    public int getItemCount() {
        return LIST.size();
    }


    /**
     * List item view_holder
     * https://developer.android.com/guide/topics/ui/layout/recyclerview#java
     */
    public static class item_holder extends RecyclerView.ViewHolder {

        TextView problemTitle;
        TextView problemDate;
        TextView recordNumber;
        Button editButton, deleteButton;


        public item_holder(View itemView) {
            super(itemView);
            problemTitle = itemView.findViewById(R.id.recordTitle);
            problemDate = itemView.findViewById(R.id.problemDate);
            recordNumber = itemView.findViewById(R.id.recordNumber);
            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }

    /**
     * interface delete button and edit button
     * https://stackoverflow.com/questions/37096547/how-to-get-data-from-edit-text-in-a-recyclerview/37096844#37096844
     */
    public interface Listener {

        void Delete(String time, int i);

        void Edit(String time, int i);
    }

    public void setListener(Listener Listener) {
        this.listener = Listener;
    }

    @Override
    public item_holder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.list_problem, viewgroup, false);
        item_holder vh = new item_holder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(item_holder VH, final int i) {
        final Problem problem = LIST.get(i);
        VH.problemTitle.setText(problem.getTitle());
        VH.problemDate.setText(problem.DateToString());

        VH.recordNumber.setText();

        VH.recordNumber.setText(problem.get_text());
        VH.recordNumber.setVisibility(TextUtils.isEmpty(problem.get_text()) ? View.GONE : View.VISIBLE);

        //https://stackoverflow.com/questions/10903754/input-text-dialog-android
        VH.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.Edit(problem.DateToString(), i);
            }
        });


        VH.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.Edit(problem.DateToString(), i);
            }
        });
    }
}