package com.kingbird.viewpagerfragmenttest;

import android.os.Bundle;

import com.kingbird.viewpagerfragmenttest.viewpager.FitSystemWindowViewPagerFragment;
import com.kingbird.viewpagerfragmenttest.viewpager.ViewPagerFragment;
import com.qmuiteam.qmui.arch.QMUIFragmentActivity;
import com.qmuiteam.qmui.arch.annotation.DefaultFirstFragment;
import com.qmuiteam.qmui.arch.annotation.LatestVisitRecord;
import com.socks.library.KLog;

@DefaultFirstFragment(FitSystemWindowViewPagerFragment.class)
@LatestVisitRecord
public class MainActivity extends QMUIFragmentActivity {

    @Override
    protected int getContextViewId() {
        KLog.e("id："+R.id.viewpager);
        return R.id.viewpager;
    }

}
