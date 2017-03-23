package studio.bowman.gamblegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

public class test extends View {

    Bitmap bullet, background, trail;
    float x, y, vx, vy;
    int width, height, bwidth, bheight, bgwidth, bgheight, padding;

    public test(Context context) {
        super(context);
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();

        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        trail = BitmapFactory.decodeResource(getResources(), R.drawable.trail);

        width = metrics.widthPixels;
        height = metrics.heightPixels;
        bheight = bullet.getHeight() / 25;
        bwidth = bullet.getWidth() / 25;
        bgheight = height / 4;
        bgwidth = (width / 20) * 19;
        padding = (width / 20) / 2;

        bullet = Bitmap.createScaledBitmap(bullet, bwidth, bheight, true);
        background = Bitmap.createScaledBitmap(background, bgwidth, bgheight, true);

        x = padding;
        y = bgheight - bheight / 2;
    }

    public void test(Canvas canvas, Bitmap background){
        canvas.drawBitmap(background, 0, 0, null);
    }

    public void start_draw(Canvas canvas) {
        canvas.drawBitmap(background, 0, 0, null);

        vx = 2;
        vy = -0.1f - (float) ((Math.pow(x / 600, 2)) / 0.2);

        x += vx;
        y += vy;

        canvas.drawBitmap(bullet, x, y, null);
        invalidate();
    }
}