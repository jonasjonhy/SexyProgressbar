package com.jianglei.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 龙衣 on 17-1-12.
 */

public class SexyProgressBar extends View {

    /**
     * 已完成部分的进度条高度
     */
    private int completeBarWidth = 20;

    /**
     * 准备完成的进度条的高度
     */
    private int prepareBarWidth = 10;

    /**
     * 进度条线条的高度
     */
    private int BAR_HEIGHT = 5;
    private int DEFAULT_WIDTH = 400;
    /**
     * 进度条达到的最大值，默认为100
     */
    private int maxValue = 100;
    /**
     * 已经进行的进度
     */
    private int progress =100;

    /**
     * 进度条颜色
     */
    private int colorRes;
    /**
     * 画笔
     */
    private Paint paint;

    private int textSize = 25;

    private int curPos = 0;
    private Rect rect = new Rect();


    public SexyProgressBar(Context context) {
        super(context);
        init();
    }

    public SexyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SexyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST) {
            width = DEFAULT_WIDTH;
        }
        if (heightMode == MeasureSpec.AT_MOST) {
            paint.setTextSize(textSize);
            paint.getTextBounds("100%", 0, 4, rect);
            height = rect.height();
            Log.d("longyi","height:"+height);
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制已经完成的进度条
        if (progress != 0) {
            paint.setColor(Color.RED);
            paint.setStrokeWidth(BAR_HEIGHT);
            Log.d("longyi",(progress*1f /maxValue*getMeasuredWidth())+"");
            canvas.drawLine(0, 5, progress*1f / maxValue * getMeasuredWidth(), 5, paint);
            curPos = getMeasuredWidth() * progress / maxValue;
        }
        //绘制数字
        int num = progress / maxValue;
        String showNum = num + "%";
        paint.setTextSize(13);
        paint.setColor(Color.BLUE);
        canvas.drawText(num + "%", curPos+ 1, getMeasuredHeight(), paint);

        Log.d("longyi","mea height:"+ getMeasuredHeight());
        paint.getTextBounds(showNum, 0, showNum.length(), rect);
        curPos = curPos + rect.width() + 2;
        //绘制右侧待加载的进度条
        paint.setColor(Color.BLACK);
        canvas.drawLine(curPos, 5, getMeasuredWidth(), 5, paint);


    }
}
