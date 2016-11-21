package com.unicellularsu.todayinhistory.storyinfo.model;

/**
 * Created by szc on 2016/11/14.
 */

public interface StoryInfoModel {
    void getStoryInfo(String eId,StoryInfoModelImpl.OnLoadStoryInfoListener listener);
}
