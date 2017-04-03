package studio.bowman.gamblegame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
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

    private int profit, balance, bet, r1, count, state;
    private float value, value_old, bailvalue, xval, vxval, yval;
    private TextView debug, valuedisplay, display, baldisplay, profdisplay, betdisplay;
    private ImageButton play, drop, minusmax,minusmid,minusmin,plusmin,plusmid,plusmax;
    private ImageButton leftBtn, mainBtn, rightBtn;
    private boolean live, boolcrash, boolbail, playing, firsttime;
    View cv;
    Utils utils;
    Thread thread;

    //STATES
    // 1 = DRAW
    // 2 = LOSE
    // 3 = WIN

    void setDisplay(){
        play.setImageResource(R.drawable.play);
        drop.setImageResource(R.drawable.bail);

        // l t r b
//        play.setAdjustViewBounds(true);
//        play.setPadding(5,0,5,0);
//        drop.setAdjustViewBounds(true);
//        drop.setPadding(5,0,5,0);

        play.setAdjustViewBounds(true);
        play.setPadding(0,0,0,0);
        drop.setAdjustViewBounds(true);
        drop.setPadding(0,0,0,0);

        betdisplay.setTextColor(Color.WHITE);
        baldisplay.setTextColor(Color.WHITE);
        profdisplay.setTextColor(Color.WHITE);
        valuedisplay.setTextColor(Color.WHITE);



        //BOTTOM BUTTONS
        leftBtn.setImageResource(R.drawable.inventory_icon);
        mainBtn.setImageResource(R.drawable.crash_icon_large);
        rightBtn.setImageResource(R.drawable.mine_icon);

        // l t r b
        leftBtn.setAdjustViewBounds(true);
        leftBtn.setPadding(0,0,0,0);

        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);

        rightBtn.setAdjustViewBounds(true);
        rightBtn.setPadding(0,0,0,0);
    }

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
        display.setText("");
        valuedisplay.setText("");
        profdisplay.setText("");
    }

    void startengine(){
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
        save.apply();
        save.commit();
    }

    void end(){
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

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);

        play = (ImageButton)findViewById(R.id.play);
        drop = (ImageButton)findViewById(R.id.drop);
        minusmax = (ImageButton)findViewById(R.id.minusmax);
        minusmid = (ImageButton)findViewById(R.id.minusmid);
        minusmin = (ImageButton)findViewById(R.id.minusmin);
        plusmax = (ImageButton)findViewById(R.id.plusmax);
        plusmid = (ImageButton)findViewById(R.id.plusmid);
        plusmin = (ImageButton)findViewById(R.id.plusmin);

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

        utils = new Utils(false);

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