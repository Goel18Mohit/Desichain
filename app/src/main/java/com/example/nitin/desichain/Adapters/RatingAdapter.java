package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.RatingContent;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/23/2017.
 */

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.MyViewHolder> {

    private Context mContext;
    private List<RatingContent> mList;

    public RatingAdapter(Context mContext, List<RatingContent> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_review,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        RatingContent rt = mList.get(position);

        holder.mReviewText.setText(rt.getmReviewText());
        holder.mDate.setText(rt.getmDate());
        holder.mReviewerName.setText(rt.getmReviewerName());
        holder.mRatingBar.setRating((float) 4.5);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mReviewerName,mDate,mReviewText;
        private RatingBar mRatingBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            mRatingBar=(RatingBar)itemView.findViewById(R.id.singleRating);
            mReviewerName=(TextView)itemView.findViewById(R.id.reviewerName);
            mDate=(TextView)itemView.findViewById(R.id.mDate);
            mReviewText=(TextView)itemView.findViewById(R.id.reveiewText);
        }
    }
}
