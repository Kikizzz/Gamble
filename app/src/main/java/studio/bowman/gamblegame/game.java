package studio.bowman.gamblegame;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class game extends AppCompatActivity {
    private int width, height,profit, balance, bet, r1, bheight, bwidth, boxwidth, boxheight, count, state;
    private float x,y,vx,vy,value, value_old, bailvalue, xval, vxval, yval;
    private Canvas c,p;
    private Bitmap bullet, background, trail;
    private ImageView window,particle;
    private TextView debug, valuedisplay, display, baldisplay, profdisplay, betdisplay;
    private ImageButton play, drop, minusmax,minusmid,minusmin,plusmin,plusmid,plusmax;
    private boolean live, boolcrash, boolbail, playing, firsttime;

    //STATES
    // 1 = DRAW
    // 2 = LOSE
    // 3 = WIN

    void updateDisplay(){
        baldisplay.setText(" " + balance + "$");
        betdisplay.setText("" + bet);
    }
    
    void endgame(){
        Toast.makeText(getBaseContext(), "Your Game Has Been Reset",
                Toast.LENGTH_SHORT).show();
        balance = 50;
        updateDisplay();
    }

    void update(){
        Random random = new Random();
        int crash = random.nextInt(r1) + 1;

        //LINE GRAPH | LINE GRAPH | LINE GRAPH | LINE GRAPH | LINE GRAPH
        Paint black = new Paint();
        black.setAntiAlias(true);
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);

        c.drawCircle(x,y,5,black);
        vy = -0.1f - (float) ((Math.pow(x / 600, 2)) / 1.25);

        x += vx;
        y += vy;
        c.drawCircle(x,y,5,black);
        //LINE GRAPH | LINE GRAPH | LINE GRAPH | LINE GRAPH | LINE GRAPH

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
            boolcrash = true;
            valuedisplay.setText("Crashed At x" + new DecimalFormat("##.00").format(value));
            profdisplay.setText("");
            value_old = value;
            end();
        }
        if (value == 300){
            boolcrash = true;
            valuedisplay.setText("Limit Reached x" + new DecimalFormat("##.00").format(value));
            end();
        }
        count = count + 1;
    }

    void create(){
        Paint AA = new Paint();
        AA.setAntiAlias(true);

        display.setText("");
        valuedisplay.setText("");
        profdisplay.setText("");
        value = 1.00f;
        vx =  0.5f;

        bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        bullet = Bitmap.createScaledBitmap(bullet, bullet.getWidth()/5, bullet.getHeight()/5, true);
        trail = BitmapFactory.decodeResource(getResources(), R.drawable.trail);
        trail = Bitmap.createScaledBitmap(trail, trail.getWidth()/15, trail.getHeight()/15, true);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        bheight = bullet.getHeight();
        bwidth = bullet.getWidth();
        boxheight = height / 4;
        boxwidth = (width / 20) * 19;
//        x = (width/20)/4;
//        y = boxheight-bheight;
        x=0;
        y=boxheight;
        xval = 5f;
        yval = 395f;

        Bitmap b1 = Bitmap.createBitmap(boxwidth, boxheight,Bitmap.Config.ARGB_8888);
        c = new Canvas(b1);
        Bitmap b2 = Bitmap.createBitmap(boxwidth, boxheight,Bitmap.Config.ARGB_8888);
        p = new Canvas(b2);

        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        background = Bitmap.createScaledBitmap(background, c.getWidth(), c.getHeight(),true);

//        c.drawBitmap(background,0,0,AA);
        c.drawColor(Color.LTGRAY);

        window=(ImageView) findViewById(R.id.window);
        window.setImageBitmap(b1);

        particle=(ImageView) findViewById(R.id.particle);
        particle.setImageBitmap(b2);
    }

    void graph_start(){
        Paint AA = new Paint();
        AA.setAntiAlias(true);
//        c.drawBitmap(background,0,0,AA);
//        c.drawColor(Color.LTGRAY);
        vy = -0.1f - (float) ((Math.pow(x / 600, 2)) / 1.25);

        x += vx;
        y += vy;

//        c.drawBitmap(bullet, x, y, AA);
        window.invalidate();
        particle.invalidate();
    }

    void particle_start(){
        Paint AA = new Paint();
        AA.setAntiAlias(true);

//        p.drawBitmap(trail,x-30,y+30,AA);
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
        count = 49;

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
//                                            graph_start();
//                                            if((count%50)== 0){
//                                                particle_start();
//                                            }

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
                updateDisplay();
                create();
                startengine();
            }
        }else{
            create();
            startengine();
        }
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);

        SharedPreferences.Editor save = load.edit();
        save.putInt("balance", balance);
        save.apply();
        save.commit();
    }

    void end(){
        if (!playing){
            state = 1;
        }else{
            if (boolcrash) {
                state = 2;
            }
            if (boolbail) {
                state = 3;
            }
        }
        debug.setText("" + state + "  " + new DecimalFormat("##.00").format(value));
        play.setEnabled(true);
        play.setClickable(true);
        drop.setEnabled(false);
        drop.setClickable(false);
        playing = false;
        live = false;
        if (balance==0){
            endgame();
        }

        // SAVE DATA
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);

        SharedPreferences.Editor save = load.edit();
        save.putInt("balance", balance);
        save.putFloat("value_old", value_old);
        save.putInt("state", state);
        save.apply();
        save.commit();

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
        
        // STARTING VALUES
        x = 5f;
        y = 395f;
        xval = 5f;
        yval = 395f;
        r1 = 0;
        bet = 5;
        profit = 0;
        balance = 50;

        //LOAD DATA
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        balance = load.getInt("balance", 50);
        state = load.getInt("state", 0);
        value_old = load.getFloat("value_old", 0);

        //DEFAULT DISPLAY
        updateDisplay();
        profdisplay.setText(" ");
        debug.setText("");

        //DEFAULT STATES
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
                    //SKIP GAME IF BAILED
//                    if (boolbail){
//                        live = false;
//                        create();
//                        end();
//                    }
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
                        balance = balance + profit;
                        updateDisplay();
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
               updateDisplay();
            }
        });

        minusmid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet - 5;
                if (bet<0){
                    bet = 0;
                }
               updateDisplay();
            }
        });

        minusmin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet - 1;
                if (bet<0){
                    bet = 0;
                }
               updateDisplay();
            }
        });

        plusmax.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = balance;
               updateDisplay();
            }
        });

        plusmid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet + 5;
                if (bet>balance){
                    bet = balance;
                }
               updateDisplay();
            }
        });

        plusmin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = bet + 1;
                if (bet>balance){
                    bet = balance;
                }
               updateDisplay();
            }
        });
    }
}