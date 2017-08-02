package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Contents.CategoryList;
import com.example.nitin.desichain.Contents.ProductHorizontal;
import com.example.nitin.desichain.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ashis on 7/10/2017.
 */

public class BrandStudioItemsAdapter extends RecyclerView.Adapter<BrandStudioItemsAdapter.MyViewHolder> {

    private List<CategoryList> mList;
    private Context mContext;


    public BrandStudioItemsAdapter(List<CategoryList> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.single_category,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

//        ProductHorizontal mProduct = mList.get(position);
        CategoryList mProduct = mList.get(position);
         holder.mProductRating.setText(mProduct.getRATINGS());
        holder.mProductCost.setText( "Rs " + mProduct.getACTUAL_PRICE());
        holder.mProductname.setText(mProduct.getPRODUCT_NAME());
        holder.mProductReviewsNo.setText(mProduct.getNUMBER_OF_REVIEWS());
        Picasso.with(mContext).load("http://www.desichain.in/uploads/thumb_"+mList.get(position).getImageUrl())
                .resize(100,100).into(holder.mProductImage);
        holder.mAddToCartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"product added to cart successfully",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
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
