package studio.bowman.gamblegame;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Sweeper extends AppCompatActivity {

    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24,img25;
    ImageButton play;
    TextView debug, balance, bet, profit;

    boolean livegame, cashout;
    boolean b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25;
    boolean firstturn;

    int buttonclicked;
    int keys, rubies;
    int playmode, minecount, dividenumber;
    int betval, profitval, balanceval;

    //VISUAL UTILS
    void setGUI(){

        btn1.setImageResource(R.drawable.go_active_royal);
        btn2.setImageResource(R.drawable.go_active_royal);
        btn3.setImageResource(R.drawable.go_active_royal);
        btn4.setImageResource(R.drawable.go_active_royal);
        btn5.setImageResource(R.drawable.go_active_royal);
        btn6.setImageResource(R.drawable.go_active_royal);
        btn7.setImageResource(R.drawable.go_active_royal);
        btn8.setImageResource(R.drawable.go_active_royal);
        btn9.setImageResource(R.drawable.go_active_royal);
        btn10.setImageResource(R.drawable.go_active_royal);
        btn11.setImageResource(R.drawable.go_active_royal);
        btn12.setImageResource(R.drawable.go_active_royal);
        btn13.setImageResource(R.drawable.go_active_royal);
        btn14.setImageResource(R.drawable.go_active_royal);
        btn15.setImageResource(R.drawable.go_active_royal);
        btn16.setImageResource(R.drawable.go_active_royal);
        btn17.setImageResource(R.drawable.go_active_royal);
        btn18.setImageResource(R.drawable.go_active_royal);
        btn19.setImageResource(R.drawable.go_active_royal);
        btn20.setImageResource(R.drawable.go_active_royal);
        btn21.setImageResource(R.drawable.go_active_royal);
        btn22.setImageResource(R.drawable.go_active_royal);
        btn23.setImageResource(R.drawable.go_active_royal);
        btn24.setImageResource(R.drawable.go_active_royal);
        btn25.setImageResource(R.drawable.go_active_royal);

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


        img1.setImageResource(R.drawable.plus);
        img2.setImageResource(R.drawable.plus);
        img3.setImageResource(R.drawable.plus);
        img4.setImageResource(R.drawable.plus);
        img5.setImageResource(R.drawable.plus);
        img6.setImageResource(R.drawable.plus);
        img7.setImageResource(R.drawable.plus);
        img8.setImageResource(R.drawable.plus);
        img9.setImageResource(R.drawable.plus);
        img10.setImageResource(R.drawable.plus);
        img11.setImageResource(R.drawable.plus);
        img12.setImageResource(R.drawable.plus);
        img13.setImageResource(R.drawable.plus);
        img14.setImageResource(R.drawable.plus);
        img15.setImageResource(R.drawable.plus);
        img16.setImageResource(R.drawable.plus);
        img17.setImageResource(R.drawable.plus);
        img18.setImageResource(R.drawable.plus);
        img19.setImageResource(R.drawable.plus);
        img20.setImageResource(R.drawable.plus);
        img21.setImageResource(R.drawable.plus);
        img22.setImageResource(R.drawable.plus);
        img23.setImageResource(R.drawable.plus);
        img24.setImageResource(R.drawable.plus);
        img25.setImageResource(R.drawable.plus);

        img1.setAdjustViewBounds(true);
        img1.setPadding(0,0,0,0);
        img2.setAdjustViewBounds(true);
        img2.setPadding(0,0,0,0);
        img3.setAdjustViewBounds(true);
        img3.setPadding(0,0,0,0);
        img4.setAdjustViewBounds(true);
        img4.setPadding(0,0,0,0);
        img5.setAdjustViewBounds(true);
        img5.setPadding(0,0,0,0);
        img6.setAdjustViewBounds(true);
        img6.setPadding(0,0,0,0);
        img7.setAdjustViewBounds(true);
        img7.setPadding(0,0,0,0);
        img8.setAdjustViewBounds(true);
        img8.setPadding(0,0,0,0);
        img9.setAdjustViewBounds(true);
        img9.setPadding(0,0,0,0);
        img10.setAdjustViewBounds(true);
        img10.setPadding(0,0,0,0);
        img11.setAdjustViewBounds(true);
        img11.setPadding(0,0,0,0);
        img12.setAdjustViewBounds(true);
        img12.setPadding(0,0,0,0);
        img13.setAdjustViewBounds(true);
        img13.setPadding(0,0,0,0);
        img14.setAdjustViewBounds(true);
        img14.setPadding(0,0,0,0);
        img15.setAdjustViewBounds(true);
        img15.setPadding(0,0,0,0);
        img16.setAdjustViewBounds(true);
        img16.setPadding(0,0,0,0);
        img17.setAdjustViewBounds(true);
        img17.setPadding(0,0,0,0);
        img18.setAdjustViewBounds(true);
        img18.setPadding(0,0,0,0);
        img19.setAdjustViewBounds(true);
        img19.setPadding(0,0,0,0);
        img20.setAdjustViewBounds(true);
        img20.setPadding(0,0,0,0);
        img21.setAdjustViewBounds(true);
        img21.setPadding(0,0,0,0);
        img22.setAdjustViewBounds(true);
        img22.setPadding(0,0,0,0);
        img23.setAdjustViewBounds(true);
        img23.setPadding(0,0,0,0);
        img24.setAdjustViewBounds(true);
        img24.setPadding(0,0,0,0);
        img25.setAdjustViewBounds(true);
        img25.setPadding(0,0,0,0);
    }
    void updateDisplay(){
        debug.setText("" + livegame);
        balance.setText("" + balanceval);
        bet.setText("" + betval);
        profit.setText("" + profitval);
    }

    //UTILS
    void field(String enable){
        switch(enable){
            case "enable":
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                btn10.setEnabled(true);
                btn11.setEnabled(true);
                btn12.setEnabled(true);
                btn13.setEnabled(true);
                btn14.setEnabled(true);
                btn15.setEnabled(true);
                btn16.setEnabled(true);
                btn17.setEnabled(true);
                btn18.setEnabled(true);
                btn19.setEnabled(true);
                btn20.setEnabled(true);
                btn21.setEnabled(true);
                btn22.setEnabled(true);
                btn23.setEnabled(true);
                btn24.setEnabled(true);
                btn25.setEnabled(true);
                break;
            case "disable":
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btn10.setEnabled(false);
                btn11.setEnabled(false);
                btn12.setEnabled(false);
                btn13.setEnabled(false);
                btn14.setEnabled(false);
                btn15.setEnabled(false);
                btn16.setEnabled(false);
                btn17.setEnabled(false);
                btn18.setEnabled(false);
                btn19.setEnabled(false);
                btn20.setEnabled(false);
                btn21.setEnabled(false);
                btn22.setEnabled(false);
                btn23.setEnabled(false);
                btn24.setEnabled(false);
                btn25.setEnabled(false);
                break;
        }
    }
    void calculateProfit(){
        profitval += betval / dividenumber;
        dividenumber -= dividenumber/10;
    }
    void createMines(){
        int placed = 0;

        Random random = new Random();

        while(placed<minecount){
            int r = random.nextInt(25)+1;
            switch(r){
                case 1:
                    if (!b1)b1=true;
                    btn1.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 2:
                    if (!b2)b2=true;
                    btn2.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 3:
                    if (!b3)b3=true;
                    btn3.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 4:
                    if (!b4)b4=true;
                    btn4.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 5:
                    if (!b5)b5=true;
                    btn5.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 6:
                    if (!b6)b6=true;
                    btn6.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 7:
                    if (!b7)b7=true;
                    btn7.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 8:
                    if (!b8)b8=true;
                    btn8.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 9:
                    if (!b9)b9=true;
                    btn9.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 10:
                    if (!b10)b10=true;
                    btn10.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 11:
                    if (!b11)b11=true;
                    btn11.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 12:
                    if (!b12)b12=true;
                    btn12.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 13:
                    if (!b13)b13=true;
                    btn13.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 14:
                    if (!b14)b14=true;
                    btn14.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 15:
                    if (!b15)b15=true;
                    btn15.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 16:
                    if (!b16)b16=true;
                    btn16.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 17:
                    if (!b17)b17=true;
                    btn17.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 18:
                    if (!b18)b18=true;
                    btn18.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 19:
                    if (!b19)b19=true;
                    btn19.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 20:
                    if (!b20)b20=true;
                    btn20.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 21:
                    if (!b21)b21=true;
                    btn21.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 22:
                    if (!b22)b22=true;
                    btn22.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 23:
                    if (!b23)b23=true;
                    btn23.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 24:
                    if (!b24)b24=true;
                    btn24.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
                case 25:
                    if (!b25)b25=true;
                    btn25.setImageResource(R.drawable.mine_dead);
                    placed+=1;
                break;
            }
        }
    }
    void clearMines(){
        b1=b2=b3=b4=b5=b6=b7=b8=b9=b10=b11=b12=b13=b14=b15=b16=b17=b18=b19=b20=b21=b22=b23=b24=b25=false;
        btn1.setImageResource(R.drawable.go_active_royal);
        btn2.setImageResource(R.drawable.go_active_royal);
        btn3.setImageResource(R.drawable.go_active_royal);
        btn4.setImageResource(R.drawable.go_active_royal);
        btn5.setImageResource(R.drawable.go_active_royal);
        btn6.setImageResource(R.drawable.go_active_royal);
        btn7.setImageResource(R.drawable.go_active_royal);
        btn8.setImageResource(R.drawable.go_active_royal);
        btn9.setImageResource(R.drawable.go_active_royal);
        btn10.setImageResource(R.drawable.go_active_royal);
        btn11.setImageResource(R.drawable.go_active_royal);
        btn12.setImageResource(R.drawable.go_active_royal);
        btn13.setImageResource(R.drawable.go_active_royal);
        btn14.setImageResource(R.drawable.go_active_royal);
        btn15.setImageResource(R.drawable.go_active_royal);
        btn16.setImageResource(R.drawable.go_active_royal);
        btn16.setImageResource(R.drawable.go_active_royal);
        btn17.setImageResource(R.drawable.go_active_royal);
        btn18.setImageResource(R.drawable.go_active_royal);
        btn19.setImageResource(R.drawable.go_active_royal);
        btn20.setImageResource(R.drawable.go_active_royal);
        btn21.setImageResource(R.drawable.go_active_royal);
        btn22.setImageResource(R.drawable.go_active_royal);
        btn23.setImageResource(R.drawable.go_active_royal);
        btn24.setImageResource(R.drawable.go_active_royal);
        btn25.setImageResource(R.drawable.go_active_royal);
    }

    void boom() {
        endGame();
    }
    void getreward() {
        calculateProfit();
        switch(buttonclicked){
            case 1:
                btn1.setImageResource(R.drawable.mine_ruby);
                break;
            case 2:
                btn2.setImageResource(R.drawable.mine_ruby);
                break;
            case 3:
                btn3.setImageResource(R.drawable.mine_ruby);
                break;
            case 4:
                btn4.setImageResource(R.drawable.mine_ruby);
                break;
            case 5:
                btn5.setImageResource(R.drawable.mine_ruby);
                break;
            case 6:
                btn6.setImageResource(R.drawable.mine_ruby);
                break;
            case 7:
                btn7.setImageResource(R.drawable.mine_ruby);
                break;
            case 8:
                btn8.setImageResource(R.drawable.mine_ruby);
                break;
            case 9:
                btn9.setImageResource(R.drawable.mine_ruby);
                break;
            case 10:
                btn10.setImageResource(R.drawable.mine_ruby);
                break;
            case 11:
                btn11.setImageResource(R.drawable.mine_ruby);
                break;
            case 12:
                btn12.setImageResource(R.drawable.mine_ruby);
                break;
            case 13:
                btn13.setImageResource(R.drawable.mine_ruby);
                break;
            case 14:
                btn14.setImageResource(R.drawable.mine_ruby);
                break;
            case 15:
                btn15.setImageResource(R.drawable.mine_ruby);
                break;
            case 16:
                btn16.setImageResource(R.drawable.mine_ruby);
                break;
            case 17:
                btn17.setImageResource(R.drawable.mine_ruby);
                break;
            case 18:
                btn18.setImageResource(R.drawable.mine_ruby);
                break;
            case 19:
                btn19.setImageResource(R.drawable.mine_ruby);
                break;
            case 20:
                btn20.setImageResource(R.drawable.mine_ruby);
                break;
            case 21:
                btn21.setImageResource(R.drawable.mine_ruby);
                break;
            case 22:
                btn22.setImageResource(R.drawable.mine_ruby);
                break;
            case 23:
                btn23.setImageResource(R.drawable.mine_ruby);
                break;
            case 24:
                btn24.setImageResource(R.drawable.mine_ruby);
                break;
            case 25:
                btn25.setImageResource(R.drawable.mine_ruby);
                break;
        }
        Log.d("Profit", " value:" +profitval);
    }

    void buttonclick(){
        if(firstturn){
            firstturn = false;
        }
        switch(buttonclicked){
            //CHECKS IF IT HAS A MINE
            case 1:
                if(b1){boom();}else{getreward();}
                break;
            case 2:
                if(b2){boom();}else{getreward();}
                break;
            case 3:
                if(b3){boom();}else{getreward();}
                break;
            case 4:
                if(b4){boom();}else{getreward();}
                break;
            case 5:
                if(b5){boom();}else{getreward();}
                break;
            case 6:
                if(b6){boom();}else{getreward();}
                break;
            case 7:
                if(b7){boom();}else{getreward();}
                break;
            case 8:
                if(b8){boom();}else{getreward();}
                break;
            case 9:
                if(b9){boom();}else{getreward();}
                break;
            case 10:
                if(b10){boom();}else{getreward();}
                break;
            case 11:
                if(b11){boom();}else{getreward();}
                break;
            case 12:
                if(b12){boom();}else{getreward();}
                break;
            case 13:
                if(b13){boom();}else{getreward();}
                break;
            case 14:
                if(b14){boom();}else{getreward();}
                break;
            case 15:
                if(b15){boom();}else{getreward();}
                break;
            case 16:
                if(b16){boom();}else{getreward();}
                break;
            case 17:
                if(b17){boom();}else{getreward();}
                break;
            case 18:
                if(b18){boom();}else{getreward();}
                break;
            case 19:
                if(b19){boom();}else{getreward();}
                break;
            case 20:
                if(b20){boom();}else{getreward();}
                break;
            case 21:
                if(b21){boom();}else{getreward();}
                break;
            case 22:
                if(b22){boom();}else{getreward();}
                break;
            case 23:
                if(b23){boom();}else{getreward();}
                break;
            case 24:
                if(b24){boom();}else{getreward();}
                break;
            case 25:
                if(b25){boom();}else{getreward();}
                break;
        }
        }

    //DATA MANAGEMENT
    void loadData(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        rubies = load.getInt("rubies", 0);
        balanceval = load.getInt("balance", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("rubies", rubies);
        save.putInt("balance", balanceval);

        save.apply();
        save.commit();
    }

    //START END METHODS
    void startGame(){
        firstturn = true;
        profitval = 0;
        balanceval-=betval;
        field("enable");
        livegame = true;
        updateDisplay();
        //CHANGE DIVIDENUMBER
        switch(playmode){
            case 1:
                minecount = 3;
                dividenumber = 1;
            break;
            case 2:
                minecount = 5;
                dividenumber = 1;
            break;
            case 3:
                minecount = 24;
                dividenumber = 1;
            break;
        }
    createMines();
     savedata();
    }
    void endGame(){
        if(cashout){
            balanceval += profitval;
        }
        livegame = false;
        cashout = false;

        field("disable");
        clearMines();
        updateDisplay();
        savedata();
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

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
        img3 = (ImageView)findViewById(R.id.img3);
        img4 = (ImageView)findViewById(R.id.img4);
        img5 = (ImageView)findViewById(R.id.img5);
        img6 = (ImageView)findViewById(R.id.img6);
        img7 = (ImageView)findViewById(R.id.img7);
        img8 = (ImageView)findViewById(R.id.img8);
        img9 = (ImageView)findViewById(R.id.img9);
        img10 = (ImageView)findViewById(R.id.img10);
        img11 = (ImageView)findViewById(R.id.img11);
        img12 = (ImageView)findViewById(R.id.img12);
        img13 = (ImageView)findViewById(R.id.img13);
        img14 = (ImageView)findViewById(R.id.img14);
        img15 = (ImageView)findViewById(R.id.img15);
        img16 = (ImageView)findViewById(R.id.img16);
        img17 = (ImageView)findViewById(R.id.img17);
        img18 = (ImageView)findViewById(R.id.img18);
        img19 = (ImageView)findViewById(R.id.img19);
        img20 = (ImageView)findViewById(R.id.img20);
        img21 = (ImageView)findViewById(R.id.img21);
        img22 = (ImageView)findViewById(R.id.img22);
        img23 = (ImageView)findViewById(R.id.img23);
        img24 = (ImageView)findViewById(R.id.img24);
        img25 = (ImageView)findViewById(R.id.img25);

        play = (ImageButton)findViewById(R.id.play);
        debug = (TextView)findViewById(R.id.debug);
        balance  = (TextView)findViewById(R.id.balance);
        bet = (TextView)findViewById(R.id.bet);
        profit = (TextView)findViewById(R.id.profit);

        dividenumber = 10;
        betval = 5;
        playmode = 2;

        field("disable");
        loadData();
        setGUI();
        updateDisplay();

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!livegame){
                    startGame();
                }else{
//                    if(!firstturn) {
                        cashout = true;
                        endGame();
//                    }
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 1;
                buttonclick();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 2;
                buttonclick();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 3;
                buttonclick();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 4;
                buttonclick();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 5;
                buttonclick();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 6;
                buttonclick();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 7;
                buttonclick();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 8;
                buttonclick();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked =9;
                buttonclick();
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 10;
                buttonclick();
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 11;
                buttonclick();
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 12;
                buttonclick();
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 13;
                buttonclick();
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 14;
                buttonclick();
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 15;
                buttonclick();
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 16;
                buttonclick();
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 17;
                buttonclick();
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 18;
                buttonclick();
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 19;
                buttonclick();
            }
        });btn20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 20;
                buttonclick();
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 21;
                buttonclick();
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 22;
                buttonclick();
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 23;
                buttonclick();
            }
        });
        btn24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 24;
                buttonclick();
            }
        });
        btn25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonclicked = 25;
                buttonclick();
            }
        });
    }
}
