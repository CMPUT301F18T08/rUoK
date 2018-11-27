package com.example.ruok.controller;

import android.os.AsyncTask;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;

import classes.User;
import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;

/**
 * @Date 2018-11-26.
 */
public class RegisterController extends AsyncTask<User, Void, JestResult> {
    private Response<String> response;

    public void setResponse(Response<String> response) {
        this.response = response;
    }

    @Override
    protected JestResult doInBackground(User... users) {
        //1. save user to local file
        if (users[0].getId() == null) {
            users[0].setId(System.currentTimeMillis() + "");
        }
        FileUtils.getInstance(MyApplication.context).saveUser(users[0]);
        //2. submit user to es
        DocumentResult result = null;
        try {
            JestService service = JestService.getInstance();
            result = service.createIndex(Constants.INDEX_USER, Constants.TYPE_NAME, users[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(JestResult jestResult) {
        super.onPostExecute(jestResult);
        if (jestResult == null) {
            response.onError("Network is not available! saved to local");
        } else {
            if (jestResult.isSucceeded()) {
                response.onSuccess("Sign up successfully");
            } else {
                response.onError(jestResult.getErrorMessage());
            }
        }
    }
}
