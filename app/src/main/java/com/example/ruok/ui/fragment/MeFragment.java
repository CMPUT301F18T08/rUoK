package com.example.ruok.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruok.R;
import com.example.ruok.activities.MainActivity;
import com.example.ruok.activities.PatientProfileActivity;
import com.example.ruok.activities.ResetPasswordActivity;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;
import com.makeramen.roundedimageview.RoundedImageView;

public class MeFragment extends Fragment implements View.OnClickListener {


    private RoundedImageView riv_head;
    private TextView tv_nick;
    private TextView tv_introduction;
    private LinearLayout ll_my_info;
    private LinearLayout ll_reset_password;
    private LinearLayout ll_logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        JsonUser jsonUser = SpUtil.getCurrentUser();
        String username = "";
        if (jsonUser.getUserType().equals("patient")) {
            username += "Patient: ";
        } else {
            username += "Care provider: ";
        }
        username += jsonUser.getUserName();
        tv_nick.setText(username);
        String desc = "Phone Number: " + jsonUser.getPhoneNumber();
        tv_introduction.setText(desc);
    }

    private void initView(View view) {
        riv_head = (RoundedImageView) view.findViewById(R.id.riv_head);
        tv_nick = (TextView) view.findViewById(R.id.tv_nick);
        tv_introduction = (TextView) view.findViewById(R.id.tv_introduction);
        ll_my_info = (LinearLayout) view.findViewById(R.id.ll_my_info);
        ll_reset_password = (LinearLayout) view.findViewById(R.id.ll_reset_password);
        ll_logout = (LinearLayout) view.findViewById(R.id.ll_logout);

        tv_introduction.setOnClickListener(this);
        ll_reset_password.setOnClickListener(this);
        ll_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_introduction:
                startActivity(new Intent(getContext(), PatientProfileActivity.class));
                break;
            case R.id.ll_reset_password:
                startActivity(new Intent(getContext(), ResetPasswordActivity.class));
                break;
            case R.id.ll_logout:
                SpUtil.logout();
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
                break;
        }
    }
}