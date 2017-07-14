package com.example.nitin.desichain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.florescu.android.rangeseekbar.RangeSeekBar;

/**
 * Created by ashis on 7/13/2017.
 */

public class PriceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_price,container,false);

        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<Integer>(getActivity());

        RangeSeekBar seekBar = (RangeSeekBar) view.findViewById(R.id.seekbar);
        seekBar.setRangeValues(0,200);
        seekBar.setSelectedMinValue(10);
        seekBar.setSelectedMaxValue(200);
        seekBar.setTextAboveThumbsColor(Color.BLACK);


        return view;
    }
}
