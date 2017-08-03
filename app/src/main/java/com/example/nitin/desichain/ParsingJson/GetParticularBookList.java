package com.example.nitin.desichain.ParsingJson;

import android.content.Context;

import com.example.nitin.desichain.Contents.BookCategoryList;
import com.example.nitin.desichain.Utility.Utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NITIN on 31-Jul-17.
 */

public class GetParticularBookList {

    private String JSON_RESPONSE;
    private Context mContent;
    private JSONObject PRODUCT_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private ArrayList<BookCategoryList> BOOKS_LIST;
    private String PRODUCT_NAME;
    private int   ACTUAL_PRICE;
    private int SELLING_PRICE;
    private String IMAGE_URL;
    private int  DISCOUNT;
    private int PRODUCT_ID;
    private String PRODUCT_DESCRIPTION;
    private String PUBLISHERNAME;
    private String AUTHORNAME;
    private int BRAND_ID;
    private String NET_WEIGTH;
    private int GROSS_WEIGHHT;

    public GetParticularBookList(String JSON_RESPONSE, Context mContent) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        this.mContent = mContent;
        BOOKS_LIST=new ArrayList<>();
    }

    public ArrayList<BookCategoryList> getParticularBookList(){
        try {
            JSONArray MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
            for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
            {

                PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
                PRODUCT_ID=PRODUCT_json_OBJECCT.getInt("sno");
                PRODUCT_NAME=PRODUCT_json_OBJECCT.getString("productname");
                ACTUAL_PRICE=PRODUCT_json_OBJECCT.getInt("price");
                SELLING_PRICE=PRODUCT_json_OBJECCT.getInt("sprice");
                IMAGE_URL=PRODUCT_json_OBJECCT.getString("productImg");
                PRODUCT_DESCRIPTION=PRODUCT_json_OBJECCT.getString("bigDesc");
                PUBLISHERNAME=PRODUCT_json_OBJECCT.getString("publisher");
                AUTHORNAME=PRODUCT_json_OBJECCT.getString("Author");
                NET_WEIGTH=PRODUCT_json_OBJECCT.getString("netweight");
                GROSS_WEIGHHT=PRODUCT_json_OBJECCT.getInt("GrossWeight");
                DISCOUNT= Utility.getDiscount(ACTUAL_PRICE,SELLING_PRICE);
                BOOKS_LIST.add(new BookCategoryList(PRODUCT_NAME,ACTUAL_PRICE,SELLING_PRICE,IMAGE_URL,DISCOUNT,PRODUCT_ID,PRODUCT_DESCRIPTION,PUBLISHERNAME,AUTHORNAME,BRAND_ID,NET_WEIGTH,GROSS_WEIGHHT,"4","12"));

            }
        } catch (JSONException e) {

            e.printStackTrace();
        }

        return BOOKS_LIST;
    }

}
