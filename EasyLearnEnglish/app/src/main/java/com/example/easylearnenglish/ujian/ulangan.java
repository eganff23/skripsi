package com.example.easylearnenglish.ujian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.easylearnenglish.MainActivity;
import com.example.easylearnenglish.R;
import com.example.easylearnenglish.dengarbaca.bacadengar;
import com.example.easylearnenglish.profil;
import com.example.easylearnenglish.puzzle.game;

public class ulangan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulangan);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    public void ulangankuis(View view) {
        Intent i = new Intent(ulangan.this, kuis.class);
        startActivity(i);
    }

    public void game(View view) {
        Intent i = new Intent(ulangan.this, game.class);
        startActivity(i);

    }

    public void user(View view) {
        Intent i = new Intent(this, profil.class);
        startActivity(i);
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