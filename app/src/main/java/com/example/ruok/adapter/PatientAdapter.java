package com.example.ruok.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruok.R;
import com.example.ruok.activities.CareProviderViewListOfProblemsActivity;
import com.example.ruok.ui.DoctorViewPatientDetailActivity;
import com.example.ruok.utils.JsonUser;

import java.util.List;

/**
 * 
 * @Date 2018-12-01.
 */
public class PatientAdapter extends BaseAdapter {
    private Context mContext;
    private List<JsonUser> list;


    public PatientAdapter(Context mContext, List<JsonUser> list) {
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
            view = View.inflate(mContext, R.layout.list_patient, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        JsonUser patient = list.get(i);
        //Title
        holder.tv_patient_name.setText(patient.getUserName());
        holder.btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CareProviderViewListOfProblemsActivity.class);
                intent.putExtra("patient", list.get(i));
                mContext.startActivity(intent);
            }
        });
        holder.tv_patient_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DoctorViewPatientDetailActivity.class);
                intent.putExtra("patient", list.get(i));
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    private class ViewHolder {
        public TextView tv_patient_name;
        public Button btn_view;


        public ViewHolder(View view) {
            this.tv_patient_name = view.findViewById(R.id.tv_patient_name);
            this.btn_view = view.findViewById(R.id.btn_view);
        }


    }
}