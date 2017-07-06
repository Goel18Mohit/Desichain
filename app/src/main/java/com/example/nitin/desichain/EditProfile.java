package com.example.nitin.desichain;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {


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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            calendar=Calendar.getInstance();
            mYear=calendar.get(Calendar.YEAR);
            mMonth=calendar.get(Calendar.MONTH);
            mDate=calendar.get(Calendar.DATE);
        }



        CUSTOMERFATEOFBIRTH= (TextView) findViewById(R.id.editBirthDateText);

        CUSTOMER_NAME= (EditText) findViewById(R.id.editcustomerNameText);



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
