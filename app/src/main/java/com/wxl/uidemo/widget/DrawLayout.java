package com.wxl.uidemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by wxl on 2017/10/31.
 */

public class DrawLayout extends RelativeLayout {


    private OnClickListener mListener;
    private int mDrawTop;

    public DrawLayout(Context context) {
        super(context);

    }

    public DrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public DrawLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    /**
     * 限制顶部的移动位置
     * @param drawTop
     */
    public void setDrawTop(int drawTop){
        mDrawTop = drawTop;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
    boolean isMove=false;
    int downX;
    int downY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //获取相对与控件左上角的间距
                downX = (int) event.getX();
                downY = (int) event.getY();
//                int left = getLeft() + (downX - getWidth() / 2);
//                int top = getTop() + (downY - getHeight() / 2);
//                int right = getRight() + (downX - getWidth() / 2);
//                int bottom = getBottom() + (downY - getHeight() / 2);
                //layout(left, top, right, bottom);

                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) event.getX();
                int moveY = (int) event.getY();

                int left = getLeft() + (moveX - getWidth() / 2);
                int top = getTop() + (moveY - getHeight() / 2);
                int right = getRight() + (moveX - getWidth() / 2);
                int bottom = getBottom() + (moveY - getHeight() / 2);
                layout(left, top, right, bottom);
                double sqrt = Math.sqrt(Math.pow((moveX - downX), 2)+ Math.pow((moveY - downY), 2));
                if(Math.abs(sqrt)>15){
                    isMove=true;
                }
                //Log.e("===","sqrt="+sqrt);
                //Log.e("===","ismove——mo="+isMove);
                break;
            case MotionEvent.ACTION_UP:
                if(getLeft()<0){
                   layout(0,getTop(),getWidth(),getBottom());
                }
                if(getTop()<mDrawTop){
                    //Log.e("","mDrawTop==="+mDrawTop);
                    layout(getLeft(),mDrawTop,getRight(),getHeight()+mDrawTop);
                }
                View view=(View)getParent();
                if(getRight()>view.getWidth()){
                    layout(getLeft()-getRight()+view.getWidth(),getTop(),view.getWidth(),getBottom());
                }
                if(getBottom()>view.getHeight()){
                    layout(getLeft(),getTop()-getBottom()+view.getHeight(),getRight(),view.getHeight());

                }
                //Log.e("===","ismove——up="+isMove);
                if(mListener!=null&&!isMove){
                    mListener.onClick(this);

                }
                isMove=false;
                break;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener listener){
        mListener = listener;
    }
}
