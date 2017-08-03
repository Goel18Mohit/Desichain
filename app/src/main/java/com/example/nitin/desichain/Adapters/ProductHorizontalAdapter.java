package com.example.nitin.desichain.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Contents.ProductHorizontal;
import com.example.nitin.desichain.R;
import com.example.nitin.desichain.Utility.Utility;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ashis on 6/20/2017.
 */

public class ProductHorizontalAdapter extends RecyclerView.Adapter<ProductHorizontalAdapter.MyViewHolder>{
    private Context mContext;
    private List<com.example.nitin.desichain.Contents.CategoryList> mProductHorizontalList;
    private static final String TAG  = ProductHorizontalAdapter.class.getSimpleName();

    public ProductHorizontalAdapter(Context mContext, List<com.example.nitin.desichain.Contents.CategoryList> mProductHorizontalList) {
        this.mContext = mContext;
        this.mProductHorizontalList = mProductHorizontalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.category,null);


            return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final com.example.nitin.desichain.Contents.CategoryList mProduct = mProductHorizontalList.get(position);
        Log.i(TAG,mProduct.getPRODUCT_NAME() + " "+ mProduct.getGROSS_WEIGHHT() + " "+
                    mProduct.getNET_WEIGTH() + " "+
                    mProduct.getDISCOUNT());
        holder.mProductRating.setText(mProduct.getRATINGS());
        holder.mProductCost.setText("Rs." + mProduct.getSELLING_PRICE());
        holder.mProdCut.setText("Rs." + mProduct.getACTUAL_PRICE());
        holder.mProdCut.setPaintFlags(holder.mProdCut.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.mProductname.setText(mProduct.getPRODUCT_NAME());
        holder.mProductReviewsNo.setText(mProduct.getNUMBER_OF_REVIEWS());
        Picasso.with(mContext).load("http://www.desichain.in/uploads/thumb_"+mProductHorizontalList.
                get(position).getImageUrl()).into(holder.mProductImage);
//        holder.mAddToCartImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext,"product added to cart successfully",Toast.LENGTH_SHORT).show();
//       // holder.mNetWeightText.setText("Net wt:"+mProduct.getNET_WEIGTH());
//             }
//        });

        holder.mNetWeightText.setText("Net Wt: " + mProduct.getNET_WEIGTH());
        holder.mProdDiscountText.setText(mProduct.getDISCOUNT()+" % off");


    }

    @Override
    public int getItemCount() {
        return mProductHorizontalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mProductImage,mAddToCartImage;
        private TextView mProductname,mProductCost,mProductRating, mProductReviewsNo,mEmptyView,mNetWeightText,mProdCut,mProdDiscountText;


        public MyViewHolder(View itemView) {
            super(itemView);
            mProdDiscountText=(TextView)itemView.findViewById(R.id.discountText);
            mProdCut=(TextView)itemView.findViewById(R.id.productnamecut);
            mNetWeightText=(TextView)itemView.findViewById(R.id.netWeightText);
            //mEmptyView=(TextView)itemView.findViewById(R.id.emptyLatestProduct);
            mAddToCartImage=(ImageView)itemView.findViewById(R.id.addToCart);
            mProductImage=(ImageView)itemView.findViewById(R.id.product_image);
            mProductname=(TextView)itemView.findViewById(R.id.productname);
            mProductCost=(TextView)itemView.findViewById(R.id.product_price);
            mProductRating=(TextView)itemView.findViewById(R.id.product_ratings);
            mProductReviewsNo=(TextView)itemView.findViewById(R.id.no_of_reviews);
        }
    }
}
