package com.unicellularsu.todayinhistory.utils;

import java.util.Calendar;

/**
 * Created by szc on 2016/11/14.
 *
 */

public class DateUtils {
    public static String getNowDay(){
        String result="";
        Calendar now = Calendar.getInstance();
        int month = now.get(Calendar.MONTH)+1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        result=String.format("%d/%d",month,day);
        return result;
    }
}
