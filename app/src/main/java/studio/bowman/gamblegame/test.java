package studio.bowman.gamblegame;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ConstraintLayout placeHolder = (ConstraintLayout) findViewById(R.id.test2);
        getLayoutInflater().inflate(R.layout.activity_test, placeHolder);

    }
}
