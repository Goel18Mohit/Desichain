package com.example.nitin.desichain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.AddressAdapter;
import com.example.nitin.desichain.Contents.AddressList;

import java.util.ArrayList;
import java.util.List;

public class SelectAddress extends AppCompatActivity {

    private RecyclerView mSelectAddressView;
    private List<AddressList> mAddressList;
    private AddressAdapter mAdapter;
    private TextView mSelectAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);

        int FLAG = getIntent().getIntExtra("flagIntent",0);
        mSelectAddress=(TextView) findViewById(R.id.btnSelectAddress);
        mSelectAddressView=(RecyclerView)findViewById(R.id.selectAddressView);
        mAddressList =new ArrayList<>();
        mAdapter=new AddressAdapter(this, mAddressList,FLAG);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mSelectAddressView.setLayoutManager(lm);
        mSelectAddressView.setItemAnimator(new DefaultItemAnimator());
        mSelectAddressView.setAdapter(mAdapter);
        prepareItems();

        mSelectAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void prepareItems() {

        mAddressList.add(new AddressList("ashish","WQDWQ jaoias aspp","984515618"));
        mAddressList.add(new AddressList("qwqwq","2013 DWDWQWQjaoias aspp","93484515618"));
        mAddressList.add(new AddressList("qwfwqqwf","2013 jaoWDDQWQias aspp","95384515618"));
        mAddressList.add(new AddressList("sdvdsvds","2013 jaoiasASDDAS aspp","984515618"));
        mAddressList.add(new AddressList("saSSA","2013 jaoias asppACS","92284515618"));
        mAddressList.add(new AddressList("BRRR","2013 jaoias aspp","98451565318"));

    }
}
