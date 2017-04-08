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

import java.util.Random;

public class ReactionPost extends AppCompatActivity {

    int xp;
    int keys, balance;
    int bet;
    int selected;
    int wins, loses;
    boolean won;

    //INCLUDES
    ImageView rank;
    ImageView reactionbanner;
    ImageView winback, loseback, winimg, loseimg;
    ImageButton leftBtn, mainBtn, rightBtn;
    TextView win, lose;

    //SPECIFICS
    ImageView display,rankdisplay, underrank, title;
    ImageView profitback;
    TextView profit;


    void setGUI(){
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

        //SPECIFICS
        display.setImageResource(R.drawable.back_icon);
        rankdisplay.setImageResource(R.drawable.back_icon);
        underrank.setImageResource(R.drawable.back_icon);
        title.setImageResource(R.drawable.back_icon);
        profitback.setImageResource(R.drawable.back_icon);
    }
    void updateDisplay(){
        win.setText("" + wins);
        lose.setText("" + loses);

        //TODO : PROFIT VISUAL
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");
        won = (boolean)bd.get("won");

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

        save.apply();
        save.commit();
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
        setContentView(R.layout.activity_reaction_post);

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

        //SPECIFICS
        display = (ImageView)findViewById(R.id.display);
        rankdisplay = (ImageView)findViewById(R.id.rankdisplay);
        underrank = (ImageView)findViewById(R.id.underrank);
        title = (ImageView)findViewById(R.id.title);
        profitback = (ImageView)findViewById(R.id.profitback);

        profit = (TextView)findViewById(R.id.profit);


        loadData();
        setGUI();
        updateDisplay();

        mainBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReactionPost.this, ReactionInit.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
