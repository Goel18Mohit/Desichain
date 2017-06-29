package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by NITIN on 29-Jun-17.
 */

public class SearchAdapter extends BaseAdapter {

    private ArrayList<String> search;
    private Context mcontext;


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

        if(convertView==null)
        {

        }

        return null;
    }
}
