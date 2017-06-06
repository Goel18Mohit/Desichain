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

public class HealthandFood extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<String> Healthandfood=new ArrayList<>();
    private ArrayList<String> Foodsupplement=new ArrayList<>();
    private ArrayList<String> HerbalTea=new ArrayList<>();
    private ArrayList<String> Ghee=new ArrayList<>();
    private ArrayList<String> Miscellaneous=new ArrayList<>();
    private ArrayList<String> Snacks=new ArrayList<>();
    private ArrayList<String> Cowproducts=new ArrayList<>();
    private ArrayList<String> Digestives=new ArrayList<>();
    private ArrayList<String> Grains=new ArrayList<>();
    private ArrayList<String> Spices=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthand_food);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Health & Food");
        Healthandfood.add("Food Supplements");
        Healthandfood.add("Herbal Tea/ Coffee");
        Healthandfood.add("Clarified Butter/ Ghee");
        Healthandfood.add("Miscellaneous");
        Healthandfood.add("Snacks");
        Healthandfood.add("Cow Products");
        Healthandfood.add("Digestives");
        Healthandfood.add("Grains (& flours)");
        Healthandfood.add("Spices (Masalas)");
        Foodsupplement.add("Candy");
        Foodsupplement.add("Chyawanprash/ Rasayan");
        Foodsupplement.add("Honey");
        Foodsupplement.add("Juices/ Ras");
        Foodsupplement.add("Murabba");
        Foodsupplement.add("Syrup/ Sharbat");
        Foodsupplement.add("Tonic/ Pak");
        HerbalTea.add("Chamomile/Cinnamon Tea");
        HerbalTea.add("Lemon/ Masala/ Mint Tea");
        HerbalTea.add("Other Herbal Tea/ Coffee");
        HerbalTea.add("Saffron Rich Tea");
        HerbalTea.add("Tridosha Tea");
        Ghee.add("Ayurvedic Desi Healthy Ghee");
        Ghee.add("Nasal Drops (Ayurghee)");
        Ghee.add("Regular Desi Ghee (Milk Fat)");
        Miscellaneous.add("Chikkis- Pattis");
        Miscellaneous.add("Instant food (Ready to Cook meal)\n" +
                "Others");
        Miscellaneous.add("Packaged Sweets");
        Miscellaneous.add("Pickles");
        Miscellaneous.add("Salt, Sugar & Jaggery");
        Snacks.add("Biscuits/ Cookies");
        Snacks.add("Namkeen");
        Snacks.add("Others");
        Snacks.add("Peanuts");
        Cowproducts.add("Ghanavati");
        Cowproducts.add("Go Ark");
        Cowproducts.add("Go Mutra");
        Digestives.add("Hing Goli");
        Digestives.add("Others");
        Digestives.add("Pachaks");
        Grains.add("Daliya");
        Grains.add("Others");
        Spices.add("Ground Spices");
        Spices.add("Whole Spices");
        









        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
        getMenuInflater().inflate(R.menu.healthand_food, menu);
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
            Intent POOJA_ITEM=new Intent(HealthandFood.this,Poojaitems.class);
            startActivity(POOJA_ITEM);

        }

        else if(id==R.id.health_and_food){
            Intent HEALTH_AND_FOOD=new Intent(HealthandFood.this,HealthandFood.class);
            startActivity(HEALTH_AND_FOOD);
        }
        else if(id==R.id.others){
            Intent OTHERS=new Intent(HealthandFood.this,Others.class);
            startActivity(OTHERS);
        }
        else if(id==R.id.my_account){
            Intent MY_ACCOUNT=new Intent(HealthandFood.this,MyAccount.class);
            startActivity(MY_ACCOUNT);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
