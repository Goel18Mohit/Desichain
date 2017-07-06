package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/18/2017.
 */

public class SlidingImageAdapter extends PagerAdapter {

    private List<Integer> mImages;
    private LayoutInflater inflater;
    private Context mContext;

    public SlidingImageAdapter(List<Integer> mImages, Context mContext) {
        this.mImages = mImages;
        this.mContext = mContext;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view =inflater.inflate(R.layout.slide,container,false);
        ImageView mImageView = (ImageView)view.findViewById(R.id.imageSliding);
        mImageView.setImageResource(mImages.get(position));
        container.addView(view,0);
        return view;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
