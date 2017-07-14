package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.FilterFragmentDataContent;
import com.example.nitin.desichain.FilterFragmentData;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 7/13/2017.
 */

public class FilterSelectionDataAdapter extends RecyclerView.Adapter<FilterSelectionDataAdapter.MyViewholder> {

    private List<FilterFragmentDataContent> mList;
    private Context mContext;

    public FilterSelectionDataAdapter(List<FilterFragmentDataContent> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }



    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_selection_data,null);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {

        holder.mNameText.setText(mList.get(position).getName());
        holder.mChkSelected.setChecked(mList.get(position).isSelected());
        holder.mChkSelected.setTag(mList.get(position));

        holder.mChkSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        private TextView mNameText;
        private CheckBox mChkSelected;


        public MyViewholder(View itemView) {
            super(itemView);


            mNameText=(TextView)itemView.findViewById(R.id.tvName);
            mChkSelected=(CheckBox)itemView.findViewById(R.id.chkSelected);

        }
    }

    public List<FilterFragmentDataContent> getItemsList(){

        return mList;
    }
}
