package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nitin.desichain.Contents.BrandStudioList;
import com.example.nitin.desichain.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class BrandStudioAdapter  extends RecyclerView.Adapter<BrandStudioAdapter.MyViewHolder>{

    private ArrayList<BrandStudioList> arrayList;
    private Context mContext;


    public BrandStudioAdapter(ArrayList<BrandStudioList> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_brand,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BrandStudioAdapter.MyViewHolder holder, int position) {


       Picasso.with(mContext).load("http://www.desichain.in/uploads/"+arrayList.get(position).getBRAND_IMAGE_URL()).into(holder.mBrandImage);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mBrandImage;


        public MyViewHolder(View itemView) {
            super(itemView);
           mBrandImage= (ImageView) itemView.findViewById(R.id.brandimage);
        }
    }
}

