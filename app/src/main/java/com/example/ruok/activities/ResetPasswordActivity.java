package com.example.ruok.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ruok.R;
import com.example.ruok.controller.ResetPasswordController;
import com.example.ruok.controller.Response;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

/**
 * ResetPasswordActivity
 * Usage: reset password
 *
 * @version 1.1
 */

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ib_back;
    private TextInputEditText et_old_password;
    private TextInputEditText et_new_password;
    private TextInputEditText et_confirm_password;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initView();
    }

    private void initView() {
        ib_back = (ImageButton) findViewById(R.id.ib_back);
        et_old_password = (TextInputEditText) findViewById(R.id.et_old_password);
        et_new_password = (TextInputEditText) findViewById(R.id.et_new_password);
        et_confirm_password = (TextInputEditText) findViewById(R.id.et_confirm_password);
        btn_save = (Button) findViewById(R.id.btn_save);

        ib_back.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_back:
                finish();
                break;
            case R.id.btn_save:
                submit();
                break;
        }
    }

    private void submit() {
        String oldPassword = et_old_password.getText().toString().trim();
        if (TextUtils.isEmpty(oldPassword)) {
            Toast.makeText(this, "Old Password", Toast.LENGTH_SHORT).show();
            return;
        }

        String newPassword = et_new_password.getText().toString().trim();
        if (TextUtils.isEmpty(newPassword)) {
            Toast.makeText(this, "New Password", Toast.LENGTH_SHORT).show();
            return;
        }

        String confirmPassword = et_confirm_password.getText().toString().trim();
        if (TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(this, "Confirm Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(this, "The codes don't match twice", Toast.LENGTH_SHORT).show();
            return;
        }

        final JsonUser user = (JsonUser) SpUtil.getCurrentUser();
        user.setPassword(newPassword);
        ResetPasswordController rpc = new ResetPasswordController();
        rpc.execute(user);
        rpc.setResponse(new Response<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(ResetPasswordActivity.this, result, Toast.LENGTH_SHORT).show();
                SpUtil.saveCurrentUser(user);
                finish();
            }

            @Override
            public void onError(String errorMsg) {
                Toast.makeText(ResetPasswordActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                SpUtil.saveCurrentUser(user);
                finish();
            }
        });


    }
}
