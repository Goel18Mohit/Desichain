package com.example.nitin.desichain.ParsingJson;

import android.content.Context;
import android.os.Bundle;

import com.example.nitin.desichain.AllConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NITIN on 11-Jul-17.
 */

public class ParticularPublisherDetail {

    private String JSON_RESPONSE;
    private Context mContent;
    private JSONObject PRODUCT_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private String BRAND_NAME;
    private String Brand_IMAGE_URL;
    private String BRAND_DESCRIPTION;
    private Bundle bundle;
    public ParticularPublisherDetail(String JSON_RESPONSE, Context mContent) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        this.mContent = mContent;
        bundle=new Bundle();
    }

    public Bundle parseParticularPublisher(){
        try {
            MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
            for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
            {
                PRODUCT_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
                BRAND_NAME=PRODUCT_json_OBJECCT.getString("PublisherBrandName");
                Brand_IMAGE_URL=PRODUCT_json_OBJECCT.getString("BrandImage");
                BRAND_DESCRIPTION=PRODUCT_json_OBJECCT.getString("BrandDiscription");
                bundle.putString(AllConstants.Brandname,BRAND_NAME);
                bundle.putString(AllConstants.Brandimageurl,Brand_IMAGE_URL);
                bundle.putString(AllConstants.Branddescription,BRAND_DESCRIPTION);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bundle;
    }
}
