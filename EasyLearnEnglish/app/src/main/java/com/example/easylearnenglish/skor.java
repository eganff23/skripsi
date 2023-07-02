package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class skor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        TextView text_skor = findViewById(R.id.text_skor);


        int nilaiSkor = getIntent().getIntExtra("SCORE", 0);

        text_skor.setText("Nilai kamu adalah : " + nilaiSkor);

    }

    public void replay(View view) {
        Intent i = new Intent(skor.this, kuis.class);
        startActivity(i);
    }

    public void home(View view) {
        Intent i = new Intent(skor.this, ulangan.class);
        startActivity(i);
    }
}