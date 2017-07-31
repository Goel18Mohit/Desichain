package com.example.nitin.desichain.ParsingJson;

import android.content.Context;

import com.example.nitin.desichain.Contents.LoginData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Karan on 28-07-2017.
 */

public class LoginParse {

    private String mJSON_RESPONSE;
    private Context mContext;
    private JSONObject USER_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private int SNO, ZIP, PHONE, FAX, MOBILE, BILLING_NO, CART_ITEM_ADD;
    private ArrayList<LoginData> arrayList;
    private String USER_FNAME, EMAIL, PWD, GENDER, LNAME,BILLING_NAME, CITY, STATE, COUNTRY, ADDRESS, NEWSLETTER, LMARK;


    public LoginParse(String JSON_RESPONSE, Context context){
        this.mJSON_RESPONSE = JSON_RESPONSE;
        this.mContext = context;
        arrayList=new ArrayList<>();
        parsingLogin();
    }
    public ArrayList<LoginData> parsingLogin(){
        try {
            MAIN_JSON_ARRAY=new JSONArray(mJSON_RESPONSE);
            for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
            {
                USER_json_OBJECCT = MAIN_JSON_ARRAY.getJSONObject(i);
                SNO = USER_json_OBJECCT.getInt("sno");
                EMAIL = USER_json_OBJECCT.getString("emailid");
                SNO = USER_json_OBJECCT.getInt("pwd");
                SNO = USER_json_OBJECCT.getInt("Gender");
                USER_FNAME = USER_json_OBJECCT.getString("Fname");
                arrayList.add(new LoginData(SNO,EMAIL,LMARK,BILLING_NAME,BILLING_NO,PWD,GENDER,USER_FNAME,
                        LNAME,CITY,STATE,COUNTRY,ZIP,ADDRESS,PHONE,FAX,MOBILE,CART_ITEM_ADD,NEWSLETTER));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
