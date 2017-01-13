package com.jianglei.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 龙衣 on 17-1-12.
 */

public class SexyProgressBar extends View {

    /**
     * 已完成部分的进度条高度
     */
    private int completeBarHeight = 20;

    /**
     * 准备完成的进度条的高度
     */
    private int prepareBarHeight = 10;

    private int width = 200;
    /**
     * 进度条达到的最大值，默认为100
     */
    private int maxValue=100;
    /**
     * 已经进行的进度
     */
    private int progress;

    /**
     * 进度条颜色
     */
    private int colorRes;
    /**
     * 画笔
     */
    private Paint paint;



    public SexyProgressBar(Context context) {
        super(context);
    }

    public SexyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SexyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        paint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制已经完成的进度条
        if(progress != 0) {
        }
        //绘制数字
        //绘制右侧待加载的进度条


    }
}
