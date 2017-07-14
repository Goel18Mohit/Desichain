package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.FilterFragmentData;
import com.example.nitin.desichain.Filters;
import com.example.nitin.desichain.PriceFragment;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/29/2017.
 */

public class FiltersListAdapter extends RecyclerView.Adapter<FiltersListAdapter.MyViewHolder> {

    private static final String LOG_TAG = FiltersListAdapter.class.getSimpleName();

    private Context mContext;
    private List<String> mList;

    public FiltersListAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.single_filter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        String filterText = mList.get(position);
        holder.mFilterText.setText(filterText);
        holder.mFilterText.setTextColor(Color.BLACK);

        holder.mFilterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (holder.mFilterText.getText().toString().equals("price")){
                    PriceFragment priceFragment = new PriceFragment();
                    Filters mFilter = (Filters) mContext;
                    FragmentManager f = mFilter.getSupportFragmentManager();
                    f.beginTransaction().replace(R.id.filterSelectionFrame,priceFragment).commit();
                }
                else {
                    Log.i(LOG_TAG, holder.mFilterText.getText().toString());

                    FilterFragmentData fData = new FilterFragmentData();
                    Toast.makeText(mContext, "fragment Called", Toast.LENGTH_SHORT).show();
                    Filters mFilter = (Filters) mContext;
                    FragmentManager fm = mFilter.getSupportFragmentManager();
                    Bundle bundle = new Bundle();
                    bundle.putString("mFilterItemName", holder.mFilterText.getText().toString());
                    fData.setArguments(bundle);
                    fm.beginTransaction().replace(R.id.filterSelectionFrame, fData).commit();
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mFilterText;

        public MyViewHolder(View view) {
            super(view);
            mFilterText=(TextView)view.findViewById(R.id.singleFilter);


        }
    }
}
