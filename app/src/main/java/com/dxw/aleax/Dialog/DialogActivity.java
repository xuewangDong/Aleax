package com.dxw.aleax.Dialog;

import android.support.v4.app.Fragment;

import com.dxw.aleax.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by dxw on 2017/6/12.
 *
 */

public class DialogActivity extends BaseActivity {

    @Override
    protected List<String> getTabIndicator() {
        return Arrays.asList(new String[]{
                "DialogUtil","基础"
        });
    }

    @Override
    protected List<Fragment> getTabFragments() {
        List<Fragment>  tabFragments = new ArrayList<>();
        tabFragments.add(DialogUtilFragment.newInstance(getTabIndicator().get(0)));
        tabFragments.add(AlterDialogFragment.newInstance(getTabIndicator().get(1)));
        return tabFragments;
    }
}
