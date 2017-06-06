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

import java.util.ArrayList;

public class Others extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<String> others=new ArrayList<>();
    private ArrayList<String> kitchencare=new ArrayList<>();
    private ArrayList<String> laundrycare=new ArrayList<>();
    private ArrayList<String> homecare=new ArrayList<>();
    private ArrayList<String> bedsheets=new ArrayList<>();
    private ArrayList<String> mobilecovers=new ArrayList<>();
    private ArrayList<String> othersothers=new ArrayList<>();
    private ArrayList<String> PersonalCareCategory=new ArrayList<>();
    private ArrayList<String> Cosmetics=new ArrayList<>();
    private ArrayList<String> Oralcare=new ArrayList<>();
    private ArrayList<String> Babycare=new ArrayList<>();
    private ArrayList<String> Haircare=new ArrayList<>();
    private ArrayList<String> Bathbody=new ArrayList<>();
    private ArrayList<String> Combos=new ArrayList<>();
    private ArrayList<String> Miscellaneous=new ArrayList<>();
    private ArrayList<String> handicrafts=new ArrayList<>();
    private ArrayList<String> local_handicraft=new ArrayList<>();
    private ArrayList<String> Paintings=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Others");
        others.add("Kitchen Care");
        others.add("Laundry Care");
        others.add("Home Care");
        others.add("Bed Sheets");
        others.add("Mobile Covers");
        others.add("Others");
        kitchencare.add("Dishwashing Products");
        kitchencare.add("Gas Stove");
        kitchencare.add("Gas Stove");
        laundrycare.add("Detergent Liquid");
        laundrycare.add("Detergent Powder/ Soaps");
        homecare.add("Floor Cleaner");
        bedsheets.add("Double Bedsheets");
        bedsheets.add("Queen Bedsheets");
        bedsheets.add("Single Bedsheets");
        mobilecovers.add("Samsung Note 4");
        mobilecovers.add("Sony Xperia Z1");
        mobilecovers.add("Sony Xperia Z2");
        mobilecovers.add("Xiaomi Redmi 1s");
        othersothers.add("Holi Special");
        othersothers.add("Rangoli Colours");
        PersonalCareCategory.add("Cosmetics/ Skin Care");
        PersonalCareCategory.add("Oral Care");
        PersonalCareCategory.add("Baby Care");
        PersonalCareCategory.add("Hair Care");
        PersonalCareCategory.add("Bath & Body");
        PersonalCareCategory.add("Combos and Kits");
        PersonalCareCategory.add("Miscellaneous");
        Cosmetics.add("Aloe Vera Gel");
        Cosmetics.add("Anti-Wrinkle Cream");
        Cosmetics.add("Face Pack");
        Cosmetics.add("Face Scrub/ Exfoliator");
        Cosmetics.add("Face Wash");
        Cosmetics.add("Kajal/ Surma (Ointment)");
        Cosmetics.add("Lip Salve");
        Cosmetics.add("Moisturizers");
        Cosmetics.add("Other Facial Care Items");
        Cosmetics.add("Shaving Gel/ Cream");
        Cosmetics.add("Sun Protection");
        Cosmetics.add("Turmeric/ Saffron Cream");
        Oralcare.add("Mouthwash");
        Oralcare.add("Tooth Brush");
        Oralcare.add("Tooth Powder (Manjan)");
        Oralcare.add("Toothpaste (For Adults)");
        Oralcare.add("Toothpaste (For Kids)");
        Babycare.add("Baby Soaps");
        Haircare.add("Amla/Almond Oil");
        Haircare.add("Anti Dandruff Shampoos");
        Haircare.add("Coconut Oil");
        Haircare.add("Herbal Oil");
        Haircare.add("Herbal Shampoos");
        Haircare.add("Other Hair Care Items");
        Haircare.add("Other Shampoos");
        Bathbody.add("Ayurvedic Soaps");
        Bathbody.add("Body Lotions");
        Bathbody.add("Herbal Bath Powder (Ubtan)");
        Bathbody.add("Herbal Soaps");
        Bathbody.add("Other Soaps");
        Bathbody.add("Shower Gel/ Cream");
        Combos.add("Gift Packs");
        Miscellaneous.add("Eye/ Ear Care");
        Miscellaneous.add("Eye/ Ear Care");
        Miscellaneous.add("Foot Care Cream");
        Miscellaneous.add("Fruits & Flowers Water");
        Miscellaneous.add("Hand Sanitizers");
        Miscellaneous.add("Hand Wash");
        Miscellaneous.add("Massage Oil/Cream");
        Miscellaneous.add("Ointment (Balms)");
        Miscellaneous.add("Others");
        Miscellaneous.add("Pain Relieve Oil/Creams");
        handicrafts.add("Local Handicrafts");
        handicrafts.add("Paintings/Prints");
        local_handicraft.add("Fancy Envelopes");
        local_handicraft.add("Handlooms");
        local_handicraft.add("Marble");
        local_handicraft.add("Metals/ Glass");
        local_handicraft.add("Others");
        local_handicraft.add("Puppets (Kathputli)");
        local_handicraft.add("Wooden");
        Paintings.add("Art Prints");
        Paintings.add("Canvas");








        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

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
        getMenuInflater().inflate(R.menu.others, menu);
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
        if(id==R.id.pooja_item){
            Intent POOJA_ITEM=new Intent(Others.this,Poojaitems.class);
            startActivity(POOJA_ITEM);

        }

        else if(id==R.id.health_and_food){
            Intent HEALTH_AND_FOOD=new Intent(Others.this,HealthandFood.class);
            startActivity(HEALTH_AND_FOOD);
        }
        else if(id==R.id.others){
            Intent OTHERS=new Intent(Others.this,Others.class);
            startActivity(OTHERS);
        }
        else if(id==R.id.my_account){
            Intent MY_ACCOUNT=new Intent(Others.this,MyAccount.class);
            startActivity(MY_ACCOUNT);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
