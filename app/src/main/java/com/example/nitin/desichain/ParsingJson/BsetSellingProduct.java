package com.example.nitin.desichain.ParsingJson;

import android.content.Context;
import android.util.Log;

import com.example.nitin.desichain.Contents.ProductHorizontal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class BsetSellingProduct {

    private String JSON_RESPONSE;
    private Context mContent;
    private JSONObject PRODUCT_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private String PRODUCT_NAME;
    private int ACTUAL_PRICE;
    private int SELLING_PRICE;
    private int DISCOUNT;
    private String IMAGE_URL;
    private ArrayList<ProductHorizontal> BEST_SELLING_LIST;
    public BsetSellingProduct(String JSON_RESPONSE,Context context) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        mContent=context;
        BEST_SELLING_LIST=new ArrayList<>();
        Log.i("ashish",JSON_RESPONSE);
    }

  public ArrayList<ProductHorizontal> parseBestSellingProduct()
  {
      try {
          JSONArray MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
          for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
          {
              PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
              PRODUCT_NAME=PRODUCT_json_OBJECCT.getString("productname");
              ACTUAL_PRICE=PRODUCT_json_OBJECCT.getInt("price");
              SELLING_PRICE=PRODUCT_json_OBJECCT.getInt("sprice");
              IMAGE_URL=PRODUCT_json_OBJECCT.getString("productImg");
              DISCOUNT=(ACTUAL_PRICE-SELLING_PRICE)/100;
              BEST_SELLING_LIST.add(new ProductHorizontal(PRODUCT_NAME,SELLING_PRICE,IMAGE_URL,"12","4",DISCOUNT));

          }
      } catch (JSONException e) {
          e.printStackTrace();
      }
      return BEST_SELLING_LIST;
  }
}
