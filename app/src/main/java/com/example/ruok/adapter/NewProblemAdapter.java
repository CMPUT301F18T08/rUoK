package com.example.ruok.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ruok.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import classes.Problem;
import classes.Record;

/**
 * @Date 2018-11-26.
 */
public class NewProblemAdapter extends BaseAdapter {
    private Context mContext;
    private List<Problem> list;


    public NewProblemAdapter(Context mContext, List<Problem> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.list_problem_new, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Problem problem = list.get(i);
        //Title
        holder.tv_problem_title.setText(problem.getTitle());
        //Problem description
        holder.tv_problem_desc.setText(problem.getDescription());
        //date
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        String format = sdf.format(problem.getDate());
        holder.tv_problem_date.setText(format);
        // Records Num
        ArrayList<Record> records = problem.getRecords();
        int num = (records == null ? 0 : records.size());
        holder.tv_problem_records_num.setText("Records Num: " + num);

        return view;
    }

    private class ViewHolder {
        public TextView tv_problem_title, tv_problem_desc, tv_problem_records_num, tv_problem_date;

        public ViewHolder(View view) {
            this.tv_problem_title = view.findViewById(R.id.tv_problem_title);
            this.tv_problem_desc = view.findViewById(R.id.tv_problem_desc);
            this.tv_problem_records_num = view.findViewById(R.id.tv_problem_records_num);
            this.tv_problem_date = view.findViewById(R.id.tv_problem_date);
        }


    }
}
