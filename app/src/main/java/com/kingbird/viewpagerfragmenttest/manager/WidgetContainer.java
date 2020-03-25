package com.kingbird.viewpagerfragmenttest.manager;


import com.kingbird.viewpagerfragmenttest.BaseFragment;
import com.kingbird.viewpagerfragmenttest.fragment.CollapsingTopBarLayoutFragment;
import com.kingbird.viewpagerfragmenttest.fragment.TabSegmentScrollableModeFragment;
import com.kingbird.viewpagerfragmenttest.model.ItemDescription;
import com.kingbird.viewpagerfragmenttest.viewpager.FitSystemWindowViewPagerFragment;
import com.kingbird.viewpagerfragmenttest.viewpager.LoopViewPagerFragment;
import com.kingbird.viewpagerfragmenttest.viewpager.ViewPagerFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WidgetContainer
 * @Description: java类作用描述
 * @Author: Pan
 * @CreateDate: 2020/3/20 09:08:08
 */
class WidgetContainer {

    private static WidgetContainer sInstance = new WidgetContainer();

    private Map<Class<? extends BaseFragment>, ItemDescription> mWidgets;

    private WidgetContainer() {
        mWidgets = new HashMap<>();
        mWidgets.put(FitSystemWindowViewPagerFragment.class, new ItemDescription(FitSystemWindowViewPagerFragment.class, "QDFitSystemWindowViewPagerFragment", 0, ""));
        mWidgets.put(LoopViewPagerFragment.class, new ItemDescription(LoopViewPagerFragment.class, "QDLoopViewPagerFragment", 0, ""));
        mWidgets.put(ViewPagerFragment.class, new ItemDescription(ViewPagerFragment.class, "QMUIViewPager", 2131492891, ""));
        mWidgets.put(TabSegmentScrollableModeFragment.class, new ItemDescription(TabSegmentScrollableModeFragment.class, "内容自适应，超过父容器则滚动", 0, ""));
        mWidgets.put(CollapsingTopBarLayoutFragment.class, new ItemDescription(CollapsingTopBarLayoutFragment.class, "QMUICollapsingTopBarLayout", 2131492877, ""));
    }

    public static WidgetContainer getInstance() {
        return sInstance;
    }

    public ItemDescription get(Class<? extends BaseFragment> fragment) {
        return mWidgets.get(fragment);
    }
}

