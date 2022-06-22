package com.example.nastore.ButtomAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nastore.Abot;
import com.example.nastore.MainActivity;
import com.example.nastore.R;
import com.example.nastore.Reg;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class My extends Fragment {

    private SharedPreferences data;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, Bundle s){
        View view=LayoutInflater.from(getContext()).inflate(R.layout.my,viewGroup,false);
        //回弹
        SmartRefreshLayout smart=(SmartRefreshLayout) view.findViewById(R.id.smarts);
        smart.setEnableLoadMore(true);
        smart.setEnablePureScrollMode(true);

        TextView zh=view.findViewById(R.id.zh);
        TextView nm=view.findViewById(R.id.nm);
        //获取个人信息
        data = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String user = data.getString("user", "");
        zh.setText(user);
        nm.setText("第168位用户");
        //跳转
        LinearLayout  abot=view.findViewById(R.id.my);
        abot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行跳转
                Intent intent =new Intent(getActivity(), Abot.class);
                startActivity(intent);
                //跳转同时运行动画，动画要放到anim下面
                requireActivity().overridePendingTransition(R.anim.activity_visible, R.anim.activity_gone);
            }
        });
        return view;
    }
    @Override
    public void onActivityCreated(Bundle s){
        super.onActivityCreated(s);
    }
}
