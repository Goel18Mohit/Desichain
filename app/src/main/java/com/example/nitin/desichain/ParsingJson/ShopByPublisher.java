package com.example.nitin.desichain.ParsingJson;

import android.content.Context;

import com.example.nitin.desichain.Contents.ChildCategoryBrand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NITIN on 11-Jul-17.
 */

public class ShopByPublisher {

    private String JSON_RESPONSE;
    private Context mContent;
    private JSONObject PRODUCT_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private int PRODUCT_ID_SNO;
    private String PRODUCT_IMAGE_URL;
    private String PRODUCT_NAME;
    private ArrayList<ChildCategoryBrand> arrayList;

    public ShopByPublisher(String JSON_RESPONSE, Context mContent) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        this.mContent = mContent;
        arrayList=new ArrayList<>();
    }

    public ArrayList<ChildCategoryBrand> parsingShopByPublisher(){
        try {
            MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
            for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
            {
                PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
                PRODUCT_ID_SNO=PRODUCT_json_OBJECCT.getInt("sno");
                PRODUCT_IMAGE_URL=PRODUCT_json_OBJECCT.getString("BrandImage");
                PRODUCT_NAME=PRODUCT_json_OBJECCT.getString("PublisherBrandName");
                arrayList.add(new ChildCategoryBrand(PRODUCT_ID_SNO,PRODUCT_NAME,PRODUCT_IMAGE_URL));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
