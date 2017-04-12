package studio.bowman.gamblegame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

public class CrashView extends View {

    static int width, height, bheight, bwidth, boxwidth, boxheight;
    private float x, y;
    static float vx, vy;

    private Bitmap bullet, background;
    private Paint AA = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CrashView(Context context) {
        super(context);
        init(context);
    }

    public CrashView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CrashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    private void init(Context ctx) {

        Display display = ((Activity) ctx).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        bullet = Bitmap.createScaledBitmap(bullet, bullet.getWidth() / 5, bullet.getHeight() / 5, true);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.crashback);

        width = size.x;
        height = size.y;

        bheight = bullet.getHeight();
        bwidth = bullet.getWidth();

        boxheight = height / 4;
        boxwidth = (width / 20) * 19;

        x = (width / 20) / 4;
        y = boxheight - bheight / 4 * 3;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = boxwidth;
        int desiredHeight = boxheight;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setMeasuredDimension(boxwidth, boxheight);
        canvas.drawBitmap(background,0,0,AA);

            vy = -0.1f - (float) ((Math.pow(x / 600, 2)) / 1.25);
            vx = 1f;

            x += vx;
            y += vy;

            canvas.drawBitmap(bullet, x, y, AA);
    }
}
