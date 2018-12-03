package com.example.ruok.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Date 2018-11-26.
 */
public class FileUtils {
    private static final String FILENAME = "user.json";
    private Context mContext;

    @SuppressLint("StaticFieldLeak")
    private static FileUtils instance = null;

    public static synchronized FileUtils getInstance(Context context) {
        if (instance == null)
            instance = new FileUtils(context);
        return instance;
    }

    private FileUtils(Context context) {
        this.mContext = context;
    }


    /**
     * save local data
     *
     * @param user
     */
    public void saveUser(JsonUser user) {
        try {
            //1.first read the user data from local file
            HashMap<String, Object> map = new HashMap<>();
            List<JsonUser> list = readUsersFromLocal();

            //查询是否已经存在，如果存在，移除user并保存，然后添加保存
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                JsonUser temp = list.get(i);
                if (temp.getId().equals(user.getId())) {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                list.remove(index);
            }

            list.add(user);

            map.put("users", list);
            String json = new Gson().toJson(map);

            //2. write new data to local file
            FileOutputStream fos = mContext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            out.write(json);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<JsonUser> readUsersFromLocal() {
        List<JsonUser> list = new ArrayList<>();
        try {
            StringBuilder result = new StringBuilder();
            FileInputStream fis = mContext.openFileInput(FILENAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
            UserData userData = new Gson().fromJson(result.toString(), UserData.class);
            list = userData.users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据id 读取本地用户信息
     *
     * @param id
     * @return
     */
    public JsonUser getUserById(String id) {
        JsonUser jsonUser = null;
        try {
            StringBuilder result = new StringBuilder();
            FileInputStream fis = mContext.openFileInput(FILENAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
            UserData userData = new Gson().fromJson(result.toString(), UserData.class);
            List<JsonUser> users = userData.users;
            for (JsonUser user : users) {
                if (user.getId().equals(id)) {
                    jsonUser = user;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonUser;
    }


    /**
     * 读取本地的Patient
     *
     * @return
     */
    public List<JsonUser> readPatientsFromLocal() {
        List<JsonUser> list = new ArrayList<>();
        try {
            StringBuilder result = new StringBuilder();
            FileInputStream fis = mContext.openFileInput(FILENAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
            UserData userData = new Gson().fromJson(result.toString(), UserData.class);
            List<JsonUser> temp = userData.users;
            if (temp != null) {
                for (JsonUser user : temp) {
                    if (user.getUserType().equals("patient")) {
                        list.add(user);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}

