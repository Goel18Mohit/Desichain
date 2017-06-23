package com.example.nitin.desichain.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Contents.QuestionAnswer;
import com.example.nitin.desichain.SingleQuesMultiAnswerList;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/23/2017.
 */

public class QuestionAnsAdapter extends RecyclerView.Adapter<QuestionAnsAdapter.MyViewHolder> {

    private Context mContext;
    private List<QuestionAnswer> mQuesList;

    public QuestionAnsAdapter(Context mContext, List<QuestionAnswer> mQuesList) {
        this.mContext = mContext;
        this.mQuesList = mQuesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_qna_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        QuestionAnswer mQnA = mQuesList.get(position);
        holder.mQues.setText(mQnA.getmQues());
        holder.mAns.setText(mQnA.getmAns());
        holder.mSellerName.setText(mQnA.getmSellerName());
        holder.mDate.setText(mQnA.getmDate());
        holder.mQuesAnsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                c.startActivity(new Intent(c, SingleQuesMultiAnswerList.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mQuesList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mQues,mAns,mSellerName,mDate;
        private LinearLayout mQuesAnsLayout;

        public MyViewHolder(View view) {
            super(view);
            mQuesAnsLayout=(LinearLayout)view.findViewById(R.id.singleQuesLayout);
            mQues=(TextView)view.findViewById(R.id.ques);
            mAns=(TextView)view.findViewById(R.id.answer);
            mSellerName=(TextView)view.findViewById(R.id.sellerName);
            mDate=(TextView)view.findViewById(R.id.mDate);



        }
    }
}
