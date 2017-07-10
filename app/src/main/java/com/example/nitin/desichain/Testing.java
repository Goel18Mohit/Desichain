package com.example.nitin.desichain;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class Testing extends AsyncTask<String,String,String>{

    private StringBuilder JSON_RESPONSE = new StringBuilder();
    private String POPULAR_URL;
    private Context context;

    @Override
    protected String doInBackground(String... params) {


    try{


        URL  bestsellingurl=new URL(params[0]);
        HttpURLConnection httpURLConnection = null;
        httpURLConnection = (HttpURLConnection) bestsellingurl.openConnection();
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int read;
        while ((read = bufferedReader.read()) != -1) {
            char singlecharacter = (char) read;
            JSON_RESPONSE.append(singlecharacter);
        }

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

        String s1=JSON_RESPONSE.toString();
        Log.i("tag7",s1);
        String s2=s1.substring(s1.indexOf("["),s1.length()-9);
        Pattern p=Pattern.compile("\\[([^\\]]*)\\]");
        Matcher m=p.matcher(JSON_RESPONSE);

            if(m.find()) {
                Log.i("tag7", s2);
            }
        return s2;
    }

}
