package com.example.nitin.desichain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by ashis on 6/20/2017.
 */

public class AddNewAddress extends AppCompatActivity {


    private String[] countryName = Locale.getISOCountries();


    TextInputEditText name,pincode,address,landmark,city,mobile,state;
    private Spinner spinner, countrySpinner;
    private Toolbar mToolbar;
    Button save;
    ArrayList<String> statelist;

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkForEmptyValues();
        }
    };

    private void checkForEmptyValues() {

        String nameString = name.getText().toString();
        String pincodeString = pincode.getText().toString();
        String addressString = address.getText().toString();
        String mobileString = mobile.getText().toString();
        String cityString = city.getText().toString();
        String stateString = state.getText().toString();

        if (nameString.equals("") || pincodeString.equals("")||addressString.equals("")||mobileString.equals("")||cityString.equals("")||stateString.equals("")){
            save.setEnabled(false);
        }else {
            save.setEnabled(true);
            save.setBackgroundColor(getResources().getColor(R.color.green));
            save.setTextColor(Color.WHITE);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_new_address);

        
        mToolbar=(Toolbar)findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);



        countrySpinner=(Spinner) findViewById(R.id.spinner_select_country);
        final ArrayAdapter<String> mAdapterCountry = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item);
        mAdapterCountry.add("Select Country");
        for (String countryCode : countryName){
            Locale locale = new Locale("",countryCode);
            mAdapterCountry.add(locale.getDisplayCountry());
        }
        countrySpinner.setAdapter(mAdapterCountry);
        final int position=getIntent().getIntExtra("REQUESTCODE",000);
        name= (TextInputEditText) findViewById(R.id.edit_name);
        pincode= (TextInputEditText) findViewById(R.id.edit_pincode);
        address= (TextInputEditText) findViewById(R.id.edit_address);
        landmark= (TextInputEditText) findViewById(R.id.edit_landmark);
        city=(TextInputEditText) findViewById(R.id.edit_city);
        mobile= (TextInputEditText) findViewById(R.id.edit_mobile);
        save= (Button) findViewById(R.id.btnSaveAddress);
        state= (TextInputEditText) findViewById(R.id.edit_state);



        name.addTextChangedListener(mTextWatcher);
        pincode.addTextChangedListener(mTextWatcher);
        address.addTextChangedListener(mTextWatcher);
        city.addTextChangedListener(mTextWatcher);
        mobile.addTextChangedListener(mTextWatcher);
        state.addTextChangedListener(mTextWatcher);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameString = name.getText().toString();
                String pincodeString = pincode.getText().toString();
                String addressString = address.getText().toString();
                String cityString = city.getText().toString();
                String mobileString = mobile.getText().toString();

                if (!nameString.isEmpty() && !pincodeString.isEmpty() &&
                        !addressString.isEmpty() && !cityString.isEmpty()
                        && !mobileString.isEmpty()) {

                    final Bundle bundle = new Bundle();
                    bundle.putString("CUSTOMERNAME", name.getText().toString());
                    bundle.putString("CUSTOMERPINCODE", pincode.getText().toString());
                    bundle.putString("CUSTOMERADDRESS", address.getText().toString());
                    bundle.putString("CUSTOMERLANDMARK", landmark.getText().toString());
                    bundle.putString("CUSTOMERCITY", city.getText().toString());
                    bundle.putString("CUSTOMERMOBILE", mobile.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("NEW ADDRESS", bundle);
                    if (position == 000) {
                        setResult(000, intent);
                    } else {
                        setResult(001, intent);
                    }
                    ;
                    finish();
                }
                else {

                    if (nameString.isEmpty()){
                        name.setError("please enter your name");
                    }


                    if (pincodeString.isEmpty()){
                        pincode.setError("Please enter pincode");
                    }
                    else if (pincodeString.length()!=6){
                        pincode.setError("Enter proper pincode");
                    }
                    if (addressString.isEmpty()){
                        address.setError("please enter your address");
                    }
                    if (cityString.isEmpty()){
                        city.setError("please enter your city");
                    }
                    if (mobileString.isEmpty()){
                        mobile.setError("please enter your mobile");
                    }
                    else  if (mobileString.length()!=10){
                        mobile.setError("Enter proper mobile no");
                    }
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(AddNewAddress.this,MyAddress.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
