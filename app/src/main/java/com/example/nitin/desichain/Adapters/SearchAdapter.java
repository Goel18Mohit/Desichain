package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitin.desichain.R;

import java.util.ArrayList;

/**
 * Created by NITIN on 29-Jun-17.
 */

public class SearchAdapter extends BaseAdapter {

    private ArrayList<String> search;
    private Context mcontext;


    public SearchAdapter(ArrayList<String> search, Context mcontext) {
        this.search = search;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return search.size();
    }

    @Override
    public Object getItem(int position) {
        return search.size();
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
            LayoutInflater layoutInflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.single_search,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.mCopyTextImage=(ImageView)convertView.findViewById(R.id.searchImage);
            viewHolder.mSearchText=(TextView)convertView.findViewById(R.id.singlesearch);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder)convertView.getTag();

       viewHolder.mSearchText.setText(search.get(position));

        return convertView;
    }


    public class ViewHolder{

        TextView mSearchText;
        ImageView mCopyTextImage;
    }
}

