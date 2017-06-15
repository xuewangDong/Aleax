package com.dxw.aleax.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.StackingBehavior;
import com.dxw.aleax.R;
import com.dxw.aleax.adapter.ShowAdapter;
import com.dxw.aleax.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static com.dxw.aleax.util.ToastUtil.showToast;

/**
 * Created by dxw on 2017/6/15.
 */

public class MaterialDialogFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mListVview;
    private ShowAdapter mShowAdapter;
    private List<String> mListDatas;
    private static final String EXTRA_CONTENT = "content";
    private int index = 0;

    public static MaterialDialogFragment newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        MaterialDialogFragment tabContentFragment = new MaterialDialogFragment();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }

    private List<String> getDatas(){
        List<String> mListDatas = new ArrayList<>();
        mListDatas.add("BASIC (no Title) ");
        mListDatas.add("BASIC ");
        mListDatas.add("BASIC(LOONG CONTENT)");
        mListDatas.add("BASICICON");
        mListDatas.add("BASICCHECKPROMPT");

        mListDatas.add("STACKED");
        mListDatas.add("NEUTRAL");
        mListDatas.add("CALLBACKS");

        mListDatas.add("LIST");
        mListDatas.add("LISTNOTITLE");
        mListDatas.add("longList");
        mListDatas.add("list_longItems");
        mListDatas.add("list_checkPrompt");
        mListDatas.add("list_longPress");
        mListDatas.add("singleChoice");
        mListDatas.add("singleChoice_longItems");

        mListDatas.add("multiChoice");
        mListDatas.add("multiChoiceLimited");
        mListDatas.add("multiChoiceLimitedMin");
        mListDatas.add("multiChoice_longItems");
        mListDatas.add("multiChoice_disabledItems");
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
        if (position == 0) {// BASIC (no Title)
            showBasicNoTitle();
        } else if (position == 1) { // BASIC
            showBasic();
        } else if (position == 2) { // BASIC(LOONG CONTENT)
            showBasicLongContent();
        } else if (position == 3) { // BASICICON
            showBasicIcon();
        } else if (position == 4) {// BASICCHECKPROMPT
            showBasicCheckPrompt();
        } else if (position == 5) { // stacked
            showStacked();
        } else if (position == 6) { // neutral
            getNeutral();
        } else if (position == 7) { //callbacks
            getCallbacks();
        } else if (position == 8) { // list
            getList();
        } else if (position == 9) { // listNoTitle
            getListNoTitle();
        }else if (position == 10) { // longList
            getLongList();
        }else if (position == 11) { // list_longItems
            getListLongItems();
        }else if (position == 12) { // list_checkPrompt
            getListCheckPrompt();
        }else if (position == 13) { // list_longPress
            getListLongPress();
        } else if (position == 14 ) { // singleChoice
            getSingleChoice();
        } else if (position == 15 ) { // singleChoice_longItems
            getSingleChoiceLongItems();
        } else if (position == 16) { // multiChoice
            getMultiChoice();
        } else if (position == 17) { // multiChoiceLimited
            getMultiChoiceLimited();
        } else if (position == 18) { // multiChoiceLimitedMin
            getMultiChoiceLimitedMin();
        } else if (position == 19) { // multiChoice_longItems
            getMultiChoiceLongItems();
        } else if (position == 20) {// multiChoice_disabledItems
            getMultiChoice_disabledItems();
        }
    }

    private void getMultiChoice_disabledItems() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsCallbackMultiChoice(
                        new Integer[]{0, 1, 2},
                        new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                StringBuilder str = new StringBuilder();
                                for (int i = 0; i < which.length; i++) {
                                    if (i > 0) {
                                        str.append('\n');
                                    }
                                    str.append(which[i]);
                                    str.append(": ");
                                    str.append(text[i]);
                                }
                                showToast(str.toString());
                                return true; // allow sele
                            }
                        }
                 )
                .onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.clearSelectedIndices();
                    }
                })
                .alwaysCallMultiChoiceCallback()
                .positiveText("choose_label")
                .autoDismiss(false)
                .neutralText(R.string.clear_selection)
                .itemsDisabledIndices(0, 1)
                .show();
    }

    private void getMultiChoiceLongItems() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks_longItems)
                .itemsCallbackMultiChoice(
                        new Integer[]{1, 3},
                        new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                StringBuilder str = new StringBuilder();
                                for (int i = 0; i < which.length; i++) {
                                    if (i > 0) {
                                        str.append('\n');
                                    }
                                    str.append(which[i]);
                                    str.append(": ");
                                    str.append(text[i]);
                                }
                                showToast(str.toString());
                                return true; // allow selection
                            }
                        }
       )
                .positiveText("choose_label")
                .show();
    }

    private void getMultiChoiceLimitedMin() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsCallbackMultiChoice(
                        new Integer[]{1},

                        new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                boolean allowSelectionChange =
                                        which.length
                                                >= 1; // selection count must stay above 1, the new (un)selection is included in the which array
                                if (!allowSelectionChange) {
                                    showToast(getActivity().getResources().getString(R.string.selection_min_limit_reached));
                                }
                                return allowSelectionChange;
                            }
                        })
                .positiveText(R.string.dismiss)
                .alwaysCallMultiChoiceCallback() // the callback will always be called, to check if (un)selection is still allowed
                .show();
    }

    private void getMultiChoiceLimited() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsCallbackMultiChoice(
                        new Integer[]{1},
                        new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                boolean allowSelectionChange =
                                        which.length
                                                <= 2; // limit selection to 2, the new (un)selection is included in the which array
                                if (!allowSelectionChange) {
                                    showToast(getActivity().getResources().getString(R.string.selection_limit_reached));
                                }
                                return allowSelectionChange;
                            }
                        })
                .positiveText(R.string.dismiss)
                .alwaysCallMultiChoiceCallback() // the callback will always be called, to check if (un)selection is still allowed
                .show();
    }

    private void getMultiChoice() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsCallbackMultiChoice(
                        new Integer[]{1, 3},

                        new MaterialDialog.ListCallbackMultiChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                                StringBuilder str = new StringBuilder();
                                for (int i = 0; i < which.length; i++) {
                                    if (i > 0) {
                                        str.append('\n');
                                    }
                                    str.append(which[i]);
                                    str.append(": ");
                                    str.append(text[i]);
                                }
                                showToast(str.toString());
                                return true; // allow selection
                            }
                        }
                )
                .onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.clearSelectedIndices();
                    }
                })
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .alwaysCallMultiChoiceCallback()
                .positiveText("choose_label")
                .autoDismiss(false)
                .neutralText(R.string.clear_selection)
                .show();
    }

    private void getListCheckPrompt() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        showToast(position+" : " + text);
                    }
                })
                .checkBoxPromptRes(R.string.example_prompt, true, null)
                .negativeText(android.R.string.cancel)
                .show();
    }

    private void getListLongPress() {
        index = 0;
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                      showToast(position + " : "+ text);
                    }
                })
                .autoDismiss(false)
                .itemsLongCallback(new MaterialDialog.ListLongCallback() {
                    @Override
                    public boolean onLongSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        dialog.getItems().remove(position);
                        dialog.notifyItemsChanged();
                        return false;
                    }
                })
                .onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        index++;
                        dialog.getItems().add("Item " + index);
                        dialog.notifyItemInserted(dialog.getItems().size() - 1);
                    }
                })
                .neutralText(R.string.add_item)
                .show();
    }

    private void getSingleChoice() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsDisabledIndices(1, 3)
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        showToast(which + ": " + text);
                        return true; // allow selection
                    }
                })
                .positiveText("choose_label")
                .show();
    }

    private void getSingleChoiceLongItems() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks_longItems)
                .itemsCallbackSingleChoice(0, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        showToast(which + ": " + text);
                        return true; // allow selection
                    }
                })
                .positiveText("choose_label")
                .show();
    }

    private void getListLongItems() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks_longItems)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        showToast(position + ":" + text);
                    }
                })
                .show();
    }

    private void getLongList() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.states)
                .items(R.array.states)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        showToast(position + ":" + text );
                    }
                })
                .positiveText(android.R.string.cancel)
                .show();
    }


    private void getListNoTitle() {
        new MaterialDialog.Builder(getActivity())
                .items(R.array.socialNetworks)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        showToast(position + ": " + text);
                    }
                })
                .show();
    }

    private void getList() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.socialNetworks)
                .items(R.array.socialNetworks)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int position, CharSequence text) {
                        showToast(position + ": " + text);
                    }
                })
                .show();
    }

    private void getCallbacks() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.useGoogleLocationServices)
                .content(R.string.useGoogleLocationServicesPrompt)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .neutralText(R.string.more_info)
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        ToastUtil.showToast(" -- " + which);
                    }
                })
                .show();
    }

    private void getNeutral() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.useGoogleLocationServices)
                .content(R.string.useGoogleLocationServicesPrompt)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .neutralText(R.string.more_info)
                .show();
    }

    private void showBasicNoTitle() {
        new MaterialDialog.Builder(getActivity())
                .content(R.string.shareLocationPrompt)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .show();
    }

    private void showBasic() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.useGoogleLocationServices)
                .content(R.string.useGoogleLocationServicesPrompt)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .show();
    }

    private void showBasicLongContent() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.useGoogleLocationServices)
                .content(R.string.loremIpsum)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .show();
    }

    private void showBasicIcon() {
        new MaterialDialog.Builder(getActivity())
                .iconRes(R.mipmap.ic_launcher)
                .limitIconToDefaultSize() // limits the displayed icon size to 48dp
                .title(R.string.useGoogleLocationServices)
                .content(R.string.useGoogleLocationServicesPrompt)
                .positiveText(R.string.agree)
                .negativeText(R.string.disagree)
                .show();
    }

    private void showBasicCheckPrompt() {
        new MaterialDialog.Builder(getActivity())
                .iconRes(R.mipmap.ic_launcher)
                .limitIconToDefaultSize()
                .title(Html.fromHtml(getString(R.string.permissionSample, getString(R.string.app_name))))
                .positiveText(R.string.allow)
                .negativeText(R.string.deny)
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if ( dialog.isPromptCheckBoxChecked()) {
                            showToast("选中了");} else {
                            showToast("未选中");}
                    }
                })
                .checkBoxPromptRes(R.string.dont_ask_again, false, null)
                .show();
    }


    private void showStacked() {
        new MaterialDialog.Builder(getActivity())
                .title(R.string.useGoogleLocationServices)
                .content(R.string.useGoogleLocationServicesPrompt)
                .positiveText(R.string.speedBoost)
                .negativeText(R.string.noThanks)
                .btnStackedGravity(GravityEnum.END)
                .stackingBehavior(
                        StackingBehavior
                                .ALWAYS) // this generally should not be forced, but is used for demo purposes
                .show();
    }
}
