package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nitin.desichain.Adapters.NotificationAdapter;
import com.example.nitin.desichain.Adapters.OrderAdapter;
import com.example.nitin.desichain.Contents.Notifications;
import com.example.nitin.desichain.Contents.Orders;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karan on 04-07-2017.
 */

public class NotificationPage extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Notifications> mNotifications;
    private NotificationAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mRecyclerView = (RecyclerView) findViewById(R.id.notificationRecyclerView);
        mNotifications = new ArrayList<>();
        mAdapter = new NotificationAdapter(this, mNotifications);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareItems();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
     /*   ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();*/


    }

    private void prepareItems() {
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));
        mNotifications.add(new Notifications("Fly High, Monsoon Deals are Here!", R.mipmap.ic_launcher));

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

}
