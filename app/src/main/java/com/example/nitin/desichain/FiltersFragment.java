package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.FiltersListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashis on 6/29/2017.
 */

public class FiltersFragment extends Fragment {

    private RecyclerView mFilterView;
    private FiltersListAdapter mAdapter;
    private List<String> mList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recycler_view,container,false);


        mFilterView=(RecyclerView)view.findViewById(R.id.filtersRecyclerView);
        mList=new ArrayList<>();
        mAdapter=new FiltersListAdapter(getActivity(),mList);

        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        mFilterView.setLayoutManager(lm);
        mFilterView.setItemAnimator(new DefaultItemAnimator());
        mFilterView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mFilterView.setAdapter(mAdapter);
        prepareItems();



        return view;


    }

    private void prepareItems() {

        mList.add("AUTHOR");
        mList.add("PRICE");
        mList.add("PUBLISHER");
        mList.add("LANGUAGES");
        mList.add("BY BINDING");
        mList.add("BY STOCK");

    }
}
