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

import com.example.nitin.desichain.Contents.BookCategoryList;
import com.example.nitin.desichain.ProductPageActual;
import com.example.nitin.desichain.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class BookCategoryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<BookCategoryList> arrayList;



    public BookCategoryAdapter(Context context, ArrayList<BookCategoryList> arrayList) {
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.single_category,null);
            viewHolder=new ViewHolder();
            viewHolder.productImage= (ImageView) convertView.findViewById(R.id.product_image);
            viewHolder.productname= (TextView) convertView.findViewById(R.id.productname);
            viewHolder.productprice= (TextView) convertView.findViewById(R.id.product_price);
            viewHolder.productratings= (TextView) convertView.findViewById(R.id.product_ratings);
            viewHolder.productnofratings= (TextView) convertView.findViewById(R.id.no_of_reviews);
            viewHolder.productcut= (TextView) convertView.findViewById(R.id.productnamecut);

            convertView.setTag(viewHolder);

        }
        Log.i("TESTING2","1");
        viewHolder= (ViewHolder) convertView.getTag();

        Picasso.with(context).load("http://www.desichain.in/uploads/"+arrayList.get(position).getIMAGE_URL()).into(viewHolder.productImage);
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
        viewHolder.productprice.setText(String.valueOf(arrayList.get(position).getACTUAL_PRICE()));
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
        viewHolder.productnofratings.setText(arrayList.get(position).getREVIEWS());
        viewHolder.productnofratings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductPageActual.class);
                context.startActivity(intent);
            }
        });
        viewHolder.productcut.setText("Rs.7490");
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
        TextView productname,productprice,productratings,productnofratings,productcut;
        LinearLayout lm;
    }
}


