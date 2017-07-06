package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nitin.desichain.R;

/**
 * Created by ashis on 7/4/2017.
 */

public class CustomViewpagerAdapter extends PagerAdapter {

    private Context mContext;
    private int mImages[];
    private LayoutInflater mLayoutInflator;

    public CustomViewpagerAdapter(Context mContext, int[] mImages) {
        this.mContext = mContext;
        this.mImages = mImages;
        mLayoutInflator=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView= mLayoutInflator.inflate(R.layout.single_image,container,false);

        ImageView mImageView = (ImageView)itemView.findViewById(R.id.imageView);
        mImageView.setImageResource(mImages[position]);

        container.addView(itemView);

        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);
    }
}
