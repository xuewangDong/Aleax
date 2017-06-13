package com.dxw.aleax;

import android.support.v4.app.Fragment;

import com.dxw.aleax.fragment.DialogUtilFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by dxw on 2017/6/12.
 */

public class DialogActivity extends BaseActivity{

    @Override
    protected List<String> getTabIndicator() {
        return Arrays.asList(new String[]{
                "DialogUtil"
        });
    }

    @Override
    protected List<Fragment> getTabFragments() {
        List<Fragment>  tabFragments = new ArrayList<>();
        for (String s : getTabIndicator()) {
            tabFragments.add(DialogUtilFragment.newInstance(s));
        }
        return tabFragments;
    }
}
