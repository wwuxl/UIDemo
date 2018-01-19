package com.wxl.uidemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.wxl.uidemo.R;


/**
 * Created by WXL on 2017/12/22.
 */

public class ItemSwitchLayout extends LinearLayout {

    private View mItemView;
    private View mLineView;
    private String itemTitle;
    private boolean isVisible;
    private boolean isCheck;
    private Switch mOptionSwitch;
    private TextView mOptionText;
    private OnCheckedChangeListener mListener;

    public ItemSwitchLayout(Context context) {
        this(context,null);
    }

    public ItemSwitchLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemSwitchLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.WHITE);
        setOrientation(VERTICAL);
        LayoutParams params1=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        mItemView = LayoutInflater.from(getContext()).inflate(R.layout.view_switch_layout,null);
        mItemView.setLayoutParams(params1);
        addView(mItemView);
        LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,1);
        mLineView = new View(getContext());
        mLineView.setLayoutParams(params);
        mLineView.setBackgroundColor(getResources().getColor(R.color.line_color_dddddd));
        addView(mLineView);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemSwitchLayout);
        itemTitle = typedArray.getString(R.styleable.ItemSwitchLayout_itemTitle);
        isVisible =typedArray.getBoolean(R.styleable.ItemSwitchLayout_linVisible,false);
        isCheck =typedArray.getBoolean(R.styleable.ItemSwitchLayout_switchCheck,false);
        typedArray.recycle();

        initView();

    }

    private void initView() {
        mOptionSwitch = mItemView.findViewById(R.id.option_switch);
        mOptionText = mItemView.findViewById(R.id.option_text);

        mOptionSwitch.setChecked(isCheck);
        mOptionText.setText(itemTitle);
        mLineView.setVisibility(isVisible?VISIBLE:GONE);

        mOptionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mListener!=null){
                    mListener.onCheckedChanged(b);
                }
            }
        });

    }

    public void setChecked(boolean isCheck){
        this.isCheck=isCheck;
        mOptionSwitch.setChecked(isCheck);
    }
    public void setItemTitle(String itemTitle){
        this.itemTitle=itemTitle;
        mOptionText.setText(itemTitle);
    }

    public View getItemView() {
        return mItemView;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public boolean isCheck() {
        return mOptionSwitch.isChecked();
    }

    public interface OnCheckedChangeListener{
        void onCheckedChanged(boolean isCheck);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener){
        mListener = listener;
    }

}
