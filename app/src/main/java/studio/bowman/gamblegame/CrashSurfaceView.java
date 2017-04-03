package studio.bowman.gamblegame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.SurfaceHolder;

public class CrashSurfaceView extends Activity{

    MyView v;
    Bitmap bullet;
    private int bheight, bwidth, width, height, boxwidth, boxheight;
    private float x,y,vx,vy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new MyView(this);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        bullet = Bitmap.createScaledBitmap(bullet, bullet.getWidth()/5, bullet.getHeight()/5, true);

        width = size.x;
        height = size.y;

        boxheight = height / 4;
        boxwidth = (width / 20) * 19;

        vx = 0.5f;

        bheight = bullet.getHeight();
        bwidth = bullet.getWidth();

        x = (width/20)/4;
        y = boxheight-bheight/4*3;

        setContentView(v);
        getWindow().setLayout(boxwidth,boxheight);
    }

    @Override
    protected void onPause() {
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        v.resume();
    }
    public class MyView extends android.view.SurfaceView implements Runnable{

        Thread t = null;
        SurfaceHolder holder;
        boolean isItOK = false;

        public MyView(Context context) {
            super(context);
            holder = getHolder();
            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        public MyView(Context context, AttributeSet attrs) {
            super(context, attrs);
            holder = getHolder();
            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        @Override
        public void run() {
            while (isItOK){
                if(!holder.getSurface().isValid()){
                    continue;
                }
                Canvas c = holder.lockCanvas();
                c.drawARGB(255,150, 20,150);
                vx = vx + 0.005f;
                vy = -0.1f - (float) ((Math.pow(x / 300, 2)));
                x = x + vx;
                y = y + vy;
                c.drawBitmap(bullet, x-bwidth/2, y, null);
                holder.unlockCanvasAndPost(c);
            }
        }

        public void pause(){
            isItOK = false;
            while(true){
                try{
                    t.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                break;
            }
            t=null;
        }

        public void resume(){
            isItOK = true;
            t = new Thread(this);
            t.start();
        }

    }
}
