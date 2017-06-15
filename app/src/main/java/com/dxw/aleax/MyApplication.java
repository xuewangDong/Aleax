package com.dxw.aleax;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by dxw on 2017/6/14.
 */

public class MyApplication extends Application{
    private static  Context mContext;
    private static Handler mHanlder;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mHanlder = new Handler();
    }

    public static Context getAppContext(){
        return mContext;
    }
    public static Handler getHandler(){
        return mHanlder;
    }

}
