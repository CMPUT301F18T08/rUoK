package com.example.ruok;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;

import com.example.ruok.utils.GlideImageLoader;
import com.example.ruok.utils.SpUtil;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.PauseOnScrollListener;
import cn.finalteam.galleryfinal.ThemeConfig;

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


        initGalleryFinal();
    }

    private void initGalleryFinal() {
       //set theme
        ThemeConfig theme = new ThemeConfig.Builder()
                .setTitleBarBgColor(getResources().getColor(R.color.colorPrimary))
                .setTitleBarTextColor(Color.WHITE)
                .setTitleBarIconColor(Color.WHITE)
                .setFabNornalColor(getResources().getColor(R.color.colorPrimary))
                .setFabPressedColor(Color.BLUE)
                .setCheckNornalColor(Color.WHITE)
                .setCheckSelectedColor(getResources().getColor(R.color.colorPrimary))
                .build();
        //set function
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .build();
        CoreConfig coreConfig = new CoreConfig.Builder(this, new GlideImageLoader(), theme)
                .setFunctionConfig(functionConfig)
                .setPauseOnScrollListener(new PauseOnScrollListener(false, true) {
                    @Override
                    public void resume() {

                    }

                    @Override
                    public void pause() {

                    }
                })
                .build();
        GalleryFinal.init(coreConfig);
    }
}
