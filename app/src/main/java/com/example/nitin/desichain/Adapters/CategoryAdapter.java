package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.CategoryList;
import com.example.nitin.desichain.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 20-Jun-17.
 */

public class CategoryAdapter extends BaseAdapter {

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
    public View getView(int position, View convertView, ViewGroup parent) {
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
            convertView.setTag(viewHolder);

        }
        viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.productImage.setImageResource(arrayList.get(position).getImageUrl());
        viewHolder.productname.setText(arrayList.get(position).getPRODUCT_NAME());
        viewHolder.productprice.setText(arrayList.get(position).getPRICE());;
        viewHolder.productratings.setText(arrayList.get(position).getRATINGS());
        viewHolder.productnofratings.setText(arrayList.get(position).getNUMBER_OF_REVIEWS());
        return convertView;
    }
    public class ViewHolder{
        ImageView productImage;
        TextView productname,productprice,productratings,productnofratings;
    }
}
