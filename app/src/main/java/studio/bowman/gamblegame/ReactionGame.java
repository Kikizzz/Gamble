package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionGame extends AppCompatActivity {

    int xp;
    int bet;
    int wins, loses;
    int balance, keys;
    int selected;
    boolean won, pressing, livegame, crashed, failed;
    int gocount, crash;

    int balance1,balance2,balance3,balance4,balance5,balance6;
    int AI1rank, AI2rank, AI3rank, AI4rank, AI5rank ,AI6rank;

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

    TextView debug, debug2, debug3;

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
        int max= 5000;
        balance1 = r.nextInt(max)+1;
        balance2 = r.nextInt(max)+1;
        balance3 = r.nextInt(max)+1;
        balance4 = r.nextInt(max)+1;
        balance5 = r.nextInt(max)+1;
        balance6 = r.nextInt(max)+1;

        bal1.setText("" + balance1 + "$");
        bal2.setText("" + balance2 + "$");
        bal3.setText("" + balance3 + "$");
        bal4.setText("" + balance4 + "$");
        bal5.setText("" + balance5 + "$");
        bal6.setText("" + balance6 + "$");
    }
    void setGUI(){
//        debug.setVisibility(View.GONE);

        //DEFAULTS
        won = false;
        crashed = false;
        livegame = false;
        crash = 0;

        //TOPBAR
        if(xp<100){
            rank.setImageResource(R.drawable.rank_6);
        }
        if(xp>=100 && xp<200){
            rank.setImageResource(R.drawable.rank_5);
        }
        if(xp>=200 && xp<300){
            rank.setImageResource(R.drawable.rank_4);
        }
        if(xp>=300 && xp<400){
            rank.setImageResource(R.drawable.rank_3);
        }
        if(xp>=400 && xp<500){
            rank.setImageResource(R.drawable.rank_2);
        }
        if(xp>=500){
            rank.setImageResource(R.drawable.rank_1);
        }
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

        Random rankrandom = new Random();

        //PLAYER RANK
        if(xp<100){
            rank.setImageResource(R.drawable.rank_6);
            AI1rank = rankrandom.nextInt(2)+5;
            AI2rank = rankrandom.nextInt(2)+5;
            AI3rank = rankrandom.nextInt(2)+5;
            AI4rank = rankrandom.nextInt(2)+5;
            AI5rank = rankrandom.nextInt(2)+5;
            AI6rank = rankrandom.nextInt(2)+5;
            // 5, 6;
        }
        if(xp>=100 && xp<200){
            rank.setImageResource(R.drawable.rank_5);
            AI1rank = rankrandom.nextInt(3)+4;
            AI2rank = rankrandom.nextInt(3)+4;
            AI3rank = rankrandom.nextInt(3)+4;
            AI4rank = rankrandom.nextInt(3)+4;
            AI5rank = rankrandom.nextInt(3)+4;
            AI6rank = rankrandom.nextInt(3)+4;
            // 4, 5 ,6
        }
        if(xp>=200 && xp<300){
            rank.setImageResource(R.drawable.rank_4);
            AI1rank = rankrandom.nextInt(3)+3;
            AI2rank = rankrandom.nextInt(3)+3;
            AI3rank = rankrandom.nextInt(3)+3;
            AI4rank = rankrandom.nextInt(3)+3;
            AI5rank = rankrandom.nextInt(3)+3;
            AI6rank = rankrandom.nextInt(3)+3;
            // 3, 4, 5
        }
        if(xp>=300 && xp<400){
            rank.setImageResource(R.drawable.rank_3);
            AI1rank = rankrandom.nextInt(3)+2;
            AI2rank = rankrandom.nextInt(3)+2;
            AI3rank = rankrandom.nextInt(3)+2;
            AI4rank = rankrandom.nextInt(3)+2;
            AI5rank = rankrandom.nextInt(3)+2;
            AI6rank = rankrandom.nextInt(3)+2;
            // 2, 3, 4
        }
        if(xp>=400 && xp<500){
            rank.setImageResource(R.drawable.rank_2);
            AI1rank = rankrandom.nextInt(3)+1;
            AI2rank = rankrandom.nextInt(3)+1;
            AI3rank = rankrandom.nextInt(3)+1;
            AI4rank = rankrandom.nextInt(3)+1;
            AI5rank = rankrandom.nextInt(3)+1;
            AI6rank = rankrandom.nextInt(3)+1;
            // 1, 2, 3
        }
        if(xp>=500){
            rank.setImageResource(R.drawable.rank_1);
            AI1rank = rankrandom.nextInt(2)+1;
            AI2rank = rankrandom.nextInt(2)+1;
            AI3rank = rankrandom.nextInt(2)+1;
            AI4rank = rankrandom.nextInt(2)+1;
            AI5rank = rankrandom.nextInt(2)+1;
            AI6rank = rankrandom.nextInt(2)+1;
            // 1, 2
        }

        switch(AI1rank){
            case 6:
                rank1.setImageResource(R.drawable.rank_6_small);
            break;
            case 5:
                rank1.setImageResource(R.drawable.rank_5_small);
            break;
            case 4:
                rank1.setImageResource(R.drawable.rank_4_small);
            break;
            case 3:
                rank1.setImageResource(R.drawable.rank_3_small);
            break;
            case 2:
                rank1.setImageResource(R.drawable.rank_2_small);
            break;
            case 1:
                rank1.setImageResource(R.drawable.rank_1_small);
            break;
        }
        switch(AI2rank){
            case 6:
                rank2.setImageResource(R.drawable.rank_6_small);
                break;
            case 5:
                rank2.setImageResource(R.drawable.rank_5_small);
                break;
            case 4:
                rank2.setImageResource(R.drawable.rank_4_small);
                break;
            case 3:
                rank2.setImageResource(R.drawable.rank_3_small);
                break;
            case 2:
                rank2.setImageResource(R.drawable.rank_2_small);
                break;
            case 1:
                rank2.setImageResource(R.drawable.rank_1_small);
                break;
        }
        switch(AI3rank){
            case 6:
                rank3.setImageResource(R.drawable.rank_6_small);
                break;
            case 5:
                rank3.setImageResource(R.drawable.rank_5_small);
                break;
            case 4:
                rank3.setImageResource(R.drawable.rank_4_small);
                break;
            case 3:
                rank3.setImageResource(R.drawable.rank_3_small);
                break;
            case 2:
                rank3.setImageResource(R.drawable.rank_2_small);
                break;
            case 1:
                rank3.setImageResource(R.drawable.rank_1_small);
                break;
        }
        switch(AI4rank){
            case 6:
                rank4.setImageResource(R.drawable.rank_6_small);
                break;
            case 5:
                rank4.setImageResource(R.drawable.rank_5_small);
                break;
            case 4:
                rank4.setImageResource(R.drawable.rank_4_small);
                break;
            case 3:
                rank4.setImageResource(R.drawable.rank_3_small);
                break;
            case 2:
                rank4.setImageResource(R.drawable.rank_2_small);
                break;
            case 1:
                rank4.setImageResource(R.drawable.rank_1_small);
                break;
        }
        switch(AI5rank){
            case 6:
                rank5.setImageResource(R.drawable.rank_6_small);
                break;
            case 5:
                rank5.setImageResource(R.drawable.rank_5_small);
                break;
            case 4:
                rank5.setImageResource(R.drawable.rank_4_small);
                break;
            case 3:
                rank5.setImageResource(R.drawable.rank_3_small);
                break;
            case 2:
                rank5.setImageResource(R.drawable.rank_2_small);
                break;
            case 1:
                rank5.setImageResource(R.drawable.rank_1_small);
                break;
        }
        switch(AI6rank){
            case 6:
                rank6.setImageResource(R.drawable.rank_6_small);
                break;
            case 5:
                rank6.setImageResource(R.drawable.rank_5_small);
                break;
            case 4:
                rank6.setImageResource(R.drawable.rank_4_small);
                break;
            case 3:
                rank6.setImageResource(R.drawable.rank_3_small);
                break;
            case 2:
                rank6.setImageResource(R.drawable.rank_2_small);
                break;
            case 1:
                rank6.setImageResource(R.drawable.rank_1_small);
                break;
        }
        

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

        displayback.setImageResource(R.drawable.hold_your_buttons);
        go.setImageResource(R.drawable.go_inactive);

        displayback.setAdjustViewBounds(true);
        displayback.setPadding(0,0,0,0);
        go.setAdjustViewBounds(true);
        go.setPadding(0,0,0,0);

        //TEXT SIZES
        bal1.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.baltextsize)*getResources().getDisplayMetrics().density);
        bal2.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.baltextsize)*getResources().getDisplayMetrics().density);
        bal3.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.baltextsize)*getResources().getDisplayMetrics().density);
        bal4.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.baltextsize)*getResources().getDisplayMetrics().density);
        bal5.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.baltextsize)*getResources().getDisplayMetrics().density);
        bal6.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.baltextsize)*getResources().getDisplayMetrics().density);
    }
    void updateDisplay(){
        win.setText("" + wins);
        lose.setText("" + loses);
        debug.setText("" + xp);
        debug2.setText("" + balance);
        debug3.setText("" + keys);
    }

    void calcXpAndProfit(){
        if(won) {
            //WINS
            if (xp < 100) {
                xp += 25;
                if(selected==1) {
                    balance += bet * 2;
                }else{
                    keys += bet * 2;
                }
            } else {
                if (xp >= 100 && xp < 200) {
                    xp += 20;
                    if(selected==1) {
                        balance += bet * 2;
                    }else{
                        keys += bet * 2;
                    }
                } else {
                    if (xp >= 200 && xp < 300) {
                        xp += 10;
                        if(selected==1) {
                            balance += bet * 2;
                        }else{
                            keys += bet * 2;
                        }
                    } else {
                        if (xp >= 300 && xp < 400) {
                            xp += 10;
                            if(selected==1) {
                                balance += bet * 2;
                            }else{
                                keys += bet * 2;
                            }
                        } else {
                            if (xp >= 400 && xp < 500) {
                                xp += 10;
                                if(selected==1) {
                                    balance += bet * 3;
                                }else{
                                    keys += bet * 3;
                                }
                            } else {
                                if (xp >= 500) {
                                    xp += 5;
                                    if(selected==1) {
                                        balance += bet * 3;
                                    }else{
                                        keys += bet * 3;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            //LOSES
            if (xp < 100) {
                xp -= 25;
            } else {
                if (xp >= 100 && xp < 200) {
                    xp -= 20;
                } else {
                    if (xp >= 200 && xp < 300) {
                        xp -= 10;
                    } else {
                        if (xp >= 300 && xp < 400) {
                            xp -= 10;
                        } else {
                            if (xp >= 400 && xp < 500) {
                                xp -= 10;
                            } else {
                                if (xp >= 500) {
                                    xp -= 5;
                                }
                            }
                        }
                    }
                }
            }
        }
        debug.setText("" + xp);
        debug2.setText("" + balance);
        debug3.setText("" + keys);
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
        xp = load.getInt("xp", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("balance", balance);
        save.putInt("wins", wins);
        save.putInt("loses", loses);
        save.putInt("bet", bet);
        save.putInt("xp", xp);
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
    }
    void endGame(){
        if(won){
            //WHAT HAPPENS IF PLAYER WON
            displayback.setImageResource(R.drawable.go_inactive);
            wins += 1;
        }else{
            //WHAT HAPPENS IF AI WON
            loses += 1;
            displayback.setImageResource(R.drawable.go_active);
        }
        calcXpAndProfit();
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
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
        debug2 = (TextView)findViewById(R.id.debug2);
        debug3 = (TextView)findViewById(R.id.debug3);

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
