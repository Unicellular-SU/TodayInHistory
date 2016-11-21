package com.unicellularsu.todayinhistory.today;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicellularsu.todayinhistory.R;
import com.unicellularsu.todayinhistory.beans.StoryList;

/**
 * Created by szc on 2016/11/14.
 *
 */

public class TodayStoryAdapter extends RecyclerView.Adapter<TodayStoryAdapter.ViewHolder> {

    private StoryList mDate;
    private TodayStoryAdapter.OnItemClickListener listener;

    public void setmDate(StoryList date){
        this.mDate=date;
        this.notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodayStoryAdapter.ViewHolder holder, int position) {
        StoryList.Result result = mDate.getResult().get(position);
        //System.out.println(mDate.getResult().get(position).getTitle().toString());
        holder.tv_Title.setText(result.getTitle().toString());
        holder.tv_Date.setText(result.getDate().toString());
    }

    @Override
    public int getItemCount() {
        if(mDate==null){
            return 0;
        }
        return mDate.getResult().size();
    }

    public StoryList.Result getItem(int position){
        return mDate==null?null:mDate.getResult().get(position);
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

   public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       public TextView tv_Title;
       public TextView tv_Date;

       public ViewHolder(View itemView) {
           super(itemView);
           tv_Title= (TextView) itemView.findViewById(R.id.tv_title);
           tv_Date = (TextView) itemView.findViewById(R.id.tv_date);
           itemView.setOnClickListener(this);
       }

       @Override
       public void onClick(View v) {
           if(listener!=null){
               listener.onItemClick(v,this.getPosition());
           }
       }
   }
}
