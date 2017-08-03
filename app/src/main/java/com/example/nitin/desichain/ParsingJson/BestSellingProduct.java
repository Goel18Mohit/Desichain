package com.example.nitin.desichain.ParsingJson;

import android.content.Context;
import android.util.Log;

import com.example.nitin.desichain.Contents.CategoryList;
import com.example.nitin.desichain.Utility.Utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class BestSellingProduct {

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
    private ArrayList<com.example.nitin.desichain.Contents.CategoryList> BEST_SELLING_LIST;

    public BestSellingProduct(String JSON_RESPONSE, Context context) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        mContent=context;
        BEST_SELLING_LIST=new ArrayList<>();
    }

  public ArrayList<com.example.nitin.desichain.Contents.CategoryList> parseBestSellingProduct()
  {
      try {
          JSONArray MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
          for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
          {
//
//              PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
//              PRODUCT_NAME=PRODUCT_json_OBJECCT.getString("productname");
//              ACTUAL_PRICE=PRODUCT_json_OBJECCT.getInt("price");
//              SELLING_PRICE=PRODUCT_json_OBJECCT.getInt("sprice");
//              IMAGE_URL=PRODUCT_json_OBJECCT.getString("productImg");
//              mNetWeight = PRODUCT_json_OBJECCT.getString("netweight");
//              DISCOUNT=(ACTUAL_PRICE-SELLING_PRICE)/100;
//             // BEST_SELLING_LIST.add(new com.example.nitin.desichain.Contents.CategoryList(IMAGE_URL,PRODUCT_NAME,ACTUAL_PRICE,"4.0","1200",mNetWeight));
              PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
              PRODUCT_ID=PRODUCT_json_OBJECCT.getInt("sno");
              PRODUCT_NAME=PRODUCT_json_OBJECCT.getString("productname");
              ACTUAL_PRICE=PRODUCT_json_OBJECCT.getInt("price");
              SELLING_PRICE=PRODUCT_json_OBJECCT.getInt("sprice");
              IMAGE_URL=PRODUCT_json_OBJECCT.getString("productImg");
              if (PRODUCT_json_OBJECCT.has("bigDesc")) {
                  PRODUCT_DESCRIPTION = PRODUCT_json_OBJECCT.getString("bigDesc");
              }
              if (PRODUCT_json_OBJECCT.has("brandid")) {
                  BRAND_ID = PRODUCT_json_OBJECCT.getInt("brandid");
              }
              if (PRODUCT_json_OBJECCT.has("Ingredients")) {
                  Ingredients = PRODUCT_json_OBJECCT.getString("Ingredients");
              }
              if (PRODUCT_json_OBJECCT.has("direction")) {
                  HOW_TO_USE = PRODUCT_json_OBJECCT.getString("direction");
              }
              NET_WEIGTH=PRODUCT_json_OBJECCT.getString("netweight");
              if (PRODUCT_json_OBJECCT.has("GrossWeight")) {
                  GROSS_WEIGHHT = PRODUCT_json_OBJECCT.getInt("GrossWeight");
              }
              DISCOUNT= Utility.getDiscount(ACTUAL_PRICE,SELLING_PRICE);
              BEST_SELLING_LIST.add(new CategoryList(IMAGE_URL,PRODUCT_NAME,SELLING_PRICE,ACTUAL_PRICE,"4.0","1200",GROSS_WEIGHHT,Ingredients,DISCOUNT,NET_WEIGTH));
          }
      } catch (JSONException e) {
          e.printStackTrace();
      }
      return BEST_SELLING_LIST;
  }
}
