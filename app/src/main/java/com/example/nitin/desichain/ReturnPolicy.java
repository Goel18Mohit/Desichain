package com.example.nitin.desichain;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReturnPolicy extends Fragment {

    private TextView text_ques1,text_ques2,text_ques3,text_ques4,text_ques5,text_ques6,text_ques7,text_ques8;

    public ReturnPolicy() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_policy,container);
        text_ques1=(TextView)view.findViewById(R.id.ques1_return_policy);
        text_ques2=(TextView)view.findViewById(R.id.ques2_return_policy);
        text_ques3=(TextView)view.findViewById(R.id.ques3_return_policy);
        text_ques4=(TextView)view.findViewById(R.id.ques4_return_policy);
        text_ques5=(TextView)view.findViewById(R.id.ques5_return_policy);
        text_ques6=(TextView)view.findViewById(R.id.ques6_return_policy);
        text_ques7=(TextView)view.findViewById(R.id.ques7_return_policy);
        text_ques8=(TextView)view.findViewById(R.id.ques8_return_policy);

        addTextToTextView();
        return view;
    }

    private void addTextToTextView() {

        text_ques1.setText(getString(R.string.ans1));
        text_ques2.setText(getString(R.string.ans2));
        text_ques3.setText(getString(R.string.ans3));
        text_ques4.setText(getString(R.string.ans4));
        text_ques5.setText(getString(R.string.ans5));
        text_ques6.setText(getString(R.string.ans6));
        text_ques7.setText(getString(R.string.ans7));
        text_ques8.setText(getString(R.string.ans8));

    }

}
