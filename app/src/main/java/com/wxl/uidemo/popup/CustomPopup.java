package com.wxl.uidemo.popup;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.wxl.uidemo.R;
import com.wxl.uidemo.databinding.ViewPopupBinding;

/**
 * Created by wxl on 2018/1/19.
 */

public class CustomPopup extends PopupWindow {

    private final ViewPopupBinding mBinding;
    private Context mContext;

    public CustomPopup(Context context){
        mContext = context;
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_popup,null,false);

        setContentView(mBinding.getRoot());
        //设置PopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        WindowManager.LayoutParams params = ((Activity) context).getWindow().getAttributes();
        params.alpha=0.95f;
        ((Activity) context).getWindow().setAttributes(params);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                //设置PopupWindow弹出窗体可点击
                WindowManager.LayoutParams params = ((Activity) mContext).getWindow().getAttributes();
                //关闭的时候把效果,把背景透明度恢复
                params.alpha=1f;
                ((Activity) mContext).getWindow().setAttributes(params);
            }
        });

    }
}
