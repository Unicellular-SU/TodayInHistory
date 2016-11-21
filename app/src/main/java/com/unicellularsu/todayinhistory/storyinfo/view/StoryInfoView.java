package com.unicellularsu.todayinhistory.storyinfo.view;

import com.unicellularsu.todayinhistory.beans.StoryInfo;

/**
 * Created by szc on 2016/11/15.
 *
 */

public interface StoryInfoView {
    void showStoryInfo(StoryInfo storyInfo);
    void showProgress();
    void hideProgress();
    void showMessage(String msg);
}
