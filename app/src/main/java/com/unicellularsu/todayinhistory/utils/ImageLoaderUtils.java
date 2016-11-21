package com.unicellularsu.todayinhistory.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by szc on 2016/11/14.
 *
 */

public class ImageLoaderUtils {
    public static void display(Context context, ImageView imageView,String url){
        if(imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).crossFade().into(imageView);
    }
}
