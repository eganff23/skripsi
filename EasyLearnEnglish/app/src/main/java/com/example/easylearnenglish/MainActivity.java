package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.easylearnenglish.dengarbaca.bacadengar;
import com.example.easylearnenglish.materi.object;
import com.example.easylearnenglish.materi.time;
import com.example.easylearnenglish.materi.verb;
import com.example.easylearnenglish.puzzle.game;
import com.example.easylearnenglish.ujian.ulangan;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    public void verb(View view) {
        Intent intent = new Intent(MainActivity.this, verb.class);
        startActivity(intent);
    }

    public void object(View view) {
        Intent intent = new Intent(MainActivity.this, object.class);
        startActivity(intent);

    }

    public void time(View view) {
        Intent intent = new Intent(MainActivity.this, time.class);
        startActivity(intent);

    }

    public void game(View view) {
        Intent i = new Intent (MainActivity.this, game.class);
        startActivity(i);
    }

    public void user(View view) {
        Intent i = new Intent(this, profil.class);
        startActivity(i);
    }

    public void kuis(View view) {
        Intent i = new Intent(MainActivity.this, ulangan.class);
        startActivity(i);

    }

    public void book(View view) {
        Intent intent = new Intent(MainActivity.this, bacadengar.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        showDialog(MainActivity.this, "are you sure to exit?");

}

    public void showDialog (Activity activity, String msg){
        final Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_exit);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        ImageButton dialogButton1 = dialog.findViewById(R.id.btn1);
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                finish();
            }
        });
        ImageButton dialogButton2 = dialog.findViewById(R.id.btn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void info(View view) {
        Intent i = new Intent(this, info.class);
        startActivity(i);
    }
}