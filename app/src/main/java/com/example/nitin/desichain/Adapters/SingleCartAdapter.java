package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.SingleCart;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/23/2017.
 */

public class SingleCartAdapter extends RecyclerView.Adapter<SingleCartAdapter.MyViewHolder> {

    private Context mContext;
    private List<SingleCart> mList;

    public SingleCartAdapter(Context mContext, List<SingleCart> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_cart,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        SingleCart sc = mList.get(position);
        holder.mProductCost.setText(String.valueOf(sc.getmCost()));
        holder.mProductQty.setText(String.valueOf(sc.getmQty()));
        holder.mProductBrand.setText(sc.getmProductBrand());
        holder.mProductName.setText(sc.getmProductName());
        holder.mProductImage.setImageResource(sc.getmImageId());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mProductImage;
        private TextView mProductName,mProductBrand,mProductQty,mProductCost;


        public MyViewHolder(View view) {
            super(view);
            mProductImage=(ImageView)view.findViewById(R.id.mProdImage);
            mProductName=(TextView)view.findViewById(R.id.mProdName);
            mProductBrand=(TextView)view.findViewById(R.id.mProductBrand);
            mProductQty=(TextView)view.findViewById(R.id.mProdQty);
            mProductCost=(TextView)view.findViewById(R.id.mProdCost);

        }
    }
}
