package com.wxl.uidemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by wxl on 2017/9/27.
 * 五星评价的子控件
 */

public class CommentImage extends android.support.v7.widget.AppCompatImageView {
    private float mPercent;

    public CommentImage(Context context) {
        this(context,null);
    }

    public CommentImage(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CommentImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        int width=getMeasuredWidth();
        int height=getMeasuredWidth();
        Path path=new Path();
        path.moveTo(0,0);
        width= (int) (width*mPercent+0.5);
        path.lineTo(width,0);
        path.lineTo(width,height);
        path.lineTo(0,height);
        path.close();
        canvas.clipPath(path);
        super.onDraw(canvas);

    }

    /**
     * 设置百分比
     * @param percent 百分比
     */
    public void setPercent(float percent){

        mPercent = percent;
        if(mPercent>1){
            mPercent=1;
        }
        invalidate();
    }

}
