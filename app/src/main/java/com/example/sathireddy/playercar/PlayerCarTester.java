package com.example.sathireddy.playercar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class PlayerCarTester extends View {
    public static Bitmap image;
    public static int x;

    public PlayerCarTester(Context context, int resID) {
        super(context);
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = 7; //Scales the image
        image = BitmapFactory.decodeResource(getResources(), resID, bitmapOptions);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(image, (int) (canvas.getWidth() * .26 + 1), canvas.getHeight() - image.getHeight(), null);
    }
}
