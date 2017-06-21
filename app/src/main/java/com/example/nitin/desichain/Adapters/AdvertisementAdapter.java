package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nitin.desichain.Contents.Advertisements;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/20/2017.
 */

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.MyViewHolder> {

    private Context mContext;
    private List<Advertisements> mPics;

    public AdvertisementAdapter(Context mContext, List<Advertisements> mPics) {
        this.mContext = mContext;
        this.mPics = mPics;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.slide,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Advertisements advertisements = mPics.get(position);
        holder.mAdvertisement.setImageResource(advertisements.getmImageId());
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mAdvertisement;

        public MyViewHolder(View itemView) {
            super(itemView);
            mAdvertisement=(ImageView)itemView.findViewById(R.id.imageSliding);
        }
    }
}
