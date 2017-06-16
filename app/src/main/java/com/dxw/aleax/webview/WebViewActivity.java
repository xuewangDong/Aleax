package com.dxw.aleax.webview;

import android.support.v4.app.Fragment;

import com.dxw.aleax.BaseActivity;
import com.dxw.aleax.webview.agentweb.FragmentAgentWeb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dxw on 2017/6/16.
 */

public class WebViewActivity extends BaseActivity {

    @Override
    protected List<String> getTabIndicator() {
        return Arrays.asList(new String[]{
                "agentweb 封装库"
        });
    }

    @Override
    protected List<Fragment> getTabFragments() {
        List<Fragment>  tabFragments = new ArrayList<>();
        tabFragments.add(FragmentAgentWeb.newInstance(getTabIndicator().get(0)));
        return tabFragments;
    }
}