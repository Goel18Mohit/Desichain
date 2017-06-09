package com.example.nitin.desichain;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Policy extends AppCompatActivity implements View.OnClickListener {


    private TextView returnTextView, customerText;
    private ImageView returnImage,customerImage;
    private int RETURN_CLICKS = 0,CUSTOMER_CLICKS =0;
    private FragmentManager fragmentManager;
    final ReturnPolicy returnPolicy = new ReturnPolicy();
    final CustomerService customerService = new CustomerService();
    TextView SHIPPING_POLICY_TEXTVIEW;
    ImageView SHIPPING_POLICY_BUTTON;
    FragmentManager FRAGMENTMANAGER;
    public static int SHIPPING_FLAG =0;
    final ShippingPolicy shippingPolicy=new ShippingPolicy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        returnImage = (ImageView) findViewById(R.id.img_return_policy);
        returnTextView=(TextView) findViewById(R.id.textview_return_policy);
        customerText = (TextView) findViewById(R.id.textCustomerService);
        customerImage = (ImageView) findViewById(R.id.imgCustomerService);
        fragmentManager = getSupportFragmentManager();

        returnTextView.setOnClickListener(this);
        returnImage.setOnClickListener(this);

        customerText.setOnClickListener(this);
        customerImage.setOnClickListener(this);


        FRAGMENTMANAGER=getSupportFragmentManager();
        SHIPPING_POLICY_TEXTVIEW= (TextView) findViewById(R.id.shipping_policy);
        SHIPPING_POLICY_BUTTON= (ImageView) findViewById(R.id.shipping_policy1);
        SHIPPING_POLICY_BUTTON.setOnClickListener(this);
        SHIPPING_POLICY_TEXTVIEW.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        Toast.makeText(this,"button clicked",Toast.LENGTH_SHORT).show();
        int id=v.getId();
        switch (id){
           case R.id.img_return_policy:
            case R.id.textview_return_policy:
                    if (RETURN_CLICKS == 0){
                        fragmentManager.beginTransaction().replace(R.id.fragment_return_policy,returnPolicy).commit();
                        RETURN_CLICKS =1;
                        returnImage.setImageResource(R.mipmap.ic_remove_black_24dp);
                    }
                    else if (RETURN_CLICKS == 1){
                        fragmentManager.beginTransaction().remove(returnPolicy).commit();
                        RETURN_CLICKS =0;
                        returnImage.setImageResource(R.mipmap.ic_add_black_24dp);
                    }
                    break;
            case R.id.imgCustomerService:
            case R.id.textCustomerService:
                    if (CUSTOMER_CLICKS == 0){
                        fragmentManager.beginTransaction().replace(R.id.fragment_customer_Service,customerService).commit();
                        CUSTOMER_CLICKS=1;
                        customerImage.setImageResource(R.mipmap.ic_remove_black_24dp);
                    }
                    else{
                        fragmentManager.beginTransaction().remove(customerService).commit();
                        CUSTOMER_CLICKS=0;
                        customerImage.setImageResource(R.mipmap.ic_add_black_24dp);
                    }
                    break;
          case R.id.shipping_policy:
            case R.id.shipping_policy1:if(SHIPPING_FLAG ==0) {
                SHIPPING_FLAG =1;
                fragmentopen(R.id.shippingfragment);
                SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_remove_black_24dp);
            }
                else if(SHIPPING_FLAG ==1)
            {
                fragmentclose(R.id.shippingfragment);
                SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                SHIPPING_FLAG =0;
            }
                                       break;
        }
    }

    public void fragmentopen(int fragmentid){

        switch (fragmentid){
            case R.id.shippingfragment:
                FRAGMENTMANAGER.beginTransaction().replace(fragmentid,shippingPolicy).commit();


        }

    }
    public void fragmentclose(int fragmentid)
    {
        switch (fragmentid){
            case R.id.shippingfragment:
                FRAGMENTMANAGER.beginTransaction().remove(shippingPolicy).commit();
                break;
        }
    }
}
