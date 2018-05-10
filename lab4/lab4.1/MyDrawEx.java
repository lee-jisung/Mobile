package com.leejisung.lab4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by leejisung on 2018-05-10.
 */

public class MyDrawEx extends View {

    private float oldX;
    private float oldY;
    private boolean downState;
    private Paint mPnt = new Paint();
    private Bitmap mBp;
    private Canvas mCanvas;

    //setting bitmap in memory and connect canvas and bitmap.
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mBp = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBp);
        mCanvas.drawColor(Color.WHITE);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public MyDrawEx(Context c) {
        super(c);
    }

    public MyDrawEx(Context c, AttributeSet a){
        super (c,a);
    }

    // Handle touch event
    // get a coordinate of x, y and draw line by x,y coordinate.
    // when finger is released, then drawing a line is stopped
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                oldX = event.getX();
                oldY = event.getY();
                downState = true;
                return true;
            case MotionEvent.ACTION_MOVE:
                if(downState){
                    mCanvas.drawLine(oldX, oldY, event.getX(), event.getY(), mPnt);
                    oldX = event.getX();
                    oldY = event.getY();
                    invalidate();
                    return true;
                }
            case MotionEvent.ACTION_UP:
                mCanvas.drawLine(oldX, oldY, event.getX(), event.getY(), mPnt);
                downState = false;
                return true;
        }
        return super.onTouchEvent(event);
    }

    // set color and width of paint
    // take a bitmap from memory and draw to the canvas.
    @Override
    protected void onDraw(Canvas canvas) {
        mPnt.setColor(Color.BLUE);
        mPnt.setStrokeWidth(15);
        if(mBp != null){
            canvas.drawBitmap(mBp, 0, 0, mPnt);
        }
        super.onDraw(canvas);
    }
}
