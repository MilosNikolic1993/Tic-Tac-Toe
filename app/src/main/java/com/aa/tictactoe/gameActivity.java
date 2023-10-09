package com.aa.tictactoe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class gameActivity extends AppCompatActivity {
    int playCount = 0;

    ArrayList<Integer> selectedIdsX = new ArrayList<>();
    ArrayList<Integer> selectedIdsY = new ArrayList<>();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
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
        setContentView(R.layout.activity_game);
        one = (ImageView)findViewById(R.id.one);
        two = (ImageView)findViewById(R.id.two);
        three = (ImageView)findViewById(R.id.three);
        four = (ImageView)findViewById(R.id.four);
        five = (ImageView)findViewById(R.id.five);
        six = (ImageView)findViewById(R.id.six);
        seven = (ImageView)findViewById(R.id.seven);
        eight = (ImageView)findViewById(R.id.eight);
        nine = (ImageView)findViewById(R.id.nine);
        valuesAll.addAll(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));


    }
    public void refresh(View view){
        for (ImageView x : valuesAll){
            x.setClickable(true);
            x.setForeground(null);
        }
        selectedIdsY.clear();
        selectedIdsX.clear();
    }


    public void boardClick(View view) {
        Drawable x = getDrawable(R.drawable.x_sign);
        Drawable o = getDrawable(R.drawable.o_sign);
        ImageView selected = (ImageView)view;
        //player checker
        if(playCount%2==0) {
            selectedIdsX.add(view.getId());
            //set X and deactivate field
            selected.setForeground(x);
            selected.setClickable(false);
            //victory checker
            if(selectedIdsX.contains(one.getId())&&selectedIdsX.contains(two.getId())&&selectedIdsX.contains(three.getId())){
                Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
                xWins.show();
            }else if(selectedIdsX.contains(one.getId())&&selectedIdsX.contains(five.getId())&&selectedIdsX.contains(nine.getId())){
                Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
                xWins.show();
            }else if(selectedIdsX.contains(one.getId())&&selectedIdsX.contains(four.getId())&&selectedIdsX.contains(seven.getId())){
            Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
            xWins.show();
            }else if(selectedIdsX.contains(two.getId())&&selectedIdsX.contains(five.getId())&&selectedIdsX.contains(eight.getId())){
                Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
                xWins.show();
            }else if(selectedIdsX.contains(three.getId())&&selectedIdsX.contains(six.getId())&&selectedIdsX.contains(nine.getId())){
                Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
                xWins.show();
            }else if(selectedIdsX.contains(four.getId())&&selectedIdsX.contains(five.getId())&&selectedIdsX.contains(six.getId())){
                Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
                xWins.show();
            }else if(selectedIdsX.contains(seven.getId())&&selectedIdsX.contains(eight.getId())&&selectedIdsX.contains(nine.getId())){
                Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
                xWins.show();
            }else if(selectedIdsX.contains(seven.getId())&&selectedIdsX.contains(five.getId())&&selectedIdsX.contains(three.getId())){
                Toast xWins =Toast.makeText(this, "X wins", Toast.LENGTH_LONG);
                xWins.show();
            }
        //player checker
        }else if(playCount%2==1){
            selectedIdsY.add(view.getId());
            //set O and deactivacte field
            selected.setForeground(o);
            selected.setClickable(false);
            //victory checker
            if(selectedIdsY.contains(one.getId())&&selectedIdsY.contains(two.getId())&&selectedIdsY.contains(three.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }else if(selectedIdsY.contains(one.getId())&&selectedIdsY.contains(five.getId())&&selectedIdsY.contains(nine.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }else if(selectedIdsY.contains(one.getId())&&selectedIdsY.contains(four.getId())&&selectedIdsY.contains(seven.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }else if(selectedIdsY.contains(two.getId())&&selectedIdsY.contains(five.getId())&&selectedIdsY.contains(eight.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }else if(selectedIdsY.contains(three.getId())&&selectedIdsY.contains(six.getId())&&selectedIdsY.contains(nine.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }else if(selectedIdsY.contains(four.getId())&&selectedIdsY.contains(five.getId())&&selectedIdsY.contains(six.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }else if(selectedIdsY.contains(seven.getId())&&selectedIdsY.contains(eight.getId())&&selectedIdsY.contains(nine.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }else if(selectedIdsY.contains(seven.getId())&&selectedIdsY.contains(five.getId())&&selectedIdsY.contains(three.getId())){
                Toast yWins =Toast.makeText(this, "O wins", Toast.LENGTH_LONG);
                yWins.show();
            }
        }else if(selectedIdsX.size() + selectedIdsY.size() == 9){

        }

        playCount++;




    }
}