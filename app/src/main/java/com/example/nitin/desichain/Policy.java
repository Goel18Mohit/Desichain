package com.example.nitin.desichain;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Policy extends AppCompatActivity {

    private LinearLayout returnPolicyLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        returnPolicyLayout = (LinearLayout)findViewById(R.id.return_policy_layout);
        returnPolicyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment returnFragment = new Fragment();
            }
        });
    }
}
