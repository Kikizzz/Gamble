package studio.bowman.gamblegame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class CaseOpen extends AppCompatActivity {

    int gotstatus;
    int keys, rubies, emeralds, royalstones;
    int gotkeys,gotrubies, gotemeralds, gotroyalstones, gotskin;
    int selected;
    int clicks, min, max, required;
    ImageButton caseview;
    ImageView flare, banneris;
    TextView debug;

    void setGUI(){
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

        flare.setImageResource(R.drawable.case_open_flare);


        flare.setAdjustViewBounds(true);
        flare.setPadding(0,0,0,0);
        caseview.setAdjustViewBounds(true);
        caseview.setPadding(0,0,0,0);
    }
    void updateDisplay(){
        debug.setText("" + clicks);
    }

    void loadData(){
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        selected = (int) bd.get("selected");

        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        rubies = load.getInt("rubies", 0);
        emeralds = load.getInt("emeralds", 0);
        royalstones = load.getInt("royalstones", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("rubies", rubies);
        save.putInt("emeralds", emeralds);
        save.putInt("royalstones", royalstones);

        save.apply();
        save.commit();
    }

    void randomReward(){
        Random random = new Random();
        int r = random.nextInt(1000)+1;

        /*
        GOT STATUS
        1:Keys
        2:Rubies
        3:Skins
         */

        if (r<=10){
            //SUPERSKIN
            gotskin = 1;
            gotstatus = 3;
        }
        if (r>10 && r<=100){
            //KEYS
            Random rkeys = new Random();
            gotkeys += rkeys.nextInt(3)+1;
            keys += gotkeys;
            gotstatus = 1;
        }
        if (r>100 && r<=301){
            //GEMS
                Random remeralds = new Random();
                gotemeralds += remeralds.nextInt(10)+1;
                emeralds += gotemeralds;

                Random rrubies = new Random();
                gotrubies += rrubies.nextInt(5)+1;
                rubies += gotrubies;

                Random rroyalstones = new Random();
                gotroyalstones += rroyalstones.nextInt(2)+1;
                royalstones += gotroyalstones;

            gotstatus = 2;
        }
        if (r>301 && r<=534){
            gotskin = 2;
            gotstatus = 3;
        }
        if (r>534 && r<=767){
            gotskin = 3;
            gotstatus = 3;
        }
        if (r>767){
            gotskin = 4;
            gotstatus = 3;
        }
        savedata();
    }
    void caseOpened(){
        debug.setText("" + gotstatus);
        caseview.setVisibility(View.INVISIBLE);
        caseview.setEnabled(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(CaseOpen.this, CaseDone.class);
                intent.putExtra("gotstatus", gotstatus);
                intent.putExtra("gotkeys", gotkeys);
                intent.putExtra("gotemeralds", gotemeralds);
                intent.putExtra("gotrubies", gotrubies);
                intent.putExtra("gotroyalstones", gotroyalstones);
                intent.putExtra("gotskin", gotskin);
                intent.putExtra("selected", selected);
                finish();
                startActivity(intent);
            }
        }, 2000);
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
        // Set No banneris
        setContentView(R.layout.activity_case_open);

        caseview = (ImageButton)findViewById(R.id.caseview);
        flare = (ImageView)findViewById(R.id.flare);
        banneris = (ImageView)findViewById(R.id.banneris);
        debug = (TextView)findViewById(R.id.debug);

        gotkeys = 0;
        gotrubies = 0;
        gotskin=0;

        min = 50;
        max = 250;
        clicks = 0;
        Random random = new Random();
//        required = random.nextInt(max) + min;
        required = 1;

        loadData();
        randomReward();
        setGUI();
        updateDisplay();

        caseview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks += 1;
                updateDisplay();
                if (clicks == required){
                    caseOpened();
                }
            }
        });
    }
}
