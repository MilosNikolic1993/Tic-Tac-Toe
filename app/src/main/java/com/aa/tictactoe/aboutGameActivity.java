package com.aa.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class aboutGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_game);
    }
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
               Intent gameIntent = new Intent(this,machineActivity.class);
               startActivity(gameIntent);
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }
    }
}