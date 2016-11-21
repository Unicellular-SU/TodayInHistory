package com.unicellularsu.todayinhistory.storyinfo.present;

import com.unicellularsu.todayinhistory.beans.StoryInfo;
import com.unicellularsu.todayinhistory.storyinfo.model.StoryInfoModel;
import com.unicellularsu.todayinhistory.storyinfo.model.StoryInfoModelImpl;
import com.unicellularsu.todayinhistory.storyinfo.view.StoryInfoView;

/**
 * Created by szc on 2016/11/15.
 */

public class StoryInfoPresentImpl implements StoryInfoPresent,StoryInfoModelImpl.OnLoadStoryInfoListener{

    StoryInfoView storyInfoView;
    StoryInfoModel storyInfoModel;

    public StoryInfoPresentImpl(StoryInfoView storyInfoView){
        this.storyInfoView = storyInfoView;
        storyInfoModel=new StoryInfoModelImpl();
    }

    @Override
    public void loadStoryInfo(String eId) {
        storyInfoView.showProgress();
        System.out.println("到Present-loadStoryInfo这里了");
        storyInfoModel.getStoryInfo(eId,this);
        System.out.println("Present-loadStoryInfo结束了");
    }

    @Override
    public void onSuccess(StoryInfo storyInfo) {
        storyInfoView.showStoryInfo(storyInfo);
        System.out.println("到Present-onSuccess这里了");
        storyInfoView.hideProgress();
    }

    @Override
    public void onFailure(String msg) {
        storyInfoView.showMessage(msg);
        storyInfoView.hideProgress();
    }
}
