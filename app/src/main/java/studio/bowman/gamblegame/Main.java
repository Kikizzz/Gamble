package studio.bowman.gamblegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Main extends AppCompatActivity {

    ImageButton play, highscores, settings, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        play = (ImageButton)findViewById(R.id.play);
        highscores = (ImageButton)findViewById(R.id.highscores);
        settings = (ImageButton)findViewById(R.id.settings);
        exit = (ImageButton)findViewById(R.id.exit);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent myIntent = new Intent (Main.this, Game.class);
            startActivity(myIntent);
            }
        });

        highscores.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Inventory.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, CrashSurfaceView.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
