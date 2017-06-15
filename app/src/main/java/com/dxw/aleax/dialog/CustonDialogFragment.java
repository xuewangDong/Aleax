package com.dxw.aleax.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.dxw.aleax.R;

/**
 * Created by dxw on 2017/6/14.
 */

public class CustonDialogFragment extends android.support.v4.app.DialogFragment{

    /**
     * 和一般Fragment的onCreate方法一样
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return 返回View对象
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.self_dialog, container);
        return view;
    }

    /**
     * 用于在Fragment里面嵌套Dialog, 和上面的方法两选一实现即可. 
     * 如果两个都写了只有这个方法生效
     *
     * @param savedInstanceState
     * @return 返回Dialog对象
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.self_dialog, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Sign in",
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int id)
                            {
                            }
                        }).setNegativeButton("Cancel", null);
        return builder.create();
    }

}
