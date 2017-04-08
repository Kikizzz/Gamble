package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
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
    boolean won, pressing, livegame, crashed, failed;
    int gocount, crash;

    int balance1,balance2,balance3,balance4,balance5,balance6;

    //REACTION PRESETS
    ImageView rank;
    ImageView reactionbanner;
    ImageView winback, loseback, winimg, loseimg;
    TextView win, lose;

    ImageView displayback;
    ImageButton go;

    ImageView nameback1,nameback2,nameback3,nameback4,nameback5,nameback6;
    ImageView balback1,balback2,balback3,balback4,balback5,balback6;
    ImageView rank1,rank2,rank3,rank4,rank5,rank6;
    TextView name1,name2,name3,name4,name5,name6;
    TextView bal1,bal2,bal3,bal4,bal5,bal6;

    TextView debug;

    String randomName(){
        Resources res = getResources();
        String[] names = res.getStringArray(R.array.names);
        String randomname = names[new Random().nextInt(names.length)];
        return randomname;
    }
    void setNames(){
        name1.setText(randomName());
        name2.setText(randomName());
        name3.setText(randomName());
        name4.setText(randomName());
        name5.setText(randomName());
        name6.setText(randomName());

        Random r = new Random();
        int max= 500;
        balance1 = r.nextInt(max)+1;
        balance2 = r.nextInt(max)+1;
        balance3 = r.nextInt(max)+1;
        balance4 = r.nextInt(max)+1;
        balance5 = r.nextInt(max)+1;
        balance6 = r.nextInt(max)+1;

        bal1.setText("" + balance1);
        bal2.setText("" + balance2);
        bal3.setText("" + balance3);
        bal4.setText("" + balance4);
        bal5.setText("" + balance5);
        bal6.setText("" + balance6);
    }
    void setGUI(){
        //DEFAULTS
        won = false;
        crashed = false;
        livegame = false;
        crash = 0;

        //TOPBAR
        rank.setImageResource(R.drawable.rank_1);
        winback.setImageResource(R.drawable.rank_win_title_back);
        loseback.setImageResource(R.drawable.rank_lose_title_back);
        winimg.setImageResource(R.drawable.rank_win_title);
        loseimg.setImageResource(R.drawable.rank_lose_title);
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
        nameback1.setImageResource(R.drawable.nickname);
        nameback2.setImageResource(R.drawable.nickname);
        nameback3.setImageResource(R.drawable.nickname);
        nameback4.setImageResource(R.drawable.nickname);
        nameback5.setImageResource(R.drawable.nickname);
        nameback6.setImageResource(R.drawable.nickname);

        balback1.setImageResource(R.drawable.bal_back);
        balback2.setImageResource(R.drawable.bal_back);
        balback3.setImageResource(R.drawable.bal_back);
        balback4.setImageResource(R.drawable.bal_back);
        balback5.setImageResource(R.drawable.bal_back);
        balback6.setImageResource(R.drawable.bal_back);

        rank1.setImageResource(R.drawable.rank_1_small);
        rank2.setImageResource(R.drawable.rank_2_small);
        rank3.setImageResource(R.drawable.rank_3_small);
        rank4.setImageResource(R.drawable.rank_4_small);
        rank5.setImageResource(R.drawable.rank_5_small);
        rank6.setImageResource(R.drawable.rank_6_small);

        displayback.setImageResource(R.drawable.hold_your_buttons);
        go.setImageResource(R.drawable.go_inactive);

        displayback.setAdjustViewBounds(true);
        displayback.setPadding(0,0,0,0);
        go.setAdjustViewBounds(true);
        go.setPadding(0,0,0,0);
    }
    void updateDisplay(){
        win.setText("" + wins);
        lose.setText("" + loses);
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");

        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        balance = load.getInt("balance", 0);
        bet = load.getInt("bet", 0);
        wins = load.getInt("wins", 0);
        loses = load.getInt("loses", 0);
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
        }, 9000);
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
        debug.setText("" + crashed);
        Random random = new Random();
        if(!crashed){
            if (crash == 1){
                //STOP APPEARED
                displayback.setImageResource(R.drawable.stop);
                crashed=true;
                if(!pressing){
                    failed = true;
                    won = false;
                    livegame = false;
                    endGame();
                }
            }
        }

        if (crashed) {
            //COUNTING THE LIMIT
            gocount += 1;
        }else{
            //ATTEMPTING TO STOP
            crash = random.nextInt(500) + 1;
        }

        if(crashed&&!pressing&&!failed){
            livegame = false;

            //DETERMINES IF HE RELEASED ON TIME AND WON
            Random w = new Random();
            int k = w.nextInt(2)+1;
            if (k==1){
                won=true;
            }else{
                won=false;
            }
            endGame();
        }else{
            if(pressing && gocount>65){
                //FAILED TO RELEASE AFTER 1 SEC INTERVAL
                won = false;
                livegame = false;
                endGame();
            }
        }
        debug.setText("" + crashed);
    }
    void endGame(){
        if(won){
            //WHAT HAPPENS IF PLAYER WON
            displayback.setImageResource(R.drawable.go_inactive);
            wins += 1;
            if(selected==1) {
                balance += bet * 7;
            }else{
                keys += bet * 7;
            }
        }else{
            //WHAT HAPPENS IF AI WON
            loses += 1;
            displayback.setImageResource(R.drawable.go_active);
        }
        updateDisplay();
        savedata();

        //AFTER DELAY STARTS NEW ACTIVITY
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ReactionGame.this, ReactionPost.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("selected", selected);
                intent.putExtra("won", won);
                startActivity(intent);
            }
        }, 4000);
    }

    @Override
    public void onBackPressed() {
    }


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

        win = (TextView)findViewById(R.id.win);
        lose = (TextView)findViewById(R.id.lose);

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

        debug = (TextView)findViewById(R.id.debug);

        loadData();
        setGUI();
        updateDisplay();
        setNames();
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
