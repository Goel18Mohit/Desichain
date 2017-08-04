package com.example.nitin.desichain.Utility;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nitin.desichain.AboutUs;
import com.example.nitin.desichain.CategoryPage;
import com.example.nitin.desichain.HelpCentre;
import com.example.nitin.desichain.MyAccount;
import com.example.nitin.desichain.MyCart;
import com.example.nitin.desichain.MyOrders;
import com.example.nitin.desichain.Policy;
import com.example.nitin.desichain.ProductPageActual;
import com.example.nitin.desichain.R;

import java.util.List;

/**
 * Created by ashis on 6/7/2017.
 */

public class Utility {

    DrawerLayout drawerLayout;
    Context mContext;
    public  void openIntent(Context mContext, int id,DrawerLayout drawer){
        drawerLayout=drawer;
        this.mContext=mContext;
        switch (id){
            case R.id.myorders:
                Intent MYORDERS=new Intent(mContext, MyOrders.class);
                mContext.startActivity(MYORDERS);
                closenavigation();
                break;
            case R.id.mycart:
                Intent MYCART=new Intent(mContext, MyCart.class);
                mContext.startActivity(MYCART);
                closenavigation();
                break;
             case R.id.myaccount:
                Intent MYACCOUNT=new Intent(mContext, MyAccount.class);
                mContext.startActivity(MYACCOUNT);
                closenavigation();
                break;
            case R.id.helpcenter:
                Intent HELPCENTER=new Intent(mContext, HelpCentre.class);
                mContext.startActivity(HELPCENTER);
                closenavigation();
                break;
            case R.id.policy:
                Intent POLICY=new Intent(mContext, Policy.class);
                mContext.startActivity(POLICY);
                closenavigation();
                break;
            case R.id.ratedesichain:
                Toast.makeText(mContext,"PLAYSTORELINK",Toast.LENGTH_SHORT).show();
                closenavigation();
                break;
            case R.id.facebook:
                openFbIntent(mContext);
                closenavigation();
                break;
            case R.id.googleplus:
                openGoogleIntent(mContext);
                closenavigation();
                break;
            case R.id.twitter:
                openTwitterIntent(mContext);
                closenavigation();
                break;
            case R.id.pinterest:
                closenavigation();
                openPinterestIntent(mContext);
                break;
            case R.id.youtube:
                openYoutubeIntent(mContext);
                closenavigation();
                break;
            case R.id.instagram:
                openInstaIntent(mContext);
                closenavigation();
                break;
            case R.id.aboutus:
                Intent ABOUTUS=new Intent(mContext, AboutUs.class);
                mContext.startActivity(ABOUTUS);
                closenavigation();
                break;
//            case R.id.latestProdViewAll:
//                mContext.startActivity(new Intent(mContext, CategoryPage.class));
//                break;
//            case R.id.topTenGameViewAll:
//                mContext.startActivity(new Intent(mContext, CategoryPage.class));
//                break;
//             case R.id.bestSellingProductViewAll:
//                mContext.startActivity(new Intent(mContext, CategoryPage.class));
//                break;
            case R.id.subscribe:
                closenavigation();
                openDialogBox();
            default: break;
        }
    }

public void closenavigation(){
    if(drawerLayout.isDrawerOpen(Gravity.LEFT)) {
        drawerLayout.closeDrawer(Gravity.LEFT);
    }
}

    public static String getFbPageUrl(Context mContext){

          String FACEBOOK_URL = "https://www.facebook.com/DesiChain.in/";
          String FACEBOOK_PAGE_ID = "DesiChain.in";

        PackageManager packageManager = mContext.getPackageManager();

        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana",0).versionCode;
            boolean activated =  packageManager.getApplicationInfo("com.facebook.katana", 0).enabled;
            if (versionCode >= 3002850 && activated){
                return "fb://facewebmodal/f?href="+FACEBOOK_URL;
            }else {
                return "fb://page/"+FACEBOOK_PAGE_ID;
            }

        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL;
        }
    }

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getTwitterUrl(Context mContext){

        String TWITTER_URL = "https://twitter.com/DesiChainindia";
        String TWITTER_ID = "DesiChainindia";

        try {
            String pkgInfo = mContext.getPackageManager().getPackageInfo("com.twitter.android", 0).toString();
            if (pkgInfo.equals("com.twitter.android")) {
                return "twitter://user?user_id=" + TWITTER_ID;
            }
            else {
                return TWITTER_URL;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return TWITTER_URL;
        }
    }
    private void openGoogleIntent(Context context) {
        String communityPage = "communities/+desichainnewdelhi";
        try {
            Intent googleIntent = new Intent(Intent.ACTION_VIEW);
            googleIntent.setClassName("com.google.android.apps.plus", "com.google.android.apps.plus.phone.UrlGatewayActivity");
            googleIntent.putExtra("customAppUri", communityPage);
            context.startActivity(googleIntent);
        }catch (ActivityNotFoundException e){
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/+desichainnewdelhi")));
        }
    }

    private void openPinterestIntent(Context context) {

        context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://in.pinterest.com/desichainin")));
    }

    private void openTwitterIntent(Context context) {
        String twitterUrl = Utility.getTwitterUrl(context);

        Intent twitterIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(twitterUrl));
        twitterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(twitterIntent);

    }

    private void openYoutubeIntent(Context context) {
        String mYoutubeUrl = "https://www.youtube.com/channel/UCAbwILoOustxYFlUuC7rkFg";
        context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(mYoutubeUrl)));
    }

    private void openInstaIntent(Context context) {
        String mInstaUrl = "https://www.instagram.com/desichain.in/";
        Intent instaIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(mInstaUrl));

        instaIntent.setPackage("com.instagram.android");
        if (isIntentAvailable(context, instaIntent)){
            context.startActivity(instaIntent);
        } else{
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mInstaUrl)));
        }

    }

    private boolean isIntentAvailable(Context ctx, Intent intent) {
        final PackageManager packageManager = ctx.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
    private void openFbIntent(Context context) {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = Utility.getFbPageUrl(context);
        facebookIntent.setData(Uri.parse(facebookUrl));
        context.startActivity(facebookIntent);

    }

    public void openDialogBox(){
        AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
        builder.setTitle("Enter The Email");
        final EditText USER_EMAIL_SUBSCRIBE=new EditText(mContext);
        builder.setView(USER_EMAIL_SUBSCRIBE);
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(USER_EMAIL_SUBSCRIBE.getText().toString().equals(""))
                {

                    Toast.makeText(mContext,"",Toast.LENGTH_SHORT).show();
                }
                else {
                    dialog.dismiss();
                    Toast.makeText(mContext, "Email has been seet", Toast.LENGTH_SHORT).show();

                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();


    }


    public static int getDiscount(int ACTUAL_PRICE,int SELLING_PRICE) {

        float diff = ACTUAL_PRICE-SELLING_PRICE;
        diff = diff/ACTUAL_PRICE;
        diff*=100;

        return Math.round(diff);
    }

}
