package com.wxl.uidemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wxl.uidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setPresenter(new Presenter());


    }

    public class Presenter{
        //dialog弹窗
        public void dialogView(View view){
            startActivity(new Intent(MainActivity.this,DialogActivity.class));

        }

        //popc弹窗
        public void popView(View view){
            startActivity(new Intent(MainActivity.this,PopActivity.class));

        }
        //自定义View
        public void customView(View view){
            startActivity(new Intent(MainActivity.this,CustomActivity.class));

        }
    }
}
