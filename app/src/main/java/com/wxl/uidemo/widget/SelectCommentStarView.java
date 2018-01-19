package com.wxl.uidemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wxl.uidemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxl on 2017/10/13.
 * 订单星级评分控件
 */

public class SelectCommentStarView extends LinearLayout {
    private int mStarSpace;
    private int mStarNum;
    private int currentClick;
    private int mSelectNomal ;
    private int mSelectRes;
    private List<ImageView> childs = new ArrayList<>();

    public SelectCommentStarView(Context context) {
        this(context, null);
    }

    public SelectCommentStarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectCommentStarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SelectCommentStarView);
        mStarNum = typedArray.getInt(R.styleable.SelectCommentStarView_star_num2, 0);
        mSelectNomal = typedArray.getResourceId(R.styleable.SelectCommentStarView_star_nomalRes, -1);
        mSelectRes = typedArray.getResourceId(R.styleable.SelectCommentStarView_star_selectRes, -1);
        mStarSpace = typedArray.getDimensionPixelSize(R.styleable.SelectCommentStarView_star_space2, 0);
        typedArray.recycle();
        currentClick=mStarNum;
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        for (int i = 0; i < mStarNum; i++) {
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ImageView imageView = new ImageView(getContext());
            if (i != 0) {
                params.setMargins(mStarSpace, 0, 0, 0);
            }
            imageView.setLayoutParams(params);
            imageView.setImageResource(mSelectRes);

            addView(imageView);
            childs.add(imageView);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int j = 0; j < childs.size(); j++) {
                        if (v == childs.get(j)) {
                            currentClick = j + 1;
                        }
                    }

                    init();
                }
            });
        }
    }

    private void init() {

        for (int i = 0; i < childs.size(); i++) {
            if (i < currentClick) {
                childs.get(i).setImageResource(mSelectRes);

            } else {
                childs.get(i).setImageResource(mSelectNomal);
            }

        }

    }



    public void setCurrentClick(int currentClick) {
        this.currentClick = currentClick;
        init();
    }

    /**
     * 获取评分(总共5星)
     * @return
     */
    public int getOrderGrade(){
        return currentClick;
    }


}
