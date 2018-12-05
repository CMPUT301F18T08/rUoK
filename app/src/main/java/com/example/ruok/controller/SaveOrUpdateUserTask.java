package com.example.ruok.controller;

import android.os.AsyncTask;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;

/**
 * 添加 或 修改用户信息
 *
 * @Date 2018-11-30.
 */
public class SaveOrUpdateUserTask extends AsyncTask<JsonUser, Void, JestResult> {
    private JsonUser user;
    private Response<String> response;

    public void setResponse(Response<String> response) {
        this.response = response;
    }

    @Override
    protected JestResult doInBackground(JsonUser... users) {
        user = users[0];
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
        //update local
        FileUtils.getInstance(MyApplication.context).saveUser(user);
        SpUtil.saveCurrentUser(user);

        if (jestResult == null) {
            response.onSuccess("save to local successful");
        } else {
            if (jestResult.isSucceeded()) {
                response.onSuccess("operate successful");
            } else {
                response.onSuccess("save to local successful");
            }
        }
    }
}
