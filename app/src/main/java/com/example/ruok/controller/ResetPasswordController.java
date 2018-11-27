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
public class ResetPasswordController extends AsyncTask<User, Void, JestResult> {
    private Response<String> response;
    private User currentUser;

    public void setResponse(Response<String> response) {
        this.response = response;
    }


    @Override
    protected JestResult doInBackground(User... users) {
        currentUser = users[0];

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
        FileUtils.getInstance(MyApplication.context).updateUser(currentUser);

        if (jestResult == null) {
            response.onError("Network is not available! Update local successful");
        } else {
            if (jestResult.isSucceeded()) {
                response.onSuccess("reset password successful");
            } else {
                response.onError(jestResult.getErrorMessage() + "（But Update local successful)");
            }
        }
    }
}
