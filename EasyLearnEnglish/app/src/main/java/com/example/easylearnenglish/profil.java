package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.easylearnenglish.dengarbaca.bacadengar;
import com.example.easylearnenglish.dengarbaca.cerita_taman;
import com.example.easylearnenglish.puzzle.game;
import com.example.easylearnenglish.ujian.ulangan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class profil extends AppCompatActivity {

    private TextView profiltext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        profiltext = findViewById(R.id.profiltext);

        String story = loadStoryFromAsset();
        profiltext.setText(story);
    }

    private String loadStoryFromAsset() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = getAssets().open("profil.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public void game(View view) {
        Intent i = new Intent (this, game.class);
        startActivity(i);
    }

    public void materii(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void kuis(View view) {
        Intent i = new Intent(this, ulangan.class);
        startActivity(i);

    }

    public void book(View view) {
        Intent intent = new Intent(this, bacadengar.class);
        startActivity(intent);
    }
}