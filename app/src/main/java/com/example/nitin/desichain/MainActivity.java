package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity{

    private ExpandableListView listView;
    ArrayList<CategoryHolder> arrayList;
    public ArrayList<String> Books;
    ArrayList<String> Poojaitem;
    ArrayList<String> Healthandfood;
    ArrayList<String> others;
    HashMap<String,ArrayList<String>> hashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiaze();
        add();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(getApplicationContext(),"onDrawerOPened",Toast.LENGTH_SHORT).show();
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        listView= (ExpandableListView)navigationView.findViewById(R.id.parentcategoryList);
        navigationCategoryList();

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
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void add()
    {
        arrayList.add(new CategoryHolder("BOOK AND MEDIA",0));
        arrayList.add(new CategoryHolder("PoojaItem",0));
        arrayList.add(new CategoryHolder("Health and food",0));
        arrayList.add(new CategoryHolder("Others",0));
        Books.add("Bhagavad-Gita As It Is");
        Books.add("Paperback/ Hardbound");
        Books.add("Media");
        Poojaitem.add("Items for Worship");
        Poojaitem.add("Other Essentials");
        Poojaitem.add("Bells");
        Poojaitem.add("Agarbatti/ Dhoop");
        Poojaitem.add("Murtis/ Deities");
        Healthandfood.add("Food Supplements");
        Healthandfood.add("Herbal Tea/ Coffee");
        Healthandfood.add("Clarified Butter/ Ghee");
        Healthandfood.add("Miscellaneous");
        Healthandfood.add("Snacks");
        Healthandfood.add("Cow Products");
        Healthandfood.add("Digestives");
        Healthandfood.add("Grains (& flours)");
        Healthandfood.add("Spices (Masalas)");
        others.add("Kitchen Care");
        others.add("Laundry Care");
        others.add("Home Care");
        others.add("Bed Sheets");
        others.add("Mobile Covers");
        others.add("Others");
        others.add("PersonalCareCategory");
        others.add("Cosmetics");
        others.add("Oralcare");
        others.add("Babycare");
        others.add("Haircare");
        others.add("Bathbody");
        others.add("Combos");
        others.add("Miscellaneous");
        others.add("handicrafts");
        others.add("local_handicraft");
        others.add("Paintings");
        hashMap.put(arrayList.get(0).getPARENTCATEGORY(),Books);
        hashMap.put(arrayList.get(1).getPARENTCATEGORY(),Poojaitem);
        hashMap.put(arrayList.get(2).getPARENTCATEGORY(),Healthandfood);
        hashMap.put(arrayList.get(3).getPARENTCATEGORY(),others);
    }

    public void initiaze(){
        arrayList=new ArrayList<>();
        hashMap=new HashMap<>();
        Books=new ArrayList<>();
        Poojaitem=new ArrayList<>();
        Healthandfood=new ArrayList<>();
        others=new ArrayList<>();

    }
    public void navigationCategoryList(){
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(MainActivity.this,arrayList,hashMap,listView);
        listView.setAdapter(showCategoryAdapeter);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if(arrayList.get(groupPosition).getFLAG_INDICATOR()==1)
                {
                    listView.collapseGroup(groupPosition);
                    arrayList.get(groupPosition).setFLAG_INDICATOR(0);

                }
                else{
                    for(int i=0;i<arrayList.size();i++)
                    {
                        if(arrayList.get(i).getFLAG_INDICATOR()==1)
                        {
                            listView.collapseGroup(i);
                            arrayList.get(i).setFLAG_INDICATOR(0);
                        }

                    }
                    listView.expandGroup(groupPosition);
                    arrayList.get(groupPosition).setFLAG_INDICATOR(1);

                }
                return true;
            }
        });

    }
}
