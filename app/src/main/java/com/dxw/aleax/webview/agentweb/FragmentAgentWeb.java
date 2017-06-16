package com.dxw.aleax.webview.agentweb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dxw.aleax.R;
import com.dxw.aleax.adapter.ShowAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.dxw.aleax.webview.agentweb.CommonActivity.TYPE_KEY;

/**
 * Created by dxw on 2017/6/16.
 */

public class FragmentAgentWeb extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListVview;
    private ShowAdapter mShowAdapter;
    private List<String> mListDatas;
    private static final String EXTRA_CONTENT = "content";

    public static FragmentAgentWeb newInstance(String content) {
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        FragmentAgentWeb tabContentFragment = new FragmentAgentWeb();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }

    private List<String> getDatas() {
        List<String> mListDatas = new ArrayList<>();
        mListDatas.add("Activity 使用AgentWeb");
        mListDatas.add("Fragment 使用AgentWeb");
        mListDatas.add("文件下载");
        mListDatas.add("input 标签文件上传");
        mListDatas.add("js通信文件上传");
        mListDatas.add("js通信");
        mListDatas.add("Video 视频全屏播放");
        mListDatas.add("自定义进度条");
        mListDatas.add("自定义设置");
        mListDatas.add("电话 信息 邮件");
        return mListDatas;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_listview, null);
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
        switch (position) {
            case 0 :
                startActivity(new Intent(getActivity(), WebActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 0));
                break;
            case 2:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 1));
                break;
            case 3:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 2));
                break;
            case 4:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 3));
                break;
            case 5:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 4));
                break;
            case 6:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 5));
                break;

            case 7:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 6));
                break;

            case 8:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 7));
                break;

            case 9:
                startActivity(new Intent(getActivity(), CommonActivity.class).putExtra(TYPE_KEY, 8));
                break;
        }
    }
}
