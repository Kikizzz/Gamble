package studio.bowman.gamblegame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Inventory extends AppCompatActivity {

    ImageButton leftBtn, mainBtn, rightBtn;

    private void setDisplay(){
            leftBtn.setImageResource(R.drawable.inventory_icon);
            mainBtn.setImageResource(R.drawable.shop_icon_large);
            rightBtn.setImageResource(R.drawable.cases_icon);

            // l t r b
            leftBtn.setAdjustViewBounds(true);
            leftBtn.setPadding(0,0,0,0);

            mainBtn.setAdjustViewBounds(true);
            mainBtn.setPadding(0,0,0,0);

            rightBtn.setAdjustViewBounds(true);
            rightBtn.setPadding(0,0,0,0);
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

        leftBtn = (ImageButton)findViewById(R.id.leftBtn);
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        rightBtn = (ImageButton)findViewById(R.id.rightBtn);

        setDisplay();

    }
}
