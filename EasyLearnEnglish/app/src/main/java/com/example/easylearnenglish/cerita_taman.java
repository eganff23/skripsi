package com.example.easylearnenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class cerita_taman extends AppCompatActivity implements View.OnClickListener {
    private TextView storyTextView;
    private ImageView btn_play, btn_pause, btn_stop;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerita_taman);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        storyTextView = findViewById(R.id.storyTextView);
        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);
        btn_stop = findViewById(R.id.btn_stop);

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
            InputStream inputStream = getAssets().open("taman.txt");
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
        }else if (view.getId()== R.id.btn_pause){
            pauseMediaPlayer();
        } else if (view.getId()== R.id.btn_stop) {
            stopMediaPlayer();

        }
    }

    private void playMediaPlayer() {
        if (!isPlaying) {
            // mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(this, R.raw.taman);
            mediaPlayer.start();
            isPlaying = true;
        }
    }

    private void pauseMediaPlayer() {
        if (isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
        }else {
            mediaPlayer.start();
            isPlaying =true;
        }
    }

    private void stopMediaPlayer() {
        mediaPlayer.stop();
        isPlaying = false;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void back(View view) {
        Intent i = new Intent(cerita_taman.this, bacadengar.class);
        startActivity(i);
        finish();
    }
}
