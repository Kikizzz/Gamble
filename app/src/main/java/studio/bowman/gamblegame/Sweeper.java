package studio.bowman.gamblegame;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Sweeper extends AppCompatActivity {

    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25;

    void setGUI(){

        ViewGroup rootView = (ViewGroup) getWindow().getDecorView().getRootView();
        int children = rootView.getChildCount();
        for (int i = 0; i < children; i++) {
            View view = rootView.getChildAt(i);
            if (view instanceof ImageButton) {
                ((ImageButton) view).setImageResource(R.drawable.minus);
                ((ImageButton) view).setAdjustViewBounds(true);
                ((ImageButton) view).setPadding(21,0,0,0);
            }
        }

        btn1.setImageResource(R.drawable.plus);
        btn2.setImageResource(R.drawable.plus);
        btn3.setImageResource(R.drawable.plus);
        btn4.setImageResource(R.drawable.plus);
        btn5.setImageResource(R.drawable.plus);
        btn6.setImageResource(R.drawable.plus);
        btn7.setImageResource(R.drawable.plus);
        btn8.setImageResource(R.drawable.plus);
        btn9.setImageResource(R.drawable.plus);
        btn10.setImageResource(R.drawable.plus);
        btn11.setImageResource(R.drawable.plus);
        btn12.setImageResource(R.drawable.plus);
        btn13.setImageResource(R.drawable.plus);
        btn14.setImageResource(R.drawable.plus);
        btn15.setImageResource(R.drawable.plus);
        btn16.setImageResource(R.drawable.plus);
        btn17.setImageResource(R.drawable.plus);
        btn18.setImageResource(R.drawable.plus);
        btn19.setImageResource(R.drawable.plus);
        btn20.setImageResource(R.drawable.plus);
        btn21.setImageResource(R.drawable.plus);
        btn22.setImageResource(R.drawable.plus);
        btn23.setImageResource(R.drawable.plus);
        btn24.setImageResource(R.drawable.plus);
        btn25.setImageResource(R.drawable.plus);

        btn1.setAdjustViewBounds(true);
        btn1.setPadding(0,0,0,0);
        btn2.setAdjustViewBounds(true);
        btn2.setPadding(0,0,0,0);
        btn3.setAdjustViewBounds(true);
        btn3.setPadding(0,0,0,0);
        btn4.setAdjustViewBounds(true);
        btn4.setPadding(0,0,0,0);
        btn5.setAdjustViewBounds(true);
        btn5.setPadding(0,0,0,0);
        btn6.setAdjustViewBounds(true);
        btn6.setPadding(0,0,0,0);
        btn7.setAdjustViewBounds(true);
        btn7.setPadding(0,0,0,0);
        btn8.setAdjustViewBounds(true);
        btn8.setPadding(0,0,0,0);
        btn9.setAdjustViewBounds(true);
        btn9.setPadding(0,0,0,0);
        btn10.setAdjustViewBounds(true);
        btn10.setPadding(0,0,0,0);
        btn11.setAdjustViewBounds(true);
        btn11.setPadding(0,0,0,0);
        btn12.setAdjustViewBounds(true);
        btn12.setPadding(0,0,0,0);
        btn13.setAdjustViewBounds(true);
        btn13.setPadding(0,0,0,0);
        btn14.setAdjustViewBounds(true);
        btn14.setPadding(0,0,0,0);
        btn15.setAdjustViewBounds(true);
        btn15.setPadding(0,0,0,0);
        btn16.setAdjustViewBounds(true);
        btn16.setPadding(0,0,0,0);
        btn17.setAdjustViewBounds(true);
        btn17.setPadding(0,0,0,0);
        btn18.setAdjustViewBounds(true);
        btn18.setPadding(0,0,0,0);
        btn19.setAdjustViewBounds(true);
        btn19.setPadding(0,0,0,0);
        btn20.setAdjustViewBounds(true);
        btn20.setPadding(0,0,0,0);
        btn21.setAdjustViewBounds(true);
        btn21.setPadding(0,0,0,0);
        btn22.setAdjustViewBounds(true);
        btn22.setPadding(0,0,0,0);
        btn23.setAdjustViewBounds(true);
        btn23.setPadding(0,0,0,0);
        btn24.setAdjustViewBounds(true);
        btn24.setPadding(0,0,0,0);
        btn25.setAdjustViewBounds(true);
        btn25.setPadding(0,0,0,0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sweeper);

        btn1 = (ImageButton)findViewById(R.id.btn1);
        btn2 = (ImageButton)findViewById(R.id.btn2);
        btn3 = (ImageButton)findViewById(R.id.btn3);
        btn4 = (ImageButton)findViewById(R.id.btn4);
        btn5 = (ImageButton)findViewById(R.id.btn5);
        btn6 = (ImageButton)findViewById(R.id.btn6);
        btn7 = (ImageButton)findViewById(R.id.btn7);
        btn8 = (ImageButton)findViewById(R.id.btn8);
        btn9 = (ImageButton)findViewById(R.id.btn9);
        btn10 = (ImageButton)findViewById(R.id.btn10);
        btn11 = (ImageButton)findViewById(R.id.btn11);
        btn12 = (ImageButton)findViewById(R.id.btn12);
        btn13 = (ImageButton)findViewById(R.id.btn13);
        btn14 = (ImageButton)findViewById(R.id.btn14);
        btn15 = (ImageButton)findViewById(R.id.btn15);
        btn16 = (ImageButton)findViewById(R.id.btn16);
        btn17 = (ImageButton)findViewById(R.id.btn17);
        btn18 = (ImageButton)findViewById(R.id.btn18);
        btn19 = (ImageButton)findViewById(R.id.btn19);
        btn20 = (ImageButton)findViewById(R.id.btn20);
        btn21 = (ImageButton)findViewById(R.id.btn21);
        btn22 = (ImageButton)findViewById(R.id.btn22);
        btn23 = (ImageButton)findViewById(R.id.btn23);
        btn24 = (ImageButton)findViewById(R.id.btn24);
        btn25 = (ImageButton)findViewById(R.id.btn25);

        setGUI();
    }
}
