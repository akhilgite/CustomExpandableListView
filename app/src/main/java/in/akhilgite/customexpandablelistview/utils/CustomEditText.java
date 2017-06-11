package in.akhilgite.customexpandablelistview.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import in.akhilgite.customexpandablelistview.R;


/**
 * Created by akhil on 10/6/17.
 */

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {
    int mWidth;
    int mHeight;
    Paint mPaint;
    Paint pathPaint;
    Path mPath;

    public CustomEditText(Context context) {
        super(context);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setStrokeWidth(8f);
        mPaint.setColor(getResources().getColor(R.color.colorPrimary));
        pathPaint=new Paint();
        mPath=new Path();
        pathPaint.setColor(Color.parseColor("#1C1B1B"));
        pathPaint.setStyle(Paint.Style.FILL);
        pathPaint.setAntiAlias(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int ht4=mHeight/4;
        /*mPath.moveTo(ht4,0);
        mPath.lineTo(0,ht4);
        mPath.lineTo(0,mHeight);
        mPath.lineTo((mWidth-ht4),mHeight);
        mPath.lineTo(mWidth,(mHeight-ht4));
        mPath.lineTo(mWidth,0);
        mPath.lineTo(ht4,0);
        mPath.close();
        canvas.drawPath(mPath, pathPaint);*/

        canvas.drawLine(ht4,0,0,ht4,mPaint);
        canvas.drawLine(0,ht4,0,mHeight,mPaint);
        canvas.drawLine(0,mHeight,(mWidth-ht4),mHeight,mPaint);
        canvas.drawLine((mWidth-ht4),mHeight,mWidth,(mHeight-ht4),mPaint);
        canvas.drawLine(mWidth,(mHeight-ht4),mWidth,0,mPaint);
        canvas.drawLine(mWidth,0,ht4,0,mPaint);

        mPath.moveTo(0,0);
        mPath.lineTo(ht4,0);
        mPath.lineTo(0,ht4);
        mPath.lineTo(0,0);
        canvas.drawPath(mPath,pathPaint);


        mPath.moveTo(mWidth-ht4,mHeight);
        mPath.lineTo(mWidth-ht4,mHeight);
        mPath.lineTo(mWidth,mHeight-ht4);
        mPath.lineTo(mWidth,mHeight);
        canvas.drawPath(mPath,pathPaint);
    }

}
