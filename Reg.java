package com.example.nastore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.nastore.ButtomAdapter.Main;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class Reg extends AppCompatActivity {

    private SharedPreferences data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        //调用状态栏修改
        Utlis.status(this);
        CardView login=(CardView) findViewById(R.id.login1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialEditText user=(MaterialEditText) findViewById(R.id.user);
                MaterialEditText pass=(MaterialEditText) findViewById(R.id.pass);
                MaterialEditText pass11=(MaterialEditText) findViewById(R.id.pass1);

                //获取
                String users=user.getText().toString().trim();
                String passs=pass.getText().toString().trim();
                String pass1=pass11.getText().toString().trim();

                //判断
                if (users.equals("") || passs.equals("") || pass1.equals("")){
                    Toast.makeText(Reg.this, "请输入信息哦~", Toast.LENGTH_SHORT).show();
                }
                else{

                    //村数据
                    data=getSharedPreferences("data",MODE_PRIVATE);
                    SharedPreferences.Editor editor=data.edit();
                    editor.putString("user",users);
                    editor.commit();
                    Toast.makeText(Reg.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    //进行跳转
                    Intent intent =new Intent(Reg.this, Main.class);
                    startActivity(intent);
                    //跳转同时运行动画，动画要放到anim下面
                    overridePendingTransition(R.anim.activity_visible, R.anim.activity_gone);
                }
            }
        });

        //回弹
        SmartRefreshLayout smart=(SmartRefreshLayout) findViewById(R.id.smart);
        smart.setEnableLoadMore(true);
        smart.setEnablePureScrollMode(true);
    }
}