package com.example.nitin.desichain;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    private static final String LOG_TAG = AboutUs.class.getSimpleName();
    TextView ABOUT_US1,ABOUT_US2,ABOUT_US3,ABOUT_US4,ABOUT_US5,ABOUT_US6;
    String STRING_ABOUT_US_1="Welcome to DesiChain, your one stop Shop for all your regular Desi (Indian) essentials. Starting from the Toiletries to Cosmetics, from Herbals Products to Fresh Organic beans, DesiChain keeps it all... We welcome and wish you a pleasant Shopping!.";
    String STRING_ABOUT_US_2="By purchasing, the buyer expressly warrants that he/she is in compliance with all applicable Federal, State, and Local laws and regulations regarding the purchase, ownership, and use of the item. The buyer expressly agrees to indemnify and hold harmless our store, company or its licensors for all claims resulting directly or indirectly from the purchase, ownership, use or mis-use of the item in violation of applicable Federal, State, and Local laws or regulations. Some items can be dangerous if improperly handled. Keep away from children. You must be 18 or older to purchase.";
    String STRING_ABOUT_US_3="You acknowledge and agree that all copyright, trademarks and all other intellectual property rights in the Content, our Desichain Site listings, Software and all HTML and other code contained herein, shall remain at all times vested in DesiChain, its parent company, associates and/or its licensors and is protected by copyright and other laws and international treaty provisions. You are permitted to use this material only as expressly authorized by our Company or its licensors. Any reproduction or redistribution of the above listed materials is prohibited by law and may result in civil and criminal penalties. Violators will be prosecuted to the fullest extent permissible under applicable law. Without limiting the foregoing, copying the above listed materials to any other server or location for publication, reproduction or distribution is expressly prohibited.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ABOUT_US1= (TextView) findViewById(R.id.about_us1);
        ABOUT_US2=(TextView)findViewById(R.id.about_us2);
        ABOUT_US3=(TextView)findViewById(R.id.about_us3);
        ABOUT_US4= (TextView) findViewById(R.id.about_us4);
        ABOUT_US5= (TextView) findViewById(R.id.about_us5);
        ABOUT_US6= (TextView) findViewById(R.id.about_us6);
        ABOUT_US4.setPaintFlags(ABOUT_US4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        ABOUT_US5.setPaintFlags(ABOUT_US5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        ABOUT_US6.setPaintFlags(ABOUT_US6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ABOUT_US1.setText(STRING_ABOUT_US_1);
        ABOUT_US2.setText(STRING_ABOUT_US_2);
        ABOUT_US3.setText(STRING_ABOUT_US_3);
    }





}
