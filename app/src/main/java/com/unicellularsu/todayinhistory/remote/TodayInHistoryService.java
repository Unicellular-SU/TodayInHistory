package com.unicellularsu.todayinhistory.remote;

import com.unicellularsu.todayinhistory.beans.StoryInfo;
import com.unicellularsu.todayinhistory.beans.StoryList;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by szc on 2016/11/13.
 *
 */

public interface TodayInHistoryService {
    @GET("queryEvent.php")
    Observable<StoryList> getStoryList(@Query("key") String key, @Query("date")String date);

    @GET("queryDetail.php")
    Observable<StoryInfo> getStoryInfo(@Query("e_id")String eId,@Query("key") String key);
}
