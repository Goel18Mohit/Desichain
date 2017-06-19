package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.FullOrderContent;
import com.example.nitin.desichain.Contents.Orders;
import com.example.nitin.desichain.FullOrder;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/17/2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    public Context mContext;
    public List<Orders> mOrdersList;

    public OrderAdapter(Context mContext, List<Orders> mOrdersList) {
        this.mContext = mContext;
        this.mOrdersList = mOrdersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_order,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Orders orders = mOrdersList.get(position);
        holder.mDateText.setText(orders.getmDate());
        holder.mStatusText.setText(orders.getmStatus());
        holder.mItemsText.setText("items : " + orders.getmItems());
        holder.mCostText.setText(orders.getmPrice());
        holder.mOrderIdText.setText(orders.getmOrderId());
        holder.mSingleOrderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c= v.getContext();
                c.startActivity(new Intent(c, FullOrder.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return  mOrdersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mDateText,mOrderIdText,mCostText,
        mItemsText,mStatusText;
        private LinearLayout mSingleOrderLayout;

        public MyViewHolder(View view) {
            super(view);

            mDateText = (TextView) view.findViewById(R.id.mDate);
            mOrderIdText = (TextView) view.findViewById(R.id.mOrderId);
            mCostText = (TextView) view.findViewById(R.id.mOrderCost);
            mItemsText = (TextView) view.findViewById(R.id.mItems);
            mStatusText = (TextView) view.findViewById(R.id.mOrderStatus);
            mSingleOrderLayout=(LinearLayout)view.findViewById(R.id.singleOrder);
        }
   }


}
