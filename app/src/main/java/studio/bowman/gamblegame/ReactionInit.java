package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ReactionInit extends AppCompatActivity {

    int xp;
    int balance, keys;
    int wins, loses;
    int selected;

    //REACTION PRESETS
    ImageView rank;
    ImageView reactionbanner;
    ImageView winback, loseback, winimg, loseimg;
    ImageButton leftBtn, mainBtn, rightBtn;
    TextView win, lose;

    //RANKS
    ImageView leftRank, mainRank, rightRank;
    ImageView leftrankImg, mainrankImg, rightrankImg;

    //BOTTOM
    ImageView banner2;
    ImageView moneyvalueback, keyvalueback;

    //BUTTONS
    ImageButton moneyBtn, keyBtn;

    TextView moneyvalue, keyvalue;


    void setGUI(){
        //TOPBAR
        winback.setImageResource(R.drawable.rank_win_title_back);
        loseback.setImageResource(R.drawable.rank_lose_title_back);
        winimg.setImageResource(R.drawable.rank_win_title);
        loseimg.setImageResource(R.drawable.rank_lose_title);
        reactionbanner.setImageResource(R.drawable.title_ranks);

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

        //SPECIFIC
        leftBtn.setImageResource(R.drawable.coinflip_icon);
        mainBtn.setImageResource(R.drawable.crash_icon);
        rightBtn.setImageResource(R.drawable.robbery_icon);
        moneyvalueback.setImageResource(R.drawable.case_amount_img);
        keyvalueback.setImageResource(R.drawable.case_amount_img);
        moneyBtn.setImageResource(R.drawable.unlock_case);
        keyBtn.setImageResource(R.drawable.buy_keys);

        banner2.setImageResource(R.drawable.title_choose_bet_type);

        leftBtn.setAdjustViewBounds(true);
        leftBtn.setPadding(0,0,0,0);
        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);
        rightBtn.setAdjustViewBounds(true);
        rightBtn.setPadding(0,0,0,0);
        moneyvalueback.setAdjustViewBounds(true);
        moneyvalueback.setPadding(0,0,0,0);
        keyvalueback.setAdjustViewBounds(true);
        keyvalueback.setPadding(0,0,0,0);
        moneyBtn.setAdjustViewBounds(true);
        moneyBtn.setPadding(0,0,0,0);
        keyBtn.setAdjustViewBounds(true);
        keyBtn.setPadding(0,0,0,0);
        banner2.setAdjustViewBounds(true);
        banner2.setPadding(0,0,0,0);

        //CUREENT RANKS

        if(xp<100){
            rank.setImageResource(R.drawable.rank_6);
            mainRank.setImageResource(R.drawable.rank_6_small);
            rightRank.setImageResource(R.drawable.rank_5_small);
            leftRank.setVisibility(View.GONE);
            rightRank.setVisibility(View.VISIBLE);
            leftrankImg.setVisibility(View.GONE);
            rightrankImg.setVisibility(View.VISIBLE);
        }
        if(xp>=100 && xp<200){
            rank.setImageResource(R.drawable.rank_5);
            leftRank.setImageResource(R.drawable.rank_6_small);
            mainRank.setImageResource(R.drawable.rank_5_small);
            rightRank.setImageResource(R.drawable.rank_4_small);
            leftRank.setVisibility(View.VISIBLE);
            rightRank.setVisibility(View.VISIBLE);
            leftrankImg.setVisibility(View.VISIBLE);
            rightrankImg.setVisibility(View.VISIBLE);
        }
        if(xp>=200 && xp<300){
            rank.setImageResource(R.drawable.rank_4);
            leftRank.setImageResource(R.drawable.rank_5_small);
            mainRank.setImageResource(R.drawable.rank_4_small);
            rightRank.setImageResource(R.drawable.rank_3_small);
            leftRank.setVisibility(View.VISIBLE);
            rightRank.setVisibility(View.VISIBLE);
            leftrankImg.setVisibility(View.VISIBLE);
            rightrankImg.setVisibility(View.VISIBLE);
        }
        if(xp>=300 && xp<400){
            rank.setImageResource(R.drawable.rank_3);
            leftRank.setImageResource(R.drawable.rank_4_small);
            mainRank.setImageResource(R.drawable.rank_3_small);
            rightRank.setImageResource(R.drawable.rank_2_small);
            leftRank.setVisibility(View.VISIBLE);
            rightRank.setVisibility(View.VISIBLE);
            leftrankImg.setVisibility(View.VISIBLE);
            rightrankImg.setVisibility(View.VISIBLE);
        }
        if(xp>=400 && xp<500){
            rank.setImageResource(R.drawable.rank_2);
            leftRank.setImageResource(R.drawable.rank_3_small);
            mainRank.setImageResource(R.drawable.rank_2_small);
            rightRank.setImageResource(R.drawable.rank_1_small);
            leftRank.setVisibility(View.VISIBLE);
            rightRank.setVisibility(View.VISIBLE);
            leftrankImg.setVisibility(View.VISIBLE);
            rightrankImg.setVisibility(View.VISIBLE);
        }
        if(xp>=500){
            rank.setImageResource(R.drawable.rank_1);
            leftRank.setImageResource(R.drawable.rank_2_small);
            mainRank.setImageResource(R.drawable.rank_1_small);
            leftRank.setVisibility(View.VISIBLE);
            rightRank.setVisibility(View.INVISIBLE);
            leftrankImg.setVisibility(View.VISIBLE);
            rightrankImg.setVisibility(View.GONE);
        }

        leftRank.setAdjustViewBounds(true);
        leftRank.setPadding(0,0,0,0);
        mainRank.setAdjustViewBounds(true);
        mainRank.setPadding(0,0,0,0);
        rightRank.setAdjustViewBounds(true);
        rightRank.setPadding(0,0,0,0);

        rank.setAdjustViewBounds(true);
        rank.setPadding(0,0,0,0);
    }
    void updateDisplay(){
        moneyvalue.setText("" + balance + "$");
        keyvalue.setText("" + keys);

        win.setText("" + wins);
        lose.setText("" + loses);
    }

    void loadData(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        balance = load.getInt("balance", 0);
        wins = load.getInt("wins", 0);
        loses = load.getInt("loses", 0);
        xp = load.getInt("xp", 50);
        selected = 0;
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("balance", balance);

        save.apply();
        save.commit();
    }

    @Override
    public void onBackPressed() {
            Intent intent = new Intent(ReactionInit.this, Main.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            finish();
            startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reaction_init);

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

        //SPECIFIC
        leftRank = (ImageView)findViewById(R.id.leftrank);
        mainRank = (ImageView)findViewById(R.id.mainrank);
        rightRank = (ImageView)findViewById(R.id.rightrank);
        leftrankImg = (ImageView)findViewById(R.id.leftrankimg);
        mainrankImg = (ImageView)findViewById(R.id.mainrankimg);
        rightrankImg = (ImageView)findViewById(R.id.rightrankimg);
        banner2 = (ImageView)findViewById(R.id.banner2);
        moneyvalueback = (ImageView)findViewById(R.id.moneyvalueback);
        keyvalueback = (ImageView)findViewById(R.id.keyvalueback);

        moneyBtn = (ImageButton)findViewById(R.id.moneyBtn);
        keyBtn= (ImageButton)findViewById(R.id.keyBtn);

        moneyvalue = (TextView)findViewById(R.id.moneyvalue);
        keyvalue = (TextView)findViewById(R.id.keyvalue);

        loadData();
        setGUI();
        updateDisplay();

        moneyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected = 1;
                Intent intent = new Intent(ReactionInit.this, ReactionChoose.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("selected", selected);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            }
        });

        keyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected = 2;
                Intent intent = new Intent(ReactionInit.this, ReactionChoose.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("selected", selected);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            }
        });

        mainBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(ReactionInit.this, Crash.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    finish();
                    startActivity(intent);
                    overridePendingTransition(0, 0);
            }
        });

        rightBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(ReactionInit.this, Sweeper.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    finish();
                    startActivity(intent);
                    overridePendingTransition(0, 0);
            }
        });
    }
}
