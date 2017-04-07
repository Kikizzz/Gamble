package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionGame extends AppCompatActivity {


    int bet;
    int wins, loses;
    int balance, keys;
    int selected;
    boolean won, pressing, livegame, crashed;
    int gocount, crash;

    int balance1,balance2,balance3,balance4,balance5,balance6;

    //REACTION PRESETS
    ImageView rank;
    ImageView reactionbanner;
    ImageView winback, loseback, winimg, loseimg;

    ImageView displayback;
    ImageButton go;

    ImageView nameback1,nameback2,nameback3,nameback4,nameback5,nameback6;
    ImageView balback1,balback2,balback3,balback4,balback5,balback6;
    ImageView rank1,rank2,rank3,rank4,rank5,rank6;
    TextView name1,name2,name3,name4,name5,name6;
    TextView bal1,bal2,bal3,bal4,bal5,bal6;

    //TODO: WINNING GIVES RESOURCES

    void setGUI(){
        //DEFAULTS
        won = false;
        crashed = false;
        livegame = false;
        crash = 0;

        //TOPBAR
        rank.setImageResource(R.drawable.rank_1);
        winback.setImageResource(R.drawable.case_amount_img);
        loseback.setImageResource(R.drawable.case_amount_img);
        winimg.setImageResource(R.drawable.case_7);
        loseimg.setImageResource(R.drawable.case_7);
        reactionbanner.setImageResource(R.drawable.case_title_exquisite);

        rank.setAdjustViewBounds(true);
        rank.setPadding(0,0,0,0);
        winback.setAdjustViewBounds(true);
        winback.setPadding(0,0,0,0);
        loseback.setAdjustViewBounds(true);
        loseback.setPadding(0,0,0,0);
        winimg.setAdjustViewBounds(true);
        winimg.setPadding(0,0,0,0);
        loseimg.setAdjustViewBounds(true);
        loseimg.setPadding(0,0,0,0);
        reactionbanner.setAdjustViewBounds(true);
        reactionbanner.setPadding(0,0,0,0);

        //SPECIFIC ITEMS
        nameback1.setImageResource(R.drawable.case_2);
        nameback2.setImageResource(R.drawable.case_2);
        nameback3.setImageResource(R.drawable.case_2);
        nameback4.setImageResource(R.drawable.case_2);
        nameback5.setImageResource(R.drawable.case_2);
        nameback6.setImageResource(R.drawable.case_2);

        balback1.setImageResource(R.drawable.case_2);
        balback2.setImageResource(R.drawable.case_2);
        balback3.setImageResource(R.drawable.case_2);
        balback4.setImageResource(R.drawable.case_2);
        balback5.setImageResource(R.drawable.case_2);
        balback6.setImageResource(R.drawable.case_2);

        rank1.setImageResource(R.drawable.case_2);
        rank2.setImageResource(R.drawable.case_2);
        rank3.setImageResource(R.drawable.case_2);
        rank4.setImageResource(R.drawable.case_2);
        rank5.setImageResource(R.drawable.case_2);
        rank6.setImageResource(R.drawable.case_2);

        displayback.setImageResource(R.drawable.hold_your_buttons);
        go.setImageResource(R.drawable.go_inactive);

        displayback.setAdjustViewBounds(true);
        displayback.setPadding(0,0,0,0);
        go.setAdjustViewBounds(true);
        go.setPadding(0,0,0,0);
    }
    void updateDisplay(){
        Random r = new Random();
        int max= 500;
        balance1 = r.nextInt(max)+1;
        balance2 = r.nextInt(max)+1;
        balance3 = r.nextInt(max)+1;
        balance4 = r.nextInt(max)+1;
        balance5 = r.nextInt(max)+1;
        balance6 = r.nextInt(max)+1;

    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");

        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        balance = load.getInt("balance", 0);
        wins = load.getInt("wins", 0);
        loses = load.getInt("loses", 0);
        bet = load.getInt("bet", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("balance", balance);
        save.putInt("wins", wins);
        save.putInt("loses", loses);
        save.putInt("bet", bet);
        save.apply();
        save.commit();
    }

    void startGame(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayback.setImageResource(R.drawable.release_on_go);
            }
        }, 4000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayback.setImageResource(R.drawable.get_ready);
            }
        }, 8000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //GAME START
                livegame = true;
                Game();
            }
        }, 11000);
    }

    void Game(){
            Timer timer = new Timer();
            timer.schedule(
                    new TimerTask() {
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
                                            if(livegame) {
                                                update();
                                            }else{
                                                cancel();
                                            }
                                        }
                                    }
                            );
                        }
                    }, 0, 10);
    }

    void update() {
        Random random = new Random();

        if (crashed) {
            //COUNTING THE LIMIT
            gocount += 1;
        }else{
            //ATTEMPTING TO STOP
            crash = random.nextInt(500) + 1;
        }

        if (crash == 1){
            //STOP APPEARED
            displayback.setImageResource(R.drawable.stop);
            crashed=true;
            if(!pressing){
                won = false;
                livegame = false;
                endGame();
            }
        }

        if(pressing && gocount>50){
            //FAILED TO RELEASE AFTER 1 SEC INTERVAL
            won = false;
            livegame = false;
            endGame();
        }

        if(crashed&&!pressing){
            livegame = false;

            //DETERMINES IF HE RELEASED ON TIME AND WON
            Random w = new Random();
            int k = w.nextInt(5)+1;
            if (k==1){
                won=true;
            }else{
                won=false;
            }

            endGame();
        }
    }

    void endGame(){
        if(won){
            displayback.setImageResource(R.drawable.go_inactive);
            //WHAT HAPPENS IF PLAYER WON
        }else{
            displayback.setImageResource(R.drawable.go_active);
            //WHAT HAPPENS IF AI WON
        }

        //AFTER FEW SEC GO TO NEXT LAYOUT
        savedata();
    }

//    @Override
//    public void onBackPressed() {
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_game);

        rank = (ImageView)findViewById(R.id.rank);
        winback = (ImageView)findViewById(R.id.winback);
        loseback = (ImageView)findViewById(R.id.loseback);
        winimg = (ImageView)findViewById(R.id.winimg);
        loseimg = (ImageView)findViewById(R.id.loseimg);
        reactionbanner = (ImageView)findViewById(R.id.reactionbanner);

        displayback = (ImageView)findViewById(R.id.displayback);
        go = (ImageButton)findViewById(R.id.go);

        nameback1 = (ImageView)findViewById(R.id.nameback1);
        nameback2 = (ImageView)findViewById(R.id.nameback2);
        nameback3 = (ImageView)findViewById(R.id.nameback3);
        nameback4 = (ImageView)findViewById(R.id.nameback4);
        nameback5 = (ImageView)findViewById(R.id.nameback5);
        nameback6 = (ImageView)findViewById(R.id.nameback6);

        balback1 = (ImageView)findViewById(R.id.balback1);
        balback2 = (ImageView)findViewById(R.id.balback2);
        balback3 = (ImageView)findViewById(R.id.balback3);
        balback4 = (ImageView)findViewById(R.id.balback4);
        balback5 = (ImageView)findViewById(R.id.balback5);
        balback6 = (ImageView)findViewById(R.id.balback6);

        rank1 = (ImageView)findViewById(R.id.rank1);
        rank2 = (ImageView)findViewById(R.id.rank2);
        rank3 = (ImageView)findViewById(R.id.rank3);
        rank4 = (ImageView)findViewById(R.id.rank4);
        rank5 = (ImageView)findViewById(R.id.rank5);
        rank6 = (ImageView)findViewById(R.id.rank6);

        name1 = (TextView)findViewById(R.id.name1);
        name2 = (TextView)findViewById(R.id.name2);
        name3 = (TextView)findViewById(R.id.name3);
        name4 = (TextView)findViewById(R.id.name4);
        name5 = (TextView)findViewById(R.id.name5);
        name6 = (TextView)findViewById(R.id.name6);

        bal1 = (TextView)findViewById(R.id.bal1);
        bal2 = (TextView)findViewById(R.id.bal2);
        bal3 = (TextView)findViewById(R.id.bal3);
        bal4 = (TextView)findViewById(R.id.bal4);
        bal5 = (TextView)findViewById(R.id.bal5);
        bal6 = (TextView)findViewById(R.id.bal6);

        loadData();
        setGUI();
        updateDisplay();
        startGame();

        go.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        pressing = true;
                        go.setImageResource(R.drawable.go_active);
                        // PRESSED
                        return true;
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        pressing = false;
                        go.setImageResource(R.drawable.go_inactive);
                        return true;
                }
                return false;
            }
        });

    }
}
