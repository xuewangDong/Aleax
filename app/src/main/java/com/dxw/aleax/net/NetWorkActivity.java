package com.dxw.aleax.net;

import android.support.v4.app.Fragment;

import com.dxw.aleax.BaseActivity;
import com.dxw.aleax.net.httpurlconnection.FragmentBaseNetWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dxw on 2017/6/14.
 */

public class NetWorkActivity extends BaseActivity{

    @Override
    protected List<String> getTabIndicator() {
        return Arrays.asList(new String[]{
                "网络基础HttpUrlConnection"
        });
    }

    @Override
    protected List<Fragment> getTabFragments() {
        List<Fragment>  tabFragments = new ArrayList<>();
        tabFragments.add(FragmentBaseNetWork.newInstance(getTabIndicator().get(0)));
        return tabFragments;
    }
}
