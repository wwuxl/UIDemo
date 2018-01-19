package com.wxl.uidemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.wxl.uidemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxl on 2017/9/27.
 * 五星评价的父控件(只显示不可点击)
 */

public class CommentView extends LinearLayout {
    private List<CommentImage> childs = new ArrayList<>();
    private int mStarNum;
    private float mWidthPercent;
    private int mBackgroud;
    private int mSrc;
    private int mStarSpace;

    public CommentView(Context context) {
        this(context, null);
    }

    public CommentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.commentView);
        mStarNum = typedArray.getInt(R.styleable.commentView_star_num, 0);
        mWidthPercent = typedArray.getFloat(R.styleable.commentView_width_percent, 0.0f);
        mBackgroud = typedArray.getResourceId(R.styleable.commentView_star_backgroud, -1);
        mSrc = typedArray.getResourceId(R.styleable.commentView_star_src, -1);
        mStarSpace = typedArray.getDimensionPixelSize(R.styleable.commentView_star_space, 0);
        typedArray.recycle();
        setOrientation(HORIZONTAL);
        init();


    }

    private void init() {

        removeAllViews();
        childs.clear();

        for (int i = 0; i < mStarNum; i++) {
            CommentImage commentImage = new CommentImage(getContext());
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            if (i != 0) {
                params.setMargins(mStarSpace, 0, 0, 0);
            }
            commentImage.setLayoutParams(params);
            commentImage.setBackgroundResource(mBackgroud);
            commentImage.setImageResource(mSrc);
            commentImage.setPercent(mWidthPercent--);
            addView(commentImage);
            childs.add(commentImage);


        }
    }

    public void setStarNum(int starNum) {
        mStarNum = starNum;
        init();
    }

    public void setWidthPercent(float widthPercent) {
        mWidthPercent = widthPercent;
        for (int i = 0; i < childs.size(); i++) {
            childs.get(i).setPercent(mWidthPercent--);
        }


    }

    public void setBackgroud(int backgroud) {
        mBackgroud = backgroud;
        for (int i = 0; i < childs.size(); i++) {
            childs.get(i).setBackgroundResource(backgroud);
        }

    }

    public void setSrc(int src) {
        mSrc = src;
        for (int i = 0; i < childs.size(); i++) {
            childs.get(i).setImageResource(src);
        }
    }

    public void setStarSpace(int starSpacePx) {
        mStarSpace = starSpacePx;
        for (int i = 0; i < childs.size(); i++) {
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            if (i != 0) {
                params.setMargins(mStarSpace, 0, 0, 0);
            }
            childs.get(i).setLayoutParams(params);

        }
    }

    public int getStarNum() {
        return mStarNum;
    }

    public float getWidthPercent() {
        return mWidthPercent;
    }

    public int getBackgroud() {
        return mBackgroud;
    }

    public int getSrc() {
        return mSrc;
    }

    public int getStarSpace() {
        return mStarSpace;
    }
}
