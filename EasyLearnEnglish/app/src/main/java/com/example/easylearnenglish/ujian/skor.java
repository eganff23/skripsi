package com.example.easylearnenglish.ujian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.easylearnenglish.R;

public class skor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);




        TextView text_skor = findViewById(R.id.text_skor);


        int nilaiSkor = getIntent().getIntExtra("SCORE", 0);

        if (nilaiSkor >= 50) {
            text_skor.setText("Selamat! Nilai kamu adalah: " + nilaiSkor);
        } else {
            text_skor.setText("Sepertinya kamu harus belajar lebih giat lagi! \n Nilai kamu adalah: " + nilaiSkor);
        }
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