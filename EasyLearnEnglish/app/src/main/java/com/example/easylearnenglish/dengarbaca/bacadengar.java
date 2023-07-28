package com.example.easylearnenglish.dengarbaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.easylearnenglish.MainActivity;
import com.example.easylearnenglish.R;
import com.example.easylearnenglish.profil;
import com.example.easylearnenglish.puzzle.game;
import com.example.easylearnenglish.ujian.ulangan;

public class bacadengar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacadengar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
        Intent i = new Intent (bacadengar.this, game.class);
        startActivity(i);
    }

    public void user(View view) {
        Intent i = new Intent(bacadengar.this, profil.class);
        startActivity(i);
    }


}