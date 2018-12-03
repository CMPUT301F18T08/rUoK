package com.example.ruok.controller;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ruok.MyApplication;
import com.example.ruok.constant.Constants;
import com.example.ruok.service.JestService;
import com.example.ruok.utils.FileUtils;
import com.example.ruok.utils.JsonUser;

import java.util.List;

import io.searchbox.core.SearchResult;

/**
 * Search Patients from es
 *
 * @Date 2018-12-01.
 */
public class SearchPatientsTask extends AsyncTask<Void, Void, SearchResult> {
    private Response<List<JsonUser>> response;

    public void setResponse(Response<List<JsonUser>> response) {
        this.response = response;
    }

    public SearchPatientsTask() {
        Log.d("SearchPatientsTask", "gouzoa");
    }

    @Override
    protected SearchResult doInBackground(Void... voids) {
        String query = "{\n" +
                "   \"query\": {\n" +
                "      \"multi_match\" : {\n" +
                "            \"query\" : \"patient\",\n" +
                "            \"fields\" : [\"userType\"]\n" +
                "        }\n" +
                "   }\n" +
                "}";
        SearchResult result = null;
        try {
            JestService service = JestService.getInstance();
            result = service.search(Constants.INDEX_USER, Constants.TYPE_NAME, query);
            Log.d("SearchPatientsTask", "result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(SearchResult searchResult) {
        super.onPostExecute(searchResult);
        Log.d("SearchPatientsTask", "searchResult:" + searchResult);

        if (searchResult == null || !searchResult.isSucceeded()) {//search failed, load patient from local
            List<JsonUser> localPatients = FileUtils.getInstance(MyApplication.context).readPatientsFromLocal();
            response.onSuccess(localPatients);
        } else {//search success, return Patient
            List<JsonUser> users = searchResult.getSourceAsObjectList(JsonUser.class);
            response.onSuccess(users);
        }

    }
}
