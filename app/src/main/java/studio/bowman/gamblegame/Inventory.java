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

public class Inventory extends AppCompatActivity {

    int balance;

    ImageView banneris;
    ImageButton leftBtn, mainBtn, rightBtn;
    ImageButton box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15;


    void setGUI(){
        box1.setImageResource(R.drawable.item_key);
        box2.setImageResource(R.drawable.item_ruby);
        box3.setImageResource(R.drawable.item_bank);
        box4.setImageResource(R.drawable.item_pig);
        box5.setImageResource(R.drawable.item_shovel);
        box6.setImageResource(R.drawable.item_shovel_2);
        box7.setImageResource(R.drawable.item_shovel_3);
        box8.setImageResource(R.drawable.item_vault);
        box9.setImageResource(R.drawable.item_watch);
        box10.setImageResource(R.drawable.case_check_1);
        box11.setImageResource(R.drawable.case_check_1);
        box12.setImageResource(R.drawable.case_check_1);
        box13.setImageResource(R.drawable.case_check_1);
        box14.setImageResource(R.drawable.case_check_1);
        box15.setImageResource(R.drawable.case_check_1);

        box1.setAdjustViewBounds(true);
        box1.setPadding(0,0,0,0);
        box2.setAdjustViewBounds(true);
        box2.setPadding(0,0,0,0);
        box3.setAdjustViewBounds(true);
        box3.setPadding(0,0,0,0);
        box4.setAdjustViewBounds(true);
        box4.setPadding(0,0,0,0);
        box5.setAdjustViewBounds(true);
        box5.setPadding(0,0,0,0);
        box6.setAdjustViewBounds(true);
        box6.setPadding(0,0,0,0);
        box7.setAdjustViewBounds(true);
        box7.setPadding(0,0,0,0);
        box8.setAdjustViewBounds(true);
        box8.setPadding(0,0,0,0);
        box9.setAdjustViewBounds(true);
        box9.setPadding(0,0,0,0);
        box10.setAdjustViewBounds(true);
        box10.setPadding(0,0,0,0);
        box11.setAdjustViewBounds(true);
        box11.setPadding(0,0,0,0);
        box12.setAdjustViewBounds(true);
        box12.setPadding(0,0,0,0);
        box13.setAdjustViewBounds(true);
        box13.setPadding(0,0,0,0);
        box14.setAdjustViewBounds(true);
        box14.setPadding(0,0,0,0);
        box15.setAdjustViewBounds(true);
        box15.setPadding(0,0,0,0);

        banneris.setImageResource(R.drawable.case_title_exquisite);
        leftBtn.setImageResource(R.drawable.shop_icon);
        mainBtn.setImageResource(R.drawable.inventory_icon_active);
        rightBtn.setImageResource(R.drawable.cases_icon);

        banneris.setAdjustViewBounds(true);
        banneris.setPadding(0,0,0,0);
        leftBtn.setAdjustViewBounds(true);
        leftBtn.setPadding(0,0,0,0);
        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);
        rightBtn.setAdjustViewBounds(true);
        rightBtn.setPadding(0,0,0,0);
    }
    void updateDisplay(){
    }

    void loadData(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        balance = load.getInt("balance", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("balance", balance);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Inventory.this, Main.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_inventory);

        banneris = (ImageView)findViewById(R.id.banneris);

        leftBtn = (ImageButton)findViewById(R.id.leftBtn);
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        rightBtn = (ImageButton)findViewById(R.id.rightBtn);

        box1 = (ImageButton)findViewById(R.id.box1);
        box2 = (ImageButton)findViewById(R.id.box2);
        box3 = (ImageButton)findViewById(R.id.box3);
        box4 = (ImageButton)findViewById(R.id.box4);
        box5 = (ImageButton)findViewById(R.id.box5);
        box6 = (ImageButton)findViewById(R.id.box6);
        box7 = (ImageButton)findViewById(R.id.box7);
        box8 = (ImageButton)findViewById(R.id.box8);
        box9 = (ImageButton)findViewById(R.id.box9);
        box10 = (ImageButton)findViewById(R.id.box10);
        box11 = (ImageButton)findViewById(R.id.box11);
        box12 = (ImageButton)findViewById(R.id.box12);
        box13 = (ImageButton)findViewById(R.id.box13);
        box14 = (ImageButton)findViewById(R.id.box14);
        box15 = (ImageButton)findViewById(R.id.box15);

        loadData();
        setGUI();
        updateDisplay();

        leftBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //SHOP BUTTON

//                Intent intent = new Intent(Inventory.this, CaseCheck.class);
//                startActivity(intent);
            }
        });

        rightBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Inventory.this, Case.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }
}
