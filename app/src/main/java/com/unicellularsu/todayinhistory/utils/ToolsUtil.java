package com.unicellularsu.todayinhistory.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by szc on 2016/11/20.
 *
 */

public class ToolsUtil {
    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if(cm!=null){
            NetworkInfo[] infos =cm.getAllNetworkInfo();
            if (infos!=null) {
                for (NetworkInfo info:infos
                     ) {
                    if (info.getState()== NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
