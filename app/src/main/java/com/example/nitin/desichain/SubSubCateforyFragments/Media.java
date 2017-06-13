package com.example.nitin.desichain.SubSubCateforyFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nitin.desichain.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Media extends Fragment {


    private ArrayList<String> arrayList;
    private Context context;
    private ListView listView;
    public Media(ArrayList<String> arrayList,Context context) {
        // Required empty public constructor
        this.arrayList=arrayList;
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_bhagavad_gita, container, false);
        listView= (ListView) v.findViewById(R.id.bhagvadlist);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
    }
}
