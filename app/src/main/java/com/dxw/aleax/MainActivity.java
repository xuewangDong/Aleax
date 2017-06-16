package com.dxw.aleax;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.dxw.aleax.dialog.DialogActivity;
import com.dxw.aleax.net.NetWorkActivity;
import com.dxw.aleax.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    List<String> mNameList = null;
    List<Class> mNameClasses = null;
    private List<String> getDatas() {
        List<String> mList = new ArrayList<>();
        mList.add("Dialog全解 以及关于Dialog封装用法");
        mList.add("网络 全解 以及关于封装的网络方法");
        mList.add("webView 的使用全解");
        return mList;
    }

    private List<Class> getClasses() {
        List<Class> mList = new ArrayList<>();
        mList.add(DialogActivity.class);
        mList.add(NetWorkActivity.class);
        mList.add(WebViewActivity.class);
        return mList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNameList = getDatas();
        mNameClasses = getClasses();
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mNameList));
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(position);
            }
        });
    }

    private void startActivity(int position) {
        Intent intent = new Intent(this, mNameClasses.get(position));
        startActivity(intent);
    }
}
