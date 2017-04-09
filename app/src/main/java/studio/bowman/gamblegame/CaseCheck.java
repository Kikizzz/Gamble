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

public class CaseCheck extends AppCompatActivity {

    private int v1,v2,v3,v4,v5,v6,v7,v8,v9;
    int selected;
    int keys;

    ImageButton caseview, mainBtn, buykey, usekey;
    ImageView back, flare;
    ImageView item1, item2, item3, item4, item5, item6;
    TextView amount;

    void setGUI(){

        //BOTTOM BUTTONS
        switch(selected){
            case 1:
                caseview.setImageResource(R.drawable.case_check_1);
//                banneris.setImageResource(R.drawable.case_title_exquisite);
            break;
            case 2:
                caseview.setImageResource(R.drawable.case_2);
//                banneris.setImageResource(R.drawable.case_title_luxurious);
                break;
            case 3:
                caseview.setImageResource(R.drawable.case_3);
//                banneris.setImageResource(R.drawable.case_title_grand);
                break;
            case 4:
                caseview.setImageResource(R.drawable.case_4);
//                banneris.setImageResource(R.drawable.case_title_industry);
                break;
            case 5:
                caseview.setImageResource(R.drawable.case_5);
//                banneris.setImageResource(R.drawable.case_title_commerce);
                break;
            case 6:
                caseview.setImageResource(R.drawable.case_6);
//                banneris.setImageResource(R.drawable.case_title_office);
                break;
            case 7:
                caseview.setImageResource(R.drawable.case_7);
                break;
            case 8:
                caseview.setImageResource(R.drawable.case_8);
                break;
            case 9:
                caseview.setImageResource(R.drawable.case_9);
                break;
        }

        if (keys==0){
            usekey.setEnabled(false);
            usekey.setImageResource(R.drawable.unlock_case_empty);
        }else {
            usekey.setEnabled(true);
            usekey.setImageResource(R.drawable.unlock_case);
        }

        buykey.setImageResource(R.drawable.buy_keys);
        back.setImageResource(R.drawable.key_amount);
        mainBtn.setImageResource(R.drawable.back_icon);
        flare.setImageResource(R.drawable.flare);

        flare.setAdjustViewBounds(true);
        flare.setPadding(0,0,0,0);
        flare.setAlpha((float)0.75);
        back.setAdjustViewBounds(true);
        back.setPadding(0,0,0,0);
        caseview.setAdjustViewBounds(true);
        caseview.setPadding(0,0,0,0);
        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);
        buykey.setAdjustViewBounds(true);
        buykey.setPadding(0,0,0,0);
        usekey.setAdjustViewBounds(true);
        usekey.setPadding(0,0,0,0);

        //ITEMS
        switch(selected){
            case 1:
                item1.setImageResource(R.drawable.case_prize_crown_1_purple);
                item2.setImageResource(R.drawable.case_prize_shield_1_purple);
                item3.setImageResource(R.drawable.case_prize_key_purple);
                item4.setImageResource(R.drawable.case_prize_ruby_purple);
                item5.setImageResource(R.drawable.case_prize_shovel_3_purple);
                item6.setImageResource(R.drawable.case_prize_pig_purple);
            break;
            case 2:
                item1.setImageResource(R.drawable.case_prize_crown_1_gold);
                item2.setImageResource(R.drawable.case_prize_watch_1_gold);
                item3.setImageResource(R.drawable.case_prize_keys_gold);
                item4.setImageResource(R.drawable.case_prize_ruby_gold);
                item5.setImageResource(R.drawable.case_prize_shovel_gold);
                item6.setImageResource(R.drawable.case_prize_bank_gold);
                break;
            case 3:
                item1.setImageResource(R.drawable.case_prize_shovel_whiteruby_fade);
                item2.setImageResource(R.drawable.case_prize_ice_pig);
                item3.setImageResource(R.drawable.case_prize_keys);
                item4.setImageResource(R.drawable.case_prize_ruby);
                item5.setImageResource(R.drawable.case_prize_shovel_whiteruby_fade);
                item6.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                break;
            case 4:
                item1.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                item2.setImageResource(R.drawable.case_prize_ice_pig);
                item3.setImageResource(R.drawable.case_prize_keys);
                item4.setImageResource(R.drawable.case_prize_ruby);
                item5.setImageResource(R.drawable.case_prize_shovel_whiteruby_fade);
                item6.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                break;
            case 5:
                item1.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                item2.setImageResource(R.drawable.case_prize_ice_pig);
                item3.setImageResource(R.drawable.case_prize_keys);
                item4.setImageResource(R.drawable.case_prize_ruby);
                item5.setImageResource(R.drawable.case_prize_shovel_whiteruby_fade);
                item6.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                break;
            case 6:
                item1.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                item2.setImageResource(R.drawable.case_prize_ice_pig);
                item3.setImageResource(R.drawable.case_prize_keys);
                item4.setImageResource(R.drawable.case_prize_ruby);
                item5.setImageResource(R.drawable.case_prize_shovel_whiteruby_fade);
                item6.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                break;
        }

        item1.setAdjustViewBounds(true);
        item1.setPadding(0,0,0,0);
        item2.setAdjustViewBounds(true);
        item2.setPadding(0,0,0,0);
        item3.setAdjustViewBounds(true);
        item3.setPadding(0,0,0,0);
        item4.setAdjustViewBounds(true);
        item4.setPadding(0,0,0,0);
        item5.setAdjustViewBounds(true);
        item5.setPadding(0,0,0,0);
        item6.setAdjustViewBounds(true);
        item6.setPadding(0,0,0,0);
    }
    void updateDisplay(){
        amount.setText("" + keys);
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");

        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        v1 = load.getInt("cases1", 0);
        v2 = load.getInt("cases2", 0);
        v3 = load.getInt("cases3", 0);
        v4 = load.getInt("cases4", 0);
        v5 = load.getInt("cases5", 0);
        v6 = load.getInt("cases6", 0);
        v7 = load.getInt("cases7", 0);
        v8 = load.getInt("cases8", 0);
        v9 = load.getInt("cases9", 0);
        keys = load.getInt("keys", 1000);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("cases1", v1);
        save.putInt("cases2", v2);
        save.putInt("cases3", v3);
        save.putInt("cases4", v4);
        save.putInt("cases5", v5);
        save.putInt("cases6", v6);
        save.putInt("cases7", v7);
        save.putInt("cases8", v8);
        save.putInt("cases9", v9);

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
        setContentView(R.layout.activity_case_check);

        caseview = (ImageButton)findViewById(R.id.caseview);
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        buykey = (ImageButton)findViewById(R.id.buykey);
        usekey = (ImageButton)findViewById(R.id.usekey);

        item1 = (ImageView)findViewById(R.id.item1);
        item2 = (ImageView)findViewById(R.id.item2);
        item3 = (ImageView)findViewById(R.id.item3);
        item4 = (ImageView)findViewById(R.id.item4);
        item5 = (ImageView)findViewById(R.id.item5);
        item6 = (ImageView)findViewById(R.id.item6);

        back = (ImageView)findViewById(R.id.back);
        flare = (ImageView)findViewById(R.id.flare);

        amount = (TextView)findViewById(R.id.amount);

        loadData();
        setGUI();
        updateDisplay();


        caseview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //CHECK ITEMS
            }
        });

        mainBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CaseCheck.this, Case.class);
                intent.putExtra("selected", selected);
                finish();
                startActivity(intent);
            }
        });

        usekey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                keys -= 1;
                switch(selected){
                    case 1:
                        v1 -= 1;
                    break;
                    case 2:
                        v2 -= 1;
                        break;
                    case 3:
                        v3 -= 1;
                        break;
                    case 4:
                        v4 -= 1;
                        break;
                    case 5:
                        v5 -= 1;
                        break;
                    case 6:
                        v6 -= 1;
                        break;
                    case 7:
                        v7 -= 1;
                        break;
                    case 8:
                        v8 -= 1;
                        break;
                    case 9:
                        v9 -= 1;
                        break;
                }
                savedata();
                Intent intent = new Intent(CaseCheck.this, CaseOpen.class);
                intent.putExtra("selected", selected);
                startActivity(intent);
            }
        });

        buykey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            //BUY KEYS
            }
        });

    }
}
