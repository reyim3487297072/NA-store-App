package com.example.nastore;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;


public class LoadDialog extends Dialog {
    /**
     * 加载框工具
     * @param context
     */
    public LoadDialog(@NonNull Context context) {
        super(context, R.style.dialogs);
        setContentView(R.layout.dialog_loading);
    }
    public void show(boolean type) {
        setCancelable(type); // 返回键是否允许关闭
        setCanceledOnTouchOutside(type); // 点击界面是否允许关闭
        super.show();
    }
}
