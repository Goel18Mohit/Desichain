package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nitin.desichain.Adapters.FiltersListAdapter;

import java.util.ArrayList;

/**
 * Created by ashis on 6/29/2017.
 */

public class FiltersFragment extends Fragment {

    private String mFilterCategName;

    private RecyclerView mFilterView;
    private FiltersListAdapter mAdapter;
    private ArrayList<String> booknMedia;
    private ArrayList<String> poojaItems;
    private ArrayList<String> homeCare;
    private ArrayList<String> others;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recycler_view,container,false);


        mFilterCategName = getArguments().getString("mFilterCategName");
        Log.i("mFilterCategName",mFilterCategName);

        mFilterView=(RecyclerView)view.findViewById(R.id.filtersRecyclerView);

        booknMedia = new ArrayList<>();
        poojaItems = new ArrayList<>();
        homeCare = new ArrayList<>();
        others= new ArrayList<>();

        if (mFilterCategName.equals("Book and media")){
            mAdapter = new FiltersListAdapter(getActivity(),booknMedia);
            prepareBookMediaItemsFilters();
        }
        else if (mFilterCategName.equals("Pooja Item")){
            mAdapter=new FiltersListAdapter(getActivity(),poojaItems);
            preparePoojaItemsFilters();

        }
        else if(mFilterCategName.equals("Home Care")){
            mAdapter=new FiltersListAdapter(getActivity(),homeCare);
            prepareHomeCareFilters();
        }
        else if(mFilterCategName.equals("Others")){
            mAdapter=new FiltersListAdapter(getActivity(),others);
            prepareOtherFilters();
        }

//        mAdapter=new FiltersListAdapter(getActivity(),mList);

        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        mFilterView.setLayoutManager(lm);
        mFilterView.setItemAnimator(new DefaultItemAnimator());
        mFilterView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mFilterView.setAdapter(mAdapter);



        return view;


    }

    private void prepareBookMediaItemsFilters() {

        booknMedia.add("author");
        booknMedia.add("price");
        booknMedia.add("publisher");
        booknMedia.add("by binding");
        booknMedia.add("by stock");
    }

    private void preparePoojaItemsFilters(){
        poojaItems.add("brand");
        poojaItems.add("price");
        poojaItems.add("gender");
        poojaItems.add("age");
        poojaItems.add("product type");
        poojaItems.add("by stock");
    }

    private void prepareHomeCareFilters(){
        homeCare.add("brand");
        homeCare.add("price");
        homeCare.add("gender");
        homeCare.add("age");
        homeCare.add("product type");
        homeCare.add("by stock");
    }

    private void prepareOtherFilters(){
        others.add("brand");
        others.add("price");
        others.add("gender");
        others.add("age");
        others.add("product type");
        others.add("by stock");

    }
}
