package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nitin.desichain.SubSubCateforyFragments.BhagavadGita;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;

public class Poojaitems extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<String> Poojaitem=new ArrayList<>();
    private ArrayList<String> itemsforworship=new ArrayList<>();
    private ArrayList<String> Otheressentials=new ArrayList<>();
    private ArrayList<String> Bells=new ArrayList<>();
    private ArrayList<String> Agarbatti=new ArrayList<>();
    private ArrayList<String> Murtis=new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poojaitems);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PoojaItems");
        Poojaitem.add("Items for Worship");
        Poojaitem.add("Other Essentials");
        Poojaitem.add("Bells");
        Poojaitem.add("Agarbatti/ Dhoop");
        Poojaitem.add("Murtis/ Deities");
        itemsforworship.add("Japa Mala & Bags");
        itemsforworship.add("Mats/ Aasans");
        itemsforworship.add("Other Items");
        itemsforworship.add("Pooja Lamps");
        itemsforworship.add("Pooja Thali");
        itemsforworship.add("Pooja Vessels");
        itemsforworship.add("Sacrifices (Havan) Items");
        itemsforworship.add("Sindoor (Vermilion)");
        itemsforworship.add("Wicks (Batti)");
        Otheressentials.add("Dhoti/ Kurta");
        Otheressentials.add("Kanthi Mala/ Neck Beads");
        Otheressentials.add("Khadaun/ Slippers");
        Otheressentials.add("Scarf/ Chadar");
        Bells.add("Brass");
        Agarbatti.add("Incense Sticks");
        Agarbatti.add("Natural Dhoops");
        Murtis.add("Brass");
        Murtis.add("Mini Temples");
        


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewPager= (ViewPager) findViewById(R.id.viewpagerp);
        tabLayout= (TabLayout) findViewById(R.id.tabp);
        addTabs(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void addTabs(ViewPager viewPager)
    {
        com.example.nitin.desichain.Utility.ViewPager adapter=new com.example.nitin.desichain.Utility.ViewPager(getSupportFragmentManager());
        adapter.addFrag(new BhagavadGita(itemsforworship,Poojaitems.this),"itemsforworship");
        adapter.addFrag(new BhagavadGita(Otheressentials,Poojaitems.this),"Otheressentials");
        adapter.addFrag(new BhagavadGita(Bells,Poojaitems.this),"Bells");
        adapter.addFrag(new BhagavadGita(Agarbatti,Poojaitems.this),"Agarbatti");
        adapter.addFrag(new BhagavadGita(Murtis,Poojaitems.this),"Murtis");

        viewPager.setAdapter(adapter);

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
        getMenuInflater().inflate(R.menu.poojaitems, menu);
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

        Utility.openIntent(this,id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
