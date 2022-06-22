package com.example.nastore.ButtomAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nastore.Abot;
import com.example.nastore.LoadDialog;
import com.example.nastore.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class App extends Fragment {
    private LoadDialog1 dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup
                              viewGroup, Bundle s){
     View view=LayoutInflater.from(getContext()).inflate(R.layout.app,viewGroup,false);
        //回弹
        SmartRefreshLayout smarts=(SmartRefreshLayout) view.findViewById(R.id.smart);
        smarts.setEnableLoadMore(true);
        smarts.setEnablePureScrollMode(true);


        //弹出演示
        dialog=new LoadDialog1(getActivity());
        LinearLayout abotss=view.findViewById(R.id.myss);
        abotss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dialog.show(true);
              Start();
            }
        });


     return view;
    }

   @Override
   public void onActivityCreated(@Nullable Bundle s){
        super.onActivityCreated(s);
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

    public void End() {
        dialog.dismiss();
    }
    }
