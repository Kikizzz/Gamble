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

public class ReactionChoose extends AppCompatActivity {

    int wins, loses;
    int balance, keys;
    int selected;

    //REACTION PRESETS
    ImageView rank;
    ImageView reactionbanner;
    ImageView winback, loseback, winimg, loseimg;
    ImageButton leftBtn, mainBtn, rightBtn;

    ImageButton choice1, choice2, choice3, choice4, choice5, choice6, choice7, choice8;

    void setGUI(){
        //TOPBAR
        rank.setImageResource(R.drawable.rank_1);
        winback.setImageResource(R.drawable.case_amount_img);
        loseback.setImageResource(R.drawable.case_amount_img);
        winimg.setImageResource(R.drawable.case_7);
        loseimg.setImageResource(R.drawable.case_7);
        reactionbanner.setImageResource(R.drawable.case_title_exquisite);
        mainBtn.setImageResource(R.drawable.buy_keys);

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

        //ALL ZE BUTTONS
        if(selected == 1) {
            choice1.setImageResource(R.drawable.unlock_case);
            choice2.setImageResource(R.drawable.unlock_case);
            choice3.setImageResource(R.drawable.unlock_case);
            choice4.setImageResource(R.drawable.unlock_case);
            choice5.setImageResource(R.drawable.unlock_case);
            choice6.setImageResource(R.drawable.unlock_case);
            choice7.setImageResource(R.drawable.unlock_case);
            choice8.setImageResource(R.drawable.unlock_case);
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
    }
    void updateDisplay(){
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
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        reactionbanner = (ImageView)findViewById(R.id.reactionbanner);

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
            }
        });
        choice2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        choice3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        choice4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        choice5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        choice6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        choice7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        choice8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }
}
