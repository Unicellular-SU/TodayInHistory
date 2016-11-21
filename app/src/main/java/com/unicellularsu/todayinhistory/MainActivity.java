package com.unicellularsu.todayinhistory;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.Toast;

import com.unicellularsu.todayinhistory.today.model.TodayStoryModel;
import com.unicellularsu.todayinhistory.today.presenter.TodayStoryPresenter;
import com.unicellularsu.todayinhistory.today.presenter.TodayStoryPresenterImpl;
import com.unicellularsu.todayinhistory.today.widget.TodayStoryFragment;
import com.unicellularsu.todayinhistory.utils.ToolsUtil;

import java.util.Calendar;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle("历史上的今天");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_content,new TodayStoryFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.menu_item_search:
                Calendar c = Calendar.getInstance();
                new DatePickerDialog(MainActivity.this, TodayStoryPresenterImpl.dateSetListener,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
