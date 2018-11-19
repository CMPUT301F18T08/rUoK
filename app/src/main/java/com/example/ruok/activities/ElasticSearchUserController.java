package com.example.ruok.activities;


import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;


import org.apache.http.client.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

import classes.User;

//https://github.com/alisajedi/lonelyTwitter/blob/ali/app/src/main/java/ca/ualberta/cs/lonelytwitter/ElasticsearchTweetController.java
public class ElasticSearchUserController {
    private static JestDroidClient client;
    private static Gson gson;
    private static HttpClient http;

    public static class GetUsersTask extends AsyncTask<String,Void,ArrayList<User>>{

        @Override
        protected ArrayList<User> doInBackground(String... params) {
            verifyConfig();
            ArrayList<User> users = new ArrayList<User>();
            String search_string;
            search_string = String.format("{\n" +
                    "    \"query\" : {\n" +
                    "        \"match\" : " +
                    "               { \"username\" : \"" + "%s" + "\" }\n" +
                    "    }\n" +
                    "}", params[0].trim());
            Search search = new Search.Builder(search_string).addIndex("cmput301f18t08").addType("user").build();
            try{
                SearchResult execute = client.execute(search);
                if(execute.isSucceeded()){
                    List<User> foundUsers = execute.getSourceAsObjectList(User.class);
                    users.addAll(foundUsers);
                }else{
                    Log.i("TODO", "Search was unsuccessful, do something!");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return users;
        }

    }


    public static class AddUserTask extends AsyncTask<User,Void,Void>{

        @Override
        protected Void doInBackground(User... users) {
            verifyConfig();
            for(User user:users){
                Index index = new Index.Builder(user).index("cmput301f18t08").type("user").build();
                try {
                    DocumentResult execute = client.execute(index);
                    if(execute.isSucceeded()) {
                        user.setId(execute.getId());
                    } else {
                        Log.e("TODO", "Our insert of user failed, oh no!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }
    public static void verifyConfig(){
        if(client == null){
            // TODO: Consider moving this URL in to some config class
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080/cmput301f18t08test");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();

            gson = new Gson();
            client.setGson(gson);
        }
    }

}
