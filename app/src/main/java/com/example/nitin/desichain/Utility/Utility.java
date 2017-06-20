package com.example.nitin.desichain.Utility;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;

import com.example.nitin.desichain.AboutUs;
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

    public  void openIntent(Context mContext, int id){
        switch (id){
            case R.id.myorders:
                Intent MYORDERS=new Intent(mContext, MyOrders.class);
                mContext.startActivity(MYORDERS);
                break;
            case R.id.mycart:
                Intent MYCART=new Intent(mContext, MyCart.class);
                mContext.startActivity(MYCART);
                break;
            case R.id.myProductLayout:
                Intent mProductIntent = new Intent(mContext, ProductPageActual.class);
                mContext.startActivity(mProductIntent);
                break;
            case R.id.myaccount:
                Intent MYACCOUNT=new Intent(mContext, MyAccount.class);
                mContext.startActivity(MYACCOUNT);
                break;
            case R.id.helpcenter:
                Intent HELPCENTER=new Intent(mContext, HelpCentre.class);
                mContext.startActivity(HELPCENTER);
                break;
            case R.id.policy:Intent POLICY=new Intent(mContext, Policy.class);
                mContext.startActivity(POLICY);
                break;
            case R.id.ratedesichain:
                Toast.makeText(mContext,"PLAYSTORELINK",Toast.LENGTH_SHORT).show();
                break;
            case R.id.facebook:
                openFbIntent(mContext);
                break;
            case R.id.googleplus:
                openGoogleIntent(mContext);
                break;
            case R.id.twitter:
                openTwitterIntent(mContext);
                break;
            case R.id.pinterest:
                openPinterestIntent(mContext);
                break;
            case R.id.youtube:
                openYoutubeIntent(mContext);
                break;
            case R.id.instagram:
                openInstaIntent(mContext);
                break;
            case R.id.aboutus:
                Intent ABOUTUS=new Intent(mContext, AboutUs.class);
                mContext.startActivity(ABOUTUS);
                break;
            default: break;
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

}
