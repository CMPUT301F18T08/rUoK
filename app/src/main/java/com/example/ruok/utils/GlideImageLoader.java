package com.example.ruok.utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import cn.finalteam.galleryfinal.widget.GFImageView;

/**
 * Desction:
 * Author:pengjianbo
 */
public class GlideImageLoader implements cn.finalteam.galleryfinal.ImageLoader {

    @Override
    public void displayImage(Activity activity, String path, final GFImageView imageView, Drawable defaultDrawable, int width, int height) {
        Glide.with(activity)
                .load("file://" + path)
                .apply(RequestOptions.placeholderOf(defaultDrawable))
                .apply(RequestOptions.errorOf(defaultDrawable))
                .apply(RequestOptions.overrideOf(width, height))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))//不缓存到SD卡
                .apply(RequestOptions.skipMemoryCacheOf(true))
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }
}