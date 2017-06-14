package com.dxw.aleax.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.dxw.aleax.R;
import com.hss01248.lib.MyDialogListener;
import com.hss01248.lib.MyItemDialogListener;
import com.hss01248.lib.StytledDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dxw on 2017/6/13.
 */

public class DialogUtilFragment extends Fragment implements View.OnClickListener {

    Button btnCommonProgress;
    Button btnContextProgress;
    Button btnMaterialAlert;
    Button btnIosAlert;
    Button btnIosBottomSheet;
    Button btnIosCenterList;
    Button btnIosAlertVertical;
    Button btnIosAlert2;
    Button btnIosAlertVertical2;

    Dialog gloablDialog;

    String msg = "如果你有心理咨询师般的敏锐，你会进一步发现——这个姑娘企图用考研来掩饰自己对于毕业的恐惧。";
           /* "\n" +
            "像琴姑娘这样的毕业生很多，她们一段时间内会认真地复习考研。可用不了多久，她们便会动摇，便会找出诸多借口给自己开脱，最后考研一事半途而废。\n" +
            "\n" +
            "原因，当事人根本不相信这件事能改变她的命运，能带给她想要的生活。她们相信自己不够努力，也愿意别人骂自己不努力。\n" +
            "\n" +
            "他们不愿意思考自己到底该干什么？他们抱着一个幻想，假如我真的努力就能解决问题了吧！于是他们把一个不可控的事件，在心理变成了可控，从而增加安全感。\n" +
            "\n" +
            "人真的可以为了逃避真正的思考，而做出任何你想象不到的事。\n" +
            "\n" +
            "这种目标是不重结果的，其实它跟刷微博是一个道理，它通过获取无用信息来给自己的生活制造一点喘息。\n" +
            "\n" +
            "只不过陷在“学习”中，要比陷在微博上更能安慰自己的内心，那个已经破了个大洞的内心。\n" +
            "\n" +
            "作者：剑圣喵大师\n" +
            "链接：https://www.zhihu.com/question/50126427/answer/119551026\n" +
            "来源：知乎\n" +
            "著作权归作者所有，转载请联系作者获得授权。";*/

    private static final String EXTRA_CONTENT = "content";

    public static DialogUtilFragment newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        DialogUtilFragment tabContentFragment = new DialogUtilFragment();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_dialog_util, null);
         btnCommonProgress = (Button) view.findViewById(R.id.btn_common_progress);
         btnContextProgress = (Button) view.findViewById(R.id.btn_context_progress);
         btnMaterialAlert = (Button) view.findViewById(R.id.btn_material_alert);
         btnIosAlert = (Button) view.findViewById(R.id.btn_ios_alert);
         btnIosBottomSheet = (Button) view.findViewById(R.id.btn_ios_bottom_sheet);
         btnIosCenterList = (Button) view.findViewById(R.id.btn_ios_center_list);
         btnIosAlertVertical = (Button) view.findViewById(R.id.btn_ios_alert_vertical);
         btnIosAlert2 = (Button) view.findViewById(R.id.btn_ios_alert_2);
         btnIosAlertVertical2 = (Button) view.findViewById(R.id.btn_ios_alert_vertical_2);
         btnCommonProgress.setOnClickListener(this);
         btnContextProgress.setOnClickListener(this);
         btnMaterialAlert.setOnClickListener(this);
         btnIosAlert.setOnClickListener(this);
         btnIosBottomSheet.setOnClickListener(this);
         btnIosCenterList.setOnClickListener(this);
         btnIosAlertVertical.setOnClickListener(this);
         btnIosAlert2.setOnClickListener(this);
         btnIosAlertVertical2.setOnClickListener(this);

        return view;
    }

    private void showToast(String onItemClick) {
        Toast.makeText(getActivity(),onItemClick,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_common_progress:
                StytledDialog.showProgressDialog(getContext(), msg, true, true);

                break;
            case R.id.btn_context_progress:
                gloablDialog = StytledDialog.showProgressDialog(getActivity(), msg, true, true);
                break;
            case R.id.btn_material_alert:
                StytledDialog.showMdAlert(getActivity(), "title", msg, "sure", "cancle", "think about", true, true, new MyDialogListener() {
                    @Override
                    public void onFirst(DialogInterface dialog) {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond(DialogInterface dialog) {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird(DialogInterface dialog) {
                        showToast("onThird");
                    }


                });
                break;
            case R.id.btn_ios_alert:
                StytledDialog.showIosAlert(getActivity(), "title", msg, "sure", "cancle", "think about", true, true, new MyDialogListener() {
                    @Override
                    public void onFirst(DialogInterface dialog) {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond(DialogInterface dialog) {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird(DialogInterface dialog) {
                        showToast("onThird");
                    }


                });
                break;
            case R.id.btn_ios_alert_vertical:
                StytledDialog.showIosAlertVertical(getActivity(), "title", msg, "sure", "cancle", "think about", true, true, new MyDialogListener() {
                    @Override
                    public void onFirst(DialogInterface dialog) {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond(DialogInterface dialog) {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird(DialogInterface dialog) {
                        showToast("onThird");
                    }


                });
                break;
            case R.id.btn_ios_bottom_sheet: {
                final List<String> strings = new ArrayList<>();
                strings.add("1");
                strings.add("2");
                strings.add(msg);
                strings.add("4");
                strings.add("5");
               /* strings.add(msg);
                strings.add("6");
                strings.add("7");
                strings.add(msg);
                strings.add("8");
                strings.add("9");
                strings.add(msg);

                strings.add("10");
                strings.add("11");
                strings.add(msg);
                strings.add("12");
                strings.add("13");
                strings.add(msg);*/

                StytledDialog.showBottomItemDialog(getActivity(), strings, "cancle", true, true, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(String text, int position) {
                        showToast(text);
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("onItemClick");
                    }
                });
            }
            break;
            case R.id.btn_ios_center_list:

                final List<String> strings = new ArrayList<>();
                strings.add("1");
                strings.add("2");
                strings.add(msg);
                strings.add("4");
                strings.add("5");
                strings.add(msg);
             /*   strings.add("6");
                strings.add("7");
                strings.add(msg);
                strings.add("8");
                strings.add("9");
                strings.add(msg);

                strings.add("10");
                strings.add("11");
                strings.add(msg);
                strings.add("12");
                strings.add("13");
                strings.add(msg);*/

                StytledDialog.showIosSingleChoose(getActivity(), strings, true, true, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(String text, int position) {
                        showToast(text);
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("onItemClick");
                    }

                });

                break;
            case R.id.btn_ios_alert_2:
                StytledDialog.showIosAlert(getActivity(), "title", msg, "sure", "", "", true, true, new MyDialogListener() {
                    @Override
                    public void onFirst(DialogInterface dialog) {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond(DialogInterface dialog) {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird(DialogInterface dialog) {
                        // showToast("onThird");
                    }


                });

                break;
            case R.id.btn_ios_alert_vertical_2:
                StytledDialog.showIosAlertVertical(getActivity(), "title", msg, "sure", "", "", true, true, new MyDialogListener() {
                    @Override
                    public void onFirst(DialogInterface dialog) {
                        showToast("onFirst");
                    }

                    @Override
                    public void onSecond(DialogInterface dialog) {
                        showToast("onSecond");
                    }

                    @Override
                    public void onThird(DialogInterface dialog) {
                        showToast("onThird");
                    }


                });
                break;
        }
    }

    private void showGlobleDialog(Context context) {
        WindowManager wmManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSLUCENT);
/**
 *以下都是WindowManager.LayoutParams的相关属性
 * 具体用途请参考SDK文档
 */
        /**三种类型,
         *  * 每个window都有z-orderd值,也就是type值,值大的会覆盖在值小的上方
         *
         * 系统级:全局可弹出,如toast,状态栏,type值为2000-2999
         * 应用级-如activity,在特定应用中出现,值为1-99
         * 子window级-需要在特定父window中,比如dialog需要在activity中,值为1000-1999
         *
         * 常见系统层级的type值:  弹出这个级别的窗口,如果是TYPE_TOAST以上,需要申请权限,小米手机默认禁止该权限
         *
         *
         * public static final int TYPE_STATUS_BAR         = FIRST_SYSTEM_WINDOW;
         *  public static final int TYPE_SEARCH_BAR         = FIRST_SYSTEM_WINDOW+1;
         *   public static final int TYPE_PHONE              = FIRST_SYSTEM_WINDOW+2;
         *    public static final int TYPE_SYSTEM_ALERT       = FIRST_SYSTEM_WINDOW+3;
         *     public static final int TYPE_KEYGUARD           = FIRST_SYSTEM_WINDOW+4;
         *      public static final int TYPE_TOAST              = FIRST_SYSTEM_WINDOW+5;
         *       public static final int TYPE_SYSTEM_OVERLAY     = FIRST_SYSTEM_WINDOW+6;
         *        public static final int TYPE_SYSTEM_DIALOG      = FIRST_SYSTEM_WINDOW+8;
         *         public static final int TYPE_SYSTEM_ERROR       = FIRST_SYSTEM_WINDOW+10;
         *         public static final int TYPE_NAVIGATION_BAR = FIRST_SYSTEM_WINDOW+19;
         * WindowManager.LayoutParams.TYPE_SYSTEM_ALERT

         * */
        wmParams.type = WindowManager.LayoutParams.TYPE_TOAST;   //
        wmParams.format = 1;
        wmParams.gravity = Gravity.CENTER;
        /**
         *这里的flags也很关键
         *代码实际是wmParams.flags |= FLAG_NOT_FOCUSABLE;
         *40的由来是wmParams的默认属性（32）+ FLAG_NOT_FOCUSABLE（8）
         *
         * // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
         *
         * // 不设置这个弹出框的透明遮罩显示为黑色
         params.format = PixelFormat.TRANSLUCENT;
         | WindowManager.LayoutParams.FLAG_DIM_BEHIND
         */
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_DIM_BEHIND | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.dimAmount = 0.5f;//与WindowManager.LayoutParams.FLAG_DIM_BEHIND以及params.format = PixelFormat.TRANSLUCENT 一起才能设置后面窗口的半透明色

        wmParams.alpha = 1.0f;//整个窗口的半透明值，1.0表示不透明，0.0表示全透明。

        /**
         * 9. public float horizontalMargin;
         水平边距，容器与widget之间的距离，占容器宽度的百分率。

         10. public float verticalMargin;
         纵向边距。*/

        wmParams.horizontalMargin = 0.1f;
       /* wmParams.width=40;
        wmParams.height=40;*/
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.progressview_wrapconent, null);


        wmManager.addView(viewGroup, wmParams);  //创建View
    }

    private void showcenterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.dialog_ios_alert);
        AlertDialog dialog = builder.create();
        Window window = dialog.getWindow();
        // window.setWindowAnimations(R.style.mystyle);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//round corner
        builder.show();
    }

    private void showDialog() {
        // AlertDialog dialog = new AlertDialog(this);
        AppCompatDialog dialog = new AppCompatDialog(getActivity());
        dialog.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//key code to remove title
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.mystyle);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//round corner
        // window.setBackgroundDrawableResource(R.drawable.bg_ios_roundcorner);
        // window.requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_ios_alert_bottom);
        // AlertDialog.Builder builder = new AlertDialog.Builder(this);


        // 可以在此设置显示动画
        WindowManager.LayoutParams wl = window.getAttributes();
       /* wl.x = 0;
        wl.y = getWindowManager().getDefaultDisplay().getHeight();*/
// 以下这两句是为了保证按钮可以水平满屏
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();

        // wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.width = (int) (width * 0.85);  // todo keycode gap
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        //wl.horizontalMargin= 0.2f;
// 设置显示位置
        // wl.gravity = Gravity.CENTER_HORIZONTAL;

        dialog.onWindowAttributesChanged(wl);
        dialog.show();
    }


    public ProgressDialog showActivityDialog(Activity activity, String msg, boolean cancleable, boolean outsideTouchable) {
        ProgressDialog dialog = new ProgressDialog(activity);//,R.style.loading_dialog,
        // android:Theme.Dialog主题能把progressbar的直线头变成圆头，但我又不想要其他特性，其圆头是怎么实现的？
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressstyleshape));
        // dialog.setIndeterminate(true);
        dialog.setMessage(msg);
        dialog.setCanceledOnTouchOutside(outsideTouchable);
        dialog.setCancelable(cancleable);
        // dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE)); 会包括下方的阴影效果
        dialog.show();
        return dialog;
    }
}
