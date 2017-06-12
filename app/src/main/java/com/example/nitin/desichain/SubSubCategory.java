package com.example.nitin.desichain;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubSubCategory extends Fragment {


    ListView SUBSUBCATEGORY;
    ArrayList<String> subsubcategorylist;
    private Context context;
    public SubSubCategory(ArrayList<String> subsubcategorylist,Context context) {
        this.subsubcategorylist=subsubcategorylist;
        this.context=context;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_sub_sub_category, container, false);
        SUBSUBCATEGORY= (ListView) v.findViewById(R.id.subsubcategory);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> simplesubsubcategory=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,subsubcategorylist);
           SUBSUBCATEGORY.setAdapter(simplesubsubcategory);
    }
}
