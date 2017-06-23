package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.nitin.desichain.Adapters.AddressAdapter;
import com.example.nitin.desichain.Contents.AddressList;

import java.util.ArrayList;
import java.util.List;

public class MyAddress extends AppCompatActivity implements AddressAdapter.SaveAddress {


    private int POSITION;
    private RecyclerView mRecyclerView;
    private AddressAdapter mAdapter;
    private List<AddressList> mAddressList;
    private Button mAddNewAddress;
    private int REQUEST_CODE_EDIT=000;
    private int REQUEST_CODE_ADD=001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_recycler_view);

        mAddNewAddress = (Button)findViewById(R.id.buttonAddAddress);
        mRecyclerView = (RecyclerView)findViewById(R.id.mAddressRecyclerView);
        mAddressList = new ArrayList<>();
        mAdapter = new AddressAdapter(this,mAddressList);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mAddNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAddress.this,AddNewAddress.class);
                intent.putExtra("REQUESTCODE",REQUEST_CODE_ADD);
                startActivityForResult(intent,REQUEST_CODE_ADD);
            }
        });

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


    @Override
    public void OnEditButtonClicked(int position) {

        POSITION=position;
        Intent intent=new Intent(MyAddress.this,AddNewAddress.class);
        intent.putExtra("REQUESTCODE",REQUEST_CODE_EDIT);
        startActivityForResult(intent,REQUEST_CODE_EDIT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_cart_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.my_cart){

            startActivity(new Intent(MyAddress.this,MyCart.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_EDIT)
        {
            if(data.getBundleExtra("NEW ADDRESS")!=null) {
                mAddressList.remove(POSITION);
                Bundle bundle = data.getBundleExtra("NEW ADDRESS");
                mAddressList.add(POSITION, new AddressList(bundle.getString("CUSTOMERNAME"), bundle.getString("CUSTOMERADDRESS"), bundle.getString("CUSTOMERMOBILE")));
                mAdapter.notifyDataSetChanged();
            }
        }
        else {
            if(data.getBundleExtra("NEW ADDRESS")!=null) {
                Bundle bundle = data.getBundleExtra("NEW ADDRESS");
                mAddressList.add(new AddressList(bundle.getString("CUSTOMERNAME"), bundle.getString("CUSTOMERADDRESS"), bundle.getString("CUSTOMERMOBILE")));
                mAdapter.notifyDataSetChanged();
            }

        }
    }
}
