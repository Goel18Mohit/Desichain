package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.SingleQuesMultipleAnswer;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/23/2017.
 */

public class SingleQuesMultiAnsAdapter extends RecyclerView.Adapter<SingleQuesMultiAnsAdapter.MyViewHolder> {

    private Context mContext;
    private List<SingleQuesMultipleAnswer> mAnsList;

    public SingleQuesMultiAnsAdapter(Context mContext, List<SingleQuesMultipleAnswer> mAnsList) {
        this.mContext = mContext;
        this.mAnsList = mAnsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_qeus_multiple_answer_layout,parent,false);
        return
                new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        SingleQuesMultipleAnswer ques = mAnsList.get(position);
        holder.mAns.setText(ques.getmAns());
        holder.mDate.setText(ques.getmDate());
        holder.mSellerName.setText(ques.getmSellerName());

    }

    @Override
    public int getItemCount() {
        return mAnsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mAns,mSellerName,mDate;

        public MyViewHolder(View itemView) {
            super(itemView);

            mAns=(TextView)itemView.findViewById(R.id.singleAnswer);
            mSellerName=(TextView)itemView.findViewById(R.id.singleSellerName);
            mDate=(TextView)itemView.findViewById(R.id.mSingleDate);
        }
    }
}
