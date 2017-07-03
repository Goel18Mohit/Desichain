package com.example.nitin.desichain;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAccount extends AppCompatActivity
        implements View.OnClickListener {

    int flag=0;
    private TextView editProfileText,CUSTOMER_FIRST_LETTER_NAME;
    private String CUSTOMERNAMEFIRSTLETTER;
    private LinearLayout mMyOrderLayout,mMyAddressLayout,
            mNotificationLayout,mHelpCenterLayout,
            mRateAppLayout,mFeedBackLayout,mPoliciesLayout;

    LinearLayout LOGOUT,RESET;
    EditText USER_EMAIL_ID;
    EditText CUSTOMER_NAME;
    TextView CUSTOMERFATEOFBIRTH;
    String CUSTOMERNAME;
    private int mYear,mMonth,mDate;
    Calendar calendar;

    private Helper listView;
    View headerView;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
    public static ArrayList<String> Poojaitem;
    public  static ArrayList<CategoryHolder> arrayList;
    public static  ArrayList<String> Books;
    public static ArrayList<String> Homecare;
    public static   ArrayList<String> others;
    public  static HashMap<String,ArrayList<String>> hashMap;
    LinearLayout myorder,mycart,myaccount,helpcenter,ratedesichain,productPage,policy,facebook,google,twitter,pinterest,youtube,instagram,aboutus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();



        mMyOrderLayout = (LinearLayout)findViewById(R.id.myOrderLayout);
        mMyAddressLayout=(LinearLayout)findViewById(R.id.myAddressLayout);
        mNotificationLayout=(LinearLayout)findViewById(R.id.notificationLayout);
        mHelpCenterLayout = (LinearLayout)findViewById(R.id.helpCentreLayout);
        mRateAppLayout =(LinearLayout)findViewById(R.id.rateAppPlayStoreLayout);
        mFeedBackLayout =(LinearLayout)findViewById(R.id.appFeedbackLayout);
        mPoliciesLayout=(LinearLayout)findViewById(R.id.policiesLayout);
       CUSTOMER_FIRST_LETTER_NAME= (TextView) findViewById(R.id.customerfirstlettername);
        if(intent!=null)
        {
            flag=intent.getIntExtra("FLAGSTATUS",0);
            if(flag==121) {
                CUSTOMERNAMEFIRSTLETTER = intent.getStringExtra("CUSTOMERNAME").toString();
                CUSTOMER_FIRST_LETTER_NAME.setText(String.valueOf(CUSTOMERNAMEFIRSTLETTER.charAt(0)));

            }
        }



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


        LOGOUT= (LinearLayout) findViewById(R.id.logout);
        RESET= (LinearLayout) findViewById(R.id.reset);
        CUSTOMER_NAME= (EditText) findViewById(R.id.editcustomerNameText);
        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAccount.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        RESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder alertDialog=new AlertDialog.Builder(MyAccount.this);
                alertDialog.setTitle("Reset Password");
                alertDialog.setMessage("Your Email Id");
                USER_EMAIL_ID=new EditText(MyAccount.this);
                alertDialog.setView(USER_EMAIL_ID);
                alertDialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(USER_EMAIL_ID.getText().toString().isEmpty())
                        {

                            USER_EMAIL_ID.setError("field cant be empty");
                        }
                        else {
                            dialog.dismiss();
                            Toast.makeText(MyAccount.this, "Email has been seet", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.create().show();

            }
        });
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //drawer.setDrawerListener(toggle);
        // toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        refferencetonavigationcategory(navigationView);
        nestedScrollView= (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView= (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();
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
        getMenuInflater().inflate(R.menu.my_cart_menu, menu);
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
        else if (id==R.id.my_cart){
            startActivity(new Intent(MyAccount.this,MyCart.class));
        }

        return super.onOptionsItemSelected(item);
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
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:ashish.chaudhary@softroneretail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject line");
                if (emailIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(emailIntent);
                }                break;
            case R.id.policiesLayout:
                startActivity(new Intent(this,Policy.class));
                break;
            default:new Utility().openIntent(this,v.getId());
                break;

        }
    }
    public void add()
    {
        arrayList.add(new CategoryHolder("Book and media",0));
        arrayList.add(new CategoryHolder("Pooja Item",0));
        arrayList.add(new CategoryHolder("Home Care",0));
        arrayList.add(new CategoryHolder("Others",0));
        Books.add("Bhagavad-Gita As It Is");
        Books.add("Paperback/ Hardbound");
        Books.add("Media");
        Poojaitem.add("Items for Worship");
        Poojaitem.add("Other Essentials");
        Poojaitem.add("Bells");
        Poojaitem.add("Agarbatti/ Dhoop");
        Poojaitem.add("Murtis/ Deities");
        Homecare.add("Home Decor");
        Homecare.add("Home Furnishing");
        Homecare.add("Kitchen n Dinning");
        others.add("Personal Care");
        others.add("Health & Food");
        others.add("Fshion Accessiories");
        others.add("Women");
        others.add("Men");
        others.add("BagsnStationery");
        others.add("MobileAccessiories");
        hashMap.put(arrayList.get(0).getPARENTCATEGORY(),Books);
        hashMap.put(arrayList.get(1).getPARENTCATEGORY(),Poojaitem);
        hashMap.put(arrayList.get(2).getPARENTCATEGORY(),Homecare);
        hashMap.put(arrayList.get(3).getPARENTCATEGORY(),others);
        navigationCategoryList();
    }

    public void initiaze(){
        arrayList=new ArrayList<>();
        hashMap=new HashMap<>();
        Books=new ArrayList<>();
        Poojaitem=new ArrayList<>();
        Homecare=new ArrayList<>();
        others=new ArrayList<>();

    }
    public void navigationCategoryList(){
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(MyAccount.this,arrayList,hashMap,listView);
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
                    listView.setSelectedGroup(groupPosition);
                    nestedScrollView.smoothScrollTo(0,groupPosition);
                    arrayList.get(groupPosition).setFLAG_INDICATOR(1);

                }
                return true;
            }
        });
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent=new Intent(MyAccount.this,Childcategoru.class);
                intent.putExtra("get",hashMap.get(arrayList.get(groupPosition).getPARENTCATEGORY()).get(childPosition));
                startActivity(intent);
                return true;
            }
        });

    }

    public void refferencetonavigationcategory(View view)
    {
        myorder= (LinearLayout) view.findViewById(R.id.myorders);
        mycart= (LinearLayout) view.findViewById(R.id.mycart);
        myaccount= (LinearLayout) view.findViewById(R.id.myaccount);
        helpcenter= (LinearLayout) view.findViewById(R.id.helpcenter);
        ratedesichain= (LinearLayout) view.findViewById(R.id.ratedesichain);
        policy= (LinearLayout) view.findViewById(R.id.policy);
        facebook= (LinearLayout) view.findViewById(R.id.facebook);
        google=(LinearLayout) view.findViewById(R.id.googleplus);
        twitter= (LinearLayout) view.findViewById(R.id.twitter);
        productPage=(LinearLayout)view.findViewById(R.id.myProductLayout);
        pinterest= (LinearLayout) view.findViewById(R.id.pinterest);
        youtube= (LinearLayout) view.findViewById(R.id.youtube);
        instagram= (LinearLayout) view.findViewById(R.id.instagram);
        aboutus= (LinearLayout) view.findViewById(R.id.aboutus);
        myorder.setOnClickListener(this);
        mycart.setOnClickListener(this);
        myaccount.setOnClickListener(this);
        helpcenter.setOnClickListener(this);
        productPage.setOnClickListener(this);
        ratedesichain.setOnClickListener(this);
        policy.setOnClickListener(this);
        facebook.setOnClickListener(this);
        google.setOnClickListener(this);
        twitter.setOnClickListener(this);
        pinterest.setOnClickListener(this);
        youtube.setOnClickListener(this);
        instagram.setOnClickListener(this);
        aboutus.setOnClickListener(this);
    }

}
