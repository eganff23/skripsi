package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class bacadengar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacadengar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void semut(View view) {
        Intent i = new Intent(bacadengar.this, ceritaSemut.class);
        startActivity(i);
    }
    public void taman(View view) {
        Intent i = new Intent(bacadengar.this, cerita_taman.class);
        startActivity(i);
    }

    public void materi(View view) {
        Intent u = new Intent(bacadengar.this, MainActivity.class);
        startActivity(u);
    }

    public void kuis(View view) {
        Intent e = new Intent(bacadengar.this, ulangan.class);
        startActivity(e);
    }

    public void game(View view) {
    }

    public void user(View view) {
    }


}