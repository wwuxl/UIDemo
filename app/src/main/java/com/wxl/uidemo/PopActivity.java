package com.wxl.uidemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.wxl.uidemo.databinding.ActivityPopBinding;
import com.wxl.uidemo.popup.BottomPopup;
import com.wxl.uidemo.popup.CustomPopup;

/**
 * @date Creation time 2018/1/19 10:41
 * @author wuxiulin
 * @description 自定义PopupWindow界面
 */
public class PopActivity extends AppCompatActivity {

    private ActivityPopBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_pop);
        mBinding.setPresenter(new Presenter());

    }
    //自定义背景的弹窗
    public void customBGPopup(){
        CustomPopup popup=new CustomPopup(this);
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        //状态栏的高度
        int statusBarHeight = frame.top;
        popup.showAtLocation(mBinding.show1, Gravity.TOP | Gravity.RIGHT, dip2px(this, 10), mBinding.show1.getBottom() + statusBarHeight);


    }

    private void showBottomPopup(View view){
        BottomPopup popup=new BottomPopup(this);
        popup.showAtLocation(view,Gravity.BOTTOM,0,0);
    }

    /**
     * dp2px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px2dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public class Presenter{
        public void popup1(View view){
            customBGPopup();

        }
        public void popup2(View view){
            showBottomPopup(view);

        }
        public void popup3(View view){


        }
        public void popup4(View view){


        }

    }
}
