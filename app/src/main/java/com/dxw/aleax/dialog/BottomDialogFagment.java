package com.dxw.aleax.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import me.curzbin.library.BottomDialog;
import me.curzbin.library.Item;
import me.curzbin.library.OnItemClickListener;

/**
 * Created by dxw on 2017/6/14.
 */

public class BottomDialogFagment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mListVview;
    private ShowAdapter mShowAdapter;
    private List<String> mListDatas;
    private static final String EXTRA_CONTENT = "content";

    public static BottomDialogFagment newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        BottomDialogFagment tabContentFragment = new BottomDialogFagment();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }

    private List<String> getDatas(){
        List<String> mListDatas = new ArrayList<>();
        mListDatas.add("单一水平方向显示");
        mListDatas.add("多个水平方向显示");
        mListDatas.add("单一竖直方向显示");
        mListDatas.add("多个竖直方向显示");
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
        if (position == 0) {// AlterDialog 基础用法 无 取消确定
         new BottomDialog(getActivity())
                .title(R.string.share_title)
                .orientation(BottomDialog.HORIZONTAL)
                .inflateMenu(R.menu.menu_share, new OnItemClickListener() {
                    @Override
                    public void click(Item item) {
                        Toast.makeText(getActivity(), getString(R.string.share_title) + item.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
        } else if (position == 1) { // AlterDialog 基础用法 有 取消确定
            new BottomDialog(getActivity())
                    .title(R.string.share_title)
                    .orientation(BottomDialog.HORIZONTAL)
                    .inflateMenu(R.menu.menu_share, new OnItemClickListener() {
                        @Override
                        public void click(Item item) {
                            Toast.makeText(getActivity(), getString(R.string.share_title) + item.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .inflateMenu(R.menu.menu_main, new OnItemClickListener() {
                        @Override
                        public void click(Item item) {
                            Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        } else if (position == 2) {
            new BottomDialog(getActivity())
                    .title(R.string.title_item)
                    .orientation(BottomDialog.VERTICAL)
                    .inflateMenu(R.menu.menu_share, new OnItemClickListener() {
                        @Override
                        public void click(Item item) {
                            Toast.makeText(getActivity(), getString(R.string.share_title) + item.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        } else if (position == 3) {
            new BottomDialog(getActivity())
                    .title(R.string.title_item)
                    .layout(BottomDialog.GRID)
                    .orientation(BottomDialog.VERTICAL)
                    .inflateMenu(R.menu.menu_grid, new OnItemClickListener() {
                        @Override
                        public void click(Item item) {
                            Toast.makeText(getActivity(), getString(R.string.share_title) + item.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }
    }
}
