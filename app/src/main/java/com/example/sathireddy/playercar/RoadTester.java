package com.example.sathireddy.playercar;

/**
 * Created by Sathi Reddy on 6/6/2016.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class RoadTester extends View
{
    public static int y = -100000;
    public RoadTester(Context context)
    {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        Paint white = new Paint();
        Rect divider = new Rect();
        white.setColor(Color.WHITE);
        white.setStyle(Paint.Style.FILL);
        int left = (int) (canvas.getWidth() * .22),
                right = (int) (canvas.getWidth() * .26),
                space = canvas.getHeight() / 18;
        while (right <= canvas.getWidth())
        {
            int top = y;
            int bottom = top + canvas.getHeight() / 9;
            while (top < canvas.getHeight())
            {
                divider.set(left, top, right, bottom);
                canvas.drawRect(divider, white);
                top = bottom + space;
                bottom = top + canvas.getHeight()/9;
            }

            left = right + (int) (canvas.getWidth() * .22);
            right = left + (int) (canvas.getWidth() * .04);
        }
        if(y < canvas.getHeight())
        {
            RoadTester.y += 5;
        }
        else
        {
            RoadTester.y = -100000;
        }
        invalidate();
    }

}
