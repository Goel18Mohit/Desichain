package com.example.nitin.desichain.SubCategoryList;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitin.desichain.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 09-Jun-17.
*/
public class ShowCategoryAdapeter extends BaseAdapter {

    private ArrayList<String> subCategory;
    private Context context;
    FragmentManager fragmentManager;
    public interface Itemclick{
        public void onItemClick(int position,FrameLayout id);
    }
    Itemclick itemclick;
    public ShowCategoryAdapeter(ArrayList<String> subCategory,Context context)
    {
        this.subCategory=subCategory;
        this.context=context;
        itemclick= (Itemclick) context;
    }
    @Override
    public int getCount() {
        return subCategory.size();
    }

    @Override
    public Object getItem(int position) {
        return subCategory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Viewholder viewholder;
        if(convertView==null)
        {
            convertView=layoutInflater.inflate(R.layout.single_book_media_category,null);
            viewholder=new Viewholder();
            viewholder.TEXTSUBCATEGORY= (TextView) convertView.findViewById(R.id.subcategorytext);
            viewholder.IMAGEVIEWSUBCATEGORY= (ImageView)convertView.findViewById(R.id.plus);
            viewholder.SUBCATEGORYLIST= (FrameLayout) convertView.findViewById(R.id.list_sub_sub_category);
            convertView.setTag(viewholder);
        }
        final View v1=convertView;
        viewholder= (Viewholder) convertView.getTag();
        viewholder.TEXTSUBCATEGORY.setText(subCategory.get(position));
        viewholder.TEXTSUBCATEGORY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                itemclick.onItemClick(position,((Viewholder) v1.getTag()).SUBCATEGORYLIST);

            }
        });
         viewholder.IMAGEVIEWSUBCATEGORY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemclick.onItemClick(position,((Viewholder) v1.getTag()).SUBCATEGORYLIST);
                }
            });
        return convertView;
    }

    public class Viewholder{
        TextView TEXTSUBCATEGORY;
        ImageView IMAGEVIEWSUBCATEGORY;
        FrameLayout SUBCATEGORYLIST;
    }
}

