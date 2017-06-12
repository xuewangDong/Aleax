package com.dxw.aleax;

import android.support.v4.app.Fragment;

import com.dxw.aleax.fragment.TabListFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by dxw on 2017/6/12.
 */

public class DialogActivity extends BaseActivity{
    @Override
    protected List<String> getTabIndicator() {
       List<String> tabIndicators = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tabIndicators.add("Tab " + i);
        }
        return tabIndicators;
    }

    @Override
    protected List<Fragment> getTabFragments() {
        List<Fragment>  tabFragments = new ArrayList<>();
        for (String s : getTabIndicator()) {
            tabFragments.add(TabListFragment.newInstance(s));
        }
        return tabFragments;
    }
}
