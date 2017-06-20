package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Utility.Utility;

public class MyAccount extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private TextView editProfileText;
    private LinearLayout mMyOrderLayout,mMyAddressLayout,
            mNotificationLayout,mHelpCenterLayout,
            mRateAppLayout,mFeedBackLayout,mPoliciesLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        mMyOrderLayout = (LinearLayout)findViewById(R.id.myOrderLayout);
        mMyAddressLayout=(LinearLayout)findViewById(R.id.myAddressLayout);
        mNotificationLayout=(LinearLayout)findViewById(R.id.notificationLayout);
        mHelpCenterLayout = (LinearLayout)findViewById(R.id.helpCentreLayout);
        mRateAppLayout =(LinearLayout)findViewById(R.id.rateAppPlayStoreLayout);
        mFeedBackLayout =(LinearLayout)findViewById(R.id.appFeedbackLayout);
        mPoliciesLayout=(LinearLayout)findViewById(R.id.policiesLayout);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        editProfileText = (TextView)findViewById(R.id.editProfileText);

        editProfileText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EditProfile.class));
            }
        });


        mMyOrderLayout.setOnClickListener(this);
        mMyAddressLayout.setOnClickListener(this);
        mNotificationLayout.setOnClickListener(this);
        mHelpCenterLayout.setOnClickListener(this);
        mRateAppLayout.setOnClickListener(this);
        mFeedBackLayout.setOnClickListener(this);
        mPoliciesLayout.setOnClickListener(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.myOrderLayout:
                startActivity(new Intent(this,MyOrders.class));
                break;
            case R.id.myAddressLayout:
                startActivity(new Intent(this,MyAddress.class));
                break;
            case R.id.notificationLayout:
                Toast.makeText(this,"Notifications option selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.helpCentreLayout:
                startActivity(new Intent(this,HelpCentre.class));
                break;
            case R.id.rateAppPlayStoreLayout:
                Toast.makeText(this,"Rate option selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.appFeedbackLayout:
                Toast.makeText(this,"feedback option selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.policiesLayout:
                startActivity(new Intent(this,Policy.class));
                break;
            default:break;

        }
    }
}
