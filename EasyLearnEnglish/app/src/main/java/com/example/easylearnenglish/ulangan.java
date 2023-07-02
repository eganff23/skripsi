package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class ulangan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulangan);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }

    public void ulangankuis(View view) {
        Intent i = new Intent(ulangan.this, kuis.class);
        startActivity(i);
    }

    public void game(View view) {

    }

    public void user(View view) {
    }


    public void materi(View view) {
        Intent intent = new Intent(ulangan.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void ulangangambar(View view) {
        Intent i = new Intent(ulangan.this, tebakGambar.class);
        startActivity(i);
        finish();
    }

    public void book(View view) {
        Intent intent = new Intent(ulangan.this, bacadengar.class);
        startActivity(intent);
        finish();
    }
}