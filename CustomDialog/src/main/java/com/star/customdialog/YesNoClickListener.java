package com.star.customdialog;

import android.content.DialogInterface;

public interface YesNoClickListener extends ClickListener {

    void onYesClick(DialogInterface dialog);

    void onNoClick(DialogInterface dialog);
}
