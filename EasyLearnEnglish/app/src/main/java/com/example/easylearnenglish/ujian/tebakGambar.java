package com.example.easylearnenglish.ujian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easylearnenglish.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class tebakGambar extends AppCompatActivity {

    private ImageView img_soal;
    private TextView text_soal;
    private TextView answerTextView;
    private RadioGroup radiogrup;
    private RadioButton opsi1;
    private RadioButton opsi2;
    private RadioButton opsi3;
    private Button btn_next;

    private List<tanya> tanyaList;
    private int currentQuestionIndex;
    private int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_gambar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        img_soal = findViewById(R.id.img_soal);
        text_soal = findViewById(R.id.text_soal);
        radiogrup = findViewById(R.id.radiogrup);
        opsi1 = findViewById(R.id.opsi1);
        opsi2 = findViewById(R.id.opsi2);
        opsi3 = findViewById(R.id.opsi3);
        btn_next = findViewById(R.id.btn_next);
        answerTextView = findViewById(R.id.answerTextView1);

        initialQuestions();
        hasil = 0;

        Collections.shuffle(tanyaList);
        showQuestion(0);
    }

    private static final int MAX_QUESTIONS = 10;

    private void initialQuestions() {
        tanyaList = new ArrayList<>();
        tanyaList.add(new tanya(R.drawable.mobil,"The image above is......","car","ship","book",0));
        tanyaList.add(new tanya(R.drawable.buku,"The image above is......","pencil","book","fork",1));
        tanyaList.add(new tanya(R.drawable.sepatu,"The image above is......","glass","chair","shoes",2));
        tanyaList.add(new tanya(R.drawable.meja,"The image above is......","blackboard","table","eraser",1));
        tanyaList.add(new tanya(R.drawable.kipas,"The image above is......","fan","wardrobe","beg",0));
        tanyaList.add(new tanya(R.drawable.cermin,"The image above is......","umbrella","mirror","glasses",1));
        tanyaList.add(new tanya(R.drawable.boneka,"The image above is......","doll","pants","bed",0));
        tanyaList.add(new tanya(R.drawable.kulkas,"The image above is......","mirror","spoon","refrigerator",2));
        tanyaList.add(new tanya(R.drawable.sendok,"The image above is......","plate","clock","spoon",2));
        tanyaList.add(new tanya(R.drawable.tas,"The image above is......","beg","book","ruler",0));
        tanyaList.add(new tanya(R.drawable.kapal,"The image above is......","train","ship","bike",1));
        tanyaList.add(new tanya(R.drawable.penggaris,"The image above is......","ruler","pencil sharpener","eraser",0));

        if (tanyaList.size() > MAX_QUESTIONS){
            List<tanya> randomQuestions = new ArrayList<>();
            Random random = new Random();
            while (randomQuestions.size() < MAX_QUESTIONS) {
                int randomIndex = random.nextInt(tanyaList.size());
                randomQuestions.add(tanyaList.get(randomIndex));
                tanyaList.remove(randomIndex);
            }
            tanyaList = randomQuestions;
        }
    }

    public void onNextButtonClick(View view) {
        int selectedAnswer = radiogrup.getCheckedRadioButtonId();
        if (selectedAnswer == -1){
            Toast.makeText(this, "Pilih jawaban terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedRadioButton = findViewById(radiogrup.getCheckedRadioButtonId());
        int answerIndex = radiogrup.indexOfChild(selectedRadioButton);
        tanya jawabBenar = tanyaList.get(currentQuestionIndex);
        if (answerIndex == jawabBenar.getJawabBenar()){
            hasil++;
            answerTextView.setVisibility(View.INVISIBLE);
        } else {
            String correctAnswerText = "";
            switch (jawabBenar.getJawabBenar()) {
                case 0:
                    correctAnswerText = jawabBenar.getOpsi1();
                    break;
                case 1:
                    correctAnswerText = jawabBenar.getOpsi2();
                    break;
                case 2:
                    correctAnswerText = jawabBenar.getOpsi3();
                    break;
            }
            answerTextView.setText("Jawaban yang benar: " + correctAnswerText);
            answerTextView.setVisibility(View.VISIBLE);
            Toast.makeText(this,"Jawaban Kamu Salah", Toast.LENGTH_SHORT).show();
        }

        // Sembunyikan answerTextView jika jawaban benar
        answerTextView.setVisibility(answerIndex == jawabBenar.getJawabBenar() ? View.INVISIBLE : View.VISIBLE);

        btn_next.setVisibility(View.VISIBLE);
        radiogrup.setVisibility(View.INVISIBLE);
        btn_next.setEnabled(true);

        currentQuestionIndex++;
        if (currentQuestionIndex < tanyaList.size()){
            showQuestion(currentQuestionIndex);
        }else {
            showFinalHasil();
        }
    }



    private void showQuestion(int i) {
        tanya tanya = tanyaList.get(i);

      //  img_soal.setImageResource(tanya.getGambar());
        text_soal.setText(tanya.getSoal());
        opsi1.setText(tanya.getOpsi1());
        opsi2.setText(tanya.getOpsi2());
        opsi3.setText(tanya.getOpsi3());

        int imageResId = tanya.getGambar();
        if(imageResId != 0){
           img_soal.setVisibility(View.VISIBLE);
           img_soal.setImageResource(imageResId);
        }else {
            img_soal.setVisibility(View.GONE);
        }
        radiogrup.clearCheck();
        radiogrup.setVisibility(View.VISIBLE);
    }

    private void showFinalHasil() {
        int totalTanya = tanyaList.size();
        int scorePercentage = (hasil * 100) / totalTanya;

        Intent i = new Intent(this, skor_gambar.class);
        i.putExtra("HASIL", scorePercentage);
        startActivity(i);
    }



}