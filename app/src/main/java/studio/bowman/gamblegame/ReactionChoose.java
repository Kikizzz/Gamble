package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ReactionChoose extends AppCompatActivity {

    int xp;
    int bet;
    int wins, loses;
    int balance, keys;
    int selected;

    //REACTION PRESETS
    ImageView rank;
    ImageView reactionbanner;
    ImageView winback, loseback, winimg, loseimg;
    ImageButton leftBtn, mainBtn, rightBtn;

    TextView win, lose;

    //SPECIFICS
    ImageButton choice1, choice2, choice3, choice4, choice5, choice6, choice7, choice8;

    void setGUI(){
        //TOPBAR
        rank.setImageResource(R.drawable.rank_1);
        winback.setImageResource(R.drawable.rank_win_title_back);
        loseback.setImageResource(R.drawable.rank_lose_title_back);
        winimg.setImageResource(R.drawable.rank_win_title);
        loseimg.setImageResource(R.drawable.rank_lose_title);
        reactionbanner.setImageResource(R.drawable.case_title_exquisite);
        mainBtn.setImageResource(R.drawable.back_icon);

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
        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);

        leftBtn.setVisibility(View.GONE);
        rightBtn.setVisibility(View.GONE);

        //ALL ZE BUTTONS
        if(selected == 1) {
            choice1.setImageResource(R.drawable.bet_100);
            choice2.setImageResource(R.drawable.bet_2500);
            choice3.setImageResource(R.drawable.bet_250);
            choice4.setImageResource(R.drawable.bet_5000);
            choice5.setImageResource(R.drawable.bet_500);
            choice6.setImageResource(R.drawable.bet_10000);
            choice7.setImageResource(R.drawable.bet_1000);
            choice8.setImageResource(R.drawable.bet_50000);
        }

        if(selected == 2) {
            choice1.setImageResource(R.drawable.buy_keys);
            choice2.setImageResource(R.drawable.buy_keys);
            choice3.setImageResource(R.drawable.buy_keys);
            choice4.setImageResource(R.drawable.buy_keys);
            choice5.setImageResource(R.drawable.buy_keys);
            choice6.setImageResource(R.drawable.buy_keys);
            choice7.setImageResource(R.drawable.buy_keys);
            choice8.setImageResource(R.drawable.buy_keys);
        }

        choice1.setAdjustViewBounds(true);
        choice1.setPadding(0,0,0,0);
        choice2.setAdjustViewBounds(true);
        choice2.setPadding(0,0,0,0);
        choice3.setAdjustViewBounds(true);
        choice3.setPadding(0,0,0,0);
        choice4.setAdjustViewBounds(true);
        choice4.setPadding(0,0,0,0);
        choice5.setAdjustViewBounds(true);
        choice5.setPadding(0,0,0,0);
        choice6.setAdjustViewBounds(true);
        choice6.setPadding(0,0,0,0);
        choice7.setAdjustViewBounds(true);
        choice7.setPadding(0,0,0,0);
        choice8.setAdjustViewBounds(true);
        choice8.setPadding(0,0,0,0);


        //RANKS
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
    }
    void updateDisplay(){
        win.setText("" + wins);
        lose.setText("" + loses);
    }

    void calculateBet(){
        if (selected == 1){
            //MONEY
            balance -= bet;
        }else{
            //KEYS
            keys -= bet;
        }
        savedata();
        Intent intent = new Intent(ReactionChoose.this, ReactionGame.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("selected", selected);
        finish();
        startActivity(intent);
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
        save.apply();
        save.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reaction_choose);

        //REACTION PRESETS
        rank = (ImageView)findViewById(R.id.rank);
        winback = (ImageView)findViewById(R.id.winback);
        loseback = (ImageView)findViewById(R.id.loseback);
        winimg = (ImageView)findViewById(R.id.winimg);
        loseimg = (ImageView)findViewById(R.id.loseimg);
        leftBtn = (ImageButton)findViewById(R.id.leftBtn);
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        rightBtn = (ImageButton)findViewById(R.id.rightBtn);
        reactionbanner = (ImageView)findViewById(R.id.reactionbanner);

        win = (TextView)findViewById(R.id.win);
        lose = (TextView)findViewById(R.id.lose);

        choice1 = (ImageButton)findViewById(R.id.choice1);
        choice2 = (ImageButton)findViewById(R.id.choice2);
        choice3 = (ImageButton)findViewById(R.id.choice3);
        choice4 = (ImageButton)findViewById(R.id.choice4);
        choice5 = (ImageButton)findViewById(R.id.choice5);
        choice6 = (ImageButton)findViewById(R.id.choice6);
        choice7 = (ImageButton)findViewById(R.id.choice7);
        choice8 = (ImageButton)findViewById(R.id.choice8);

        loadData();
        setGUI();
        updateDisplay();

        mainBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        choice1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 100;
                    break;
                    case 2:
                        //KEYS
                        bet = 1;
                    break;
                }
                calculateBet();
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 2500;
                        break;
                    case 2:
                        //KEYS
                        bet = 3;
                        break;
                }
                calculateBet();
            }
        });
        choice3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 250;
                        break;
                    case 2:
                        //KEYS
                        bet = 5;
                        break;
                }
                calculateBet();
            }
        });
        choice4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 5000;
                        break;
                    case 2:
                        //KEYS
                        bet = 10;
                        break;
                }
                calculateBet();
            }
        });
        choice5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 500;
                        break;
                    case 2:
                        //KEYS
                        bet = 15;
                        break;
                }
                calculateBet();
            }
        });
        choice6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 10000;
                        break;
                    case 2:
                        //KEYS
                        bet = 20;
                        break;
                }
                calculateBet();
            }
        });
        choice7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 1000;
                        break;
                    case 2:
                        //KEYS
                        bet = 25;
                        break;
                }
                calculateBet();
            }
        });
        choice8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(selected){
                    case 1:
                        //MONEY
                        bet = 25000;
                        break;
                    case 2:
                        //KEYS
                        bet = 50;
                        break;
                }
                calculateBet();
            }
        });
    }
}
