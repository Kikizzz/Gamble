package studio.bowman.gamblegame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Case extends AppCompatActivity {

    ImageButton leftBtn, mainBtn,rightBtn;
    ImageButton case1, case2, case3, case4, case5, case6, case7, case8, case9;
    ImageView title1, title2,title3;

    void setDisplay(){
        // TITLE BARS
            title1.setImageResource(R.drawable.title_img);
            title2.setImageResource(R.drawable.title_img);
            title3.setImageResource(R.drawable.title_img);

            title1.setAdjustViewBounds(true);
            title1.setPadding(0,0,0,0);
            title2.setAdjustViewBounds(true);
            title2.setPadding(0,0,0,0);
            title3.setAdjustViewBounds(true);
            title3.setPadding(0,0,0,0);

        // CASES
        case1.setImageResource(R.drawable.case_1);
//        case2.setImageResource(R.drawable.case_2);
//        case3.setImageResource(R.drawable.case_3);
//        case4.setImageResource(R.drawable.case_4);
//        case5.setImageResource(R.drawable.case_5);
//        case6.setImageResource(R.drawable.case_6);
        case7.setImageResource(R.drawable.case_7);
        case8.setImageResource(R.drawable.case_8);
        case9.setImageResource(R.drawable.case_9);

        case2.setImageResource(R.drawable.case_7);
        case3.setImageResource(R.drawable.case_7);
        case4.setImageResource(R.drawable.case_7);
        case5.setImageResource(R.drawable.case_7);
        case6.setImageResource(R.drawable.case_7);

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

        //BOTTOM BUTTONS
        leftBtn.setImageResource(R.drawable.coinflip_icon);
        mainBtn.setImageResource(R.drawable.crash_icon);
        rightBtn.setImageResource(R.drawable.robbery_icon);

        leftBtn.setAdjustViewBounds(true);
        leftBtn.setPadding(0,0,0,0);

        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);

        rightBtn.setAdjustViewBounds(true);
        rightBtn.setPadding(0,0,0,0);

        //TEXT SETTINGS
//        display.setTextColor(Color.WHITE);
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

        title1= (ImageView)findViewById(R.id.title1);
        title2= (ImageView)findViewById(R.id.title2);
        title3= (ImageView)findViewById(R.id.title3);

        setDisplay();
    }
}
