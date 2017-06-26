package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.nitin.desichain.Adapters.ChildCategoryAdapter;
import com.example.nitin.desichain.Contents.ChildCategoryList;

import java.util.ArrayList;

import static com.example.nitin.desichain.MainActivity.arrayList;
import static com.example.nitin.desichain.MainActivity.hashMap;


public class Childcategoru extends AppCompatActivity {

    ArrayList<ChildCategoryList> homedecor;
    ArrayList<ChildCategoryList> homefurnishing;
    ArrayList<ChildCategoryList> kitchenndinning;
    ArrayList<ChildCategoryList> agarbatti;
    ArrayList<ChildCategoryList> bells;
    ArrayList<ChildCategoryList> itemsofworship;
    ArrayList<ChildCategoryList> murtis;
    ArrayList<ChildCategoryList> otheressentials;
    ArrayList<ChildCategoryList> bhagavad;
    ArrayList<ChildCategoryList> media;
    ArrayList<ChildCategoryList> paperback;
    ArrayList<ChildCategoryList> personalcare;
    ArrayList<ChildCategoryList> healthandfood;
    ArrayList<ChildCategoryList> fashion;
    ArrayList<ChildCategoryList> women;
    ArrayList<ChildCategoryList> men;
    ArrayList<ChildCategoryList> bags;
    ArrayList<ChildCategoryList> mobile;
    GridView gridView;
    ChildCategoryAdapter childCategoryAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childcategoru);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inti();
        gridView= (GridView) findViewById(R.id.singlechildlistview);
        Intent intent = getIntent();
        String choice = intent.getStringExtra("get");
         if(hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(0).equals(choice)){
             setBhagavad();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,bhagavad);
             gridView.setAdapter(childCategoryAdapter);


         }
        else if(hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(1).equals(choice))
         {

                setPaperback();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,paperback);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(2).equals(choice)){

             setMedia();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,media);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(0).equals(choice)){

             setItemsofworship();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,itemsofworship);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(1).equals(choice)){
             setOtheressentials();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,otheressentials);
             gridView.setAdapter(childCategoryAdapter);

         }
        else if(hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(2).equals(choice)){
             setBells();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,bells);
             gridView.setAdapter(childCategoryAdapter);

         }
        else if(hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(3).equals(choice)){

             setAgarbatti();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,agarbatti);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(4).equals(choice)){

             setMurtis();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,murtis);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(0).equals(choice)){

             setHomedecor();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,homedecor);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(1).equals(choice)){

             setHomefurnishing();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,homefurnishing);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(2).equals(choice))
         {
             setKitchenndinning();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,kitchenndinning);
             gridView.setAdapter(childCategoryAdapter);

         }
         else if(hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(0).equals(choice)){

             setPersonalcare();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,personalcare);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(1).equals(choice)){

             setHealthandfood();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,healthandfood);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(2).equals(choice)){

             setFashion();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,fashion);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(3).equals(choice)){

             setWomen();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,women);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(4).equals(choice)){

             setMen();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,men);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(5).equals(choice)){
             setBags();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,bags);
             gridView.setAdapter(childCategoryAdapter);

         }
         else if(hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(6).equals(choice))
         {
             setMobile();

             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,mobile);
             gridView.setAdapter(childCategoryAdapter);

           }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(Childcategoru.this,CategoryPage.class);
                startActivity(intent1);
            }
        });
    }

    public void inti(){
        homedecor = new ArrayList<>();
        homefurnishing = new ArrayList<>();
        kitchenndinning = new ArrayList<>();
        agarbatti = new ArrayList<>();
        murtis = new ArrayList<>();
        bells = new ArrayList<>();
        itemsofworship = new ArrayList<>();
        paperback = new ArrayList<>();
        mobile = new ArrayList<>();
        bags = new ArrayList<>();
        women = new ArrayList<>();
        men = new ArrayList<>();
        fashion = new ArrayList<>();
        healthandfood = new ArrayList<>();
        personalcare = new ArrayList<>();
        otheressentials = new ArrayList<>();
        bhagavad = new ArrayList<>();
        media = new ArrayList<>();
    }

    public void setHomedecor() {
        homedecor.add(new ChildCategoryList("Showpieces & Decoratives", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Arts,Gift & Crafts", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Clocks", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Lamps & Lighting", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Paintings", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Wall Decals", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Photo Frames & Albums", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Candles & Fragrances", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Flowers,Plants & Vases", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Religion & Devotion", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Festive Decor", R.mipmap.ic_security_black_24dp));

    }

    public void setHomefurnishing() {


        homefurnishing.add(new ChildCategoryList("Bedsheets", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Curtains", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Cushion & Pillow Covers", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Blankets,Quilts & Dohars", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Towels", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Mats Carpets & Rugs", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Bath Linen", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Diwan Sets", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Bedding Sets", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Sofa Covers", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Tables", R.mipmap.ic_security_black_24dp));

    }

    public void setKitchenndinning() {

        kitchenndinning.add(new ChildCategoryList("Dinnerware", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Cookware", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Kitchen Tools & Cultery", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Kitchen Care", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Laundry Care", R.mipmap.ic_security_black_24dp));

    }

    public void setAgarbatti() {

        agarbatti.add(new ChildCategoryList("Incense Sticks", R.mipmap.ic_security_black_24dp));
        agarbatti.add(new ChildCategoryList("Natural Dhoops", R.mipmap.ic_security_black_24dp));
    }

    public void setBells() {

        bells.add(new ChildCategoryList("Brass", R.mipmap.ic_security_black_24dp));

    }

    public void setItemsofworship() {

        itemsofworship.add(new ChildCategoryList("Japa Mala & Bags", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList(" Mats/Assan", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Other Items", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Pooja Lamps", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Pooja Thali", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Pooja Vessels", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Sacrifices(Havan)Items", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Sindoor(Vermilion)", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Wicks(Batti", R.mipmap.ic_security_black_24dp));

    }

    public void setMurtis() {

        murtis.add(new ChildCategoryList("Brass", R.mipmap.ic_security_black_24dp));
        murtis.add(new ChildCategoryList("Mini Temples", R.mipmap.ic_security_black_24dp));

    }

    public void setOtheressentials() {

        otheressentials.add(new ChildCategoryList("Kanthi Mala/Neck Beads", R.mipmap.ic_security_black_24dp));
        otheressentials.add(new ChildCategoryList("Khadaun/Slippers", R.mipmap.ic_security_black_24dp));
        otheressentials.add(new ChildCategoryList("Scarf/Chadar", R.mipmap.ic_security_black_24dp));

    }

    public void setBhagavad() {

        bhagavad.add(new ChildCategoryList("Bengali", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Chinese", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("English", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Gujarati", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Hindi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Kannada", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Malayalam", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Marathi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Nepali", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Oriya", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Punjabi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Russian", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Sindhi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Tamil", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Telugu", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Urdu", R.mipmap.ic_security_black_24dp));

    }

    public void setMedia() {

        media.add(new ChildCategoryList("Animation Movies", R.mipmap.ic_security_black_24dp));
        media.add(new ChildCategoryList("Independent Cinema", R.mipmap.ic_security_black_24dp));
        media.add(new ChildCategoryList("kirtans/Bhajans", R.mipmap.ic_security_black_24dp));
        media.add(new ChildCategoryList("Lectures/Talks", R.mipmap.ic_security_black_24dp));

    }

    public void setPaperback() {

        paperback.add(new ChildCategoryList("Astrology", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Ayurveda & Health", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Biography", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Children", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Classic Text", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Cooking & Vegetariansim", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Cow Protection", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Magazines", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Personal Growth", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Philossophy", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Re-Incranation", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Religious/Spirtual", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Science", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Travel & Pilgrimage", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Vedic/Indian Culture", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Yoga and Meditation", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Language Learning", R.mipmap.ic_security_black_24dp));
    }

    public void setPersonalcare() {



        personalcare.add(new ChildCategoryList("Baby Care", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Bath & Body", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Cosmetics/Skin Care", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Hair Cair", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Miscellaneous", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Oral Care", R.mipmap.ic_security_black_24dp));

    }

    public void setHealthandfood() {


        healthandfood.add(new ChildCategoryList("Rice/Flour/Cereal", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Spices(Masalas) & Herbs", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Snacks", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Herbal Tea/Coffee", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("DryFruits,Nuts,Seeds", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Food Suplements", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Cow Products", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Miscellaneous", R.mipmap.ic_security_black_24dp));


    }

    public void setFashion() {


        fashion.add(new ChildCategoryList("Fashion Accessiories", R.mipmap.ic_security_black_24dp));
        fashion.add(new ChildCategoryList("JewelLery", R.mipmap.ic_security_black_24dp));
        fashion.add(new ChildCategoryList("Eye Wear", R.mipmap.ic_security_black_24dp));
    }

    public void setMen() {

        men.add(new ChildCategoryList("Footwear", R.mipmap.ic_security_black_24dp));

    }

    private void setWomen() {

        women.add(new ChildCategoryList("Footwear", R.mipmap.ic_security_black_24dp));
    }

    public void setBags() {


        bags.add(new ChildCategoryList("Footwear", R.mipmap.ic_security_black_24dp));
        bags.add(new ChildCategoryList("Bags", R.mipmap.ic_security_black_24dp));
        bags.add(new ChildCategoryList("School Stationery", R.mipmap.ic_security_black_24dp));

    }

    public void setMobile() {

        mobile.add(new ChildCategoryList("Mobile & Accessiories", R.mipmap.ic_security_black_24dp));

    }

}
