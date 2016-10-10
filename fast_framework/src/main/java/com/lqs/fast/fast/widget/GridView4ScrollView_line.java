package com.lqs.fast.fast.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by dell on 2016/10/10.
 */

public class GridView4ScrollView_line extends GridView{

    private int lineColor = 0xC0C0C0C0;

    //构造方法
    public GridView4ScrollView_line(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public GridView4ScrollView_line(Context context) {
        super(context);
    }

    //ScrollView嵌套GridView   修改测量高度
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int childCount = getChildCount();  //子控件数量
        int numColumns = getNumColumns();  //列数
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);  //填充
        paint.setStrokeWidth(1);           //线宽
        paint.setColor(lineColor);            //颜色
        for(int i = 0; i< childCount; i++)
        {
            View childView = getChildAt(i);  //取出每一个子view
            if(i/numColumns != childCount/numColumns)   //不是最后一行
            {
                canvas.drawLine(childView.getLeft(),childView.getBottom(),childView.getRight(),childView.getBottom(),paint);  //画底部线条
            }
        }
    }

    public void setLineColor(int color){  //预留设置线条颜色的方法
        this.lineColor = color;
    }
}
