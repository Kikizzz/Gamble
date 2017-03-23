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

    Bitmap bullet,background;
    float x , y, vx, vy, width, height, bwidth, bheight;

    public test(Context context) {
        super(context);
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();

        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        bullet = Bitmap.createScaledBitmap(bullet, bullet.getWidth()/10, bullet.getHeight()/10, true);
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        background = Bitmap.createScaledBitmap(background, background.getWidth()/4*3, background.getHeight()/4*3,true);
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        bheight = bullet.getHeight();
        bwidth = bullet.getWidth();
        x = 0;
        y = height /2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        Paint custom = new Paint();
        paint.setAntiAlias(true);

        canvas.drawBitmap(background,0,0,null);

        vx = 2;
        vy = - 0.1f - (float) ((Math.pow(x/600,2))/0.2);

        x += vx;
        y += vy;

        canvas.drawBitmap(bullet, x, y ,custom);
        invalidate();
    }
}