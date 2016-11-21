package com.unicellularsu.todayinhistory;

import android.app.Application;
import android.content.Context;

/**
 * Created by szc on 2016/11/13.
 */

public class MyApplication extends Application {
    public static String TODAY_IN_HISTORY_KEY ="024d8b417bff5df0fa37bf7811823816";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();

    }

    public static Context getContentObj(){
        return context;
    }
}
