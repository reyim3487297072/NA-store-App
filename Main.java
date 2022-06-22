package com.example.nastore.ButtomAdapter;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.nastore.LoadDialog;
import com.example.nastore.R;
import com.example.nastore.Utlis;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    private LoadDialog dialog;
    //创建适配
    private List<Fragment> fragmentList;
    private RadioGroup radioGroup;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.main);
        //弹出
        dialog=new LoadDialog(this);
        dialog.show(true);

        Utlis.status(this);

        //获取
        radioGroup=findViewById(R.id.radiogroup);
        viewPager=findViewById(R.id.viewpager);

        //适配
        Initview();
        //更换
        Check();
        //弹出关闭运行
        Start();

    }

    private void Initview() {

        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new App());
        fragmentList.add(new Game());
        fragmentList.add(new My());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rd1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rd2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rd3:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

    }

    private void Check() {

    }

    // 捕获返回键的方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            // 1. 通过Context获取ActivityManager
            ActivityManager activityManager = (ActivityManager) this.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            // 2. 通过ActivityManager获取任务栈
            List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
            // 3. 逐个关闭Activity
            for (ActivityManager.AppTask appTask : appTaskList) {
                appTask.finishAndRemoveTask();
            }
            return false;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }

    //弹出关闭运行
    private void Start(){
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                End();
            }
        },2500); // 延时2秒
    }

    public void End(){
        dialog.dismiss();
    }
}
