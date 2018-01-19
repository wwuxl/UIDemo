package com.wxl.uidemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.wxl.uidemo.R;

/**
 * Created by wxl on 2017/11/22.
 * 圆角图片控件
 */

public class RadiusImageView extends AppCompatImageView {
    private int mRadius;//圆角半径
    private Paint roundPaint;

    public RadiusImageView(Context context) {
        this(context,null);
    }

    public RadiusImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RadiusImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RadiusImageView);
        mRadius = typedArray.getDimensionPixelSize(R.styleable.RadiusImageView_radius, 0);
        typedArray.recycle();


        roundPaint = new Paint();
        roundPaint.setAntiAlias(true);
        roundPaint.setStyle(Paint.Style.FILL);
        roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0, 0, canvas.getWidth(), canvas.getHeight()), new Paint(), Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        drawTopLeft(canvas);
        drawTopRight(canvas);
        drawBottomLeft(canvas);
        drawBottomRight(canvas);
        canvas.restore();
    }

    private void drawTopLeft(Canvas canvas) {
        if (mRadius > 0) {
            Path path = new Path();
            path.moveTo(0, mRadius);
            path.lineTo(0, 0);
            path.lineTo(mRadius, 0);
            path.arcTo(new RectF(0, 0, mRadius * 2, mRadius * 2),
                    -90, -90);
            path.close();
            canvas.drawPath(path, roundPaint);
        }
    }

    private void drawTopRight(Canvas canvas) {
        if (mRadius > 0) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - mRadius, 0);
            path.lineTo(width, 0);
            path.lineTo(width, mRadius);
            path.arcTo(new RectF(width - 2 * mRadius, 0, width,
                    mRadius * 2), 0, -90);
            path.close();
            canvas.drawPath(path, roundPaint);
        }
    }

    private void drawBottomLeft(Canvas canvas) {
        if (mRadius > 0) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0, height - mRadius);
            path.lineTo(0, height);
            path.lineTo(mRadius, height);
            path.arcTo(new RectF(0, height - 2 * mRadius,
                    mRadius * 2, height), 90, 90);
            path.close();
            canvas.drawPath(path, roundPaint);
        }
    }

    private void drawBottomRight(Canvas canvas) {
        if (mRadius > 0) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - mRadius, height);
            path.lineTo(width, height);
            path.lineTo(width, height - mRadius);
            path.arcTo(new RectF(width - 2 * mRadius, height - 2
                    * mRadius, width, height), 0, 90);
            path.close();
            canvas.drawPath(path, roundPaint);
        }
    }
}
