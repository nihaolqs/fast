package com.lqs.fast.fast.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lqs.fast.fast.R;

import static android.R.attr.baseline;

/**
 * Created by dell on 2016/10/26.
 */

public class ProgressButton extends View {

    private int mDefaultColour = 0xFF555555;
    private int mCompleteColour = 0xFFff0000;
    private int mTextColour = 0xFF000000;
    private float mTextSize = 20;
    private int mMaxProgress = 100;
    private String mText = "";

    private Paint mDefaultPaint;
    private Paint mCompletePaint;
    private Paint mTextPaint;

    private int mProgress = mMaxProgress;


    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ProgressButton);

        mDefaultColour = a.getColor(R.styleable.ProgressButton_defaultColour, 0xffc0c0c0);
        mCompleteColour = a.getColor(R.styleable.ProgressButton_completeColour, 0xffc00000);
        mTextColour = a.getColor(R.styleable.ProgressButton_textColor, 0xff000000);
        mTextSize = a.getDimension(R.styleable.ProgressButton_textSize, 36);
        mMaxProgress = a.getInt(R.styleable.ProgressButton_mMaxProgress, 100);
        mText = a.getString(R.styleable.ProgressButton_text);
        if(mText == null){
            mText = "";
        }
        a.recycle();
        initPaint();
    }

    public ProgressButton(Context context) {
        super(context);
        initPaint();
    }

    //默认执行，计算view的宽高,在onDraw()之前
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        //设置宽高
        setMeasuredDimension(width, height);
    }

    //根据xml的设定获取宽度
    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST) {

        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY) {

        }
        Log.i("这个控件的宽度----------", "specMode=" + specMode + " specSize=" + specSize);

        return specSize;
    }

    //根据xml的设定获取高度
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST) {

        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY) {

        }
        Log.i("这个控件的高度----------", "specMode:" + specMode + " specSize:" + specSize);

        return specSize;
    }

    private void initPaint() {
        mCompletePaint = new Paint();
        mCompletePaint.setColor(mCompleteColour);
        mCompletePaint.setAntiAlias(true);
        mCompletePaint.setStyle(Paint.Style.FILL);

        mDefaultPaint = new Paint();
        mDefaultPaint.setColor(mDefaultColour);
        mDefaultPaint.setAntiAlias(true);
        mDefaultPaint.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColour);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();   //宽度
        int height = getHeight(); //高度
        RectF defaultRectF = new RectF(0, 0, width, height);
        RectF completeRectF = new RectF(0, 0, width * mProgress / mMaxProgress, height);
        canvas.drawRoundRect(defaultRectF, 30f, 30f, mDefaultPaint);  //绘制圆角矩形
        canvas.drawRoundRect(completeRectF, 30f, 30f, mCompletePaint);  //绘制圆角矩形
//
//        baseline = (mHeight - (mFontMetricsInt.descent - mFontMetricsInt.ascent)) / 2 - mFontMetricsInt.ascent;
//        canvas.

        int x = width / 2;
        int y = (height - mTextPaint.getFontMetricsInt().ascent - mTextPaint.getFontMetricsInt().descent) / 2;
        canvas.drawText(mText, x, y, mTextPaint);

    }

    public void setText(String str) {
        this.mText = str;
        invalidate();
    }

    public void setProgress(int progress) {
        if (progress < 0) {
            progress = 0;
        }
        if (progress > mMaxProgress) {
            progress = mMaxProgress;
        }
        this.mProgress = progress;
        invalidate();
    }

    public int getDefaultColour() {
        return mDefaultColour;
    }

    public void setDefaultColour(int mDefaultColour) {
        this.mDefaultColour = mDefaultColour;
        invalidate();
    }

    public int getCompleteColour() {
        return mCompleteColour;
    }

    public void setCompleteColour(int mCompleteColour) {
        this.mCompleteColour = mCompleteColour;
        invalidate();
    }

    public int getTextColour() {
        return mTextColour;
    }

    public void setTextColour(int mTextColour) {
        this.mTextColour = mTextColour;
        invalidate();
    }

    public float getTextSize() {
        return mTextSize;
    }

    public void setTextSize(float mTextSize) {
        this.mTextSize = mTextSize;
        invalidate();
    }

    public int getMaxProgress() {
        return mMaxProgress;
    }

    public void setMaxProgress(int mMaxProgress) {
        this.mMaxProgress = mMaxProgress;
        invalidate();
    }

    public String getText() {
        return mText;
    }


    public int getProgress() {
        return mProgress;
    }
}
