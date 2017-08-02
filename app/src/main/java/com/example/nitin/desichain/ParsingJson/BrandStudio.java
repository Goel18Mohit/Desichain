package com.example.nitin.desichain.ParsingJson;

import android.content.Context;

import com.example.nitin.desichain.Contents.BrandStudioList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class BrandStudio {
    private String JSON_RESPONSE;
    private Context mContent;
    private JSONObject PRODUCT_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private String BRAND_IMAGE;
    private String BRAND_PAGE_URL;
    private String BRAND_PAGE_DESCRIPTION;
    private int BRAND_SNO;
    private ArrayList<BrandStudioList> BRAND_PRODUCT_LIST;
    public BrandStudio(String JSON_RESPONSE, Context context) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        mContent=context;
        BRAND_PRODUCT_LIST=new ArrayList<>();
    }
    public ArrayList<BrandStudioList> parseBestSellingProduct()
    {
        try {
            JSONArray MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
            for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
            {
                PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
                BRAND_IMAGE=PRODUCT_json_OBJECCT.getString("BrandImage");
                BRAND_PAGE_URL=PRODUCT_json_OBJECCT.getString("BrandName");
                BRAND_PAGE_DESCRIPTION = PRODUCT_json_OBJECCT.getString("BrandDiscription");
                BRAND_SNO = PRODUCT_json_OBJECCT.getInt("sno");
                BRAND_PRODUCT_LIST.add(new BrandStudioList(BRAND_IMAGE,BRAND_PAGE_URL,BRAND_PAGE_DESCRIPTION,BRAND_SNO));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return BRAND_PRODUCT_LIST;
    }
}
