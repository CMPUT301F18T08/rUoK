package com.example.ruok.controller;

import android.os.AsyncTask;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import io.searchbox.client.JestResult;

/**
 * @Date 2018-11-30.
 */
public class GetUserInfoTask extends AsyncTask<Void, Void, JestResult> {
    private Response<JsonUser> response;
    private String id;

    public GetUserInfoTask(String id) {
        this.response = response;
        this.id = id;
    }

    public void setResponse(Response<JsonUser> response) {
        this.response = response;
    }

    @Override
    protected JestResult doInBackground(Void... voids) {
        JestResult result = null;
        try {
            JestService service = JestService.getInstance();
            result = service.get(Constants.INDEX_USER, Constants.TYPE_NAME, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    protected void onPostExecute(JestResult jestResult) {
        super.onPostExecute(jestResult);
        if (jestResult != null && jestResult.isSucceeded()) {
            JsonUser user = jestResult.getSourceAsObject(JsonUser.class);
            if (user != null) {
                response.onSuccess(user);
                SpUtil.saveCurrentUser(user);
                FileUtils.getInstance(MyApplication.context).saveUser(user);
            } else {
                readLocal();
            }
        } else {
            readLocal();
        }
    }

    private void readLocal() {
        JsonUser user = FileUtils.getInstance(MyApplication.context).getUserById(id);
        if (user == null) {
            response.onError("Get data failed!");
        } else {
            response.onSuccess(user);
        }

    }
}
