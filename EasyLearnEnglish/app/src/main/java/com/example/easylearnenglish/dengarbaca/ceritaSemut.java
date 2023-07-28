package com.example.easylearnenglish.dengarbaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easylearnenglish.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ceritaSemut extends AppCompatActivity implements View.OnClickListener {

    private TextView storyTextView;
    private ImageView btn_play, btn_pause, btn_stop;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private int currentPosition1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerita_semut);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        storyTextView = findViewById(R.id.storyTextView);
        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);
        btn_stop = findViewById(R.id.btn_stop);

        btn_play.setVisibility(View.VISIBLE);
        btn_pause.setVisibility(View.GONE);
        btn_stop.setVisibility(View.GONE);

        btn_play.setOnClickListener(this);
        btn_pause.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopMediaPlayer();
            }
        });

        String story = loadStoryFromAsset();
        storyTextView.setText(story);
    }

    private String loadStoryFromAsset() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = getAssets().open("semut.txt");
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
    @Override
    public void onClick(View view) {
       if (view.getId()== R.id.btn_play){
           playMediaPlayer();
           btn_play.setVisibility(View.GONE);
           btn_pause.setVisibility(View.VISIBLE);
           btn_stop.setVisibility(View.VISIBLE);
        }else if (view.getId()== R.id.btn_pause){
           pauseMediaPlayer();
           btn_play.setVisibility(View.VISIBLE);
           btn_pause.setVisibility(View.GONE);
           btn_stop.setVisibility(View.GONE);
       } else if (view.getId()== R.id.btn_stop) {
           stopMediaPlayer();
           btn_play.setVisibility(View.VISIBLE);
           btn_pause.setVisibility(View.GONE);
           btn_stop.setVisibility(View.GONE);

       }
    }

    private void playMediaPlayer() {
        if (!isPlaying) {
                mediaPlayer = MediaPlayer.create(this, R.raw.semut);
                mediaPlayer.seekTo(currentPosition1);
                mediaPlayer.start();
                isPlaying = true;
        }
    }

    private void pauseMediaPlayer() {
        if (isPlaying) {
            mediaPlayer.pause();
            currentPosition1 = mediaPlayer.getCurrentPosition();
            isPlaying = false;

        }
    }

    private void stopMediaPlayer() {
        if(isPlaying) {
            mediaPlayer.stop();
            mediaPlayer.release();
            isPlaying = false;
            currentPosition1 = 0;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void back(View view) {
        Intent i = new Intent(ceritaSemut.this, bacadengar.class);
        startActivity(i);
        finish();
    }
}
