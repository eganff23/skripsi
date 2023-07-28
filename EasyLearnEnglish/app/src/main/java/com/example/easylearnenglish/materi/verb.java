package com.example.easylearnenglish.materi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.easylearnenglish.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class verb extends AppCompatActivity {
    private String[]verbs = {
            "Buy = Beli\n"+"Verb-ing\n"+"Buying = Membeli","Borrow = Meminjam\n"+"Verb-ing\n"+"Borrowing = Meminjam",
            "Clean = Bersih\n"+"Verb-ing\n"+"Cleaning = Membersihkan","Cook = Masak\n"+"Verb-ing\n"+"Cooking = Memasak",
            "Discuss = Diskusi\n"+"Verb-ing\n"+"Discussing = Berdiskusi","Dance = Tari\n"+"Verb-ing\n"+"Dancing = Menari",
            "Drink = Minum\n"+"Verb-ing\n"+"Drinking = Minum","Draw = Gambar\n"+"Verb-ing\n"+"Drawing = Menggambar",
            "Eat = Makan\n"+"Verb=ing\n"+"Eating = Makan","Finish = Selesai\n"+"Verb-ing\n"+"Finishing = Menyelesaikan",
            "Give = Beri\n"+"Verb-ing\n"+"Giving = Memberi","Go = Pergi\n"+"Verb-ing\n"+"Going = Pergi",
            "Listen = Dengar\n"+"Verb-ing\n"+"Listening = Mendengarkan","Make = Buat\n"+"Verb-ing\n"+"Making = Membuat",
            "Play = Main\n"+"Verb-ing\n"+"Playing = Bermain","Read = Baca\n"+"Verb-ing\n"+"Reading = Membaca",
            "Run = Lari\n"+"Verb-ing\n"+"Running = Berlari","Sleep = Tidur\n"+"Verb-ing\n"+"Sleeping = Tidur",
            "Speak = Bicara\n"+"Verb-ing\n"+"Speaking = Berbicara","Study = Belajar\n"+"Verb-ing\n"+"Studying = Belajar",
            "Swim = Berenang\n"+"Verb-ing\n"+"Swimming = Berenang","Take = Ambil\n"+"Verb-ing\n"+"Taking = Mengambil",
            "Talk = Bicara\n"+"Verb-ing\n"+"Talking = Berbicara","Think = Berpikir\n"+"Verb-ing\n"+"Thinking = Berpikir",
            "Use = Menggunakan\n"+"Verb-ing\n"+"Using = Menggunakan","Walk = jalan\n"+"Verb-ing\n"+"Walking = Berjalan",
            "Wash = Cuci\n"+"Verb-ing\n"+"Washing = Mencuci","Watch = Lihat/Tonton\n"+"Verb-ing\n"+"Watching = Melihat/Menonton",
            "Work = Kerja\n"+"Verb-ing\n"+"Working = Bekerja","Write = Tulis\n"+"Verb-ing\n"+"Writing = Menulis"
    };

    private ArrayList<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        ListView listView = findViewById(R.id.list_view);
        data = new ArrayList<>();
        getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.gaya_baru, data);
        listView.setAdapter(adapter);


        // Menambahkan pendengar acara klik pada setiap item dalam ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                String[] parts = selectedItem.split(" ");
                playSound(parts[0]);
                Log.d("onItemClick: ", String.valueOf(parts[0]));
            }
        });
    }
    private void playSound(String musik) {
        int resId;

        switch (musik) {
            case "Buy":
                resId = R.raw.buy;
                break;
            case "Cook":
                resId = R.raw.cook;
                break;
            case "Borrow":
                resId = R.raw.borrow;
                break;
            case "Clean":
                resId = R.raw.clean;
                break;
            case "Dance":
                resId = R.raw.dance;
                break;
            case "Discuss":
                resId = R.raw.discuss;
                break;
            case "Draw":
                resId = R.raw.draw;
                break;
            case "Drink":
                resId = R.raw.drink;
                break;
            case "Eat":
                resId = R.raw.eat;
                break;
            case "Finish":
                resId = R.raw.finish;
                break;
            case "Give":
                resId = R.raw.give;
                break;
            case "Go":
                resId = R.raw.go;
                break;
            case "Listen":
                resId = R.raw.listen;
                break;
            case "Make":
                resId = R.raw.make;
                break;
            case "Play":
                resId = R.raw.play;
                break;
            case "Read":
                resId = R.raw.read;
                break;
            case "Run":
                resId = R.raw.run;
                break;
            case "Sleep":
                resId = R.raw.sleep;
                break;
            case "Speak":
                resId = R.raw.speak;
                break;
            case "Study":
                resId = R.raw.study;
                break;
            case "Swim":
                resId = R.raw.swim;
                break;
            case "Take":
                resId = R.raw.take;
                break;
            case "Talk":
                resId = R.raw.talk;
                break;
            case "Think":
                resId = R.raw.think;
                break;
            case "Use":
                resId = R.raw.use;
                break;
            case "Walk":
                resId = R.raw.walk;
                break;
            case "Wash":
                resId = R.raw.wash;
                break;
            case "Watch":
                resId = R.raw.watch;
                break;
            case "Work":
                resId = R.raw.work;
                break;
            case "Write":
                resId = R.raw.write;
                break;
            default:
                // Tambahkan kondisi dan aksi lainnya sesuai kebutuhan
                // Jika tidak ada nama musik yang cocok, atur resId ke 0 atau berikan nilai default
                resId = 0;
                break;
        }

        if (resId != 0) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, resId);
            mediaPlayer.start();
        }
    }

    private void getData(){
        Collections.addAll(data, verbs);
    }


    public void back(View view) {
        onBackPressed();
    }
}