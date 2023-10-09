package com.aa.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class machineActivity extends AppCompatActivity {
    ArrayList<ImageView> xList = new ArrayList<>();
    ArrayList<ImageView> yList = new ArrayList<>();
    ArrayList<ImageView> crosses = new ArrayList<>();
    ArrayList<ImageView> sides = new ArrayList<>();
    ArrayList<ImageView> valuesAll = new ArrayList<>();

    ImageView one;
    ImageView two;
    ImageView three;
    ImageView four;
    ImageView five;
    ImageView six;
    ImageView seven;
    ImageView eight;
    ImageView nine;
    int clickCount = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent infoIntent = new Intent(this, aboutGameActivity.class);
                startActivity(infoIntent);
                return true;
            case R.id.play:
                Intent gameIntent = new Intent(this, machineActivity.class);
                startActivity(gameIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);
        one = (ImageView) findViewById(R.id.oneMach);
        two = (ImageView) findViewById(R.id.twoMach);
        three = (ImageView) findViewById(R.id.threeMach);
        four = (ImageView) findViewById(R.id.fourMach);
        five = (ImageView) findViewById(R.id.fiveMach);
        six = (ImageView) findViewById(R.id.sixMach);
        seven = (ImageView) findViewById(R.id.sevenMach);
        eight = (ImageView) findViewById(R.id.eightMach);
        nine = (ImageView) findViewById(R.id.nineMach);
        crosses.addAll(Arrays.asList(one, three, seven, nine));
        sides.addAll(Arrays.asList(two, four, six, eight));
        valuesAll.addAll(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));

    }

    public void winChecker() {
        if ((xList.contains(one) && xList.contains(two) && xList.contains(three))
                || (xList.contains(one) && xList.contains(four) && xList.contains(seven))
                || (xList.contains(one) && xList.contains(five) && xList.contains(nine))
                || (xList.contains(two) && xList.contains(five) && xList.contains(eight))
                || (xList.contains(three) && xList.contains(six) && xList.contains(nine))
                || (xList.contains(three) && xList.contains(five) && xList.contains(seven))
                || (xList.contains(four) && xList.contains(five) && xList.contains(six))
                || (xList.contains(seven) && xList.contains(eight) && xList.contains(nine))) {
            Toast xWins = Toast.makeText(this, "X is the winner", Toast.LENGTH_SHORT);
            xWins.show();
            for (ImageView iv : valuesAll) {
                iv.setClickable(false);
            }
        } else if ((yList.contains(one) && yList.contains(two) && yList.contains(three))
                || (yList.contains(one) && yList.contains(four) && yList.contains(seven))
                || (yList.contains(one) && yList.contains(five) && yList.contains(nine))
                || (yList.contains(two) && yList.contains(five) && yList.contains(eight))
                || (yList.contains(three) && yList.contains(six) && yList.contains(nine))
                || (yList.contains(three) && yList.contains(five) && yList.contains(seven))
                || (yList.contains(four) && yList.contains(five) && yList.contains(six))
                || (yList.contains(seven) && yList.contains(eight) && yList.contains(nine))) {
            Toast xWins = Toast.makeText(this, "O is the winner", Toast.LENGTH_SHORT);
            xWins.show();
            for (ImageView iv : valuesAll) {
                iv.setClickable(false);
            }
        } else if ((xList.size() + yList.size()) == 9) {
            Toast draw = Toast.makeText(this, "Its a draw.. better luck next time", Toast.LENGTH_LONG);
            draw.show();
        }
    }

    public void playO(ImageView view) {
        Drawable o = getResources().getDrawable(R.drawable.o_sign);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (view.isClickable() && !xList.contains(view)) {
                    view.setForeground(o);
                    view.setClickable(false);
                    yList.add(view);
                    valuesAll.remove(view);
                    winChecker();
                }
            }
        }, 300);
    }


    public void playRandom() {
        Drawable o = getResources().getDrawable(R.drawable.o_sign);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int randomIndex = random.nextInt(valuesAll.size());
                ImageView hailMary = valuesAll.get(randomIndex);
                if (hailMary.isClickable()) {
                    hailMary.setForeground(o);
                    hailMary.setClickable(false);
                    yList.add(hailMary);
                    valuesAll.remove(hailMary);
                    winChecker();
                } else {
                    playRandom();

                }
            }
        }, 300);
    }

    public void refresh(View view) {
        if (!valuesAll.isEmpty()) {
            valuesAll.clear();
        }
        for (int i = 0; i < xList.size(); i++) {
            ImageView current = xList.get(i);
            if (!(current.getForeground().equals(null) && !current.isClickable())) {
                current.setForeground(null);
                current.setClickable(true);
            }
        }
        for (int i = 0; i < yList.size(); i++) {
            ImageView current = yList.get(i);
            if (!(current.getForeground().equals(null) && !current.isClickable())) {
                current.setForeground(null);
                current.setClickable(true);
            }
        }
        xList = new ArrayList<ImageView>();
        yList = new ArrayList<ImageView>();
        valuesAll.addAll(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
        for (ImageView x : valuesAll) {
            x.setClickable(true);
        }
    }


    public void boardClickMachine(View view) {
        ImageView selected = (ImageView) view;
        if (selected.isClickable()) {
            xList.add(selected);
            valuesAll.remove(selected);
        }
        Drawable x = getResources().getDrawable(R.drawable.x_sign);
        Drawable o = getResources().getDrawable(R.drawable.x_sign);
        if (selected.isClickable()) {
            selected.setForeground(x);
            //PRVI POTEZ
            if (xList.size() == 1) {
                if (crosses.contains(selected) || sides.contains(selected)) {
                    playO(five);
                } else if (selected.equals(five)) {
                    ImageView counterField;
                    Random rand = new Random();
                    int randIndex = rand.nextInt(crosses.size());
                    counterField = crosses.get(randIndex);
                    playO(counterField);
                }
                //DRUGI POTEZ
            } else if (xList.size() == 2) {
                //DRAW MOVES
                if ((xList.contains(two) && xList.contains(five)) || (xList.contains(seven) && xList.contains(nine))
                        || (xList.contains(two) && xList.contains(seven)) || (xList.contains(two) && xList.contains(nine))
                        || (xList.contains(one) && xList.contains(nine))) {
                    playO(eight);
                } else if ((xList.contains(one) && xList.contains(three)) || (xList.contains(three) && xList.contains(seven))
                        || (xList.contains(five) && xList.contains(eight)) || (xList.contains(four) && xList.contains(six))) {
                    playO(two);
                } else if ((xList.contains(five) && xList.contains(three)) || (xList.contains(one) && xList.contains(six))
                        || (xList.contains(one) && xList.contains(four)) || (xList.contains(eight) && xList.contains(nine))
                        || (xList.contains(four) && xList.contains(eight)) || (xList.contains(four) && xList.contains(nine))
                        || (xList.contains(one) && xList.contains(eight))) {
                    if (valuesAll.contains(seven)) {
                        playO(seven);
                    } else {
                        playRandom();
                    }
                } else if ((xList.contains(four) && xList.contains(five)) || (xList.contains(three) && xList.contains(nine))) {
                    playO(six);
                } else if (xList.contains(five) && xList.contains(six) || (xList.contains(one) && xList.contains(seven))) {
                    playO(four);
                } else if (xList.contains(one) && xList.contains(five) || (xList.contains(three) && xList.contains(eight))) {
                    if (!yList.contains(nine)) {
                        playO(nine);
                    } else if (!yList.contains(three)) {
                        playO(three);
                    }
                } else if (xList.contains(five) && xList.contains(seven)) {
                    if (valuesAll.contains(three)) {
                        playO(three);
                    } else if (xList.contains(nine)) {
                        playO(one);
                    } else {
                        playRandom();
                    }
                } else if (xList.contains(five) && xList.contains(nine)) {
                    if (valuesAll.contains(one)) {
                        playO(one);
                    } else {
                        playRandom();
                    }
                } else if ((xList.contains(two) && xList.contains(eight)) || (xList.contains(one) && xList.contains(two))
                        || (xList.contains(six) && xList.contains(nine)) || (xList.contains(two) && xList.contains(six))) {
                    if (valuesAll.contains(three)) {
                        playO(three);
                    } else {
                        playRandom();
                    }
                } else if ((xList.contains(seven) && xList.contains(eight)) || (xList.contains(three) && xList.contains(six))
                        || (xList.contains(six) && xList.contains(eight)) || (xList.contains(seven) && xList.contains(six))) {
                    if (valuesAll.contains(nine)) {
                        playO(nine);
                    } else {
                        playRandom();
                    }
                } else if ((xList.contains(two) && xList.contains(three)) || (xList.contains(four) && xList.contains(seven))
                        || (xList.contains(two) && xList.contains(four)) || (xList.contains(three) && xList.contains(four))) {
                    if (valuesAll.contains(one)) {
                        playO(one);
                    } else {
                        playRandom();
                    }
                } else {
                    playRandom();
                }

            }
            //treci potez
            else if (xList.size() == 3) {
                //WIN MOVES
                //SIDE WIN MOVES
                if ((yList.contains(one) && yList.contains(two)) || (yList.contains(six) && yList.contains(nine))) {
                    if (valuesAll.contains(three)) {
                        playO(three);
                    } else {
                        playRandom();
                    }
                } else if ((yList.contains(two) && yList.contains(three)) || (yList.contains(seven) && yList.contains(four))) {
                    if (valuesAll.contains(one)) {
                        playO(one);
                    } else {
                        playRandom();
                    }
                } else if ((yList.contains(one) && yList.contains(three))) {
                    if (valuesAll.contains(two)) {
                        playO(two);
                    } else if (xList.contains(five) && xList.contains(two)) {
                        if (valuesAll.contains(eight)) {
                            playO(eight);
                        } else if (xList.contains(five) && xList.contains(one)) {
                            if (valuesAll.contains(nine)) {
                                playO(nine);
                            }
                        } else {
                            playRandom();
                        }
                    }
                } else if ((yList.contains(one) && yList.contains(four)) || (yList.contains(nine) && yList.contains(eight))
                        || (yList.contains(eight) && yList.contains(nine))) {
                    if (!xList.contains(seven)) {
                        playO(seven);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(one) && yList.contains(seven)) {
                    if (!xList.contains(four)) {
                        playO(four);
                    } else if (xList.contains(five) && xList.contains(four)) {
                        playO(six);
                    }
                } else if ((yList.contains(seven) && yList.contains(nine))|| (xList.contains(seven) && xList.contains(nine))) {
                    if (xList.contains(eight) && xList.contains(five)) {
                        if (valuesAll.contains(two)) {
                            playO(two);
                        }else {
                            playRandom();
                        }
                    } else if (valuesAll.contains(eight)) {
                        playO(eight);
                    } else {
                        playRandom();
                    }

                } else if ((yList.contains(eight) && yList.contains(seven)) || (yList.contains(three) && yList.contains(six))) {
                    if (valuesAll.contains(nine)) {
                        playO(nine);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(four) && yList.contains(five)) {
                    if (valuesAll.contains(six)) {
                        playO(six);
                    } else if (!xList.contains(nine)) {
                        playO(nine);
                    } else {
                        playRandom();
                    }

                } else if (yList.contains(five) && yList.contains(six)) {
                    if (valuesAll.contains(four)) {
                        playO(four);
                    } else if (valuesAll.contains(one)) {
                        playO(one);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(four) && yList.contains(six)) {
                    if (valuesAll.contains(five)) {
                        playO(five);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(two) && yList.contains(eight)) {
                    if (valuesAll.contains(five)) {
                        playO(five);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(two) && yList.contains(five)) {
                    if (valuesAll.contains(eight)) {
                        playO(eight);
                    } else if (xList.contains(three) && xList.contains(nine)) {
                        if (valuesAll.contains(six)) {
                            playO(six);
                        }
                    } else if (xList.contains(one) && xList.contains(seven) && !eight.isClickable()) {
                        if (valuesAll.contains(four)) {
                            playO(four);
                        }
                    } else if (valuesAll.contains(nine)) {
                        playO(nine);
                    } else if (valuesAll.contains(seven)) {
                        playO(seven);

                    }
                } else if (yList.contains(five) && yList.contains(eight)) {
                    if (!xList.contains(two)) {
                        playO(two);
                    } else if (xList.contains(one) && xList.contains(two)) {
                        playO(three);
                    } else if (xList.contains(two) && xList.contains(three)) {
                        playO(one);
                    }else if(xList.contains(one) && xList.contains(three)){
                        if(valuesAll.contains(two)){
                            playO(two);
                        }
                    }
                } else if (yList.contains(three) && yList.contains(nine)) {
                    if (valuesAll.contains(six)) {
                        playO(six);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(five) && yList.contains(nine)) {
                    if (!xList.contains(one)) {
                        playO(one);
                    } else if (!xList.contains(two)) {
                        playO(two);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(one) && yList.contains(five)) {
                    if (!xList.contains(nine)) {
                        playO(nine);
                    } else if (xList.contains(three) && xList.contains(nine)) {
                        playO(six);
                    } else if (!xList.contains(eight)) {
                        playO(eight);
                    }

                } else if (yList.contains(one) && yList.contains(nine)) {
                    if (!xList.contains(five)) {
                        playO(five);
                    }
                } else if (yList.contains(three) && yList.contains(five)) {
                    if (!xList.contains(seven)) {
                        playO(seven);
                    } else if (xList.contains(seven) && xList.contains(one)) {
                        playO(four);
                    } else if (!xList.contains(nine)) {
                        playO(nine);
                    } else {
                        playRandom();
                    }
                } else if (yList.contains(three) && yList.contains(seven)) {
                    playO(five);
                } else if (yList.contains(seven) && yList.contains(five)) {
                    if (xList.contains(three)) {
                        playO(two);
                    } else {
                        playO(three);
                    }
                }
                //IF ALL ELSE FAILS, RANDOM BLOCK
                else {
                    playRandom();
                }

            } else if (xList.size() == 4) {
                if(xList.contains(one) && xList.contains(three)){
                    if(valuesAll.contains(two)){
                        playO(two);
                    }else {
                        playRandom();
                    }
                }else if(xList.contains(seven) && xList.contains(nine)){
                    if(valuesAll.contains(eight)){
                        playO(eight);
                    }else {
                        playRandom();
                    }
                }else if(xList.contains(one) && xList.contains(seven)){
                   if(valuesAll.contains(four)) {
                       playO(four);
                   }else{
                       playRandom();
                   }
                }else if(xList.contains(nine) && xList.contains(three)){
                    if(valuesAll.contains(six)){
                        playO(six);
                    }else {
                        playRandom();
                    }
                }
                else {
                    playRandom();
                }

            }
                view.setClickable(false);
                winChecker();
            }
        }
    }
