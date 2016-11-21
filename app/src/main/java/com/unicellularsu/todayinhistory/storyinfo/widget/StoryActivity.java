package com.unicellularsu.todayinhistory.storyinfo.widget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.unicellularsu.todayinhistory.beans.StoryInfo;
import com.unicellularsu.todayinhistory.storyinfo.present.StoryInfoPresent;
import com.unicellularsu.todayinhistory.storyinfo.present.StoryInfoPresentImpl;
import com.unicellularsu.todayinhistory.storyinfo.view.StoryInfoView;
import com.unicellularsu.todayinhistory.R;


/**
 * Created by szc on 2016/11/15.
 *
 */

public class StoryActivity extends AppCompatActivity implements StoryInfoView {

    private ProgressDialog dialog;
    private StoryInfoPresent present;
    //TextView tv_title;
    TextView tv_content;
    ImageView iv_history;
    Toolbar toolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storyinfo);
        System.out.println("到StoryActivity这里了");

        initView();
        String eId = getIntent().getStringExtra("e_id");
        System.out.println(eId);
        present.loadStoryInfo(eId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dialog.dismiss();
    }

    void initView(){
        dialog = new ProgressDialog(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //tv_title = (TextView) findViewById(R.id.tv_title);
        tv_content= (TextView) findViewById(R.id.tv_content);
        iv_history = (ImageView) findViewById(R.id.iv_history);

        tv_content.setMovementMethod(ScrollingMovementMethod.getInstance());

        present = new StoryInfoPresentImpl(this);
    }

    @Override
    public void showStoryInfo(StoryInfo storyInfo) {
        StoryInfo.Result result = storyInfo.getResult().get(0);
        System.out.println(result.getTitle());
        //tv_title.setText(result.getTitle());
        tv_content.setText(result.getContent());
        if(Integer.parseInt(result.getPicNo())>=1){
            Glide.with(this).load(result.getPicUrl().get(0).getUrl()).placeholder(R.drawable.loading).crossFade().into(iv_history);
        }
        this.setTitle(result.getTitle());
    }

    @Override
    public void showProgress() {
        dialog.setMessage("Please wait...");
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.hide();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
