package com.kingbird.viewpagerfragmenttest.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

import com.kingbird.viewpagerfragmenttest.BaseFragment;
import com.kingbird.viewpagerfragmenttest.R;
import com.kingbird.viewpagerfragmenttest.manager.DataManager;
import com.kingbird.viewpagerfragmenttest.model.ItemDescription;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author cginechen
 * @date 2017-09-13
 */

public class ViewPagerFragment extends BaseFragment {
    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBar;
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;

    private DataManager mQDDataManager;
    private ItemDescription mQDItemDescription;

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_grouplistview, null);
        ButterKnife.bind(this, root);

        mQDDataManager = DataManager.getInstance();
        mQDItemDescription = mQDDataManager.getDescription(this.getClass());
        initTopBar();

        initGroupListView();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLazyViewLifecycleOwner().getLifecycle().addObserver(new LazyTestObserver("QDViewPager"));
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        KLog.e("标题："+mQDItemDescription);
        KLog.e("标题："+mQDItemDescription.getName());
        mTopBar.setTitle(mQDItemDescription.getName());
    }

    private void initGroupListView() {
        QMUIGroupListView.newSection(getContext())
                .addItemView(mGroupListView.createItemView(mQDDataManager.getName(
                        FitSystemWindowViewPagerFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        KLog.e("跳转 FitSystemWindowViewPagerFragment");
                        FitSystemWindowViewPagerFragment fragment = new FitSystemWindowViewPagerFragment();
                        startFragment(fragment);
                    }
                })
                .addItemView(mGroupListView.createItemView(mQDDataManager.getName(
                        LoopViewPagerFragment.class)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        KLog.e("跳转 LoopViewPagerFragment");
                        LoopViewPagerFragment fragment = new LoopViewPagerFragment();
                        startFragment(fragment);
                    }
                })
                .addTo(mGroupListView);
    }
}
