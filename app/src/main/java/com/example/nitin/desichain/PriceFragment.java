package com.example.nitin.desichain;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;


/**
 * Created by ashis on 7/13/2017.
 */

public class PriceFragment extends Fragment {

    CrystalRangeSeekbar seekbar;
    private TextView minPriceText,maxPriceText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_price,container,false);

       // RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<Integer>(getActivity());

        seekbar=(CrystalRangeSeekbar)view.findViewById(R.id.seekbar);
        minPriceText=(TextView)view.findViewById(R.id.minPriceSeekbarText);
        maxPriceText=(TextView)view.findViewById(R.id.maxPriceSeekbarText);

        seekbar.setMinStartValue(0);
        seekbar.setMaxStartValue(200);
        seekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                minPriceText.setText("₹  " + String.valueOf(minValue))  ;
                maxPriceText.setText("₹  " + String.valueOf(maxValue));
            }
        });
/*
        final RangeSeekBar seekBar = (RangeSeekBar) view.findViewById(R.id.seekbar);
        seekBar.setRangeValues(0,200);
        seekBar.setSelectedMinValue(10);
        seekBar.setSelectedMaxValue(200);
        seekBar.setTextAboveThumbsColor(Color.BLACK);

        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Object minValue, Object maxValue) {

                minPriceText.setText(String.valueOf(minValue));

            }

        });
*/

        return view;
    }
}
