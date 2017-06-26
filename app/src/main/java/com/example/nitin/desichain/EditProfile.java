package com.example.nitin.desichain;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    LinearLayout LOGOUT,RESET;
    EditText USER_EMAIL_ID;
    EditText CUSTOMER_NAME;
    TextView CUSTOMERFATEOFBIRTH;
    String CUSTOMERNAME;
    private int mYear,mMonth,mDate;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        calendar=Calendar.getInstance();
        mYear=calendar.get(Calendar.YEAR);
        mMonth=calendar.get(Calendar.MONTH);
        mDate=calendar.get(Calendar.DATE);



        LOGOUT= (LinearLayout) findViewById(R.id.logout);
        CUSTOMERFATEOFBIRTH= (TextView) findViewById(R.id.editBirthDateText);
        RESET= (LinearLayout) findViewById(R.id.reset);
        CUSTOMER_NAME= (EditText) findViewById(R.id.editcustomerNameText);
        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditProfile.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        RESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final AlertDialog.Builder alertDialog=new AlertDialog.Builder(EditProfile.this);
                alertDialog.setTitle("Reset Password");
                alertDialog.setMessage("Your Email Id");
                USER_EMAIL_ID=new EditText(EditProfile.this);
                alertDialog.setView(USER_EMAIL_ID);
                alertDialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(EditProfile.this,"Email has been seet",Toast.LENGTH_SHORT).show();

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

        CUSTOMERFATEOFBIRTH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(EditProfile.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        month=month+1;

                        CUSTOMERFATEOFBIRTH.setText(String.valueOf(dayOfMonth+"/"+month+"/"+year));
                    }
                },mYear,mMonth,mDate);
                datePickerDialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_edit_profile,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.saveProfile:
                CUSTOMERNAME=CUSTOMER_NAME.getText().toString();
                Intent intent =new Intent(EditProfile.this,MyAccount.class);
                if(CUSTOMERNAME!=null) {
                    intent.putExtra("CUSTOMERNAME", CUSTOMERNAME);
                }
                    intent.putExtra("FLAGSTATUS",121);
                startActivity(intent);
                finish();

        }
        return super.onOptionsItemSelected(item);

    }
}
