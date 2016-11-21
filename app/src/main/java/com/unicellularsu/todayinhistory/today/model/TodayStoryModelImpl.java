package com.unicellularsu.todayinhistory.today.model;

import com.unicellularsu.todayinhistory.MyApplication;
import com.unicellularsu.todayinhistory.beans.StoryList;
import com.unicellularsu.todayinhistory.remote.ServiceGenerator;
import com.unicellularsu.todayinhistory.remote.TodayInHistoryService;
import com.unicellularsu.todayinhistory.storyinfo.model.StoryInfoModelImpl;
import com.unicellularsu.todayinhistory.utils.DateUtils;
import com.unicellularsu.todayinhistory.utils.ToolsUtil;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by szc on 2016/11/14.
 *
 */

public class TodayStoryModelImpl implements TodayStoryModel{

    private Subscription subscription;
    OnLoadTodayStoryListener listener;
    public TodayStoryModelImpl(OnLoadTodayStoryListener listener){
        this.listener=listener;
    }

    @Override
    public void getTodayStory() {
        final TodayInHistoryService service = ServiceGenerator.createSerxice(TodayInHistoryService.class);
        if (ToolsUtil.isNetworkAvailable(MyApplication.getContentObj())) {
            subscription = service.getStoryList(MyApplication.TODAY_IN_HISTORY_KEY, DateUtils.getNowDay())
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<StoryList>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            //listener.onFailure("ERROR IN MODEL",e);
                        }

                        @Override
                        public void onNext(StoryList storyList) {
                            listener.onSuccess(storyList);
                        }
                    });
        }else {
            listener.onFailure("没有网络呀");
        }

        System.out.println("到Model-->getTodayStory这里了");
    }

    @Override
    public void getSearchStory(String date) {
        final TodayInHistoryService service = ServiceGenerator.createSerxice(TodayInHistoryService.class);
        if (ToolsUtil.isNetworkAvailable(MyApplication.getContentObj())) {
            subscription = service.getStoryList(MyApplication.TODAY_IN_HISTORY_KEY, date)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<StoryList>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            //listener.onFailure("ERROR IN MODEL",e);
                        }

                        @Override
                        public void onNext(StoryList storyList) {
                            listener.onSuccess(storyList);
                        }
                    });
        }else {
            listener.onFailure("没有网络呀");
        }
        System.out.println("到Model-->getSearchStory这里了");
    }

    @Override
    public void Unsubscribed() {
        if (subscription!=null&&subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public interface OnLoadTodayStoryListener{
        void onSuccess(StoryList storyList);
        void onFailure(String msg);
    }
}
