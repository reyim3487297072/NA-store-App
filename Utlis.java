package com.example.nastore;

import android.app.Activity;
import android.content.Context;

import com.gyf.immersionbar.ImmersionBar;

public class Utlis {
    public static void status(Context context) {
        ImmersionBar.with((Activity) context)
                .statusBarColor(R.color.white) // 状态栏颜色
                .navigationBarColor(R.color.white) // 导航栏深色
                .statusBarDarkFont(true) // 状态栏深色
                .navigationBarDarkIcon(true) // 导航栏深色
                .fitsSystemWindows(true) // 解决状态栏和布局重叠问题
                .init();
    }

}
