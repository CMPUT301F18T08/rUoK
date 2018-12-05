package com.example.ruok.controller;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;
import com.example.ruok.utils.JsonUser;
import com.example.ruok.utils.SpUtil;

import java.util.List;

import io.searchbox.core.SearchResult;

/**
 * @Date 2018-11-26.
 */
public class LoginController extends AsyncTask<String, Void, SearchResult> {
    private Response<JsonUser> response;
    private String userName, password;

    public void setResponse(Response<JsonUser> response) {
        this.response = response;
    }

    @Override
    protected SearchResult doInBackground(String... strings) {
        userName = strings[0];
        password = strings[1];
        SearchResult result = null;
        String query = "{\"query\":{\"bool\":{\"must\":{\"term\":{\"userName\":\"" + userName + "\"}}}}}";
//        String query = "{\"query\":{\"bool\":{\"must\":{\"term\":{\"userName\":\"" + userName + "\"}},\"filter\":{\"term\":{\"password\":\"" + password + "\"}}}}}";
        try {
            JestService service = JestService.getInstance();
            result = service.search(Constants.INDEX_USER, Constants.TYPE_NAME, query);
            Log.d("LoginTask", "result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(SearchResult jestResult) {
        super.onPostExecute(jestResult);
        if (jestResult == null || !jestResult.isSucceeded()) {

            //read data from local
            List<JsonUser> list = FileUtils.getInstance(MyApplication.context).readUsersFromLocal();
            if (list == null || list.size() == 0) {
                response.onError("Wrong username or password!");
            } else {
                JsonUser isExistUser = null;
                for (JsonUser user : list) {
                    if (userName.equals(user.getUserName())) {
                        isExistUser = user;
                        break;
                    }
                }
                if (isExistUser != null) {
                    SpUtil.saveCurrentUser(isExistUser);
                    response.onSuccess(isExistUser);
                } else {
                    response.onError("Wrong username or password!");
                }
            }
        } else {
            JsonUser user = jestResult.getSourceAsObject(JsonUser.class);

            if (user != null) {
                response.onSuccess(user);
                SpUtil.saveCurrentUser(user);
                FileUtils.getInstance(MyApplication.context).saveUser(user);
            } else {
                response.onError("Wrong username or password!");
            }
        }
    }
}
