package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.nitin.desichain.Adapters.FilterSelectionDataAdapter;
import com.example.nitin.desichain.Contents.FilterFragmentDataContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashis on 6/29/2017.
 */

public class FilterFragmentData extends Fragment {


    private static final String LOG_TAG = FilterFragmentData.class.getSimpleName();
    private LinearLayout mFragmentDataLayout;
    private RecyclerView mFilterListView;
    private List<FilterFragmentDataContent> mContent;
    private FilterSelectionDataAdapter mAdapter;
    private String mFilterItemName;
    private List<FilterFragmentDataContent> authorFilterList;
    private List<FilterFragmentDataContent> priceFilterList;
    private List<FilterFragmentDataContent> publisherFilterList;
    private List<FilterFragmentDataContent> brandFilterList;
    private List<FilterFragmentDataContent> genderFilterList;
    private List<FilterFragmentDataContent> ageFilterList;
    private List<FilterFragmentDataContent> prodTypeFilterList;
    private List<FilterFragmentDataContent> bindingFilterList;
    private List<FilterFragmentDataContent> stockFilterList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_data,container,false);

        mFilterItemName = getArguments().getString("mFilterItemName");

        Log.i(LOG_TAG,mFilterItemName);

        /*
        mContent=new ArrayList<>();
        for (int i =0;i<6;i++){
            mContent.add(new FilterFragmentDataContent("Student #"+i,false));
        }
*/



        mFilterListView = (RecyclerView) view.findViewById(R.id.filterSelectionDataRecycView);
        mFilterListView.setHasFixedSize(true);
        mFilterListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (mFilterItemName.equals("author")){
            if (mAdapter==null) {
                authorFilterList = new ArrayList<>();
                prepareAuthorFilters();

                mAdapter = new FilterSelectionDataAdapter(authorFilterList, getActivity());
                mFilterListView.setAdapter(mAdapter);

            }
            else {
                authorFilterList.clear();
                mFilterListView.getAdapter().notifyDataSetChanged();

            }
        }
        else if (mFilterItemName.equals("price")){
            if (mAdapter==null) {
                priceFilterList = new ArrayList<>();
                preparePriceFilters();
                mAdapter = new FilterSelectionDataAdapter(priceFilterList, getActivity());
                mFilterListView.setAdapter(mAdapter);

            }
            else {
                priceFilterList.clear();
                mFilterListView.getAdapter().notifyDataSetChanged();
            }
        }
        else if(mFilterItemName.equals("publisher")){
            if (mAdapter==null) {
                publisherFilterList = new ArrayList<>();
                preparePublisherFilters();
                mAdapter = new FilterSelectionDataAdapter(publisherFilterList, getActivity());
                mFilterListView.setAdapter(mAdapter);

            }
            else {
                publisherFilterList.clear();
                mFilterListView.getAdapter().notifyDataSetChanged();
            }
        }
        else if(mFilterItemName.equals("by binding")){
            if (mAdapter==null) {
                bindingFilterList = new ArrayList<>();
                prepareBindingFilters();
                mAdapter = new FilterSelectionDataAdapter(bindingFilterList, getActivity());
                mFilterListView.setAdapter(mAdapter);

            }
            else {

                bindingFilterList.clear();
                mFilterListView.getAdapter().notifyDataSetChanged();
            }
        }
        else if(mFilterItemName.equals("by stock")) {
            if (mAdapter == null) {
                stockFilterList = new ArrayList<>();
                prepareStockFilterList();
                mAdapter = new FilterSelectionDataAdapter(stockFilterList, getActivity());
                mFilterListView.setAdapter(mAdapter);

            }
            else {
                stockFilterList.clear();
                mFilterListView.getAdapter().notifyDataSetChanged();
            }
        }
        else if (mFilterItemName.equals("brand")){

            brandFilterList=new ArrayList<>();
            prepareBrandFilterList();
            mAdapter=new FilterSelectionDataAdapter(brandFilterList,getActivity());
            mFilterListView.setAdapter(mAdapter);

        }
        else if(mFilterItemName.equals("gender")){
            genderFilterList=new ArrayList<>();
            prepareGenderFilterList();
            mAdapter=new FilterSelectionDataAdapter(genderFilterList,getActivity());
            mFilterListView.setAdapter(mAdapter);

        }
        else if(mFilterItemName.equals("age")){
            ageFilterList=new ArrayList<>();
            prepareAgeFilterList();
            mAdapter=new FilterSelectionDataAdapter(ageFilterList,getActivity());
            mFilterListView.setAdapter(mAdapter);

        }
        else if(mFilterItemName.equals("product type")){
            prodTypeFilterList=new ArrayList<>();
            prepareProductTypeFilterList();
            mAdapter=new FilterSelectionDataAdapter(prodTypeFilterList,getActivity());
            mFilterListView.setAdapter(mAdapter);

        }






        return view;

    }

    private void prepareProductTypeFilterList() {
        prodTypeFilterList.add(new FilterFragmentDataContent("Solid",false));
    }

    private void prepareAgeFilterList() {
        ageFilterList.add(new FilterFragmentDataContent("all",false));
    }

    private void prepareGenderFilterList() {

        genderFilterList.add(new FilterFragmentDataContent("all",false));
    }

    private void prepareBrandFilterList() {

        brandFilterList.add(new FilterFragmentDataContent("Kishori Collections",false));
    }


    private void prepareBindingFilters() {
        bindingFilterList.add(new FilterFragmentDataContent("Hardbound",false));
    }

    private void prepareStockFilterList() {
        stockFilterList.add(new FilterFragmentDataContent("True",false));
        stockFilterList.add(new FilterFragmentDataContent("False",false));

    }

    private void preparePublisherFilters() {

        publisherFilterList.add(new FilterFragmentDataContent("Bhaktivedanta Book Trust (BBT)",false));

    }

    private void preparePriceFilters() {
    }

    private void prepareAuthorFilters() {
        authorFilterList.add(new FilterFragmentDataContent("A.C. Bhaktivedanta Swami Prabhupada",false));
    }

}
