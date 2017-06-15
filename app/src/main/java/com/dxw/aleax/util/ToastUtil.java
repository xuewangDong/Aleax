package com.dxw.aleax.util;

import android.widget.Toast;

import com.dxw.aleax.MyApplication;

/**
 * Created by dxw on 2017/6/14.
 */

public class ToastUtil {
    public static void showToast(String content) {
        Toast.makeText(MyApplication.getAppContext(),content,Toast.LENGTH_LONG).show();
    }

    public static void showToast(int resId) {
        Toast.makeText(MyApplication.getAppContext(),MyApplication.getAppContext().getResources().getString(resId),Toast.LENGTH_LONG).show();
    }

}
