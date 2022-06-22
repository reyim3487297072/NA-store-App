package com.example.nastore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.nastore.ButtomAdapter.Main;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //状态栏
        Window window =this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.clubs));

        //进行跳转
        Start();

    }

    //进行跳转
    private void Start(){
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
           Dia();
            }
        },2000); // 延时2秒
    }

    //Dialong弹出
    public void Dia(){
    //弹出
        BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
        View dialog1 = getLayoutInflater().inflate(R.layout.login_in, null);
        dialog.setContentView(dialog1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        dialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(R.color.bantouming);

        CardView open=dialog.findViewById(R.id.main);
        CardView lg=dialog.findViewById(R.id.login);
        CardView reg=dialog.findViewById(R.id.regup);

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行跳转
                Intent intent =new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                //跳转同时运行动画，动画要放到anim下面
                overridePendingTransition(R.anim.activity_visible, R.anim.activity_gone);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行跳转
                Intent intent =new Intent(MainActivity.this, Reg.class);
                startActivity(intent);
                //跳转同时运行动画，动画要放到anim下面
                overridePendingTransition(R.anim.activity_visible, R.anim.activity_gone);
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行跳转
                Intent intent =new Intent(MainActivity.this, Main.class);
                startActivity(intent);
                //跳转同时运行动画，动画要放到anim下面
                overridePendingTransition(R.anim.activity_visible, R.anim.activity_gone);
            }
        });

        //回弹
        SmartRefreshLayout smart=(SmartRefreshLayout) findViewById(R.id.smart);
        smart.setEnableLoadMore(true);
        smart.setEnablePureScrollMode(true);

        smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dia();
            }
        });

    }
}