package com.dxw.aleax.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dxw.aleax.R;

import java.util.List;

/**
 * Created by dxw on 2017/6/14.
 */

public class ShowAdapter extends BaseAdapter{

    private List<String> mListDatas;
    private Context mContext;
    private LayoutInflater mInflater;

    public ShowAdapter(Context context){
       this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setListDatas (List<String> datas) {
        this.mListDatas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mListDatas == null ? 0 : mListDatas.size();
    }

    @Override
    public String getItem(int position) {
        return mListDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  viewHolder = null;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.show_adapter_item,null);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.list_items);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String item = mListDatas.get(position);
        if (!TextUtils.isEmpty(item)) {
            viewHolder.mTextView.setText(item);
        }
        return convertView;
    }

    class ViewHolder{
        TextView mTextView;
    }
}
