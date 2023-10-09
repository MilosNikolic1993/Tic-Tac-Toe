package com.aa.tictactoe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openGame(View view) {
        Intent intent = new Intent(this, machineActivity.class);
        startActivity(intent);
    }

    public void openAboutGame(View view) {
        Intent intent = new Intent(this, aboutGameActivity.class);
        startActivity(intent);
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
                Intent gameIntent = new Intent(this, machineActivity.class);
                startActivity(gameIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}