package com.example.nastore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nastore.ButtomAdapter.Main;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class Login extends AppCompatActivity {

    private SharedPreferences data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //调用状态栏修改
        Utlis.status(this);
        CardView login=(CardView) findViewById(R.id.login1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialEditText user=(MaterialEditText) findViewById(R.id.user);
                MaterialEditText pass=(MaterialEditText) findViewById(R.id.passs);

                //获取
                String users=user.getText().toString().trim();
                String passs=pass.getText().toString().trim();

                //判断
                if (users.equals("") || passs.equals("")){
                    Toast.makeText(Login.this, "请输入信息哦~", Toast.LENGTH_SHORT).show();
                }
                else{
                    //存数据
                    data=getSharedPreferences("data",MODE_PRIVATE);
                    SharedPreferences.Editor editor=data.edit();
                    editor.putString("user",users);
                    editor.commit();

                    Toast.makeText(Login.this, "登录成功!", Toast.LENGTH_SHORT).show();
                    //进行跳转
                    Intent intent =new Intent(Login.this, Main.class);
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