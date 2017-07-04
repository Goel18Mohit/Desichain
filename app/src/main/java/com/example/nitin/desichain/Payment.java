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
import android.widget.Toast;

public class Payment extends AppCompatActivity {



    RadioButton PaymentRadioButton,bankdeposit;
    Button PaymentContinue;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        bankdeposit=(RadioButton)findViewById(R.id.bankdeposit);
        PaymentContinue= (Button) findViewById(R.id.paymentcontinue);
        radioGroup= (RadioGroup) findViewById(R.id.paymentradio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PaymentContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PaymentRadioButton= (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                Toast.makeText(Payment.this,String.valueOf(radioGroup.getCheckedRadioButtonId()),Toast.LENGTH_SHORT).show();
                if(radioGroup.getCheckedRadioButtonId()==R.id.bankdeposit)
                {
                    //Toast.makeText(Payment.this,String.valueOf(radioGroup.getCheckedRadioButtonId()+1),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Payment.this,BankDeposit.class);
                    startActivity(intent);
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
