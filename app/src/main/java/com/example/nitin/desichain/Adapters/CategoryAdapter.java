package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Contents.CategoryList;
import com.example.nitin.desichain.MyCart;
import com.example.nitin.desichain.MyOrders;
import com.example.nitin.desichain.ProductPageActual;
import com.example.nitin.desichain.R;
import com.example.nitin.desichain.Utility.Utility;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CategoryAdapter extends BaseAdapter {
    private static final String TAG = CategoryAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<CategoryList> arrayList;



    public CategoryAdapter(Context context, ArrayList<CategoryList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView( int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.category,null);
            viewHolder=new ViewHolder();
            viewHolder.productImage= (ImageView) convertView.findViewById(R.id.product_image);
            viewHolder.productname= (TextView) convertView.findViewById(R.id.productname);
            viewHolder.productprice= (TextView) convertView.findViewById(R.id.product_price);
            viewHolder.productratings= (TextView) convertView.findViewById(R.id.product_ratings);
            viewHolder.productnofratings= (TextView) convertView.findViewById(R.id.no_of_reviews);
            viewHolder.productcut= (TextView) convertView.findViewById(R.id.productnamecut);
            viewHolder.mProdDiscountText=(TextView)convertView.findViewById(R.id.discountText);
            viewHolder.mProdNetWt=(TextView)convertView.findViewById(R.id.netWeightText);
            convertView.setTag(viewHolder);

        }
        viewHolder= (ViewHolder) convertView.getTag();

       // viewHolder.productImage.setImageResource(arrayList.get(position).getImageUrl());
        Picasso.with(parent.getContext()).load("http://www.desichain.in/uploads/thumb_"+arrayList.get(position).getImageUrl()).into(viewHolder.productImage);
     //   Picasso.with(context).load("http://www.desichain.in/uploads/"+arrayList.get(position).getIMAGE_URL()).into(viewHolder.productImage);

        final String imgUrl = "http://www.desichain.in/uploads/thumb_"+arrayList.get(position).getImageUrl();
        final String prodName = arrayList.get(position).getPRODUCT_NAME();
        final int prodPrice = arrayList.get(position).getACTUAL_PRICE();



        Log.i(TAG,imgUrl+"\n"+prodName+"\n"+prodPrice);


        viewHolder.mProdNetWt.setText("Net Wt: "+arrayList.get(position).getNET_WEIGTH());

        viewHolder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });
        viewHolder.productname.setText(arrayList.get(position).getPRODUCT_NAME());
        viewHolder.productname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });
        viewHolder.productprice.setText("Rs. " +arrayList.get(position).getSELLING_PRICE());
        viewHolder.productprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });

        viewHolder.productratings.setText(arrayList.get(position).getRATINGS());
        viewHolder.productratings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });
        viewHolder.productnofratings.setText(arrayList.get(position).getNUMBER_OF_REVIEWS());
        viewHolder.productnofratings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });
        viewHolder.mProdDiscountText.setText(arrayList.get(position).getDISCOUNT()+"% off");
        viewHolder.productcut.setText("Rs. " +arrayList.get(position).getACTUAL_PRICE());
        viewHolder.productcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });
        viewHolder.productcut.setPaintFlags(viewHolder.productcut.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        viewHolder.productcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public class ViewHolder{
        ImageView productImage;
        TextView productname,productprice,productratings,productnofratings,productcut,mProdDiscountText,mProdNetWt;
    }
}
