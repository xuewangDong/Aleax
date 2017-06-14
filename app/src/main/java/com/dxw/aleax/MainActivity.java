package com.dxw.aleax;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.dxw.aleax.Dialog.DialogActivity;

public class MainActivity extends ListActivity {
    String[] mNameList = new String[]{"Dialog全解 以及关于Dialog封装用法"};
    Class[] mNameClasses = new Class[]{DialogActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mNameList));
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(position);
            }
        });




    }

    private void startActivity(int position) {
        Intent intent = new Intent(this, mNameClasses[position]);
        startActivity(intent);
    }
}
