package com.star.customdialogexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;

import com.star.customdialog.CustomDialog;
import com.star.customdialog.OkButtonClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CustomDialog.success(MainActivity.this, "", "this is test message", new OkButtonClickListener() {
                    @Override
                    public void onOKClick(DialogInterface dialog) {
                        dialog.dismiss();
                    }
                });
            }
        },3000);

    }
}