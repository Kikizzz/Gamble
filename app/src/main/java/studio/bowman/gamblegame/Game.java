package studio.bowman.gamblegame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Game extends AppCompatActivity {
    private int width, height, bheight, bwidth, boxwidth, boxheight;
    private float x, y;

    private float v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12;
    private int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;

    MediaPlayer button, intense;

    private int profit, balance, bet, r1, count, state;
    private float value, value_old, bailvalue, xval, vxval, yval;
    private TextView debug, valuedisplay, display, baldisplay, profdisplay, betdisplay;
    private ImageButton play, drop, minusmax,minusmid,minusmin,plusmin,plusmid,plusmax;
    private ImageButton leftBtn, mainBtn, rightBtn, settings, inventory;
    private boolean live, boolcrash, boolbail, playing, firsttime;
    View cv;
    Utils utils;
    Thread thread;

    //STATES
    // 1 = DRAW
    // 2 = LOSE
    // 3 = WIN

    void setDisplay(){
        // TOP SCREEN
        settings.setImageResource(R.drawable.play);
        inventory.setImageResource(R.drawable.play);

        settings.setAdjustViewBounds(true);
        settings.setPadding(0,0,0,0);
        inventory.setAdjustViewBounds(true);
        inventory.setPadding(0,0,0,0);

        // MIDDLE SCREEN
        play.setImageResource(R.drawable.play);
        drop.setImageResource(R.drawable.bail);

        play.setAdjustViewBounds(true);
        play.setPadding(0,0,0,0);
        drop.setAdjustViewBounds(true);
        drop.setPadding(0,0,0,0);

        // LOWER MID BUTTONS
        minusmax.setImageResource(R.drawable.minus);
        minusmid.setImageResource(R.drawable.minus);
        minusmin.setImageResource(R.drawable.minus);

        plusmax.setImageResource(R.drawable.plus);
        plusmid.setImageResource(R.drawable.plus);
        plusmin.setImageResource(R.drawable.plus);

        minusmax.setAdjustViewBounds(true);
        minusmid.setAdjustViewBounds(true);
        minusmin.setAdjustViewBounds(true);
        minusmax.setPadding(0,0,0,0);
        minusmid.setPadding(0,0,0,0);
        minusmin.setPadding(0,0,0,0);

        plusmax.setAdjustViewBounds(true);
        plusmid.setAdjustViewBounds(true);
        plusmin.setAdjustViewBounds(true);
        plusmax.setPadding(0,0,0,0);
        plusmid.setPadding(0,0,0,0);
        plusmin.setPadding(0,0,0,0);

        //BOTTOM BUTTONS
        leftBtn.setImageResource(R.drawable.coinflip_icon);
        mainBtn.setImageResource(R.drawable.crash_icon);
        rightBtn.setImageResource(R.drawable.robbery_icon);

        leftBtn.setAdjustViewBounds(true);
        leftBtn.setPadding(0,0,0,0);

        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);

        rightBtn.setAdjustViewBounds(true);
        rightBtn.setPadding(0,0,0,0);

        //TEXT SETTINGS
        display.setTextColor(Color.WHITE);
        betdisplay.setTextColor(Color.WHITE);
        baldisplay.setTextColor(Color.WHITE);
        profdisplay.setTextColor(Color.WHITE);
        valuedisplay.setTextColor(Color.WHITE);
    }

    void updateDisplay(){
        baldisplay.setText(" " + balance + "$");
        betdisplay.setText("" + bet);
        t1.setText("" + new DecimalFormat("##.00").format(v1));
        t2.setText("" + new DecimalFormat("##.00").format(v2));
        t3.setText("" + new DecimalFormat("##.00").format(v3));
        t4.setText("" + new DecimalFormat("##.00").format(v4));
        t5.setText("" + new DecimalFormat("##.00").format(v5));
        t6.setText("" + new DecimalFormat("##.00").format(v6));
        t7.setText("" + new DecimalFormat("##.00").format(v7));
        t8.setText("" + new DecimalFormat("##.00").format(v8));
        t9.setText("" + new DecimalFormat("##.00").format(v9));
        t10.setText("" + new DecimalFormat("##.00").format(v10));
        t11.setText("" + new DecimalFormat("##.00").format(v11));
        t12.setText("" + new DecimalFormat("##.00").format(v12));
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
//        if (value == 300){
//            boolcrash = true;
//            valuedisplay.setText("Limit Reached x" + new DecimalFormat("##.00").format(value));
//            end();
//        }
        count = count + 1;
    }

    void create(){
        display.setText("");
        valuedisplay.setText("");
        profdisplay.setText("");
    }

    void startengine(){
        intense.start();
        intense.setLooping(true);

        xval = 5f;
        yval = 395f;

        cv.setX(x);
        cv.setY(y);
        utils.setCrashRunning(true);

        Random random = new Random();
        r1 = random.nextInt(750)+750;
//        r1 = 200000;

        profdisplay.setText("");
        boolcrash=false;
        boolbail=false;
        live = true;
        drop.setEnabled(true);
        drop.setClickable(true);
        play.setEnabled(false);
        play.setClickable(false);

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
                                        if(utils.isCrashRunning()){
                                            cv.invalidate();
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
        save.putFloat("v1", v1);
        save.putFloat("v2", v2);
        save.putFloat("v3", v3);
        save.putFloat("v4", v4);
        save.putFloat("v5", v5);
        save.putFloat("v6", v6);
        save.putFloat("v7", v7);
        save.putFloat("v8", v8);
        save.putFloat("v9", v9);
        save.putFloat("v10", v10);
        save.putFloat("v11", v11);
        save.putFloat("v12", v12);
        save.apply();
        save.commit();
    }

    public void sethistory(){
        // s = state , v = value, 1 = newest, 12 = oldest;
        s12 = s11;
        v12 = v11;

        s11 = s10;
        v11 = v10;

        s10 = s9;
        v10 = v9;

        s9 = s8;
        v9 = v8;

        s8 = s7;
        v8 = v7;

        s7 = s6;
        v7 = v6;

        s6 = s5;
        v6 = v5;

        s5 = s4;
        v5 = v4;

        s4 = s3;
        v4 = v3;

        s3 = s2;
        v3 = v2;

        s2 = s1;
        v2 = v1;

        s1 = state;
        v1 = value;

        updateDisplay();
    }

    void end(){
        intense.setLooping(false);
        intense.stop();
        utils.setCrashRunning(false);

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

        sethistory();

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
        save.putFloat("v1", v1);
        save.putFloat("v2", v2);
        save.putFloat("v3", v3);
        save.putFloat("v4", v4);
        save.putFloat("v5", v5);
        save.putFloat("v6", v6);
        save.putFloat("v7", v7);
        save.putFloat("v8", v8);
        save.putFloat("v9", v9);
        save.putFloat("v10", v10);
        save.putFloat("v11", v11);
        save.putFloat("v12", v12);
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
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        /*
        CRASHVIEW DEFAULT VALUES
        */
        Display displey = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        displey.getSize(size);
        Bitmap bullet = BitmapFactory.decodeResource(getResources(), R.drawable.bullet);
        bullet = Bitmap.createScaledBitmap(bullet, bullet.getWidth() / 5, bullet.getHeight() / 5, true);

        width = size.x;
        height = size.y;

        bheight = bullet.getHeight();
        bwidth = bullet.getWidth();

        boxheight = height / 4;
        boxwidth = (width / 20) * 19;

        x = (width / 20) / 4;
        y = boxheight - bheight / 4 * 3;
        /*
        CRASHVIEW DEFAULT VALUES
        */

        play = (ImageButton)findViewById(R.id.play);
        drop = (ImageButton)findViewById(R.id.drop);
        minusmax = (ImageButton)findViewById(R.id.minusmax);
        minusmid = (ImageButton)findViewById(R.id.minusmid);
        minusmin = (ImageButton)findViewById(R.id.minusmin);
        plusmax = (ImageButton)findViewById(R.id.plusmax);
        plusmid = (ImageButton)findViewById(R.id.plusmid);
        plusmin = (ImageButton)findViewById(R.id.plusmin);

        settings = (ImageButton)findViewById(R.id.settings);
        inventory = (ImageButton)findViewById(R.id.inventory);

        leftBtn = (ImageButton)findViewById(R.id.leftBtn);
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        rightBtn = (ImageButton)findViewById(R.id.rightBtn);

        cv = findViewById(R.id.crashView);

        display = (TextView)findViewById(R.id.display);
        valuedisplay = (TextView)findViewById(R.id.valuedisplay);
        baldisplay = (TextView)findViewById(R.id.balance);
        profdisplay = (TextView)findViewById(R.id.profit);
        betdisplay = (TextView)findViewById(R.id.betdisplay);
        debug = (TextView)findViewById(R.id.debug);

        t1 = (TextView)findViewById(R.id.v1);
        t2 = (TextView)findViewById(R.id.v2);
        t3 = (TextView)findViewById(R.id.v3);
        t4 = (TextView)findViewById(R.id.v4);
        t5 = (TextView)findViewById(R.id.v5);
        t6 = (TextView)findViewById(R.id.v6);
        t7 = (TextView)findViewById(R.id.v7);
        t8 = (TextView)findViewById(R.id.v8);
        t9 = (TextView)findViewById(R.id.v9);
        t10 = (TextView)findViewById(R.id.v10);
        t11 = (TextView)findViewById(R.id.v11);
        t12 = (TextView)findViewById(R.id.v12);

        //CRASH RUNNING BOOLEAN
        utils = new Utils(false);

        //SOUNDS
        button = MediaPlayer.create(this, R.raw.button);
        intense = MediaPlayer.create(this, R.raw.intense);

        // STARTING VALUES
        xval = 5f;
        yval = 395f;
        bet = 5;
        profit = 0;
        balance = 50;

        //LOAD DATA
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        balance = load.getInt("balance", 50);
        state = load.getInt("state", 0);
        value_old = load.getFloat("value_old", 0);
        v1 = load.getFloat("v1", 0);
        v2 = load.getFloat("v2", 0);
        v3 = load.getFloat("v3", 0);
        v4 = load.getFloat("v4", 0);
        v5 = load.getFloat("v5", 0);
        v6 = load.getFloat("v6", 0);
        v7 = load.getFloat("v7", 0);
        v8 = load.getFloat("v8", 0);
        v9 = load.getFloat("v9", 0);
        v10 = load.getFloat("v10", 0);
        v11 = load.getFloat("v11", 0);
        v12 = load.getFloat("v12", 0);

        //DEFAULT DISPLAY
        setDisplay();
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
                        xval = 5f;
                        yval = 395f;
                        playing = true;
                        if (firsttime){
                            start();
                            firsttime = false;
                        }
                    }
//                }else{
//                    //SKIP GAME IF BAILED
//                    if (boolbail){
//                        live = false;
//                        create();
//                        end();
//                    }
//                }
                }
            }
        });

        drop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playing) {
                    if (!boolbail && !boolcrash) {
                        bailvalue = value;
                        display.setText("Bailed at x" + new DecimalFormat("##.00").format(bailvalue));
                        intense.setLooping(false);
                        intense.stop();
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

        inventory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Game.this, Inventory.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        minusmax.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bet = 0;
               updateDisplay();
                button.start();
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