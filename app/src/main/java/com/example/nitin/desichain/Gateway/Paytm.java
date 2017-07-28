package com.example.nitin.desichain.Gateway;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.paytm.pgsdk.PaytmMerchant;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NITIN on 11-Jul-17.
 */

public class Paytm {

   private String orderID="0000000";
   private Context mContext;
   public Paytm(Context mContext) {
      this.mContext = mContext;
     /* orderID = "DCDM" + String.Format("{0:d7}", (DateTime.Now.Ticks / 10) % 10000000);*/
}


   public void onStartTransaction(View view) {
      PaytmPGService Service = PaytmPGService.getStagingService();
      Map<String, String> paramMap = new HashMap<String, String>();

      // these are mandatory parameters
       paramMap.put("MID" , "WorldP64425807474247");
       paramMap.put("ORDER_ID" ,"ORDER");
       paramMap.put("CUST_ID" , "mohit.aggarwal@paytm.com");
       paramMap.put("INDUSTRY_TYPE_ID" , "Retail");
       paramMap.put("CHANNEL_ID" ,"WAP");
       paramMap.put("TXN_AMOUNT" ,"1");
       paramMap.put("WEBSITE" , "www.androidluckyguys.com");

       PaytmMerchant Merchant = new PaytmMerchant(
               "https://pguat.paytm.com/paytmchecksum/paytmCheckSumGenerator.jsp",
               "https://pguat.paytm.com/paytmchecksum/paytmCheckSumVerify.jsp");

       PaytmOrder Order = new PaytmOrder(paramMap);
       Service.initialize(Order,Merchant, null);

      Service.startPaymentTransaction(mContext, true, true,
              new PaytmPaymentTransactionCallback() {
                 @Override
                 public void someUIErrorOccurred(String inErrorMessage) {
                    // Some UI Error Occurred in Payment Gateway Activity.
                    // // This may be due to initialization of views in
                    // Payment Gateway Activity or may be due to //
                    // initialization of webview. // Error Message details
                    // the error occurred.
                    Toast.makeText(mContext, "Ui/Webview error occured.", Toast.LENGTH_LONG).show();

                 }

                 @Override
                 public void onTransactionSuccess(Bundle inResponse) {
                    // After successful transaction this method gets called.
                    // // Response bundle contains the merchant response
                    // parameters.
                    ;
                    Log.d("LOG", "Payment Transaction is successful " + inResponse);
                    Toast.makeText(mContext, "Payment Transaction is successful ", Toast.LENGTH_LONG).show();
                 }

                 @Override
                 public void onTransactionFailure(String inErrorMessage,
                                                  Bundle inResponse) {
                    // This method gets called if transaction failed. //
                    // Here in this case transaction is completed, but with
                    // a failure. // Error Message describes the reason for
                    // failure. // Response bundle contains the merchant
                    // response parameters.
                    Log.d("LOG", "Payment Transaction Failed " + inErrorMessage);
                    Toast.makeText(mContext, "Payment Transaction Failed ", Toast.LENGTH_LONG).show();
                 }



                 @Override
                 public void networkNotAvailable() { // If network is not
                    // available, then this
                    // method gets called.
                    Toast.makeText(mContext, "No Internet connection.", Toast.LENGTH_LONG).show();

                 }

                 @Override
                 public void clientAuthenticationFailed(String inErrorMessage) {
                    // This method gets called if client authentication
                    // failed. // Failure may be due to following reasons //
                    // 1. Server error or downtime. // 2. Server unable to
                    // generate checksum or checksum response is not in
                    // proper format. // 3. Server failed to authenticate
                    // that client. That is value of payt_STATUS is 2. //
                    // Error Message describes the reason for failure.
                    Toast.makeText(mContext, "Client Authentication Failed.", Toast.LENGTH_LONG).show();

                 }

                 @Override
                 public void onErrorLoadingWebPage(int iniErrorCode,
                                                   String inErrorMessage, String inFailingUrl) {

                 }

                 // had to be added: NOTE
                 @Override
                 public void onBackPressedCancelTransaction() {
                    // TODO Auto-generated method stub
                 }

              });
   }
   }


