package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nitin.desichain.Adapters.QuestionAnsAdapter;
import com.example.nitin.desichain.Contents.QuestionAnswer;

import java.util.ArrayList;
import java.util.List;

public class QuestionandAnser extends AppCompatActivity {

    private RecyclerView mQuesAnsView;
    private QuestionAnsAdapter mAdapter;
    private List<QuestionAnswer> mQuesAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionand_anser);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mQuesAnswers=new ArrayList<>();
        mQuesAnsView=(RecyclerView)findViewById(R.id.quesAnswerView);
        mAdapter=new QuestionAnsAdapter(this,mQuesAnswers);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        mQuesAnsView.setLayoutManager(lm);
        mQuesAnsView.setItemAnimator(new DefaultItemAnimator());
        mQuesAnsView.setAdapter(mAdapter);

        prepareItems();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void prepareItems() {

        mQuesAnswers.add(new QuestionAnswer("Q. If we buy only this product what is the shipping chage?",
                "A: A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));


        mQuesAnswers.add(new QuestionAnswer("Q. If we buy only this product what is the shipping chage?",
                "A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

        mQuesAnswers.add(new QuestionAnswer("Q. If we buy only this product what is the shipping chage?",
                "A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

        mQuesAnswers.add(new QuestionAnswer("Q. If we buy only this product what is the shipping chage?",
                "A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));
        mQuesAnswers.add(new QuestionAnswer("Q. If we buy only this product what is the shipping chage?",
                "A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

        mQuesAnswers.add(new QuestionAnswer("Q. If we buy only this product what is the shipping chage?",
                "A minimum total of Rs 499 for items",
                "Kutuhal and OiDeal",
                "10 months ago"));

    }

}
