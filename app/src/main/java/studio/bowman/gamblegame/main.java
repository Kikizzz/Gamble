package studio.bowman.gamblegame;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class main extends AppCompatActivity {

    ImageButton play, highscores, settings, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (ImageButton)findViewById(R.id.play);
        highscores = (ImageButton)findViewById(R.id.highscores);
        settings = (ImageButton)findViewById(R.id.settings);
        exit = (ImageButton)findViewById(R.id.exit);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent myIntent = new Intent (main.this, game1.class);
            startActivity(myIntent);
            }
        });

        highscores.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(main.this, Main2Activity.class);
//                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(main.this, settings.class);
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
