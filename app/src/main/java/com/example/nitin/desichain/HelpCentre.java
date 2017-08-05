package com.example.nitin.desichain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpCentre extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = HelpCentre.class.getSimpleName();
    private ImageView mCallImage,mWhatsappImage;
    private CardView emailCard,mapsCard,bulkOrderCard;
    LinearLayout myorder,mycart,myaccount,helpcenter,ratedesichain,productPage,policy,facebook,google,twitter,pinterest,youtube,instagram,aboutus;
    private Helper listView;
    private static double LAT = 28.658577;
    private static double LON = 77.202432;
    private EditText editName,editNumber,editEmail,editQuery,editCaptcha;
    private Button mSubmit;
    private ImageView mRetryCaptcha;
    private TextView mCaptchaText;
    private Toolbar mToolbar;
    View headerView;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
    public static ArrayList<String> Poojaitem;
    public  static ArrayList<CategoryHolder> arrayList;
    public static  ArrayList<String> Books;
    public static ArrayList<String> Homecare;
    public static   ArrayList<String> others;
    public  static HashMap<String,ArrayList<String>> hashMap;
    LinearLayout subscribe;
    private String mNameString,mContactString,mEmailString,mQueryString,mCaptchaString;


    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkForEmptyValues();
        }
    };

    private void checkForEmptyValues() {
        mNameString = editName.getText().toString();
        mContactString = editNumber.getText().toString();
        mEmailString = editEmail.getText().toString();
        mQueryString = editQuery.getText().toString();
        mCaptchaString = editCaptcha.getText().toString();

        if (mNameString.equals("")|| mContactString.equals("")||mEmailString.equals("")||mQueryString.equals("")||mCaptchaString.equals("")){
            mSubmit.setEnabled(false);
        }
        else {
            mSubmit.setEnabled(true);
            mSubmit.setBackgroundColor(getResources().getColor(R.color.green));
            mSubmit.setTextColor(Color.WHITE);
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_centre);

        mRetryCaptcha=(ImageView)findViewById(R.id.retryCaptcha);
        mCaptchaText=(TextView)findViewById(R.id.captchaText);
        mRetryCaptcha=(ImageView)findViewById(R.id.retryCaptcha);
        editName=(EditText) findViewById(R.id.edit_name);
        editNumber=(EditText) findViewById(R.id.edit_phone_no);
        editEmail = (EditText)findViewById(R.id.edit_email);
        editQuery=(EditText)findViewById(R.id.edit_query);
        editCaptcha=(EditText)findViewById(R.id.edit_captcha);
        mSubmit=(Button)findViewById(R.id.submit);

        bulkOrderCard=(CardView)findViewById(R.id.card_bulk_order_enquiry);
        mapsCard=(CardView)findViewById(R.id.card_our_location);
        emailCard=(CardView)findViewById(R.id.card_email);
        mCallImage=(ImageView)findViewById(R.id.dialler_call);
        mWhatsappImage=(ImageView)findViewById(R.id.textMessage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.title_activity_help_centre));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        generateCaptcha();

      //  mSubmit.setEnabled(false);

        mNameString = editName.getText().toString();
        mContactString = editNumber.getText().toString();
        mEmailString = editEmail.getText().toString();
        mQueryString = editQuery.getText().toString();
        mCaptchaString = editCaptcha.getText().toString();

        mSubmit.setOnClickListener(this);

        bulkOrderCard.setOnClickListener(this);
        mapsCard.setOnClickListener(this);
        emailCard.setOnClickListener(this);
        mCallImage.setOnClickListener(this);
        mWhatsappImage.setOnClickListener(this);
        mRetryCaptcha.setOnClickListener(this);


        editName.addTextChangedListener(mTextWatcher);
        editEmail.addTextChangedListener(mTextWatcher);
        editNumber.addTextChangedListener(mTextWatcher);
        editQuery.addTextChangedListener(mTextWatcher);
        editCaptcha.addTextChangedListener(mTextWatcher);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

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

    private void generateCaptcha() {

        SecureRandom sr = new SecureRandom();
        int num = sr.nextInt(100000);
        String format = String.format("%05d",num);
        Log.i(LOG_TAG,format);
        mCaptchaText.setText(format);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        else if (item.getItemId()==R.id.search_item){
            startActivity(new Intent(this,SearchActivity.class));
        }
        else if (item.getItemId()==R.id.my_orders){
            startActivity(new Intent(this,MyOrders.class));
        }
        else if (item.getItemId()==R.id.notifications){
            startActivity(new Intent(this,NotificationPage.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }



    public boolean isEmailValid(String email)
    {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.dialler_call:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+"9871712741"));
                if (callIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(callIntent);
                }
                break;
            case R.id.textMessage:
                Intent msgIntent = new Intent(Intent.ACTION_VIEW);
                msgIntent.setType("vnd.android-dir/mms-sms");
                msgIntent.putExtra("address","9871712741");
                startActivity(msgIntent);
                break;
            case R.id.card_email:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:info@desichain.in"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject line");
                if (emailIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(emailIntent);
                }
                break;
            case R.id.retryCaptcha:
                generateCaptcha();
                break;
            case R.id.card_our_location:
                Uri mapLocUri = Uri.parse("geo:0,0?q="+LAT+","+LON+"(Desichain)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,mapLocUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;

            case R.id.card_bulk_order_enquiry:
                Intent bulkMailIntent = new Intent(Intent.ACTION_SENDTO);
                bulkMailIntent.setData(Uri.parse("mailto:sales@desichain.in"));
                bulkMailIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject line");
                if (bulkMailIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(bulkMailIntent);
                }
                break;
            case R.id.submit:




                 if (mNameString.isEmpty()){
                    editName.setError("please enter name");
                }

                if (mContactString.isEmpty()){
                    editNumber.setError("please enter contact number");
                }
                if (mEmailString.isEmpty()){
                    editEmail.setError("please enter email id");
                }
                else if (!isEmailValid(mEmailString)){
                    editEmail.setError("please Enter proper email id");
                }
                if (mCaptchaString.isEmpty()){
                    editCaptcha.setError("please Enter Captcha!");
                }
                else if (!mCaptchaString.equals(mCaptchaText.getText().toString())){
                    editCaptcha.setError("Wrong Captcha!");
                }
                else if (mQueryString.isEmpty()){
                    editQuery.setError("Please Enter your Query");
                }
                else if (!mNameString.isEmpty() && !mContactString.isEmpty() && !mEmailString.isEmpty() &&
                        !mQueryString.isEmpty()){

                    editCaptcha.setText("");
                    editQuery.setText("");
                    editEmail.setText("");
                    editName.setText("");
                    editNumber.setText("");

                    InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                    Toast.makeText(this, "thankyou for reaching us", Toast.LENGTH_LONG).show();

               }
                break;
            default:
                new Utility().openIntent(this,v.getId(),drawer);

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
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(HelpCentre.this,arrayList,hashMap,listView);
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
                Intent intent=new Intent(HelpCentre.this,Childcategoru.class);
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
        myaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("myPref",MODE_PRIVATE);
                String email = preferences.getString("emailId","none");
                String pwd = preferences.getString("password","none");

                if (email.equals("none") && pwd.equals("none")){
                    startActivity(new Intent(HelpCentre.this,LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(HelpCentre.this,MyAccount.class));

                }
            }
        });
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
