package com.example.nastore.ButtomAdapter;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.nastore.R;


public class LoadDialog1 extends Dialog {
    /**
     * 加载框工具
     * @param context
     */
    public LoadDialog1(@NonNull Context context) {
        super(context, R.style.dialogs);
        setContentView(R.layout.dialog_loading1);
    }
    public void show(boolean type) {
        setCancelable(type); // 返回键是否允许关闭
        setCanceledOnTouchOutside(type); // 点击界面是否允许关闭
        super.show();
    }
}
