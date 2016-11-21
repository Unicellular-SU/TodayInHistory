package com.unicellularsu.todayinhistory.today.view;

import com.unicellularsu.todayinhistory.beans.StoryList;


/**
 * Created by szc on 2016/11/14.
 *
 */

public interface TodayStoryView {
    void addStory(StoryList storyList);
    void showProgress();
    void hideProgress();
    void showMessage(String msg);
}
