package com.example.nitin.desichain;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpCentre extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private static final String LOG_TAG = HelpCentre.class.getSimpleName();
    private ImageView mCallImage,mWhatsappImage;
    private CardView emailCard,mapsCard,bulkOrderCard;
    private static double LAT = 28.658577;
    private static double LON = 77.202432;
    private EditText editName,editNumber,editEmail,editQuery,editCaptcha;
    private Button mSubmit;
    private ImageView mRetryCaptcha;
    private TextView mCaptchaText;

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

        mSubmit.setOnClickListener(this);

        bulkOrderCard.setOnClickListener(this);
        mapsCard.setOnClickListener(this);
        emailCard.setOnClickListener(this);
        mCallImage.setOnClickListener(this);
        mWhatsappImage.setOnClickListener(this);
        mRetryCaptcha.setOnClickListener(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

      /*  DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle =  new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void generateCaptcha() {

        SecureRandom sr = new SecureRandom();
        int num = sr.nextInt(100000);
        String format = String.format("%05d",num);
        Log.i(LOG_TAG,format);
        mCaptchaText.setText(format);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.START);
        return true;
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


                String mNameString = editName.getText().toString();
                String mContactString = editNumber.getText().toString();
                String mEmailString = editEmail.getText().toString();
                String mQueryString = editQuery.getText().toString();
                String mCaptchaString = editCaptcha.getText().toString();

                editCaptcha.setText("");
                editQuery.setText("");
                editEmail.setText("");
                editName.setText("");
                editNumber.setText("");

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

                else {

                    Toast.makeText(this, "thankyou for reaching us", Toast.LENGTH_LONG).show();

               }
                break;
            default:
                break;

        }
    }
}
