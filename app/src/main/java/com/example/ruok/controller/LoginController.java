package com.example.ruok.controller;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;

import java.util.List;

import classes.CareProvider;
import classes.Patient;
import classes.User;
import io.searchbox.core.SearchResult;

/**
 * @Date 2018-11-26.
 */
public class LoginController extends AsyncTask<String, Void, SearchResult> {
    private Response<User> response;
    private String userName, password;

    public void setResponse(Response<User> response) {
        this.response = response;
    }

    @Override
    protected SearchResult doInBackground(String... strings) {
        userName = strings[0];
        password = strings[1];
        SearchResult result = null;
        String query = "{\"query\":{\"bool\":{\"must\":{\"term\":{\"userName\":\"" + userName + "\"}},\"filter\":{\"term\":{\"password\":\"" + password + "\"}}}}}";
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
        if (jestResult == null) {

            //read data from local
            List<User> list = FileUtils.getInstance(MyApplication.context).readUsersFromLocal();
            if (list == null || list.size() == 0) {
            } else {
                User isExistUser = null;
                for (User user : list) {
                    if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
                        isExistUser = user;
                        break;
                    }
                }
                if (isExistUser != null) {
                    response.onSuccess(isExistUser);
                } else {
                    response.onError("Wrong username or password!");
                }
            }
//            response.onError("Network is not available!");
        } else {
            if (jestResult.isSucceeded()) {
                User user = jestResult.getSourceAsObject(User.class);

                if (user != null) {
                    if (user.getUserType().equals("patient")) {
                        user = jestResult.getSourceAsObject(Patient.class);
                    } else {
                        user = jestResult.getSourceAsObject(CareProvider.class);
                    }
                    response.onSuccess(user);
                } else {
                    response.onError("Wrong username or password!");
                }
            } else {
                response.onError(jestResult.getErrorMessage());
            }
        }
    }
}
