package com.example.nitin.desichain.ParsingJson;

import android.content.Context;

import com.example.nitin.desichain.Contents.CategoryList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NITIN on 31-Jul-17.
 */

public class GetParticularCategoryList {

    private String JSON_RESPONSE;
    private Context mContent;
    private JSONObject PRODUCT_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private ArrayList<CategoryList> arrayList1;
    private String PRODUCT_NAME;
    private int   ACTUAL_PRICE;
    private int SELLING_PRICE;
    private String IMAGE_URL;
    private int  DISCOUNT;
    private int PRODUCT_ID;
    private String PRODUCT_DESCRIPTION;
    private int BRAND_ID;
    private String Ingredients;
    private String HOW_TO_USE;
    private String NET_WEIGTH;
    private int GROSS_WEIGHHT;
    public GetParticularCategoryList(String JSON_RESPONSE,Context context) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        mContent=context;
        arrayList1=new ArrayList<>();

    }
    public ArrayList<CategoryList> getParticularCategoryList(){
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
                BRAND_ID=PRODUCT_json_OBJECCT.getInt("brandid");
                Ingredients=PRODUCT_json_OBJECCT.getString("Ingredients");
                HOW_TO_USE=PRODUCT_json_OBJECCT.getString("direction");
                NET_WEIGTH=PRODUCT_json_OBJECCT.getString("netweight");
                GROSS_WEIGHHT=PRODUCT_json_OBJECCT.getInt("GrossWeight");
                DISCOUNT=(ACTUAL_PRICE-SELLING_PRICE)/100;
               // arrayList1.add(new CategoryList(PRODUCT_NAME,ACTUAL_PRICE,SELLING_PRICE,IMAGE_URL,DISCOUNT,PRODUCT_ID,PRODUCT_DESCRIPTION,BRAND_ID,Ingredients,HOW_TO_USE,NET_WEIGTH,GROSS_WEIGHHT,"4","12"));
                arrayList1.add(new CategoryList(IMAGE_URL,PRODUCT_NAME,SELLING_PRICE,"4.0","1200",GROSS_WEIGHHT,Ingredients));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList1;

    }

}
