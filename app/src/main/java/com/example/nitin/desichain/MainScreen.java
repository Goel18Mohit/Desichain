package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

public class MainScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=2000;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        frameLayout= (FrameLayout) findViewById(R.id.activity_main_screen);
        frameLayout.setBackgroundColor(getResources().getColor(R.color.darkgreen));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
