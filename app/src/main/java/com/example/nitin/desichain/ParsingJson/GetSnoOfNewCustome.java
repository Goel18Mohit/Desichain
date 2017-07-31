package com.example.nitin.desichain.ParsingJson;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by NITIN on 31-Jul-17.
 */

public class GetSnoOfNewCustome {
    private String JSON_RESPONSE;
    private Context mContent;
    private JSONObject SNO_json_OBJECCT;
    private JSONArray MAIN_JSON_ARRAY;
    private String SNO;

    public GetSnoOfNewCustome(String JSON_RESPONSE, Context mContent) {
        this.JSON_RESPONSE = JSON_RESPONSE;
        this.mContent = mContent;
    }

    public String getSno()
    {
        try {
            JSONArray MAIN_JSON_ARRAY=new JSONArray(JSON_RESPONSE);
            for(int i=0;i<MAIN_JSON_ARRAY.length();i++)
            {
                SNO_json_OBJECCT=MAIN_JSON_ARRAY.getJSONObject(i);
                SNO=String.valueOf(SNO_json_OBJECCT.getInt("sno"));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return SNO;
    }
}
