package com.star.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog {

    private static Dialog m_dialog;

    private static Dialog getDialog(Activity activity){

        if (m_dialog == null) {
            m_dialog = new Dialog(activity);
            m_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        return m_dialog;
    }

    public static void error(Activity activity,String title, String message, ClickListener listener){

        TextView tvTitle, tvErrorMessage;
        Button btnOk, btnYes, btnNo;
        Dialog dialog = getDialog(activity);
        dialog.setContentView(R.layout.dialog_error);
        dialog.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        tvTitle = dialog.findViewById(R.id.tvTitle);
        tvErrorMessage = dialog.findViewById(R.id.tvBody);
        btnOk = dialog.findViewById(R.id.btnOk);
        btnYes = dialog.findViewById(R.id.btnYes);
        btnNo = dialog.findViewById(R.id.btnNo);

        if (listener instanceof OkButtonClickListener){
                btnOk.setVisibility(View.VISIBLE);
                btnYes.setVisibility(View.GONE);
                btnNo.setVisibility(View.GONE);
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((OkButtonClickListener) listener).onOKClick(dialog);
                    }
                });}
        else if (listener instanceof YesNoClickListener){
            btnOk.setVisibility(View.GONE);
            btnYes.setVisibility(View.VISIBLE);
            btnNo.setVisibility(View.VISIBLE);
                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((YesNoClickListener) listener).onYesClick(dialog);
                    }
                });

                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((YesNoClickListener) listener).onNoClick(dialog);
                    }
                });
        }

        if (!title.isEmpty()){
            tvTitle.setText(title);
        }
        tvErrorMessage.setText(message);

        if (!dialog.isShowing()){
            dialog.show();
        }
    }

    public static void success(Activity activity,String title, String message, ClickListener listener){

        TextView tvTitle, tvSuccessMessage;
        Button btnOk, btnYes, btnNo;
        Dialog dialog = getDialog(activity);
        dialog.setContentView(R.layout.dialog_success);
        dialog.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        tvTitle = dialog.findViewById(R.id.tvTitle);
        tvSuccessMessage = dialog.findViewById(R.id.tvBody);
        btnOk = dialog.findViewById(R.id.btnOk);
        btnYes = dialog.findViewById(R.id.btnYes);
        btnNo = dialog.findViewById(R.id.btnNo);

        if (listener instanceof OkButtonClickListener){
            btnOk.setVisibility(View.VISIBLE);
            btnYes.setVisibility(View.GONE);
            btnNo.setVisibility(View.GONE);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((OkButtonClickListener) listener).onOKClick(dialog);
                }
            });}
        else if (listener instanceof YesNoClickListener){
            btnOk.setVisibility(View.GONE);
            btnYes.setVisibility(View.VISIBLE);
            btnNo.setVisibility(View.VISIBLE);
            btnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((YesNoClickListener) listener).onYesClick(dialog);
                }
            });

            btnNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((YesNoClickListener) listener).onNoClick(dialog);
                }
            });
        }

        if (!title.isEmpty()){
            tvTitle.setText(title);
        }
        tvSuccessMessage.setText(message);

        if (!dialog.isShowing()){
            dialog.show();
        }
    }



}
