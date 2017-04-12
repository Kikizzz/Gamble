package studio.bowman.gamblegame;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Sweeper extends AppCompatActivity {

    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24,img25;
    ImageView maintitle, bettitle;
    ImageButton play;
    ImageButton bet1, bet2, bet3;
    ImageButton leftBtn, mainBtn, rightBtn;

    boolean livegame, cashout;
    boolean b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25;
    boolean firstturn;
    
    int r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25;
    int buttonclicked;
    int keys, rubyrings, emeraldrings, royalrings;
    int gotrubyrings, gotemeraldrings, gotroyalrings;
    static int minecount = 7, dividenumber;
    int betval, profitval, balanceval;

    //VISUAL UTILS
    void setGUI(){
        leftBtn.setImageResource(R.drawable.reaction_icon);
        mainBtn.setImageResource(R.drawable.crash_icon);
        rightBtn.setImageResource(R.drawable.robbery_icon_active);

        leftBtn.setAdjustViewBounds(true);
        leftBtn.setPadding(0,0,0,0);
        mainBtn.setAdjustViewBounds(true);
        mainBtn.setPadding(0,0,0,0);
        rightBtn.setAdjustViewBounds(true);
        rightBtn.setPadding(0,0,0,0);

        play.setImageResource(R.drawable.robbery_icon_active);
        bet1.setImageResource(R.drawable.robbery_icon_active);
        bet2.setImageResource(R.drawable.robbery_icon_active);
        bet3.setImageResource(R.drawable.robbery_icon_active);

        play.setAdjustViewBounds(true);
        play.setPadding(0,0,0,0);
        bet1.setAdjustViewBounds(true);
        bet1.setPadding(0,0,0,0);
        bet2.setAdjustViewBounds(true);
        bet2.setPadding(0,0,0,0);
        bet3.setAdjustViewBounds(true);
        bet3.setPadding(0,0,0,0);

        btn1.setImageResource(R.drawable.mine_default);
        btn2.setImageResource(R.drawable.mine_default);
        btn3.setImageResource(R.drawable.mine_default);
        btn4.setImageResource(R.drawable.mine_default);
        btn5.setImageResource(R.drawable.mine_default);
        btn6.setImageResource(R.drawable.mine_default);
        btn7.setImageResource(R.drawable.mine_default);
        btn8.setImageResource(R.drawable.mine_default);
        btn9.setImageResource(R.drawable.mine_default);
        btn10.setImageResource(R.drawable.mine_default);
        btn11.setImageResource(R.drawable.mine_default);
        btn12.setImageResource(R.drawable.mine_default);
        btn13.setImageResource(R.drawable.mine_default);
        btn14.setImageResource(R.drawable.mine_default);
        btn15.setImageResource(R.drawable.mine_default);
        btn16.setImageResource(R.drawable.mine_default);
        btn17.setImageResource(R.drawable.mine_default);
        btn18.setImageResource(R.drawable.mine_default);
        btn19.setImageResource(R.drawable.mine_default);
        btn20.setImageResource(R.drawable.mine_default);
        btn21.setImageResource(R.drawable.mine_default);
        btn22.setImageResource(R.drawable.mine_default);
        btn23.setImageResource(R.drawable.mine_default);
        btn24.setImageResource(R.drawable.mine_default);
        btn25.setImageResource(R.drawable.mine_default);

        img1.setImageResource(R.drawable.mine_default);
        img2.setImageResource(R.drawable.mine_default);
        img3.setImageResource(R.drawable.mine_default);
        img4.setImageResource(R.drawable.mine_default);
        img5.setImageResource(R.drawable.mine_default);
        img6.setImageResource(R.drawable.mine_default);
        img7.setImageResource(R.drawable.mine_default);
        img8.setImageResource(R.drawable.mine_default);
        img9.setImageResource(R.drawable.mine_default);
        img10.setImageResource(R.drawable.mine_default);
        img11.setImageResource(R.drawable.mine_default);
        img12.setImageResource(R.drawable.mine_default);
        img13.setImageResource(R.drawable.mine_default);
        img14.setImageResource(R.drawable.mine_default);
        img15.setImageResource(R.drawable.mine_default);
        img16.setImageResource(R.drawable.mine_default);
        img17.setImageResource(R.drawable.mine_default);
        img18.setImageResource(R.drawable.mine_default);
        img19.setImageResource(R.drawable.mine_default);
        img20.setImageResource(R.drawable.mine_default);
        img21.setImageResource(R.drawable.mine_default);
        img22.setImageResource(R.drawable.mine_default);
        img23.setImageResource(R.drawable.mine_default);
        img24.setImageResource(R.drawable.mine_default);
        img25.setImageResource(R.drawable.mine_default);

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

    int rewardmethod(boolean b, ImageView img){
        Random rewardrandom = new Random();
        int foobar;
        int r = -1;

        if(!b){
            foobar = rewardrandom.nextInt(100)+1;
            if (foobar <= 50){
                r = 0;
                img.setImageResource(R.drawable.mine_blank);
            }
            if (foobar > 50 && foobar <=80){
                r = 1;
                img.setImageResource(R.drawable.mine_ringemerald);
            }
            if (foobar > 80 && foobar<=95){
                r = 2;
                img.setImageResource(R.drawable.mine_ringruby);
            }
            if (foobar > 95){
                r = 3;
                img.setImageResource(R.drawable.mine_ringroyalstone);
            }
        }
        return r;
    }
    void createRewards(){
        r1 = rewardmethod(b1,img1);
        r2 = rewardmethod(b2,img2);
        r3 = rewardmethod(b3,img3);
        r4 = rewardmethod(b4,img4);
        r5 = rewardmethod(b5,img5);
        r6 = rewardmethod(b6,img6);
        r7 = rewardmethod(b7,img7);
        r8 = rewardmethod(b8,img8);
        r9 = rewardmethod(b9,img9);
        r10 = rewardmethod(b10,img10);
        r11 = rewardmethod(b11,img11);
        r12 = rewardmethod(b12,img12);
        r13 = rewardmethod(b13,img13);
        r14 = rewardmethod(b14,img14);
        r15 = rewardmethod(b15,img15);
        r16 = rewardmethod(b16,img16);
        r17 = rewardmethod(b17,img17);
        r18 = rewardmethod(b18,img18);
        r19 = rewardmethod(b19,img19);
        r20 = rewardmethod(b20,img20);
        r21 = rewardmethod(b21,img21);
        r22 = rewardmethod(b22,img22);
        r23 = rewardmethod(b23,img23);
        r24 = rewardmethod(b24,img24);
        r25 = rewardmethod(b25,img25);
    }
    void rewardmethod(ImageView btn, int r){
        btn.setVisibility(View.INVISIBLE);
        switch(r){
            case -1:
                break;
            case 0:
                break;
            case 1:
                gotemeraldrings+=1;
                break;
            case 2:
                gotrubyrings+=1;
                break;
            case 3:
                gotroyalrings+=1;
                break;
        }
    }
    void getreward() {
        switch(buttonclicked){
            case 1:
                rewardmethod(btn1, r1);
                break;
            case 2:
                rewardmethod(btn2, r2);
                break;
            case 3:
                rewardmethod(btn3, r3);
                break;
            case 4:
                rewardmethod(btn4, r4);
                break;
            case 5:
                rewardmethod(btn5, r5);
                break;
            case 6:
                rewardmethod(btn6, r6);
                break;
            case 7:
                rewardmethod(btn7, r7);
                break;
            case 8:
                rewardmethod(btn8, r8);
                break;
            case 9:
                rewardmethod(btn9, r9);
                break;
            case 10:
                rewardmethod(btn10, r10);
                break;
            case 11:
                rewardmethod(btn11, r11);
                break;
            case 12:
                rewardmethod(btn12, r12);
                break;
            case 13:
                rewardmethod(btn13, r13);
                break;
            case 14:
                rewardmethod(btn14, r14);
                break;
            case 15:
                rewardmethod(btn15, r15);
                break;
            case 16:
                rewardmethod(btn16, r16);
                break;
            case 17:
                rewardmethod(btn17, r17);
                break;
            case 18:
                rewardmethod(btn18, r18);
                break;
            case 19:
                rewardmethod(btn19, r19);
                break;
            case 20:
                rewardmethod(btn20, r20);
                break;
            case 21:
                rewardmethod(btn21, r21);
                break;
            case 22:
                rewardmethod(btn22, r22);
                break;
            case 23:
                rewardmethod(btn23, r23);
                break;
            case 24:
                rewardmethod(btn24, r24);
                break;
            case 25:
                rewardmethod(btn25, r25);
                break;
        }
        updateDisplay();
        savedata();
    }

    void createMines(){
        int placed = 0;

        Random random = new Random();

        while(placed<minecount){
            int r = random.nextInt(25)+1;
            switch(r){
                case 1:
                    if (!b1){
                        b1=true;
                        img1.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 2:
                    if (!b2){
                        b2=true;
                        img2.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 3:
                    if (!b3){
                        b3=true;
                        img3.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 4:
                    if (!b4){
                        b4=true;
                        img4.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 5:
                    if (!b5){
                        b5=true;
                        img5.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 6:
                    if (!b6){
                        b6=true;
                        img6.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 7:
                    if (!b7){
                        b7=true;
                        img7.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 8:
                    if (!b8){
                        b8=true;
                        img8.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 9:
                    if (!b9){
                        b9=true;
                        img9.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 10:
                    if (!b10){
                        b10=true;
                        img10.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 11:
                    if (!b11){
                        b11=true;
                        img11.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 12:
                    if (!b12){
                        b12=true;
                        img12.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 13:
                    if (!b13){
                        b13=true;
                        img13.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 14:
                    if (!b14){
                        b14=true;
                        img14.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 15:
                    if (!b15){
                        b15=true;
                        img15.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 16:
                    if (!b16){
                        b16=true;
                        img16.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 17:
                    if (!b17){
                        b17=true;
                        img17.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 18:
                    if (!b18){
                        b18=true;
                        img18.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 19:
                    if (!b19){
                        b19=true;
                        img19.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 20:
                    if (!b20){
                        b20=true;
                        img20.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 21:
                    if (!b21){
                        b21=true;
                        img21.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 22:
                    if (!b22){
                        b22=true;
                        img22.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 23:
                    if (!b23){
                        b23=true;
                        img23.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 24:
                    if (!b24){
                        b24=true;
                        img24.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
                case 25:
                    if (!b25){
                        b25=true;
                        img25.setImageResource(R.drawable.mine_dead);
                        placed+=1;
                    }
                break;
            }
        }
    }
    void clearMines(){
        b1=b2=b3=b4=b5=b6=b7=b8=b9=b10=b11=b12=b13=b14=b15=b16=b17=b18=b19=b20=b21=b22=b23=b24=b25=false;
    }

    void boom() {
        endGame();
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
    void btnVisibility(String visibility){
        switch (visibility){
            case "INVISIBLE":
                btn1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                btn3.setVisibility(View.INVISIBLE);
                btn4.setVisibility(View.INVISIBLE);
                btn5.setVisibility(View.INVISIBLE);
                btn6.setVisibility(View.INVISIBLE);
                btn7.setVisibility(View.INVISIBLE);
                btn8.setVisibility(View.INVISIBLE);
                btn9.setVisibility(View.INVISIBLE);
                btn10.setVisibility(View.INVISIBLE);
                btn11.setVisibility(View.INVISIBLE);
                btn12.setVisibility(View.INVISIBLE);
                btn13.setVisibility(View.INVISIBLE);
                btn14.setVisibility(View.INVISIBLE);
                btn15.setVisibility(View.INVISIBLE);
                btn16.setVisibility(View.INVISIBLE);
                btn17.setVisibility(View.INVISIBLE);
                btn18.setVisibility(View.INVISIBLE);
                btn19.setVisibility(View.INVISIBLE);
                btn20.setVisibility(View.INVISIBLE);
                btn21.setVisibility(View.INVISIBLE);
                btn22.setVisibility(View.INVISIBLE);
                btn23.setVisibility(View.INVISIBLE);
                btn24.setVisibility(View.INVISIBLE);
                btn25.setVisibility(View.INVISIBLE);

                break;
            case "VISIBLE":
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
                btn9.setVisibility(View.VISIBLE);
                btn10.setVisibility(View.VISIBLE);
                btn11.setVisibility(View.VISIBLE);
                btn12.setVisibility(View.VISIBLE);
                btn13.setVisibility(View.VISIBLE);
                btn14.setVisibility(View.VISIBLE);
                btn15.setVisibility(View.VISIBLE);
                btn16.setVisibility(View.VISIBLE);
                btn17.setVisibility(View.VISIBLE);
                btn18.setVisibility(View.VISIBLE);
                btn19.setVisibility(View.VISIBLE);
                btn20.setVisibility(View.VISIBLE);
                btn21.setVisibility(View.VISIBLE);
                btn22.setVisibility(View.VISIBLE);
                btn23.setVisibility(View.VISIBLE);
                btn24.setVisibility(View.VISIBLE);
                btn25.setVisibility(View.VISIBLE);
                img1.setImageResource(R.drawable.bal_back);
                img2.setImageResource(R.drawable.bal_back);
                img3.setImageResource(R.drawable.bal_back);
                img4.setImageResource(R.drawable.bal_back);
                img5.setImageResource(R.drawable.bal_back);
                img6.setImageResource(R.drawable.bal_back);
                img7.setImageResource(R.drawable.bal_back);
                img8.setImageResource(R.drawable.bal_back);
                img9.setImageResource(R.drawable.bal_back);
                img10.setImageResource(R.drawable.bal_back);
                img11.setImageResource(R.drawable.bal_back);
                img12.setImageResource(R.drawable.bal_back);
                img13.setImageResource(R.drawable.bal_back);
                img14.setImageResource(R.drawable.bal_back);
                img15.setImageResource(R.drawable.bal_back);
                img16.setImageResource(R.drawable.bal_back);
                img17.setImageResource(R.drawable.bal_back);
                img18.setImageResource(R.drawable.bal_back);
                img19.setImageResource(R.drawable.bal_back);
                img20.setImageResource(R.drawable.bal_back);
                img21.setImageResource(R.drawable.bal_back);
                img22.setImageResource(R.drawable.bal_back);
                img23.setImageResource(R.drawable.bal_back);
                img24.setImageResource(R.drawable.bal_back);
                img25.setImageResource(R.drawable.bal_back);
                break;
        }
    }

    //DATA MANAGEMENT
    void loadData(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        keys = load.getInt("keys", 0);
        rubyrings = load.getInt("rubyrings", 0);
        emeraldrings = load.getInt("emeraldrings", 0);
        royalrings = load.getInt("royalrings", 0);
        balanceval = load.getInt("balance", 0);
    }
    void savedata(){
        SharedPreferences load = getSharedPreferences("Database", Context.MODE_PRIVATE);
        SharedPreferences.Editor save = load.edit();
        save.putInt("keys", keys);
        save.putInt("rubyrings", rubyrings);
        save.putInt("emeraldrings", emeraldrings);
        save.putInt("royalrings", royalrings);
        save.putInt("balance", balanceval);

        save.apply();
        save.commit();
    }

    //START END METHODS
    void startGame(){
        btnVisibility("VISIBLE");

        gotemeraldrings = gotrubyrings = gotroyalrings = 0;

        firstturn = true;
        profitval = 0;
        dividenumber = 5;
        balanceval-=betval;
        field("enable");
        livegame = true;
        updateDisplay();

    createMines();
    createRewards();
     savedata();
    }
    void endGame(){
        btnVisibility("INVISIBLE");

        if(cashout){
            emeraldrings += gotemeraldrings;
            rubyrings += gotrubyrings;
            royalrings += gotroyalrings;
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
        bet1 = (ImageButton)findViewById(R.id.bet1);
        bet2 = (ImageButton)findViewById(R.id.bet2);
        bet3 = (ImageButton)findViewById(R.id.bet3);

        maintitle = (ImageView)findViewById(R.id.maintitle);
        bettitle = (ImageView)findViewById(R.id.bettitle);

        leftBtn = (ImageButton)findViewById(R.id.leftBtn);
        mainBtn = (ImageButton)findViewById(R.id.mainBtn);
        rightBtn = (ImageButton)findViewById(R.id.rightBtn);

        betval = 5;

        field("disable");
        loadData();
        setGUI();
        updateDisplay();

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!livegame){
                    startGame();
                }else{
                    if(!firstturn) {
                        cashout = true;
                        endGame();
                    }
                }
            }
        });

        leftBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    savedata();
                    Intent intent = new Intent(Sweeper.this, ReactionInit.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    finish();
                    startActivity(intent);
            }
        });
        mainBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    savedata();
                    Intent intent = new Intent(Sweeper.this, Crash.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    finish();
                    startActivity(intent);
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
