package com.wxl.uidemo.popup;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.wxl.uidemo.R;
import com.wxl.uidemo.databinding.ViewBottomPopupBinding;

/**
 * Created by wxl on 2018/1/19.
 */

public class BottomPopup extends PopupWindow {

    private ViewBottomPopupBinding mBinding;
    private Context mContext;

    public BottomPopup(Context context){
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_bottom_popup,null,false);
        mContext = context;
        setContentView(mBinding.getRoot());
        // 设置宽
        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        // 设置高
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        //设置点击外部关闭
        setOutsideTouchable(true);
        setAnimationStyle(R.style.DialogAnimation);

        Activity activity= (Activity) mContext;
        //设置背景半透明
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha=0.6f;
        activity.getWindow().setAttributes(params);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                Activity activity= (Activity) mContext;
                //把背景的颜色恢复为全透明
                WindowManager.LayoutParams params = activity.getWindow().getAttributes();
                params.alpha=1.0f;
                activity.getWindow().setAttributes(params);
            }
        });

        mBinding.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mBinding.option1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mBinding.option2.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }


}
