package com.example.sathireddy.playercar;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;

/**
 * Created by Sathi Reddy on 6/5/2016.
 */
public class SecondActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private GestureDetectorCompat gestureDetector;
    public static int x;
    float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        View road = new PlayerCarTester(this, R.drawable.yellowcar);
        setContentView(road);
        this.gestureDetector = new GestureDetectorCompat(this, this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        PlayerCarTester x = new PlayerCarTester (this, R.drawable.yellowcar);
        x.draw(new Canvas());
        return true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: { //store x value of finger location upon pressing down
                x1 = event.getX();
                break;
            }
            case MotionEvent.ACTION_UP: { //store x value of finger location upon releasing
                x2 = event.getX();

                if (x1 < x2) { //evaluate swipe direction based on x value increasing from left to right
                    Toast.makeText(this, "Right Swipe", Toast.LENGTH_SHORT).show();
                }

                if (x1 > x2) {
                    Toast.makeText(this, "Left Swipe", Toast.LENGTH_SHORT).show();
                }
            }
            this.gestureDetector.onTouchEvent(event);
        }
        return true;
    }
}
