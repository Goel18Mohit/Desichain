package com.example.nitin.desichain;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.SingleQuesMultiAnsAdapter;
import com.example.nitin.desichain.Contents.SingleQuesMultipleAnswer;

import java.util.ArrayList;
import java.util.List;

public class SingleQuesMultiAnswerList extends AppCompatActivity {

    private RecyclerView mSingleQuesMultiAnsView;
    private SingleQuesMultiAnsAdapter mAdapter;
    private List<SingleQuesMultipleAnswer> mList;
    private TextView mAnswerQues;
    private FrameLayout mAnswerQuesFrame;
    private Button mCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_answer_list);

        mCancelBtn=(Button)findViewById(R.id.cancelAnswer);
        mAnswerQues=(TextView)findViewById(R.id.answerQues);
        mAnswerQuesFrame=(FrameLayout)findViewById(R.id.answerQuesFrame);
        mList=new ArrayList<>();
        mAdapter = new SingleQuesMultiAnsAdapter(this,mList);
        mSingleQuesMultiAnsView=(RecyclerView)findViewById(R.id.mSinglequesAnswerList);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mSingleQuesMultiAnsView.setLayoutManager(lm);
        mSingleQuesMultiAnsView.setItemAnimator(new DefaultItemAnimator());
        mSingleQuesMultiAnsView.setAdapter(mAdapter);

        prepareItems();

        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnswerQues.setTextColor(getResources().getColor(R.color.blue));
                mAnswerQuesFrame.setVisibility(View.GONE);
            }
        });

        mAnswerQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAnswerQues.setTextColor(Color.BLACK);
                mAnswerQuesFrame.setVisibility(View.VISIBLE);



            }
        });
    }

    private void prepareItems() {

        mList.add(new SingleQuesMultipleAnswer("A: A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

        mList.add(new SingleQuesMultipleAnswer("A: A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

        mList.add(new SingleQuesMultipleAnswer("A: A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

        mList.add(new SingleQuesMultipleAnswer("A: A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

        mList.add(new SingleQuesMultipleAnswer("A: A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));


    }
}
