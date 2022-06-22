package com.example.nastore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class Abot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abot);

        //回弹
        SmartRefreshLayout smart=(SmartRefreshLayout) findViewById(R.id.smart);
        smart.setEnableLoadMore(true);
        smart.setEnablePureScrollMode(true);
    }
}