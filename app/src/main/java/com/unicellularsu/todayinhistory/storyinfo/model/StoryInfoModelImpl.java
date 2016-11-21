package com.unicellularsu.todayinhistory.storyinfo.model;

import com.unicellularsu.todayinhistory.MyApplication;
import com.unicellularsu.todayinhistory.beans.StoryInfo;
import com.unicellularsu.todayinhistory.remote.ServiceGenerator;
import com.unicellularsu.todayinhistory.remote.TodayInHistoryService;
import com.unicellularsu.todayinhistory.utils.ToolsUtil;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by szc on 2016/11/14.
 *
 */

public class StoryInfoModelImpl implements StoryInfoModel{

    private Subscription subscription;

    @Override
    public void getStoryInfo(String eId, final OnLoadStoryInfoListener listener) {
        final TodayInHistoryService service = ServiceGenerator.createSerxice(TodayInHistoryService.class);
        System.out.println("Model中eId="+eId);
        if(ToolsUtil.isNetworkAvailable(MyApplication.getContentObj())){
            subscription = service.getStoryInfo(eId,MyApplication.TODAY_IN_HISTORY_KEY)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<StoryInfo>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(StoryInfo storyInfo) {
                            if (storyInfo.getReason().equals("success")) {
                                listener.onSuccess(storyInfo);
                                System.out.println("到Model这里了");
                            } else {
                                listener.onFailure(storyInfo.getReason());
                            }

                        }
                    });
        }else{
            listener.onFailure("没有网络呀");
        }

    }

    public interface OnLoadStoryInfoListener{
        void onSuccess(StoryInfo storyInfo);
        void onFailure(String msg);
    }
}
