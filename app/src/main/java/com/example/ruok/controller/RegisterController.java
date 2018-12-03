package com.example.ruok.controller;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;
import com.example.ruok.utils.JsonUser;

import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;

/**
 * @Date 2018-11-26.
 */
public class RegisterController extends AsyncTask<JsonUser, Void, JestResult> {
    private Response<String> response;
    private JsonUser user;

    public void setResponse(Response<String> response) {
        this.response = response;
    }

    @Override
    protected JestResult doInBackground(JsonUser... users) {
        user = users[0];
        //设置 id
        if (TextUtils.isEmpty(user.getId())) {
            user.setId(System.currentTimeMillis() + "");
        }
        //1. save user to local file
        FileUtils.getInstance(MyApplication.context).saveUser(user);
        //2. submit user to es
        DocumentResult result = null;
        try {
            JestService service = JestService.getInstance();
            result = service.createIndex(Constants.INDEX_USER, Constants.TYPE_NAME, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(JestResult jestResult) {
        super.onPostExecute(jestResult);

        if (jestResult == null) {
            response.onSuccess("local register successfully");
        } else {
            if (jestResult.isSucceeded()) {
                response.onSuccess("Sign up successfully");
            } else {
                response.onSuccess("local register successfully");
            }
        }
    }
}
