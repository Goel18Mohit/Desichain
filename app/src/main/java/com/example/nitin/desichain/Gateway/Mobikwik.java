package com.example.nitin.desichain.Gateway;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.nitin.desichain.R;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Mobikwik extends AppCompatActivity {

    WebView webView;
    String EMAIL_ID="singhal95nitin@gmail.com";
    double AMOUNT=5;
    String MOBILE_NO="9910391606";
    String ORDER_ID="1234567";
    String MID="MBK4744";
    String MERCHANT_NAME="Desichain";
    String REDIRECT_URL="www.desichain.in/ResponseHandlingMobikwik.aspx";
    boolean SHOW_PARAMETER=true;
    String checksum="'"+MOBILE_NO+"'"+"'"+EMAIL_ID+"'"+AMOUNT+"'"+ORDER_ID+"'"+REDIRECT_URL+"'"+MID+"'";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobikwik);
        webView= (WebView) findViewById(R.id.mobikwik_page);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

        try {
            checksum=encode("eKO5dZpKX1Bm8VnVyLma5KEA4XUV",getChecksumString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        webView.loadUrl("https://walletapi.mobikwik.com/wallet?checksum="+checksum+"&cell=9910391606&email=singhal95nitin@gmail.com&amount=10&orderid=DCDM1091525&redirecturl=www.desichain.in/ResponseHandlingMobikwik.aspx&mid=MBK4744");
    }

    public static String getChecksumString()
    {
        String checksumString = "";
        checksumString = "'" + "9910391606" + "''" + "singhal95nitin@gmail.com" + "''" + "10" + "''" + "DCDM12345" + "''" + "www.desichain.in/ResponseHandlingMobikwik.aspx" + "''" + "MBK4744" + "'";
        return checksumString;
    }
    public static String encode(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

}
