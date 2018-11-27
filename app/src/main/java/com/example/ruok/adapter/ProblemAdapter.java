package com.example.ruok.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruok.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import classes.Patient;
import classes.Problem;
import classes.Record;

/**
 * @Date 2018-11-26.
 */

public class ProblemAdapter extends BaseAdapter {
    private Context mContext;
    private Patient patient;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onDelete(Patient patient);

        void onEdit(Patient patient, int position);
    }

    public ProblemAdapter(Context mContext, Patient patient) {
        this.mContext = mContext;
        this.patient = patient;
    }

    @Override
    public int getCount() {
        return patient.getProblems().size();
    }

    @Override
    public Object getItem(int i) {
        return patient.getProblems().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.list_problem, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Problem problem = patient.getProblems().get(i);
        holder.recordTitle.setText(problem.getTitle());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(problem.getDate());
        holder.problemDate.setText(format);
        ArrayList<Record> records = problem.getRecords();
        int num = (records == null ? 0 : records.size());
        holder.recordNumber.setText(num + "");

        holder.delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    ArrayList<Problem> problems = patient.getProblems();
                    problems.remove(i);
                    listener.onDelete(patient);
                }
            }
        });

        holder.edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onEdit(patient, i);
                }
            }
        });
        return view;
    }

    private class ViewHolder {
        public TextView recordTitle, problemDate, recordNumber;
        public Button delete_button, edit_button;

        public ViewHolder(View view) {
            this.recordTitle = view.findViewById(R.id.recordTitle);
            this.problemDate = view.findViewById(R.id.problemDate);
            this.recordNumber = view.findViewById(R.id.recordNumber);
            this.delete_button = view.findViewById(R.id.delete_button);
            this.edit_button = view.findViewById(R.id.edit_button);
        }


    }
}
