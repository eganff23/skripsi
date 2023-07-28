package com.example.easylearnenglish.puzzle;

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
import com.example.easylearnenglish.ujian.ulangan;

public class game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void easy(View view) {
        Intent i = new Intent(game.this, game_easy.class);
        startActivity(i);
    }

    public void materi(View view) {
        Intent i = new Intent(game.this, MainActivity.class);
        startActivity(i);    }

    public void book(View view) {
        Intent i = new Intent(game.this, bacadengar.class);
        startActivity(i);
    }
    public void user(View view) {
        Intent i = new Intent(this, profil.class);
        startActivity(i);
    }

    public void ulangan(View view) {
        Intent i = new Intent(game.this, ulangan.class);
        startActivity(i);
    }

    public void medium(View view) {
        Intent i = new Intent(game.this, game_medium.class);
        startActivity(i);
    }

    public void hard(View view) {
        Intent i = new Intent(game.this, game_hard.class);
        startActivity(i);
    }
}