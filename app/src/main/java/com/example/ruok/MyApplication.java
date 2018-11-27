package com.example.ruok;

import android.app.Application;
import android.content.Context;

import com.example.ruok.utils.SpUtil;

/**
 * @Date 2018-11-26.
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        SpUtil.init(this);

    }
}
