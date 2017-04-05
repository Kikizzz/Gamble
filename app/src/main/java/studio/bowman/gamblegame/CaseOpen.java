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

    int selected;
    int clicks, min, max, required;
    ImageButton caseview;
    ImageView flare, title;
    TextView debug;

    void setGUI(){
        //BOTTOM BUTTONS
        switch(selected){
            case 1:
                caseview.setImageResource(R.drawable.case_1);
                break;
            case 2:
                caseview.setImageResource(R.drawable.case_2_open);
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
        flare.setImageResource(R.drawable.case_open_flare);
        title.setImageResource(R.drawable.title_img_1);


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
    }

    void caseOpened(){
        debug.setText("GZ");
        caseview.setVisibility(View.INVISIBLE);
        caseview.setEnabled(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(CaseOpen.this, Case.class);
                startActivity(intent);
            }
        }, 1000);
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
        setContentView(R.layout.activity_case_open);

        caseview = (ImageButton)findViewById(R.id.caseview);
        flare = (ImageView)findViewById(R.id.flare);
        title = (ImageView)findViewById(R.id.title);
        debug = (TextView)findViewById(R.id.debug);

        min = 50;
        max = 250;
        clicks = 0;
        Random random = new Random();
//        required = random.nextInt(max) + min;
        required = 1;

        loadData();
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
