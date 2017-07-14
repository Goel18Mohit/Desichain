package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Karan on 06-07-2017.
 */

public class Wallet_page extends AppCompatActivity {

    private TextView amountTextView;
    private Button shopButton;
    private int amount =2500;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("My Wallet");
        setContentView(R.layout.activity_wallet);

        shopButton = (Button) findViewById(R.id.goShopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wallet_page.this, MainActivity.class);
                startActivity(intent);

            }
        });

        amountTextView =(TextView) findViewById(R.id.walletTextView);
        amountTextView.setText("Amount: ₹"+ amount);
    }
}
