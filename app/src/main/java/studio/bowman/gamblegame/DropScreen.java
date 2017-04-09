package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DropScreen extends AppCompatActivity {

    ImageView droptitle, dropview, yougotimg, textback;
    TextView droptext;
    int gotindrop;
    int v1, v2, v3, v4, v5, v6, v7, v8, v9;
    int keys;

    void setGUI(){
        droptitle.setAdjustViewBounds(true);
        droptitle.setPadding(0,0,0,0);
        dropview.setAdjustViewBounds(true);
        dropview.setPadding(0,0,0,0);
        yougotimg.setAdjustViewBounds(true);
        yougotimg.setPadding(0,0,0,0);
        textback.setAdjustViewBounds(true);
        textback.setPadding(0,0,0,0);
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        gotindrop = (int) bd.get("gotindrop");

        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);

        v1 = load.getInt("cases1", 0);
        v2 = load.getInt("cases2", 0);
        v3 = load.getInt("cases3", 0);
        v4 = load.getInt("cases4", 0);
        v5 = load.getInt("cases5", 0);
        v6 = load.getInt("cases6", 0);
        v7 = load.getInt("cases7", 0);
        v8 = load.getInt("cases8", 0);
        v9 = load.getInt("cases9", 0);
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

    void caseDropVisual(){
        droptitle.setImageResource(R.drawable.case_title_luxurious);
        yougotimg.setImageResource(R.drawable.buy_keys);
        textback.setImageResource(R.drawable.bal_back);

        droptitle.setAdjustViewBounds(true);
        droptitle.setPadding(0,0,0,0);
        dropview.setAdjustViewBounds(true);
        dropview.setPadding(0,0,0,0);
        yougotimg.setAdjustViewBounds(true);
        yougotimg.setPadding(0,0,0,0);
        textback.setAdjustViewBounds(true);
        textback.setPadding(0,0,0,0);

        switch(gotindrop){
            case 1:
                dropview.setImageResource(R.drawable.case_1_open);
                droptext.setText("Grand Case");
                break;
            case 2:
                dropview.setImageResource(R.drawable.case_2_open);
                droptext.setText("Luxurious Case");
                break;
            case 3:
                dropview.setImageResource(R.drawable.case_3_open);
                droptext.setText("Exquisite Case");
                break;
            case 4:
                dropview.setImageResource(R.drawable.case_4_open);
                droptext.setText("Office Case");
                break;
            case 5:
                dropview.setImageResource(R.drawable.case_5_open);
                droptext.setText("Commerce Case");
                break;
            case 6:
                dropview.setImageResource(R.drawable.case_6_open);
                droptext.setText("Industry Case");
                break;
            case 7:
                dropview.setImageResource(R.drawable.case_7_open);
                droptext.setText("Budget Case");
                break;
            case 8:
                dropview.setImageResource(R.drawable.case_8_open);
                droptext.setText("Ordinary Case");
                break;
            case 9:
                dropview.setImageResource(R.drawable.case_9_open);
                droptext.setText("Standard Case");
                break;
            case 10:
                dropview.setImageResource(R.drawable.case_prize_keys);
                droptext.setText("Key");
                break;
        }
    }

    void caseDrop(){
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        int percentage1 = r1.nextInt(1000)|1;
        int percentage2 = r2.nextInt(1000)|1;
        int randomcase = r3.nextInt(3)+1;
        gotindrop = 0;

        /*
        GOT IN DROP VALUES:
        1: Case1
        2: Case2
        3: Case3
        4: Case4
        5: Case5
        6: Case6
        7: Case7
        8: Case8
        9: Case9
        10 : Keys
         */

        if(percentage1 <= 10){
            //KEY DROP
            keys += 1;
            gotindrop = 10;
        }else{
            //CHEST DROP
            if(percentage2>=950) {
                //ROYAL CASE
                switch (randomcase){
                    case 1:
                        v1 += 1;
                        gotindrop = 1;
                        break;
                    case 2:
                        v2 += 1;
                        gotindrop = 2;
                        break;
                    case 3:
                        v3 += 1;
                        gotindrop = 3;
                        break;
                }
            }
            if(percentage2>600 && percentage2<950) {
                //BUSINESS CASE
                switch (randomcase){
                    case 1:
                        v4 += 1;
                        gotindrop = 4;
                        break;
                    case 2:
                        v5 += 1;
                        gotindrop = 5;
                        break;
                    case 3:
                        v6 += 1;
                        gotindrop = 6;
                        break;
                }
            }
            if(percentage2<=600) {
                //CASUAL CASE
                switch (randomcase){
                    case 1:
                        v7 += 1;
                        gotindrop = 7;
                        break;
                    case 2:
                        v8 += 1;
                        gotindrop = 8;
                        break;
                    case 3:
                        v9 += 1;
                        gotindrop = 9;
                        break;
                }
            }
        }
        savedata();
        caseDropVisual();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dropscreen);

        droptitle = (ImageView)findViewById(R.id.droptitle);
        dropview = (ImageView)findViewById(R.id.dropview);
        textback = (ImageView)findViewById(R.id.textback);
        yougotimg = (ImageView)findViewById(R.id.yougotimg);
        droptext = (TextView)findViewById(R.id.droptext);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = (int) ((dm.widthPixels) * 0.85);
        int height = (int) ((dm.heightPixels) * 0.8);

        getWindow().setLayout(width, height);

        caseDrop();
    }
}
