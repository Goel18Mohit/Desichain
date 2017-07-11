package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.ChildCategoryBrand;
import com.example.nitin.desichain.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ashis on 7/5/2017.
 */

public class ChildCategoryCardAdapter extends RecyclerView.Adapter<ChildCategoryCardAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<ChildCategoryBrand> mList;

    public ChildCategoryCardAdapter(Context mContext, ArrayList<ChildCategoryBrand> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_card_category,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ChildCategoryBrand brand = mList.get(position);
        Picasso.with(mContext).load("http://www.desichain.in/uploads/"+mList.get(position).getPRODUCT_IMAGE_URL()).into(holder.imageView);
        holder.textView.setText(mList.get(position).getPRODUCT_NAME());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageCategory);
            textView=(TextView)itemView.findViewById(R.id.brandText);
        }
    }
}
