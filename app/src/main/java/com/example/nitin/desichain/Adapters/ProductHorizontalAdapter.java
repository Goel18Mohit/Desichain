package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Contents.ProductHorizontal;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/20/2017.
 */

public class ProductHorizontalAdapter extends RecyclerView.Adapter<ProductHorizontalAdapter.MyViewHolder>{


    private Context mContext;
    private List<ProductHorizontal> mProductHorizontalList;

    public ProductHorizontalAdapter(Context mContext, List<ProductHorizontal> mProductHorizontalList) {
        this.mContext = mContext;
        this.mProductHorizontalList = mProductHorizontalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_category,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ProductHorizontal mProduct = mProductHorizontalList.get(position);
        holder.mProductRating.setText(mProduct.getmProductRating());
        holder.mProductCost.setText(String.valueOf(mProduct.getmProductCost()));
        holder.mProductname.setText(mProduct.getmProductName());
        holder.mProductReviewsNo.setText(mProduct.getmProductNoOfReviews());
        holder.mProductImage.setImageResource(mProduct.getmProductImageId());
        holder.mAddToCartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"product added to cart successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductHorizontalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView mProductImage,mAddToCartImage;
        private TextView mProductname,mProductCost,mProductRating, mProductReviewsNo;


        public MyViewHolder(View itemView) {
            super(itemView);
            mAddToCartImage=(ImageView)itemView.findViewById(R.id.addToCart);
            mProductImage=(ImageView)itemView.findViewById(R.id.product_image);
            mProductname=(TextView)itemView.findViewById(R.id.productname);
            mProductCost=(TextView)itemView.findViewById(R.id.product_price);
            mProductRating=(TextView)itemView.findViewById(R.id.product_ratings);
            mProductReviewsNo=(TextView)itemView.findViewById(R.id.no_of_reviews);
        }
    }
}
