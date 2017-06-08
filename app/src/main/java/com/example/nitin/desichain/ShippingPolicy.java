package com.example.nitin.desichain;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ShippingPolicy extends Fragment {

    TextView DeliveryHeading;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v=inflater.inflate(R.layout.fragment_shipping_policy, container, false);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DeliveryHeading= (TextView) v.findViewById(R.id.deliveryheadingtext);
        DeliveryHeading.setPaintFlags(DeliveryHeading.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        DeliveryHeading.setText(" Delivery Period (Tentative)");

    }
}

