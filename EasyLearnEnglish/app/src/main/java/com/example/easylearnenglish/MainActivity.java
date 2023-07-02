package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }


    public void verb(View view) {
        Intent intent = new Intent(MainActivity.this, verb.class);
        startActivity(intent);
    }

    public void object(View view) {
        Intent intent = new Intent(MainActivity.this, object.class);
        startActivity(intent);

    }

    public void time(View view) {
        Intent intent = new Intent(MainActivity.this, time.class);
        startActivity(intent);

    }

    public void game(View view) {
    }

    public void user(View view) {
    }

    public void kuis(View view) {
        Intent i = new Intent(MainActivity.this, ulangan.class);
        startActivity(i);

    }

    public void book(View view) {
        Intent intent = new Intent(MainActivity.this, bacadengar.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        finishAffinity();
    }
}