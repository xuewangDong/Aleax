package com.dxw.aleax.net.httpurlconnection;

import com.dxw.aleax.MyApplication;

/**
 * Created by dxw on 2017/6/14.
 *
 * 简单的封装  缺点：
 * 每次都new Thread，new Handler消耗过大
   没有异常处理机制
   没有缓存机制
   没有完善的API(请求头,参数,编码,拦截器等)与调试模式
   没有Https
 */

public class AsyncNetUtil {
    public interface Callback{
        void onResponse(String response);
    }

    public static void get(final String url, final NetUtil.Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String reponse = NetUtil.get(url);
                MyApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                      callback.onResponse(reponse);
                    }
                });
            }
        }).start();
    }

    public static void post(final String url, final String content, final Callback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = NetUtil.post(url,content);
                MyApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResponse(response);
                    }
                });
            }
        }).start();
    }
}
