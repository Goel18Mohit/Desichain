package com.example.nitin.desichain;

import android.content.Intent;
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

/**
 * Created by ashis on 6/20/2017.
 */

public class AddNewAddress extends AppCompatActivity {


    TextInputEditText name,pincode,address,landmark,city,mobile;
    String state[] = {"Select your state",
            "Andaman and Nicobar Islands",
            "Andhra Pradesh",
            "Arunachal Pradesh",
            "Assam",
        "Bihar",
        "Chandigarh",
        "Chhattisgarh",
        "Dadra and Nagar Haveli",
        "Daman and Diu",
        "Delhi",
        "Goa",
        "Gujrat",
        "Haryana",
        "Himachal Pradesh",
        "Jammu and Kashmir",
        "Jharkand",
        "Karnataka",
        "Kerala",
        "Lakshadweep",
        "Madhya Pradesh",
        "Maharashtra",
        "Manipur",
        "Meghalaya",
        "Mizoram",
        "Nagaland",
        "Orissa",
        "Pondicherry",
        "Punjab",
        "Rajasthan",
        "Sikkim",
        "Tamil Nadu",
        "Telangana",
        "Tripura",
        "Uttar Pradesh",
        "Uttarakhand",
        "West Bengal"};
    private Spinner spinner;
    private Toolbar mToolbar;
    Button save;
    ArrayList<String> statelist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_new_address);

        
        mToolbar=(Toolbar)findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);


        spinner=(Spinner)findViewById(R.id.spinner_select_state);
        ArrayAdapter<CharSequence> mAdapter = new ArrayAdapter<CharSequence>(AddNewAddress.this,android.R.layout.simple_spinner_dropdown_item,state);
        spinner.setAdapter(mAdapter);

        final int position=getIntent().getIntExtra("REQUESTCODE",000);
   //     String mCustName = getIntent().getStringExtra("mCustName");
     //   String mCustAdd = getIntent().getStringExtra("mCustAdd");
        name= (TextInputEditText) findViewById(R.id.edit_name);
        pincode= (TextInputEditText) findViewById(R.id.edit_pincode);
        address= (TextInputEditText) findViewById(R.id.edit_address);
        landmark= (TextInputEditText) findViewById(R.id.edit_landmark);
        city=(TextInputEditText) findViewById(R.id.edit_city);
        mobile= (TextInputEditText) findViewById(R.id.edit_mobile);
        save= (Button) findViewById(R.id.btnSaveAddress);
        final Spinner mSpinner = (Spinner)findViewById(R.id.spinner_select_state);



        statelist =new ArrayList<>();
        statelist.add("DELHI");
        statelist.add("haryana");
        statelist.add("punjab");


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
