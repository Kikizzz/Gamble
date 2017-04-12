package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CaseDone extends AppCompatActivity {

    int selected;
    int keys, rubies;
    int gotstatus;
    int gotkeys, gotrubies, gotemeralds, gotroyalstones, gotskin;

    ImageView itemview;
    ImageView banneris, title2;
    ImageView back1, back2, back3, back4;
    TextView stats1, stats2, stats3, stats4;
    ImageButton mainBtn;

    void setGUI(){
        back1.setImageResource(R.drawable.stats_back);
        back2.setImageResource(R.drawable.stats_back);
        back3.setImageResource(R.drawable.stats_back);
        back4.setImageResource(R.drawable.stats_back);
        mainBtn.setImageResource(R.drawable.back_icon);


        itemview.setAdjustViewBounds(true);
        itemview.setPadding(0,0,0,0);
        back1.setAdjustViewBounds(true);
        back1.setPadding(0,0,0,0);
        back2.setAdjustViewBounds(true);
        back2.setPadding(0,0,0,0);
        back3.setAdjustViewBounds(true);
        back3.setPadding(0,0,0,0);
        back4.setAdjustViewBounds(true);
        back4.setPadding(0,0,0,0);
        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);

        switch(selected){
            case 1:
                banneris.setImageResource(R.drawable.case_title_grand);
                break;
            case 2:
                banneris.setImageResource(R.drawable.case_title_luxurious);
                break;
            case 3:
                banneris.setImageResource(R.drawable.case_title_exquisite);
                break;
            case 4:
                banneris.setImageResource(R.drawable.case_title_office);
                break;
            case 5:
                banneris.setImageResource(R.drawable.case_title_commerce);
                break;
            case 6:
                banneris.setImageResource(R.drawable.case_title_industry);
                break;
            case 7:
                banneris.setImageResource(R.drawable.case_title_budget);
                break;
            case 8:
                banneris.setImageResource(R.drawable.case_title_ordinary);
                break;
            case 9:
                banneris.setImageResource(R.drawable.case_title_standard);
                break;
        }

        /*
        GOT STATUS
        1:Keys
        2:Gems
        3:Skins
         */

        if (gotstatus==1){
            //KEYS
            itemview.setImageResource(R.drawable.case_open_prize_keys);
        }
        if (gotstatus==2){
            //GEMS
            itemview.setImageResource(R.drawable.case_open_prize_ruby);
        }
        if (gotstatus==3) {
            switch (selected) {
                case 1:
                    switch (gotskin) {
                        case 1:
                            itemview.setImageResource(R.drawable.case_open_prize_crown_1_purple);
                            break;
                        case 2:
                            itemview.setImageResource(R.drawable.case_open_prize_shield_1_purple);
                            break;
                        case 3:
                            itemview.setImageResource(R.drawable.case_open_prize_pig_purple);
                            break;
                        case 4:
                            itemview.setImageResource(R.drawable.case_open_prize_shovel_3_purple);
                            break;
                    }
                    break;
                case 2:
                    switch (gotskin) {
                        case 1:
                            itemview.setImageResource(R.drawable.case_open_prize_crown_1_gold);
                            break;
                        case 2:
                            itemview.setImageResource(R.drawable.case_open_prize_watch_1_gold);
                            break;
                        case 3:
                            itemview.setImageResource(R.drawable.case_open_prize_bank_gold);
                            break;
                        case 4:
                            itemview.setImageResource(R.drawable.case_open_prize_shovel_gold);
                            break;
                    }
                    break;
                case 3:
                    switch (gotskin) {
                        case 1:
                            itemview.setImageResource(R.drawable.case_prize_shovel_whiteruby_fade);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 4:
                    switch (gotskin) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 5:
                    switch (gotskin) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 6:
                    switch (gotskin) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 7:
                    switch (gotskin) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 8:
                    switch (gotskin) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 9:
                    switch (gotskin) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
            }
        }
    }
    void updateDisplay(){
        if (gotkeys>0){
            stats1.setText("" + gotkeys);
            stats2.setText("");
            stats3.setText("");
            stats4.setText("");
        }
        if (gotrubies>0){
            stats1.setText("" + gotemeralds);
            stats2.setText("" + gotrubies);
            stats3.setText("" + gotroyalstones);
            stats4.setText("");
        }
        if (gotskin>0){
            switch (selected){
            //WHICH CASE WAS OPENED
                case 1 :
                switch(gotskin){
                    //WHICH SKIN
                    case 1:
                    break;
                    case 2:
                    break;
                    case 3:
                    break;
                    case 4:
                    break;
                }
                break;
                case 2 :
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 3 :
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 4 :
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 5 :
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 6 :
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 7:
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 8 :
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 9 :
                    switch(gotskin){
                        //WHICH SKIN
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
            }
        }
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");
        gotkeys = (int) bd.get("gotkeys");
        gotemeralds = (int) bd.get("gotemeralds");
        gotrubies = (int) bd.get("gotrubies");
        gotroyalstones = (int) bd.get("gotroyalstones");
        gotskin = (int) bd.get("gotskin");
        gotstatus = (int)bd.get("gotstatus");


        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        rubies = load.getInt("rubies", 0);
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
        setContentView(R.layout.activity_case_done);

        itemview = (ImageView)findViewById(R.id.itemview);
        banneris = (ImageView)findViewById(R.id.banneris);
        title2= (ImageView)findViewById(R.id.title2);
        back1 = (ImageView)findViewById(R.id.back1);
        back2 = (ImageView)findViewById(R.id.back2);
        back3 = (ImageView)findViewById(R.id.back4);
        back4 = (ImageView)findViewById(R.id.back4);

        stats1 = (TextView) findViewById(R.id.stats1);
        stats2 = (TextView) findViewById(R.id.stats2);
        stats3 = (TextView) findViewById(R.id.stats3);
        stats4 = (TextView) findViewById(R.id.stats4);

        mainBtn = (ImageButton) findViewById(R.id.mainBtn);

        loadData();
        setGUI();
        updateDisplay();

        mainBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CaseDone.this, Case.class);
                intent.putExtra("selected", selected);
                finish();
                startActivity(intent);
            }
        });
    }
}
