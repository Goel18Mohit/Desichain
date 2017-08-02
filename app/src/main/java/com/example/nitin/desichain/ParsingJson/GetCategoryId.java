package com.example.nitin.desichain.ParsingJson;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NITIN on 31-Jul-17.
 */

public class GetCategoryId {
    private String JSON_RESPONSE;
    private String CHILDCATEGORYNAME;
    private Context mContent;
    private String API_CHILD_CATEGORY_NAME;
    private JSONObject PRODUCT_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private int GETCATEGORYID=-1;

    public GetCategoryId(String JSON_RESPONSE, String CHILDCATEGORYNAME, Context mContent) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        this.CHILDCATEGORYNAME = CHILDCATEGORYNAME;
        this.mContent = mContent;
    }

    public int getCategoryId()
    {
        try {
            JSONArray MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
            for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
            {
                PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
                API_CHILD_CATEGORY_NAME=PRODUCT_json_OBJECCT.getString("catname");
                if(CHILDCATEGORYNAME.equals(API_CHILD_CATEGORY_NAME))
                {
                    GETCATEGORYID=PRODUCT_json_OBJECCT.getInt("sno");
                }



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return GETCATEGORYID;

    }
}
