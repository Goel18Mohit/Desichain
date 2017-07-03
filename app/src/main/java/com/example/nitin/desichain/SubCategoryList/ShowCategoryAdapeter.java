package com.example.nitin.desichain.SubCategoryList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nitin.desichain.CategoryHolder;
import com.example.nitin.desichain.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by NITIN on 09-Jun-17.
*/
public class ShowCategoryAdapeter extends BaseExpandableListAdapter {


    private Context content;
    private ArrayList<CategoryHolder> headerlist;
    private HashMap<String,ArrayList<String>> childlist;
    private ExpandableListView listView;

    TextView headerTextview;
    ImageView headerImageview,categoryImage;
    public ShowCategoryAdapeter(Context content, ArrayList<CategoryHolder> headerlist, HashMap<String, ArrayList<String>> childlist,ExpandableListView listView) {
        this.content = content;
        this.headerlist = headerlist;
        this.childlist = childlist;
        this.listView=listView;
    }

    @Override
    public int getGroupCount() {
        return headerlist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childlist.get(headerlist.get(groupPosition).getPARENTCATEGORY()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerlist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childlist.get(headerlist.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) content.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.simple_list,null);
        }
        headerTextview= (TextView) convertView.findViewById(R.id.parentcategory);
        headerImageview= (ImageView) convertView.findViewById(R.id.parentcategoryarrow);
        categoryImage=(ImageView)convertView.findViewById(R.id.categoryImage);

        categoryImage.setImageResource(headerlist.get(groupPosition).getmImageId());


        headerTextview.setText(headerlist.get(groupPosition).getPARENTCATEGORY());
        if(isExpanded)
        {
            headerImageview.setImageResource(R.mipmap.ic_keyboard_arrow_up_black_24dp);
        }
        else
        {
            headerImageview.setImageResource(R.mipmap.ic_keyboard_arrow_down_black_24dp);
        }
       return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) content.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.singlechildcategory,null);
        }
        TextView headerTextview= (TextView) convertView.findViewById(R.id.childcategory);
        headerTextview.setText(childlist.get(headerlist.get(groupPosition).getPARENTCATEGORY()).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

