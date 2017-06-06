package com.example.nitin.desichain;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NITIN on 05-Jun-17.
 */

public class CategoryList extends RecyclerView.Adapter<CategoryList.Myviewholder> {

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Myviewholder extends RecyclerView.ViewHolder{

        public Myviewholder(View itemView) {
            super(itemView);
        }
    }
}
