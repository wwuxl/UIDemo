package com.wxl.uidemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by WXL on 2017/9/6.
 * 在TextView中设置左右上下的图片时, 可以用这个控件居中内容
 */

public class DrawableTextView extends android.support.v7.widget.AppCompatTextView {
    public DrawableTextView(Context context) {
        this(context,null);
    }

    public DrawableTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // getCompoundDrawables() : Returns drawables for the left, top, right, and bottom borders.
        Drawable[] drawables = getCompoundDrawables();
        // 得到drawableLeft设置的drawable对象
        Drawable leftDrawable = drawables[0];
        if (leftDrawable != null) {
            // 得到leftDrawable的宽度
            int leftDrawableWidth = leftDrawable.getIntrinsicWidth();
            // 得到drawable与text之间的间距
            int drawablePadding = getCompoundDrawablePadding();
            // 得到文本的宽度
            int textWidth = (int) getPaint().measureText(getText().toString().trim());
            int bodyWidth = leftDrawableWidth + drawablePadding + textWidth;
            canvas.save();
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        Drawable topDrawable=drawables[1];
        if (topDrawable != null) {
            // 得到leftDrawable的高度
            int topDrawableHeight = topDrawable.getIntrinsicHeight();
            // 得到drawable与text之间的间距
            int drawablePadding = getCompoundDrawablePadding();
            // 得到文本的高度
            int textHeight = getLineHeight()*getLineCount();
            int bodyHeight = topDrawableHeight + drawablePadding + textHeight;
            canvas.save();
            canvas.translate(0, (getHeight() - bodyHeight) / 2);
        }
        Drawable rightDrawable = drawables[2];
        if (rightDrawable != null) {
            // 得到leftDrawable的宽度
            int rightDrawableWidth = rightDrawable.getIntrinsicWidth();
            // 得到drawable与text之间的间距
            int drawablePadding = getCompoundDrawablePadding();
            // 得到文本的宽度
            int textWidth = (int) getPaint().measureText(getText().toString().trim());
            int bodyWidth = rightDrawableWidth + drawablePadding + textWidth;
            canvas.save();
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        Drawable bottomDrawable=drawables[3];
        if (bottomDrawable != null) {
            // 得到leftDrawable的高度
            int bottomDrawableHeight = bottomDrawable.getIntrinsicHeight();
            // 得到drawable与text之间的间距
            int drawablePadding = getCompoundDrawablePadding();
            // 得到文本的高度
            int textHeight = getLineHeight()*getLineCount();
            int bodyHeight = bottomDrawableHeight + drawablePadding + textHeight;
            canvas.save();
            canvas.translate(0, (getHeight() - bodyHeight) / 2);
        }

        super.onDraw(canvas);
    }
}
