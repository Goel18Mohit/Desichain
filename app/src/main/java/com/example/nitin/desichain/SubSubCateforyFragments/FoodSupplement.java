package com.example.nitin.desichain.SubSubCateforyFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nitin.desichain.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodSupplement extends Fragment {


    public FoodSupplement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_supplement, container, false);
    }

}
