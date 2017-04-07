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

public class ReactionInit extends AppCompatActivity {

    int balance, keys;
    int wins, loses;
    int selected;

    //REACTION PRESETS
    ImageView rank;
    ImageView reactionbanner;
    ImageView winback, loseback, winimg, loseimg;
    ImageButton leftBtn, mainBtn, rightBtn;

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
        rank.setImageResource(R.drawable.rank_1);
        rank.setAdjustViewBounds(true);
        winback.setImageResource(R.drawable.case_amount_img);
        loseback.setImageResource(R.drawable.case_amount_img);
        winimg.setImageResource(R.drawable.case_7);
        loseimg.setImageResource(R.drawable.case_7);
        reactionbanner.setImageResource(R.drawable.case_title_exquisite);

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

        //RANKS
        leftRank.setImageResource(R.drawable.case_7);
        mainRank.setImageResource(R.drawable.case_5);
        rightRank.setImageResource(R.drawable.case_2);

        leftRank.setAdjustViewBounds(true);
        leftRank.setPadding(0,0,0,0);
        mainRank.setAdjustViewBounds(true);
        mainRank.setPadding(0,0,0,0);
        rightRank.setAdjustViewBounds(true);
        rightRank.setPadding(0,0,0,0);

        //SPECIFIC
        leftBtn.setImageResource(R.drawable.coinflip_icon);
        mainBtn.setImageResource(R.drawable.crash_icon);
        rightBtn.setImageResource(R.drawable.robbery_icon);
        moneyvalueback.setImageResource(R.drawable.case_amount_img);
        keyvalueback.setImageResource(R.drawable.case_amount_img);
        moneyBtn.setImageResource(R.drawable.unlock_case);
        keyBtn.setImageResource(R.drawable.buy_keys);

        banner2.setImageResource(R.drawable.case_title_exquisite);

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
    }
    void updateDisplay(){
        moneyvalue.setText("" + balance + "$");
        keyvalue.setText("" + keys);
    }

    void loadData(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        balance = load.getInt("balance", 0);
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

        selected = 0;
        loadData();
        setGUI();
        updateDisplay();

        moneyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected = 1;
                Intent intent = new Intent(ReactionInit.this, ReactionChoose.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                finish();
                startActivity(intent);
            }
        });

        keyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selected = 2;
                Intent intent = new Intent(ReactionInit.this, ReactionChoose.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                finish();
                startActivity(intent);
            }
        });

        mainBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(ReactionInit.this, Crash.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    finish();
                    startActivity(intent);
            }
        });

        rightBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(ReactionInit.this, Sweeper.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    finish();
                    startActivity(intent);
            }
        });
    }
}
