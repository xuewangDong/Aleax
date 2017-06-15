package com.dxw.aleax.dialog;

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
                "基础","仿Ios显示","底部弹出框","MaterialDialog"
        });
    }

    @Override
    protected List<Fragment> getTabFragments() {
        List<Fragment>  tabFragments = new ArrayList<>();
        tabFragments.add(AlterDialogFragment.newInstance(getTabIndicator().get(0)));
        tabFragments.add(DialogUtilFragment.newInstance(getTabIndicator().get(1)));
        tabFragments.add(BottomDialogFagment.newInstance(getTabIndicator().get(2)));
        tabFragments.add(MaterialDialogFragment.newInstance(getTabIndicator().get(3)));
        return tabFragments;
    }
}
