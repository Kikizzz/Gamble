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

    void GUI(){
        play.setImageResource(R.drawable.stats_back);
        settings.setImageResource(R.drawable.stats_back);
        highscores.setImageResource(R.drawable.stats_back);
        exit.setImageResource(R.drawable.stats_back);

        play.setAdjustViewBounds(true);
        play.setPadding(5,5,5,5);
        settings.setAdjustViewBounds(true);
        settings.setPadding(5,5,5,5);
        highscores.setAdjustViewBounds(true);
        highscores.setPadding(5,5,5,5);
        exit.setAdjustViewBounds(true);
        exit.setPadding(5,5,5,5);
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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        play = (ImageButton)findViewById(R.id.play);
        highscores = (ImageButton)findViewById(R.id.highscores);
        settings = (ImageButton)findViewById(R.id.settings);
        exit = (ImageButton)findViewById(R.id.exit);

        GUI();

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent myIntent = new Intent (Main.this, Crash.class);
            startActivity(myIntent);
            }
        });

        highscores.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(Main.this, DropScreen.class);
//               startActivity(intent);

                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Royal Crash");
                    String sAux = "\nElvis lohs\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=Orion.Soft \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "Sharing Options"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, Case.class);
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
