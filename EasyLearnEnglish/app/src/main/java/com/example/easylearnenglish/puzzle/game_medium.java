package com.example.easylearnenglish.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearnenglish.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class game_medium extends AppCompatActivity implements card_Adapter.OnCardClickListener {

    private List<card> cards;
    private card_Adapter cardAdapter;
    private int previousCardIndex = -1;
    private int matchedPairs = 0;
    private TextView tvTimer;
    private Handler handler;
    private int seconds = 15;
    private int level = 1;
    private int maxLevel = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_medium);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        tvTimer = findViewById(R.id.tvTimer1);
        GridView gridView = findViewById(R.id.gridView1);
        gridView.setNumColumns(2);

        handler = new Handler();
        startTimer();

        cards = new ArrayList<>();

        Collections.shuffle(cards);

        cardAdapter = new card_Adapter(this, cards, this);
        gridView.setAdapter(cardAdapter);

        resetGame();
    }

    @Override
    public void onCardClick(int i) {
        card clickedCard = cards.get(i);

        if (clickedCard.isMatched() || clickedCard.isFlipped()) {
            return; // Jangan lakukan apa-apa jika kartu sudah cocok atau sudah terbuka
        }

        clickedCard.setFlipped(true);
        cardAdapter.notifyDataSetChanged();

        if (previousCardIndex == -1) {
            previousCardIndex = i;
        } else {
            card previousCard = cards.get(previousCardIndex);

            if (previousCard.getImageResId() == clickedCard.getImageResId()) {
                clickedCard.setMatched(true);
                previousCard.setMatched(true);
                matchedPairs++;
            } else {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clickedCard.setFlipped(false);
                        previousCard.setFlipped(false);
                        cardAdapter.notifyDataSetChanged();
                        previousCardIndex = -1;
                    }
                }, 250);
            }
            previousCardIndex = -1;
        }
    }
    private void resetGame() {
        matchedPairs = 0;
        seconds = 15;
        tvTimer.setText("00:15");

        cards.clear();

        int numCard = level * 4;
        List<Integer> imageResIds = getRandomImageResIds(numCard / 2);
        for (int i = 0; i < numCard; i++) {
            cards.add(new card(imageResIds.get(i % (numCard / 2))));

        }

        Collections.shuffle(cards);
        cardAdapter.notifyDataSetChanged();

    }

    private List<Integer> getRandomImageResIds(int i) {
        List<Integer> imageResIds = new ArrayList<>();
        imageResIds.add(R.drawable.card_5);
        imageResIds.add(R.drawable.card_6);
        imageResIds.add(R.drawable.card_7);
        imageResIds.add(R.drawable.card_8);
        imageResIds.add(R.drawable.card_9);
        imageResIds.add(R.drawable.card_10);
        imageResIds.add(R.drawable.card_1);
        imageResIds.add(R.drawable.card_2);
        imageResIds.add(R.drawable.card_11);
        imageResIds.add(R.drawable.card_12);
        imageResIds.add(R.drawable.card_13);
        imageResIds.add(R.drawable.card_14);

        Collections.shuffle(imageResIds);
        return imageResIds.subList(0, i);
    }
    private void startTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                seconds--;
                if (seconds <= 0 && level == 1) {
                    // Waktu sudah habis, lakukan tindakan yang diperlukan di sini
                    Toast.makeText(game_medium.this, "Time's up!", Toast.LENGTH_SHORT).show();
                    finish();
                    return;

                } else if (seconds <= 0 && level > 1) {
                    // Waktu sudah habis, lakukan tindakan yang diperlukan di sini
                    Toast.makeText(game_medium.this, "Time's up!", Toast.LENGTH_SHORT).show();
                    finish();
                    return;
                }
                int minutes = seconds /60;
                int secs = seconds % 60;
                String time = String.format("%02d:%02d", minutes, secs);
                tvTimer.setText(time);


                if (matchedPairs == cards.size() / 2) {
                    //Toast.makeText(game_medium.this, "You win!", Toast.LENGTH_SHORT).show();
                    handler.removeCallbacks(null);
                    level++;
                    if (level > maxLevel) {
                        Toast.makeText(game_medium.this, "Game Over!", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                    resetGame();
                }
                handler.postDelayed(this,1000);
            }
        });
    }
    }