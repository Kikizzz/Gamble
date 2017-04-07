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
    int gotkeys, gotrubies, gotskin;

    ImageView itemview;
    ImageView title1, title2;
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

        /*
        GOT STATUS
        1:Keys
        2:Rubies
        3:Skins
         */

        if (gotstatus==1){
            itemview.setImageResource(R.drawable.case_prize_keys);
        }
        if (gotstatus==2){
            itemview.setImageResource(R.drawable.case_prize_ruby);
        }
        if (gotstatus==3) {
            switch (selected) {
                case 1:
                    switch (gotskin) {
                        case 1:
                            itemview.setImageResource(R.drawable.case_prize_vault_whiteruby_fade);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 2:
                    switch (gotskin) {
                        case 1:
                            itemview.setImageResource(R.drawable.case_prize_mask_whiteruby_fade);
                            break;
                        case 2:
                            itemview.setImageResource(R.drawable.case_prize_vault_whiteruby_fade);
                            break;
                        case 3:
                            itemview.setImageResource(R.drawable.case_prize_ice_pig);
                            break;
                        case 4:
                            itemview.setImageResource(R.drawable.case_prize_mask_whiteruby);
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
            stats1.setText("" + keys);
            stats2.setText("");
            stats3.setText("");
            stats4.setText("");
        }
        if (gotrubies>0){
            stats1.setText("" + rubies);
            stats2.setText("");
            stats3.setText("");
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
        gotrubies = (int) bd.get("gotrubies");
        gotskin = (int) bd.get("gotskin");
        gotstatus = (int)bd.get("gotstatus");


        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        rubies = load.getInt("rubies", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("rubies", rubies);

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
        setContentView(R.layout.activity_case_done);

        itemview = (ImageView)findViewById(R.id.itemview);
        title1 = (ImageView)findViewById(R.id.title1);
        title2= (ImageView)findViewById(R.id.title2);
        back1 = (ImageView)findViewById(R.id.back1);
        back2 = (ImageView)findViewById(R.id.back2);
        back3 = (ImageView)findViewById(R.id.back3);
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
                Intent intent = new Intent(CaseDone.this, CaseCheck.class);
                intent.putExtra("selected", selected);
                finish();
                startActivity(intent);
            }
        });
    }
}
