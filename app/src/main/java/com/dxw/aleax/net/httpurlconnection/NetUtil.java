package com.dxw.aleax.net.httpurlconnection;

import android.accounts.NetworkErrorException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dxw on 2017/6/14.
 *
 *
 *
 */

public class NetUtil {

    public interface Callback{
        void onResponse(String response);
    }

   public static String post (String url,String content) {
       HttpURLConnection mHUConn = null;
       try {
           URL mURL = new URL(url);
           mHUConn = (HttpURLConnection)mURL.openConnection();
           mHUConn.setRequestMethod("POST"); // 设置请求方法为post
           mHUConn.setReadTimeout(5000);// 设置读取超时为5秒
           mHUConn.setConnectTimeout(10000);// 设置连接超时为10秒
           mHUConn.setDoOutput(true);// 设置此方法,允许向服务器输出内容

           // post请求的参数
           String data = content;
           OutputStream out = mHUConn.getOutputStream();
           out.write(data.getBytes());
           out.flush();
           out.close();

           // 调用此方法就不必再使用conn.connect()方法
           int responseCode = mHUConn.getResponseCode();
           if (responseCode == 200) {
               InputStream is = mHUConn.getInputStream();
               String response = getStringFromInputStream(is);
               return response;
           } else {
               throw new NetworkErrorException("response status is "+responseCode);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return "";
   }

    public static String get(String url) {
        HttpURLConnection conn = null;
        try {
            // 利用string url构建URL对象
            URL mURL = new URL(url);
            conn = (HttpURLConnection) mURL.openConnection();

            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(10000);

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {

                InputStream is = conn.getInputStream();
                String response = getStringFromInputStream(is);
                return response;
            } else {
                throw new NetworkErrorException("response status is "+responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (conn != null) {
                conn.disconnect();
            }
        }

        return null;
    }

    private static String getStringFromInputStream(InputStream is) throws Exception{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 模板代码 必须熟练
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        is.close();
        String state = os.toString();// 把流中的数据转换成字符串,采用的编码是utf-8(模拟器默认编码)
        os.close();
        return state;
    }
}
