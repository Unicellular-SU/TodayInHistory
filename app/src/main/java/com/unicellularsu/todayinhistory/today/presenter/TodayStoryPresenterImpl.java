package com.unicellularsu.todayinhistory.today.presenter;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

import com.unicellularsu.todayinhistory.beans.StoryList;
import com.unicellularsu.todayinhistory.today.model.TodayStoryModel;
import com.unicellularsu.todayinhistory.today.model.TodayStoryModelImpl;
import com.unicellularsu.todayinhistory.today.view.TodayStoryView;

/**
 * Created by szc on 2016/11/14.
 *
 */

public class TodayStoryPresenterImpl implements TodayStoryPresenter,TodayStoryModelImpl.OnLoadTodayStoryListener{

    private static TodayStoryModel mModel;
    private static TodayStoryView mView;

    public TodayStoryPresenterImpl(TodayStoryView view){
        mModel=new TodayStoryModelImpl(this);
        this.mView = view;
    }

    @Override
    public void loadTodayStory() {
        mView.showProgress();
        mModel.getTodayStory();
    }


    @Override
    public void onSuccess(StoryList storyList) {
        System.out.println("到Present这里了--->"+storyList.getReason());

        mView.addStory(storyList);
        mView.hideProgress();
    }

    @Override
    public void onFailure(String msg) {
        mView.hideProgress();
        mView.showMessage(msg);
    }

    public static DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            System.out.println((month+1)+"月"+dayOfMonth+"日");
            mView.showProgress();
            mModel.getSearchStory(String.valueOf(month+1)+"/"+String.valueOf(dayOfMonth));
        }
    };
}
