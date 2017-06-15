package com.dxw.aleax.net.httpurlconnection;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.dxw.aleax.MyApplication;
import com.dxw.aleax.R;
import com.dxw.aleax.adapter.ShowAdapter;
import com.dxw.aleax.util.ToastUtil;
import com.hss01248.lib.StytledDialog;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dxw on 2017/6/14.
 * 基础知识 ： http://www.jianshu.com/p/3141d4e46240
 */

public class FragmentBaseNetWork extends Fragment implements AdapterView.OnItemClickListener {
    private static final String GET_URL = "http://192.168.1.241:8002/consult/getInteractionCircleList?Page=0&PageSize=1";
    private static final String POST_URL = "http://192.168.1.241:8002/consult/getInteractionCircleList";

    private ListView mListVview;
    private ShowAdapter mShowAdapter;
    private List<String> mListDatas;
    private static final String EXTRA_CONTENT = "content";

    public static FragmentBaseNetWork newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        FragmentBaseNetWork tabContentFragment = new FragmentBaseNetWork();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }

    private List<String> getDatas(){
        List<String> mListDatas = new ArrayList<>();
        mListDatas.add("HttpURLConnection post ");
        mListDatas.add("HttpURLConnection get ");
        return mListDatas;
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
        if (position == 0 ) {
           // postHttpUrlConnection();
            postAsync();
        } else if (position == 1) {
           // getHttpUrlConnection();
            getAsync();
        }
    }
    private  void  getAsync(){
        AsyncNetUtil.get(GET_URL, new NetUtil.Callback() {
            @Override
            public void onResponse(String response) {
                ToastUtil.showToast(response);
            }
        });
    }

    private  void  postAsync(){
        AsyncNetUtil.post(POST_URL, "Page=0&PageSize=1", new AsyncNetUtil.Callback() {
            @Override
            public void onResponse(String response) {
                ToastUtil.showToast(response);
            }
        });
    }

    /***raw */
    private void getHttpUrlConnection() {
        final Dialog dialog = StytledDialog.showProgressDialog(getContext(), "正在请求", true, true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String  response =  NetUtil.get(GET_URL);
                StytledDialog.dismiss(dialog); // Dialog 可以在子线程中DisMiss 但是不可以在子线程中Show（）;
                MyApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.showToast(response);
                    }
                });
            }
        }).start();
    }

    /**post
     * Dialog 可以在子线程中结束。
     *
     * */
    private void postHttpUrlConnection() {
        final Dialog dialog = StytledDialog.showProgressDialog(getContext(), "正在请求", true, true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String  response =  NetUtil.post(POST_URL,"Page=0&PageSize=1");
                StytledDialog.dismiss(dialog); // Dialog 可以在子线程中DisMiss 但是不可以在子线程中Show（）;
                MyApplication.getHandler().post(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.showToast(response);
                    }
                });
            }
        }).start();
    }
}
