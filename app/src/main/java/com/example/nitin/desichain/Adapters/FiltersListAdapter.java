package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.FilterFragmentData;
import com.example.nitin.desichain.Filters;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/29/2017.
 */

public class FiltersListAdapter extends RecyclerView.Adapter<FiltersListAdapter.MyViewHolder> {

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
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String filterText = mList.get(position);
        holder.mFilterText.setText(filterText);

        holder.mFilterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FilterFragmentData fData = new FilterFragmentData();
                Toast.makeText(mContext,"fragment Called",Toast.LENGTH_SHORT).show();
                Filters mFilter = (Filters)mContext;
                FragmentManager fm = mFilter.getSupportFragmentManager();
                fm.beginTransaction().add(R.id.filterSelectionFrame,fData).commit();

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
