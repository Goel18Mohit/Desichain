package com.example.nitin.desichain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nitin.desichain.Adapters.AddressAdapter;
import com.example.nitin.desichain.Contents.AddressList;

import java.util.ArrayList;
import java.util.List;

public class MyAddress extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private AddressAdapter mAdapter;
    private List<AddressList> mAddressList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_recycler_view);

        mRecyclerView = (RecyclerView)findViewById(R.id.mAddressRecyclerView);
        mAddressList = new ArrayList<>();
        mAdapter = new AddressAdapter(this,mAddressList);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareItems();
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
