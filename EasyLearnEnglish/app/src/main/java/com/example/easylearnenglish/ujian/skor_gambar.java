package com.example.easylearnenglish.ujian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.easylearnenglish.R;

public class skor_gambar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_gambar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView text_nilai = findViewById(R.id.text_nilai);

        int hasil = getIntent().getIntExtra("HASIL", 0);

        if (hasil >= 50) {
            text_nilai.setText("Selamat! Nilai kamu adalah: " + hasil);
        } else {
            text_nilai.setText("Sepertinya kamu harus belajar lebih giat lagi! \n Nilai kamu adalah: " + hasil);
        }
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