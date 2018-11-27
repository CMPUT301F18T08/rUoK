package com.example.ruok.controller;

import android.os.AsyncTask;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;
import com.example.ruok.utils.SpUtil;

import classes.User;
import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;

/**
 * @Date 2018-11-26.
 */
public class AddProblemController extends AsyncTask<User, Void, JestResult> {
    private User user;

    private Response<String> response;

    public void setResponse(Response<String> response) {
        this.response = response;
    }

    @Override
    protected JestResult doInBackground(User... users) {
        this.user = users[0];
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
        //update local
        FileUtils.getInstance(MyApplication.context).updateUser(user);
        SpUtil.saveCurrentUser(user);

        if (jestResult == null) {
            response.onError("Network is not available! add to local successful");
        } else {
            if (jestResult.isSucceeded()) {
                response.onSuccess("Add successful");
            } else {
                response.onError(jestResult.getErrorMessage());
            }
        }
    }
}
