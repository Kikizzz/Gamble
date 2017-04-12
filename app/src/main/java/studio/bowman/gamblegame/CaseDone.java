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
    int gotstatus;
    int gotkeys, gotrubies, gotemeralds, gotroyalstones, gotskin;

    int balance, keys;
    int emeralds, rubies, royalstones;
    int emeraldrings, rubyrings, royalrings;
    int backpack1, backpack2, backpack3, backpack4;
    int anvil1, anvil2, anvil3;
    int pig1, pigroyalstone;
    int vault, vaultruby;
    int bank1, bankgold;
    int shield1, shield1_1, shield1_2, shield2, shield3, shield3royalstone, shield4;
    int watch1, watch1gold, watch1_1, watch2, watch3;
    int shovel1, shovel1royalstone, shovel2, shovel2gold, shovel3;
    int mask1, mask1whiteruby, mask2;
    int crowngold, crownroyalstone, crownwhiteruby;

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
        balance = load.getInt("balance", 0);
        keys = load.getInt("balance", 0);

        emeralds = load.getInt("emeralds", 0);
        rubies = load.getInt("rubies", 0);
        royalstones = load.getInt("royalstones", 0);

        emeraldrings = load.getInt("emeraldrings", 0);
        rubyrings = load.getInt("rubyrings", 0);
        royalrings = load.getInt("royalrings", 0);

        backpack1 = load.getInt("backpack1", 0);
        backpack2 = load.getInt("backpack2", 0);
        backpack3 = load.getInt("backpack3", 0);
        backpack4 = load.getInt("backpack4", 0);

        anvil1 = load.getInt("anvil1", 0);
        anvil2 = load.getInt("anvil2", 0);
        anvil3 = load.getInt("anvil3", 0);

        pig1 = load.getInt("pig1", 0);
        pigroyalstone = load.getInt("pigroyalstone", 0);

        vault = load.getInt("vault", 0);
        vaultruby = load.getInt("vaultruby", 0);

        bank1 = load.getInt("bank1", 0);
        bankgold = load.getInt("bankgold", 0);

        shield1 = load.getInt("shield1", 0);
        shield1_1 = load.getInt("shield1_1", 0);
        shield1_2 = load.getInt("shield1_2", 0);
        shield2 = load.getInt("shield2", 0);
        shield3 = load.getInt("shield3", 0);
        shield3royalstone = load.getInt("shield3royalstone", 0);
        shield4 = load.getInt("shield4", 0);

        watch1 = load.getInt("watch1", 0);
        watch1_1 = load.getInt("watch1_1", 0);
        watch1gold = load.getInt("watch1gold", 0);
        watch2 = load.getInt("watch2", 0);
        watch3 = load.getInt("watch3", 0);

        shovel1 = load.getInt("shovel1", 0);
        shovel1royalstone = load.getInt("shovel1royalstone", 0);
        shovel2 = load.getInt("shovel2", 0);
        shovel2gold = load.getInt("shovel2gold", 0);
        shovel3 = load.getInt("shovel3", 0);

        mask1 = load.getInt("mask1", 0);
        mask1whiteruby = load.getInt("mask1whiteruby", 0);
        mask2 = load.getInt("mask2", 0);

        crowngold = load.getInt("crowngold", 0);
        crownroyalstone = load.getInt("crownroyalstone", 0);
        crownwhiteruby = load.getInt("crownwhiteruby", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("balance", balance);
        save.putInt("keys", keys);
        save.putInt("emeralds", emeralds);
        save.putInt("rubies", rubies);
        save.putInt("royalstones", royalstones);
        save.putInt("emeraldrings", emeraldrings);
        save.putInt("rubyrings", rubyrings);
        save.putInt("royalrings", royalrings);

        //SALVAGE RATE
        save.putInt("anvil1", anvil1);
        save.putInt("anvil2", anvil2);
        save.putInt("anvil3", anvil3);

        //INVENTORY SIZE
        save.putInt("backpack1", backpack1);
        save.putInt("backpack2", backpack2);
        save.putInt("backpack3", backpack3);
        save.putInt("backpack4", backpack4);

        //BALANCE HOLDERS
        save.putInt("pig1", pig1);
        save.putInt("pigroyalstone", pigroyalstone);

        save.putInt("vault", vault);
        save.putInt("vaultruby", vaultruby);

        save.putInt("bank1", bank1);
        save.putInt("bankgold", bankgold);

        //SHIELDS
        save.putInt("shield1", shield1);
        save.putInt("shield1_1", shield1_1);
        save.putInt("shield1_2", shield1_2);
        save.putInt("shield2", shield2);
        save.putInt("shield3", shield3);
        save.putInt("shield3royalstone", shield3royalstone);
        save.putInt("shield4", shield4);

        //WATCHES
        save.putInt("watch1", watch1);
        save.putInt("watch1gold", watch1gold);
        save.putInt("watch1_1", watch1_1);
        save.putInt("watch2", watch2);
        save.putInt("watch3", watch3);

        //SHOVELS
        save.putInt("shovel1", shovel1);
        save.putInt("shovel1royalstone", shovel1royalstone);
        save.putInt("shovel2", shovel2);
        save.putInt("shovel2gold", shovel2gold);
        save.putInt("shovel3", shovel3);

        //MASKS
        save.putInt("mask1", mask1);
        save.putInt("mask1whiteruby", mask1whiteruby);
        save.putInt("mask2", mask2);

        //CROWNS
        save.putInt("crowngold", crowngold);
        save.putInt("crownroyalstone", crownroyalstone);
        save.putInt("crownwhiteruby", crownwhiteruby);
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
