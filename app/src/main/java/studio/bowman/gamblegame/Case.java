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

public class Case extends AppCompatActivity {
    private int v1,v2,v3,v4,v5,v6,v7,v8,v9;
    private int selected;

    ImageView back1,back2,back3,back4,back5,back6,back7,back8,back9;
    TextView val1,val2,val3,val4,val5,val6,val7,val8,val9;

    ImageView title1, title2,title3;
    ImageButton case1, case2, case3, case4, case5, case6, case7, case8, case9;

    ImageButton leftBtn, mainBtn,rightBtn;

    void setGUI(){
        // TITLE BARS
            title1.setImageResource(R.drawable.title_img_1);
            title2.setImageResource(R.drawable.title_img_2);
            title3.setImageResource(R.drawable.title_img_3);

            title1.setAdjustViewBounds(true);
            title1.setPadding(0,0,0,0);
            title2.setAdjustViewBounds(true);
            title2.setPadding(0,0,0,0);
            title3.setAdjustViewBounds(true);
            title3.setPadding(0,0,0,0);

        // CASES
        if (v1 > 0){
            case1.setImageResource(R.drawable.case_1);
        }else{
            case1.setImageResource(R.drawable.case_1_empty);
        }
        if (v2 > 0){
            case2.setImageResource(R.drawable.case_2);
        }else{
            case2.setImageResource(R.drawable.case_2_empty);
        }
        if (v3 > 0){
            case3.setImageResource(R.drawable.case_3);
        }else{
            case3.setImageResource(R.drawable.case_3_empty);
        }
        if (v4 > 0){
            case4.setImageResource(R.drawable.case_4);
        }else{
            case4.setImageResource(R.drawable.case_4_empty);
        }
        if (v5 > 0){
            case5.setImageResource(R.drawable.case_5);
        }else{
            case5.setImageResource(R.drawable.case_5_empty);
        }
        if (v6 > 0){
            case6.setImageResource(R.drawable.case_6);
        }else{
            case6.setImageResource(R.drawable.case_6_empty);
        }
        if (v7 > 0){
            case7.setImageResource(R.drawable.case_7);
        }else{
            case7.setImageResource(R.drawable.case_7_empty);
        }
        if (v8 > 0){
            case8.setImageResource(R.drawable.case_8);
        }else{
            case8.setImageResource(R.drawable.case_8_empty);
        }
        if (v9 > 0){
            case9.setImageResource(R.drawable.case_9);
        }else{
            case9.setImageResource(R.drawable.case_9_empty);
        }


        case1.setAdjustViewBounds(true);
        case1.setPadding(0,0,0,0);
        case2.setAdjustViewBounds(true);
        case2.setPadding(0,0,0,0);
        case3.setAdjustViewBounds(true);
        case3.setPadding(0,0,0,0);
        case4.setAdjustViewBounds(true);
        case4.setPadding(0,0,0,0);
        case5.setAdjustViewBounds(true);
        case5.setPadding(0,0,0,0);
        case6.setAdjustViewBounds(true);
        case6.setPadding(0,0,0,0);
        case7.setAdjustViewBounds(true);
        case7.setPadding(0,0,0,0);
        case8.setAdjustViewBounds(true);
        case8.setPadding(0,0,0,0);
        case9.setAdjustViewBounds(true);
        case9.setPadding(0,0,0,0);

        // CASE BACKS AND VALUES}
        back1.setImageResource(R.drawable.case_amount_img);
        back2.setImageResource(R.drawable.case_amount_img);
        back3.setImageResource(R.drawable.case_amount_img);
        back4.setImageResource(R.drawable.case_amount_img);
        back5.setImageResource(R.drawable.case_amount_img);
        back6.setImageResource(R.drawable.case_amount_img);
        back7.setImageResource(R.drawable.case_amount_img);
        back8.setImageResource(R.drawable.case_amount_img);
        back9.setImageResource(R.drawable.case_amount_img);

        back1.setAdjustViewBounds(true);
        back1.setPadding(0,0,0,0);
        back2.setAdjustViewBounds(true);
        back2.setPadding(0,0,0,0);
        back3.setAdjustViewBounds(true);
        back3.setPadding(0,0,0,0);
        back4.setAdjustViewBounds(true);
        back4.setPadding(0,0,0,0);
        back5.setAdjustViewBounds(true);
        back5.setPadding(0,0,0,0);
        back6.setAdjustViewBounds(true);
        back6.setPadding(0,0,0,0);
        back7.setAdjustViewBounds(true);
        back7.setPadding(0,0,0,0);
        back8.setAdjustViewBounds(true);
        back8.setPadding(0,0,0,0);
        back9.setAdjustViewBounds(true);
        back9.setPadding(0,0,0,0);

        //BOTTOM BUTTONS
        leftBtn.setImageResource(R.drawable.shop_icon);
        mainBtn.setImageResource(R.drawable.inventory_icon);
        rightBtn.setImageResource(R.drawable.case_icon);

        leftBtn.setAdjustViewBounds(true);
        leftBtn.setPadding(0,0,0,0);

        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);

        rightBtn.setAdjustViewBounds(true);
        rightBtn.setPadding(0,0,0,0);

        //TEXT SETTINGS
        val1.setTextColor(Color.WHITE);
        val2.setTextColor(Color.WHITE);
        val3.setTextColor(Color.WHITE);
        val4.setTextColor(Color.WHITE);
        val5.setTextColor(Color.WHITE);
        val6.setTextColor(Color.WHITE);
        val7.setTextColor(Color.WHITE);
        val8.setTextColor(Color.WHITE);
        val9.setTextColor(Color.WHITE);
    }
    void updateDisplay(){
        val1.setText("" + v1);
        val2.setText("" + v2);
        val3.setText("" + v3);
        val4.setText("" + v4);
        val5.setText("" + v5);
        val6.setText("" + v6);
        val7.setText("" + v7);
        val8.setText("" + v8);
        val9.setText("" + v9);
    }
    
    void loadData(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        v1 = load.getInt("val1", 0);
        v2 = load.getInt("val2", 2);
        v3 = load.getInt("val3", 0);
        v4 = load.getInt("val4", 0);
        v5 = load.getInt("val5", 5);
        v6 = load.getInt("val6", 0);
        v7 = load.getInt("val7", 0);
        v8 = load.getInt("val8", 1);
        v9 = load.getInt("val9", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
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

    boolean hasValue(int Case){
        boolean hasValue = false;
        switch (Case){
            case 1:
                if(v1 > 0){
                    hasValue=true;
                }
            break;
            case 2:
                if(v2 > 0){
                    hasValue=true;
                }
                break;
            case 3:
                if(v3 > 0){
                    hasValue=true;
                }
                break;
            case 4:
                if(v4 > 0){
                    hasValue=true;
                }
                break;
            case 5:
                if(v5 > 0){
                    hasValue=true;
                }
                break;
            case 6:
                if(v6 > 0){
                    hasValue=true;
                }
                break;
            case 7:
                if(v7 > 0){
                    hasValue=true;
                }
                break;
            case 8:
                if(v8 > 0){
                    hasValue=true;
                }
                break;
            case 9:
                if(v9 > 0){
                    hasValue=true;
                }
                break;
        }
        return hasValue;
    }
    void openCase(Boolean hasValue, int Case){
        if (!hasValue){
            //DENY ACTION
        }else{
           switch (Case){
               case 1:
                   selected = 1;
               break;
               case 2:
                   selected = 2;
                   break;
               case 3:
                   selected = 3;
                   break;
               case 4:
                   selected = 4;
                   break;
               case 5:
                   selected = 5;
                   break;
               case 6:
                   selected = 6;
                   break;
               case 7:
                   selected = 7;
                   break;
               case 8:
                   selected = 8;
                   break;
               case 9:
                   selected = 9;
                   break;
           }
            savedata();
            Intent intent = new Intent(Case.this, CaseCheck.class);
            intent.putExtra("selected", selected);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_case);

        case1 = (ImageButton)findViewById(R.id.case1);
        case2 = (ImageButton)findViewById(R.id.case2);
        case3 = (ImageButton)findViewById(R.id.case3);
        case4 = (ImageButton)findViewById(R.id.case4);
        case5 = (ImageButton)findViewById(R.id.case5);
        case6 = (ImageButton)findViewById(R.id.case6);
        case7 = (ImageButton)findViewById(R.id.case7);
        case8 = (ImageButton)findViewById(R.id.case8);
        case9 = (ImageButton)findViewById(R.id.case9);

        leftBtn = (ImageButton)findViewById(R.id.leftBtn);
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        rightBtn = (ImageButton)findViewById(R.id.rightBtn);

        title1 = (ImageView)findViewById(R.id.title1);
        title2 = (ImageView)findViewById(R.id.title2);
        title3 = (ImageView)findViewById(R.id.title3);

        back1 = (ImageView)findViewById(R.id.back1);
        back2 = (ImageView)findViewById(R.id.back2);
        back3 = (ImageView)findViewById(R.id.back3);
        back4 = (ImageView)findViewById(R.id.back4);
        back5 = (ImageView)findViewById(R.id.back5);
        back6 = (ImageView)findViewById(R.id.back6);
        back7 = (ImageView)findViewById(R.id.back7);
        back8 = (ImageView)findViewById(R.id.back8);
        back9 = (ImageView)findViewById(R.id.back9);

        val1 = (TextView) findViewById(R.id.val1);
        val2 = (TextView) findViewById(R.id.val2);
        val3 = (TextView) findViewById(R.id.val3);
        val4 = (TextView) findViewById(R.id.val4);
        val5 = (TextView) findViewById(R.id.val5);
        val6 = (TextView) findViewById(R.id.val6);
        val7 = (TextView) findViewById(R.id.val7);
        val8 = (TextView) findViewById(R.id.val8);
        val9 = (TextView) findViewById(R.id.val9);

        loadData();
        updateDisplay();
        setGUI();


        case1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(1),1);
            }
        });
        case2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(2),2);
            }
        });
        case3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(3),3);
            }
        });
        case4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(4),4);
            }
        });
        case5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(5),5);
            }
        });
        case6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(6),6);
            }
        });
        case7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(7),7);
            }
        });
        case8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(8),8);
            }
        });
        case9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCase(hasValue(9),9);
            }
        });
    }
}
