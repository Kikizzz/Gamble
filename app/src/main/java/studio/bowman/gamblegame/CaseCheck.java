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

public class CaseCheck extends AppCompatActivity {

    int selected;
    int keys;

    ImageButton caseview, mainBtn, buykey;
    ImageView key;

    void setGUI(){

        //BOTTOM BUTTONS
        switch(selected){
            case 1:
                caseview.setImageResource(R.drawable.case_1);
            break;
            case 2:
                caseview.setImageResource(R.drawable.case_2);
                break;
//            case 3:
//                caseview.setImageResource(R.drawable.case_3);
//                break;
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

        buykey.setImageResource(R.drawable.case_icon);

        caseview.setAdjustViewBounds(true);
        caseview.setPadding(0,0,0,0);

        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);

        buykey.setAdjustViewBounds(true);
        buykey.setPadding(0,0,0,0);

        if (keys>0){
            buykey.setEnabled(false);
            buykey.setVisibility(View.GONE);

            key.setEnabled(true);
            key.setVisibility(View.VISIBLE);

            //MAIN BUTTON USE KEYS
            mainBtn.setImageResource(R.drawable.inventory_icon);
        }else{
            buykey.setEnabled(true);
            buykey.setVisibility(View.VISIBLE);

            key.setEnabled(false);
            key.setVisibility(View.GONE);

            //MAIN BUTTON DONE
            mainBtn.setImageResource(R.drawable.inventory_icon);
        }
    }
    void updateDisplay(){
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");

        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);

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

        key = (ImageView) findViewById(R.id.key);

        loadData();
        setGUI();
        updateDisplay();

        key.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //BUY KEY
            }
        });

        caseview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //CHECK ITEMS
            }
        });
    }
}
