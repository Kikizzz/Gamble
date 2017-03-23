package studio.bowman.gamblegame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class settings extends AppCompatActivity {

        Canvas c;
        test v;
        ImageView graph;
        Bitmap background, trail, bullet;
        int width, height, boxwidth, boxheight;
        float x, y, vx, vy;
        boolean live;

    public void start_draw(Canvas canvas, ImageView img) {
        canvas.drawBitmap(background, 0, 0, null);

        vx = 2;
        vy = -0.1f - (float) ((Math.pow(x / 600, 2)) / 0.2);

        x += vx;
        y += vy;

        canvas.drawBitmap(bullet, x, y, null);
//        img.invalidate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        DisplayMetrics metrics = new DisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        boxheight = height / 4;
        boxwidth = (width / 20) * 19;

        graph = (ImageView)findViewById(R.id.graph);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        trail = BitmapFactory.decodeResource(getResources(), R.drawable.trail);

        bullet = Bitmap.createScaledBitmap(bullet, bullet.getWidth()/25, bullet.getHeight()/25, true);

        x=0;
        y=600;

        Runnable loop = new Runnable() {
            @Override
            public void run() {
                    start_draw(c,graph);
            }
        };

        Thread myThread = new Thread(loop);

//        v = new test(settings.this);
//        setContentView(v);

        Bitmap b = Bitmap.createBitmap(600,400,Bitmap.Config.ARGB_8888);
        c = new Canvas(b);
        c.drawBitmap(background,0,0,null);
        graph.setImageBitmap(b);

        live = false;

        myThread.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                live = true;
            }
        }, 2000);
    }
}
