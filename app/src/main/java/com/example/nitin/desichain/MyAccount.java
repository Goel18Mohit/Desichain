package com.example.nitin.desichain;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAccount extends AppCompatActivity
        implements View.OnClickListener {

    int flag=0;
    String referChoiceSelected;
    private TextView editProfileText,CUSTOMER_FIRST_LETTER_NAME;
    private String CUSTOMERNAMEFIRSTLETTER;
    private LinearLayout mMyOrderLayout,mMyAddressLayout,mMyWallet,
            mNotificationLayout,mHelpCenterLayout,mRefer,
            mRateAppLayout,mFeedBackLayout,mPoliciesLayout,mCountry;


    public String grpname[] = {"Email","SMS","Whatsapp"};
    TextView txtViewCount;
    int count=2;
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
    LinearLayout subscribe;
    private TextView mLogInLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mLogInLogOut=(TextView)findViewById(R.id.logInLogOut);

        Intent intent=getIntent();

        SharedPreferences sharedPreferences = getSharedPreferences("myPref",MODE_PRIVATE);
        String email = sharedPreferences.getString("emailId","none");
        String pwd = sharedPreferences.getString("password","none");

        if (email.equals("none") && pwd.equals("none")){
            mLogInLogOut.setText("Log In");
        } else {
            mLogInLogOut.setText("Log Out");
        }

        mMyOrderLayout = (LinearLayout)findViewById(R.id.myOrderLayout);
        mMyAddressLayout=(LinearLayout)findViewById(R.id.myAddressLayout);
        mMyWallet = (LinearLayout)findViewById(R.id.walletLayout);
        mNotificationLayout=(LinearLayout)findViewById(R.id.notificationLayout);
        mHelpCenterLayout = (LinearLayout)findViewById(R.id.helpCentreLayout);
        mRateAppLayout =(LinearLayout)findViewById(R.id.rateAppPlayStoreLayout);
        mFeedBackLayout =(LinearLayout)findViewById(R.id.appFeedbackLayout);
        mPoliciesLayout=(LinearLayout)findViewById(R.id.policiesLayout);
        mRefer= (LinearLayout) findViewById(R.id.refer);

        mCountry=(LinearLayout)findViewById(R.id.country);
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
        mMyWallet.setOnClickListener(this);
        mNotificationLayout.setOnClickListener(this);
        mHelpCenterLayout.setOnClickListener(this);
        mRateAppLayout.setOnClickListener(this);
        mFeedBackLayout.setOnClickListener(this);
        mPoliciesLayout.setOnClickListener(this);
        mCountry.setOnClickListener(this);


        mRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog=new AlertDialog.Builder(MyAccount.this);
//                alertDialog.setTitle("Friends email Id");
//                alertDialog.setMessage("Terms and Condition");
//                USER_EMAIL_ID=new EditText(MyAccount.this);
//                alertDialog.setView(USER_EMAIL_ID);
//                alertDialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        if(USER_EMAIL_ID.getText().toString().isEmpty())
//                        {
//
//                            USER_EMAIL_ID.setError("field cant be empty");
//                        }
//                        else {
//                            dialog.dismiss();
//                            Toast.makeText(MyAccount.this, "Email has been set", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });
//                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//
//                alertDialog.create().show();

                alertDialog.setTitle("Choose Option");
                alertDialog.setSingleChoiceItems(grpname, -1, new DialogInterface
                        .OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0 : referChoiceSelected = "Email";
                                break;
                            case 1 : referChoiceSelected = "SMS";
                                break;
                            case 2 : referChoiceSelected = "Whatsapp";
                                break;
                        }
                    }
                });
                alertDialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (referChoiceSelected.equals("Email")){
                            Intent shareIntent = ShareCompat.IntentBuilder.from(MyAccount.this)
                                    .setType("text/plain")
                                    .setText("referal link")
                                    .getIntent();
                            startActivity(shareIntent);

                            dialog.dismiss();// dismiss the alertbox after chose option
                        }
                        if (referChoiceSelected.equals("SMS")){
                            Intent shareIntent = ShareCompat.IntentBuilder.from(MyAccount.this)
                                    .setType("text/plain")
                                    .setText("referal link")
                                    .getIntent();
                            startActivity(shareIntent);
                            dialog.dismiss();// dismiss the alertbox after chose option
                        }
                        if (referChoiceSelected.equals("Whatsapp")){
                            Intent shareIntent = ShareCompat.IntentBuilder.from(MyAccount.this)
                                    .setType("text/plain")
                                    .setText("referal link")
                                    .getIntent();
                            startActivity(shareIntent);
                            dialog.dismiss();// dismiss the alertbox after chose option
                        }
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.show();

            }
        });

        LOGOUT= (LinearLayout) findViewById(R.id.logout);
        RESET= (LinearLayout) findViewById(R.id.reset);
        CUSTOMER_NAME= (EditText) findViewById(R.id.editcustomerNameText);
        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLogInLogOut.getText().toString().equals("Log Out")) {
                    SharedPreferences sharedPreferences1 = getSharedPreferences("myPref",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences1.edit();
                    editor.clear();
                    editor.apply();
                    Toast.makeText(MyAccount.this, "You have been logged out ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MyAccount.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MyAccount.this, LoginActivity.class);
                    startActivity(intent);

                }
//                finish();
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

        drawer.setDrawerListener(toggle);
        toggle.syncState();
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
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem=menu.findItem(R.id.my_cart);
        MenuItemCompat.setActionView(menuItem,R.layout.cart_icon_for_toolbar);
        RelativeLayout mycarttoolbar= (RelativeLayout) MenuItemCompat.getActionView(menuItem);
        txtViewCount = (TextView) mycarttoolbar.findViewById(R.id.badge_notification_1);
        count++;
        txtViewCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewCount.setText(String.valueOf(count++));
            }
        });

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
        else if (id == android.R.id.home){
            if (drawer.isDrawerOpen(Gravity.LEFT)) {
                drawer.closeDrawer(Gravity.LEFT);
            } else {
                drawer.openDrawer(Gravity.START);
            }
        }
        else if (id==R.id.my_cart){
            startActivity(new Intent(MyAccount.this,MyCart.class));
        }
        else if (item.getItemId()==R.id.my_orders){
            startActivity(new Intent(this,MyOrders.class));
        }
        else if (item.getItemId()==R.id.notifications){
            startActivity(new Intent(this,NotificationPage.class));
        }
        else if (item.getItemId()==R.id.search_item){
            startActivity(new Intent(this,SearchActivity.class));
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
            case R.id.walletLayout:
                startActivity(new Intent(this, Wallet_page.class));
                break;
            case R.id.country:
                startActivity(new Intent(this, Location.class));
                break;
            case R.id.notificationLayout:
                startActivity(new Intent(this, NotificationPage.class));
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
            default:new Utility().openIntent(this,v.getId(),drawer);
                break;

        }
    }
    public void add()
    {
        arrayList.add(new CategoryHolder("Book and media",0,R.mipmap.book));
        arrayList.add(new CategoryHolder("Pooja Item",0,R.mipmap.pooja));
        arrayList.add(new CategoryHolder("Home Care",0,R.mipmap.homecare));
        arrayList.add(new CategoryHolder("Others",0,R.mipmap.other));
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
                intent.putExtra("getFilterName",String.valueOf(arrayList.get(groupPosition).getPARENTCATEGORY()));
                startActivity(intent);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                for (int i=0; i<parent.getCount(); ++i) {
                    if (parent.isGroupExpanded(i)) {
                        parent.collapseGroup(i);
                    }
                }
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
        pinterest= (LinearLayout) view.findViewById(R.id.pinterest);
        youtube= (LinearLayout) view.findViewById(R.id.youtube);
        instagram= (LinearLayout) view.findViewById(R.id.instagram);
        aboutus= (LinearLayout) view.findViewById(R.id.aboutus);
        subscribe= (LinearLayout) findViewById(R.id.subscribe);
        myorder.setOnClickListener(this);
        mycart.setOnClickListener(this);
        myaccount.setOnClickListener(this);
        helpcenter.setOnClickListener(this);
        ratedesichain.setOnClickListener(this);
        policy.setOnClickListener(this);
        facebook.setOnClickListener(this);
        google.setOnClickListener(this);
        twitter.setOnClickListener(this);
        pinterest.setOnClickListener(this);
        youtube.setOnClickListener(this);
        instagram.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        subscribe.setOnClickListener(this);
    }

}
