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
import com.example.nitin.desichain.SubSubCateforyFragments.Media;
import com.example.nitin.desichain.SubSubCateforyFragments.PaperBack;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;

public class BookandMedia extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
       private ArrayList<String> Books=new ArrayList<>();
    private ArrayList<String> BhagavadGita=new ArrayList<>();
    private ArrayList<String> Paperback=new ArrayList<>();
    private ArrayList<String> Mediacategory=new ArrayList<>();
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookand_media);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("BOOKS & MEDIA");
        Books.add("Bhagavad-Gita As It Is");
        Books.add("Paperback/ Hardbound");
        Books.add("Media");
        BhagavadGita.add("Bengali");
        BhagavadGita.add("Chinese");
        BhagavadGita.add("English");
        BhagavadGita.add("Gujarati");
        BhagavadGita.add("Hindi");
        BhagavadGita.add("Kannada");
        BhagavadGita.add("Malayalam");
        BhagavadGita.add("Marathi");
        BhagavadGita.add("Nepali");
        BhagavadGita.add("Oriya");
        BhagavadGita.add("Punjabi");
        BhagavadGita.add("Russian");
        BhagavadGita.add("Sindhi");
        BhagavadGita.add("Tamil");
        BhagavadGita.add("Telugu");
        BhagavadGita.add("Urdu");
        Paperback.add("Astrology");
        Paperback.add("Ayurveda");
        Paperback.add("Ayurveda & Health");
        Paperback.add("Biography");
        Paperback.add("Children");
        Paperback.add("Classic Text");
        Paperback.add("Cooking & Vegetarianism");
        Paperback.add("Cow Protection");
        Paperback.add("Language Learning");
        Paperback.add("Personal Growth");
        Paperback.add("Philosophy");
        Paperback.add("Re-Incarnation");
        Paperback.add("Religious/ Spiritual");
        Paperback.add("Science");
        Paperback.add("Travel & Pilgrimage");
        Paperback.add("Vedic/ Indian Culture");
        Paperback.add("Yoga and Meditation");
        Paperback.add("Magazines");
        Mediacategory.add("Animation Movies");
        Mediacategory.add("Independent Cinema");
        Mediacategory.add("Kirtans/Bhajans");
        Mediacategory.add("Lectures/ Talks");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        tabLayout= (TabLayout) findViewById(R.id.tab);
        addTabs(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void addTabs(ViewPager viewPager)
    {
        com.example.nitin.desichain.Utility.ViewPager adapter=new com.example.nitin.desichain.Utility.ViewPager(getSupportFragmentManager());
        adapter.addFrag(new BhagavadGita(BhagavadGita,BookandMedia.this),"BhagavadGita");
        adapter.addFrag(new PaperBack(Paperback,BookandMedia.this),"PaperBack");
        adapter.addFrag(new Media(Mediacategory,BookandMedia.this),"Media");
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
        getMenuInflater().inflate(R.menu.bookand_media, menu);
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
