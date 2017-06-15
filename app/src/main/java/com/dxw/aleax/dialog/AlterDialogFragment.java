package com.dxw.aleax.dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.dxw.aleax.R;
import com.dxw.aleax.adapter.ShowAdapter;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dxw on 2017/6/14.
 * 摘自 http://liangjingkanji.coding.me/2016/10/09/Diglog/
 */

public class AlterDialogFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListVview;
    private ShowAdapter mShowAdapter;
    private List<String> mListDatas;

    private static final String EXTRA_CONTENT = "content";

    public static AlterDialogFragment newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        AlterDialogFragment tabContentFragment = new AlterDialogFragment();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }

    private List<String> getDatas(){
        List<String> mListDatas = new ArrayList<>();
        mListDatas.add("AlterDialog  无 取消确定");
        mListDatas.add("AlterDialog  有 取消确定");
        mListDatas.add("AlterDialog  选择对话框");
        mListDatas.add("MaterialDesign单选对话框");
        mListDatas.add("MaterialDesign多选对话框");
        mListDatas.add("自定义对话框            ");
        mListDatas.add("ProgressDialog   一般  ");
        mListDatas.add("ProgressDialog   进度条  ");
        mListDatas.add("DialogFragment   自定义  ");
        return mListDatas;
    }

    private void toast(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_tab_listview,null);
         mListVview = (ListView) view.findViewById(R.id.lv_content);
         mShowAdapter = new ShowAdapter(getActivity());
         mListDatas = getDatas();
         mShowAdapter.setListDatas(mListDatas);
         mListVview.setAdapter(mShowAdapter);

         mListVview.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0 ) {// AlterDialog 基础用法 无 取消确定
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("标题");
            builder.setMessage("信息");
            builder.show();
        } else if (position == 1) { // AlterDialog 基础用法 有 取消确定
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("标题");
            builder.setMessage("信息");
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    toast("取消");
                }
            });
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    toast("确定");
                }
            });
            builder.setNeutralButton("中立按钮",null);
            builder.show();
        } else if (position == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("标题");
            builder.setItems(new CharSequence[]{"鲍鱼","象拔蚌","花甲"},null);
            builder.setNegativeButton("取消",null);
            builder.show();
        } else if (position == 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("标题");
            builder.setSingleChoiceItems(new CharSequence[]{"鲍鱼","象拔蚌","花甲"},1,null);
            builder.show();
        } else if (position == 4) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("标题");
            builder.setMultiChoiceItems(new CharSequence[]{"鲍鱼","象拔蚌","花甲"},null,null);
            builder.show();
        } else if (position == 5) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("登录界面");
            builder.setView(R.layout.self_dialog);
            builder.show();
//            监听器
//
//              取消监听器
//
//            取消监听器是点击对话框外部的方式关闭了对话框. 调用dismiss方法关闭的时候不会回调
//
//            AlertDialog.Builder setOnCancelListener (DialogInterface.OnCancelListener onCancelListener)

        } else if (position == 6) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("标题");
            progressDialog.setMessage("加载中...");
            progressDialog.show();
        } else if (position == 7) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle("标题");
            progressDialog.setMessage("加载中...");
            progressDialog.show();
            /**
             * 进度设置

             既然是进度对话框当然提供设置进度的方法, 默认的旋转进度条样式是无法设置进度的. 该方法必须在show()后面执行才生效.
             int getProgress ()
             void setProgress (int value)
             最大进度
             void setMax (int max)
             int getMax ()
             */
        } else if (position == 8) {
           CustonDialogFragment dialogFragment = new CustonDialogFragment();
           dialogFragment.show(getFragmentManager(),"FragemntDialog");
        }
    }
}
