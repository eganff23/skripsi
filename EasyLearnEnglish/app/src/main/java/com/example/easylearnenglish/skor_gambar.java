package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class skor_gambar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_gambar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        TextView text_nilai = findViewById(R.id.text_nilai);

        int hasil = getIntent().getIntExtra("HASIL", 0);

        text_nilai.setText("Nilai kamu adalah : " + hasil);

    }

    public void replay(View view) {
        Intent i = new Intent(skor_gambar.this, tebakGambar.class);
        startActivity(i);
    }

    public void home(View view) {
        Intent i = new Intent(skor_gambar.this, ulangan.class);
        startActivity(i);
    }
}