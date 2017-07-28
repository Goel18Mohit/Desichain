package com.example.nitin.desichain;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Location extends AppCompatActivity implements View.OnClickListener {

    private TextView mContinue,mCountryName;
    private LinearLayout mSelectCountryLayout;
    private String strName ;
    private Switch mDetectLocation;
    private String[] countryName = Locale.getISOCountries();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        mSelectCountryLayout=(LinearLayout)findViewById(R.id.selectCountry);
        mContinue =(TextView)findViewById(R.id.submitLocation);
        mDetectLocation=(Switch)findViewById(R.id.detectLocationSwitch);
        mCountryName=(TextView)findViewById(R.id.countryName);

        mContinue.setOnClickListener(this);
        mSelectCountryLayout.setOnClickListener(this);


        mDetectLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mSelectCountryLayout.setEnabled(false);
                    mSelectCountryLayout.setBackgroundColor(Color.parseColor("#d0d0d0"));
                }
                else {
                    mSelectCountryLayout.setEnabled(true);
                    mSelectCountryLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.submitLocation:
                finish();
                break;
            case R.id.selectCountry:
                showDialogBox();
                break;
        }
    }

    private void showDialogBox() {

        AlertDialog.Builder builderCountry = new AlertDialog.Builder(this);
        builderCountry.setTitle("Select your Country");

        final ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice);
        for (String countryCode : countryName){
            Locale locale = new Locale("",countryCode);
            mAdapter.add(locale.getDisplayCountry());
        }

        builderCountry.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });



        builderCountry.setAdapter(mAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                strName = mAdapter.getItem(which);

                dialog.dismiss();


                if (strName!=null || !strName.equals("")){
                    mCountryName.setText(strName);

                }
            }
        });




        builderCountry.show();


    }

}
