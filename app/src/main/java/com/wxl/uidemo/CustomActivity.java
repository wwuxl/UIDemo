package com.wxl.uidemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wxl.uidemo.databinding.ActivityCustomBinding;

/**
 * @date Creation time 2018/1/19 10:40
 * @author wuxiulin
 * @description  自定义View界面
 */
public class CustomActivity extends AppCompatActivity {

    private ActivityCustomBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_custom);

        initView();

    }

    private void initView() {
        

    }
}
