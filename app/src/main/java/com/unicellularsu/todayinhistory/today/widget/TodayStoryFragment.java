package com.unicellularsu.todayinhistory.today.widget;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.unicellularsu.todayinhistory.MyApplication;
import com.unicellularsu.todayinhistory.R;
import com.unicellularsu.todayinhistory.beans.StoryList;
import com.unicellularsu.todayinhistory.storyinfo.widget.StoryActivity;
import com.unicellularsu.todayinhistory.today.TodayStoryAdapter;
import com.unicellularsu.todayinhistory.today.presenter.TodayStoryPresenter;
import com.unicellularsu.todayinhistory.today.presenter.TodayStoryPresenterImpl;
import com.unicellularsu.todayinhistory.today.view.TodayStoryView;
import com.unicellularsu.todayinhistory.utils.ToolsUtil;

/**
 * Created by szc on 2016/11/14.
 *
 */

public class TodayStoryFragment extends Fragment implements TodayStoryView{
    private StoryList mData;
    private TodayStoryPresenter mTodayStoryPresent;
    private ProgressDialog mDialog;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private TodayStoryAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTodayStoryPresent = new TodayStoryPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_today, null);


        initView(view);

        mTodayStoryPresent.loadTodayStory();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDialog.dismiss();
    }

    private void initView(View view){
        mDialog = new ProgressDialog(getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        mData = new StoryList();
        adapter = new TodayStoryAdapter();
        adapter.setOnItemClickListener(onItemClickListener);
        recyclerView.setAdapter(adapter);
    }

    private TodayStoryAdapter.OnItemClickListener onItemClickListener = new TodayStoryAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            if(mData.getResult().size()<=0){
                return;
            }
            StoryList.Result result = adapter.getItem(position);

            Intent intent = new Intent(getActivity(),StoryActivity.class);
            intent.putExtra("e_id",result.getEId());
            startActivity(intent);

        }
    } ;


    @Override
    public void addStory(StoryList storyList) {

        if(storyList.getReason().equals("success")){
            adapter.setmDate(storyList);
            mData.setResult(storyList.getResult());
        }else {
            showMessage("ERROR IN SET ADAPTER");
        }
    }

    @Override
    public void showProgress() {
        mDialog.setMessage("please wait...");
        mDialog.show();
    }

    @Override
    public void hideProgress() {
        mDialog.hide();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
