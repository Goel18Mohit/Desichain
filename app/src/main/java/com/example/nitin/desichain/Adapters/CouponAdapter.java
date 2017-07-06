package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.FullOrderContent;
import com.example.nitin.desichain.Contents.Coupons;
import com.example.nitin.desichain.FullOrder;
import com.example.nitin.desichain.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.nitin.desichain.R.drawable.grey;

/**
 * Created by Karan on 04-07-2017.
 */

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.MyViewHolder> {

    public Context mContext;
    public List<Coupons> mCouponsList;
    private LinearLayout mSingleCouponLayout;

    public CouponAdapter(Context mContext, List<Coupons> mCouponsList) {
        this.mContext = mContext;
        this.mCouponsList = mCouponsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_coupon, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Coupons Coupons = mCouponsList.get(position);
        holder.mPromoCode.setText(Coupons.getmCouponCode());
        holder.mCode.setText(Coupons.getmCouponCode());
        holder.mDescription.setText(Coupons.getmCouponDescription());

    }

    @Override
    public int getItemCount() {
        return mCouponsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ExpandableTextView mCode;
        private TextView mDescription, mPromoCode;


        public MyViewHolder(View view) {
            super(view);

            mPromoCode = (TextView) view.findViewById(R.id.code_text_view);
            mCode = (ExpandableTextView) view.findViewById(R.id.expand_text_view);
            mDescription = (TextView) view.findViewById(R.id.expandable_text);

        }
    }

}
