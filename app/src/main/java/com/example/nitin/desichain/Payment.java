package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Payment extends AppCompatActivity {


    private RadioGroup radioGroup;
    private Button submit;
    RadioButton bankdeposit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        submit=(Button)findViewById(R.id.continueBtn);
        radioGroup=(RadioGroup)findViewById(R.id.paymentRadiogroup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bankdeposit= (RadioButton) findViewById(R.id.bankdeposit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                if (id == bankdeposit.getId()){
                    startActivity(new Intent(Payment.this,BankDeposit.class));
                }
            }
        });
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
