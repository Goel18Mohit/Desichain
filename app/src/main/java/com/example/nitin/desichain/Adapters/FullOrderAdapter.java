package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.FullOrderContent;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/18/2017.
 */

public class FullOrderAdapter extends RecyclerView.Adapter<FullOrderAdapter.MyViewHolder> {

    private Context mContext;
    private List<FullOrderContent> mFullOrderList;

    public FullOrderAdapter(Context mContext, List<FullOrderContent> mFullOrderList) {
        this.mContext = mContext;
        this.mFullOrderList = mFullOrderList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_full_order,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        FullOrderContent mFullOrderContent= mFullOrderList.get(position);

        holder.mCostText.setText("Rs" +mFullOrderContent.getmCost());
        holder.mProductText.setText(mFullOrderContent.getmProductName());
        holder.mBrandText.setText(mFullOrderContent.getmBrandName());
        holder.mQtyText.setText(String.valueOf(mFullOrderContent.getmQty()));
    }

    @Override
    public int getItemCount() {
        return mFullOrderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mBrandText,mProductText,mCostText,mQtyText;

        public MyViewHolder(View view) {
            super(view);

            mBrandText=(TextView)view.findViewById(R.id.productBrand);
            mProductText=(TextView)view.findViewById(R.id.product_Name);
            mCostText=(TextView)view.findViewById(R.id.product_Cost);
            mQtyText=(TextView)view.findViewById(R.id.productQty);

        }

    }
}
