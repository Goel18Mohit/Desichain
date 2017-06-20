package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

/**
 * Created by ashis on 6/20/2017.
 */

public class AddNewAddress extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_address);

        Spinner mSpinner = (Spinner)findViewById(R.id.spinner_select_state);
        mSpinner.setPrompt("Select State");
    }
}
