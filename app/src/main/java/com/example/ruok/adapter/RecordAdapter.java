package com.example.ruok.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ruok.R;

import java.text.SimpleDateFormat;
import java.util.List;

import classes.Record;

/**
 * @Date 2018-11-30.
 */
public class RecordAdapter extends BaseAdapter{

    private Context mContext;
    private List<Record> list;


    public RecordAdapter(Context mContext, List<Record> list) {
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
            view = View.inflate(mContext, R.layout.list_record_new, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Record record = list.get(i);
        //Title
        holder.tv_record_title.setText(record.getRecordTitle());
        //Problem description
        holder.tv_record_desc.setText(record.getDetail());
        //date
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        String format = sdf.format(record.getDate());
        holder.tv_record_date.setText(format);

        return view;
    }

    private class ViewHolder {
        public TextView tv_record_title, tv_record_desc, tv_record_date;

        public ViewHolder(View view) {
            this.tv_record_title = view.findViewById(R.id.tv_record_title);
            this.tv_record_desc = view.findViewById(R.id.tv_record_desc);
            this.tv_record_date = view.findViewById(R.id.tv_record_date);
        }


    }
}
