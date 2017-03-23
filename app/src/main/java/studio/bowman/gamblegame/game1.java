package studio.bowman.gamblegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.left;
import static android.R.attr.right;
import static android.graphics.Bitmap.createBitmap;
import static studio.bowman.gamblegame.R.id.bottom;
import static studio.bowman.gamblegame.R.id.top;

public class game1 extends AppCompatActivity {
    private int width=600, height=400,profit, balance, bet, r1, bheight, bwidth;
    private float x,y,vx=0.5f, vy,value, bailvalue, xval, vxval, yval;
    private Canvas c;
    private Bitmap bullet, background, trail;
    private ImageView imageview;
    private TextView debug, valuedisplay, display, baldisplay, profdisplay, betdisplay;
    private ImageButton play, drop, minusmax,minusmid,minusmin,plusmin,plusmid,plusmax;
    private boolean live, boolcrash, boolbail, playing, firsttime;

    void endgame(){
        Toast.makeText(getBaseContext(), "Your Game Has Been Reset",
                Toast.LENGTH_SHORT).show();
        balance = 50;
        baldisplay.setText("" + balance + "$");
    }

    void update(){
        Random random = new Random();
        int crash = random.nextInt(r1) + 1;

        //COUNTING GRAPH
        vxval = 0.5f;
        xval = xval + vxval;
        yval = yval - 0.1f - (float) ((Math.pow(xval/600,3))/10);

        value = 1 + (-(yval - 396))/100;
        valuedisplay.setText("x" + new DecimalFormat("##.00").format(value));

        if(playing) {
            if (!boolbail) {
                profdisplay.setText("Profit: " + Math.round(bet * value) + "$");
            } else {
                profdisplay.setText("You got " + Math.round(profit) + "$");
            }
        }
        if (crash == 1){
            end();
            boolcrash = true;
            valuedisplay.setText("Crashed At x" + new DecimalFormat("##.00").format(value));
        }
        if (value == 300){
            end();
            boolcrash = true;
            valuedisplay.setText("Limit Reached x" + new DecimalFormat("##.00").format(value));
        }
        imageview.invalidate();
    }

    void create(){

        display.setText("");
        valuedisplay.setText("");
        profdisplay.setText("");
        value = 1.00f;

        x = -bwidth/3;
        y = 400-bheight/3*2;
        xval = 5f;
        yval = 395f;

        Bitmap b = Bitmap.createBitmap(width, height,Bitmap.Config.ARGB_8888);
        c = new Canvas(b);

        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        bullet = Bitmap.createScaledBitmap(bullet, bullet.getWidth()/25, bullet.getHeight()/25, true);
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        background = Bitmap.createScaledBitmap(background, c.getWidth(), c.getHeight(),true);
        bheight = bullet.getHeight();
        bwidth = bullet.getWidth();

        c.drawBitmap(background,0,0,null);

        imageview=(ImageView) findViewById(R.id.window);
        imageview.setImageBitmap(b);

    }

    void graph_start(){
            vy = -0.1f - (float) ((Math.pow(x / 600, 2)) / 0.2);

            x += vx;
            y += vy;

            c.drawBitmap(bullet, x, y, null);
    }

    void startengine(){
        Random random = new Random();
        r1 = random.nextInt(750)+750;
//        r1 = 20000;
        profdisplay.setText("");
        boolcrash=false;
        boolbail=false;
        live = true;
        drop.setEnabled(true);
        drop.setClickable(true);
        play.setEnabled(false);
        play.setClickable(false);

        graph_start();

        Timer timer=new Timer();
        timer.schedule(
                new TimerTask(){
                    @Override
                    public boolean cancel() {
                        return super.cancel();
                    }
                    @Override
                    public void run() {
                        runOnUiThread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        if (!boolcrash && live) {
                                            update();
                                        }else{
                                            cancel();
                                        }
                                    }
                                }

                        );
                    }
                },0,10 );
    }

    void start(){
        if(playing){
            if (bet==0){
                Toast.makeText(getBaseContext(), "Can't bet 0",
                        Toast.LENGTH_SHORT).show();
            }else{
                balance = balance - bet;
                baldisplay.setText("" + balance + "$");
                create();
                startengine();
            }
        }else{
            create();
            startengine();
        }
    }

    void end(){
        play.setEnabled(true);
        play.setClickable(true);
        drop.setEnabled(false);
        drop.setClickable(false);
        playing = false;
        live = false;
        if (balance==0){
            endgame();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                valuedisplay.setText("5");
            }
        }, 5000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                valuedisplay.setText("4");
            }
        }, 6000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                valuedisplay.setText("3");
            }
        }, 7000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                valuedisplay.setText("2");
            }
        }, 8000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                valuedisplay.setText("1");
            }
        }, 9000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                start();
            }
        }, 10000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        play = (ImageButton)findViewById(R.id.play);
        drop = (ImageButton)findViewById(R.id.drop);
        minusmax = (ImageButton)findViewById(R.id.minusmax);
        minusmid = (ImageButton)findViewById(R.id.minusmid);
        minusmin = (ImageButton)findViewById(R.id.minusmin);
        plusmax = (ImageButton)findViewById(R.id.plusmax);
        plusmid = (ImageButton)findViewById(R.id.plusmid);
        plusmin = (ImageButton)findViewById(R.id.plusmin);

        display = (TextView)findViewById(R.id.display);
        valuedisplay = (TextView)findViewById(R.id.valuedisplay);
        baldisplay = (TextView)findViewById(R.id.balance);
        profdisplay = (TextView)findViewById(R.id.profit);
        betdisplay = (TextView)findViewById(R.id.betdisplay);
        debug = (TextView)findViewById(R.id.debug);

        x = 5f;
        y = 395f;
        xval = 5f;
        yval = 395f;
        r1 = 0;
        bet = 5;
        profit = 0;
        balance = 50;

        profdisplay.setText(" ");
        baldisplay.setText(" " + balance + "$");
        betdisplay.setText("" + bet);
        debug.setText("");

        drop.setEnabled(false);
        drop.setClickable(false);
        create();
        firsttime = true;
        playing = false;
        boolbail = false;
        boolcrash = false;
        live = false;

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!live) {
                    if (bet==0){
                        Toast.makeText(getBaseContext(), "Can't bet 0",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        profdisplay.setText("Bet Placed");
                        x = 5f;
                        y = 395f;
                        xval = 5f;
                        yval = 395f;
                        playing = true;
                        if (firsttime){
                            start();
                            firsttime = false;
                        }
                    }
                }else{
                    if (boolbail){
                        live = false;
                        create();
                        end();
                    }
                }
            }
        });

        drop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playing) {
                    if (!boolbail && !boolcrash) {
                        bailvalue = value;
                        display.setText("Bailed at x" + new DecimalFormat("##.00").format(bailvalue));
                        profit = Math.round(bet * bailvalue);
                        profdisplay.setText("" + profit);
                        balance = balance + profit;
                        baldisplay.setText("" + balance);
                        boolbail = true;

                        play.setClickable(true);
                        play.setEnabled(true);

                    }
                }
            }
        });

        minusmax.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = 0;
                betdisplay.setText("" + bet + "$");
            }
        });

        minusmid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet - 5;
                if (bet<0){
                    bet = 0;
                }
                betdisplay.setText("" + bet + "$");
            }
        });

        minusmin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet - 1;
                if (bet<0){
                    bet = 0;
                }
                betdisplay.setText("" + bet + "$");
            }
        });

        plusmax.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = balance;
                betdisplay.setText("" + bet + "$");
            }
        });

        plusmid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet + 5;
                if (bet>balance){
                    bet = balance;
                }
                betdisplay.setText("" + bet + "$");
            }
        });

        plusmin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet + 1;
                if (bet>balance){
                    bet = balance;
                }
                betdisplay.setText("" + bet + "$");
            }
        });
    }
}
