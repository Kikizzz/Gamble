package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    ImageView foobar, back, flare;
    TextView amount;

    void setGUI(){

        //BOTTOM BUTTONS
        switch(selected){
            case 1:
                caseview.setImageResource(R.drawable.case_1);
            break;
            case 2:
                caseview.setImageResource(R.drawable.case_2);
                break;
            case 3:
                caseview.setImageResource(R.drawable.case_3);
                break;
            case 4:
                caseview.setImageResource(R.drawable.case_4);
                break;
            case 5:
                caseview.setImageResource(R.drawable.case_5);
                break;
            case 6:
                caseview.setImageResource(R.drawable.case_6);
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
        foobar.setImageResource(R.drawable.you_have_keys);
        back.setImageResource(R.drawable.key_amount);
        mainBtn.setImageResource(R.drawable.back_icon);
        flare.setImageResource(R.drawable.flare);

        flare.setAdjustViewBounds(true);
        flare.setPadding(0,0,0,0);
        flare.setAlpha((float)0.75);
        back.setAdjustViewBounds(true);
        back.setPadding(0,0,0,0);
        foobar.setAdjustViewBounds(true);
        foobar.setPadding(0,0,0,0);
        caseview.setAdjustViewBounds(true);
        caseview.setPadding(0,0,0,0);
        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);
        buykey.setAdjustViewBounds(true);
        buykey.setPadding(0,0,0,0);
        usekey.setAdjustViewBounds(true);
        usekey.setPadding(0,0,0,0);

    }
    void updateDisplay(){
        amount.setText("" + keys);
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");

        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        v1 = load.getInt("val1", 0);
        v2 = load.getInt("val2", 0);
        v3 = load.getInt("val3", 0);
        v4 = load.getInt("val4", 0);
        v5 = load.getInt("val5", 0);
        v6 = load.getInt("val6", 0);
        v7 = load.getInt("val7", 0);
        v8 = load.getInt("val8", 0);
        v9 = load.getInt("val9", 0);
        keys = load.getInt("keys", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("val1", v1);
        save.putInt("val2", v2);
        save.putInt("val3", v3);
        save.putInt("val4", v4);
        save.putInt("val5", v5);
        save.putInt("val6", v6);
        save.putInt("val7", v7);
        save.putInt("val8", v8);
        save.putInt("val9", v9);

        save.apply();
        save.commit();
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

        foobar = (ImageView)findViewById(R.id.foobar);
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
                finish();
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
