package com.example.nitin.desichain.ExtraFunctionality;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.view.View;

/**
 * Created by NITIN on 12-Jun-17.
 */

public class ScollvieExtn extends NestedScrollView {
    public ScollvieExtn(Context context) {
        super(context);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }
}
