package com.example.nitin.desichain.Internet;

import android.os.AsyncTask;

import com.example.nitin.desichain.Contents.ProductHorizontal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class FetchingFromUrl extends AsyncTask<String,String,String> {

    private StringBuilder JSON_RESPONSE = new StringBuilder();
    private ArrayList<ProductHorizontal> bestsellingproductlist;


    @Override
    protected String doInBackground(String... params) {
        try{


            URL bestsellingurl=new URL(params[0]);
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
        if(s1.contains("Mail Id Already exist.")){
            return "Mail Id Already exist.";
        }
        String s2=s1.substring(s1.indexOf("["),s1.length()-9);
        return s2;
    }
}
