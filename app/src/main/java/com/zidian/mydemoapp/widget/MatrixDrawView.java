package com.zidian.mydemoapp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zidian.mydemoapp.R;


/**
 * @Author: Bai.Mo
 * @CreateDate: 2023/11/19
 * @Description: This is MatrixDrawView
 */
public class MatrixDrawView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private Matrix mMatrix;


    public MatrixDrawView(Context context) {
        super(context);
        init();
    }

    public MatrixDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MatrixDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundResource(R.color.teal_700);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_parallel_available);
    }

    public void setMatrix(Matrix matrix) {
        this.mMatrix = matrix;
        invalidate();
    }

    public int getBitMapWidth() {
        return mBitmap.getWidth();
    }

    public int getBitMapHeight() {
        return mBitmap.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mMatrix == null) {
            return;
        }
        canvas.drawBitmap(mBitmap, mMatrix, mPaint);
    }
}

