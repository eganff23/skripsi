package com.example.easylearnenglish.ujian;

import android.content.Intent;
//import android.media.MediaPlayer;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.easylearnenglish.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class kuis extends AppCompatActivity {
    private TextView questionTextView;
    private TextView answerTextView;
    private RadioGroup optionRadioGroup;
    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;
    private Button nextButton;

    private List<question> questionList;
    private int currentQuestionIndex;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Mengatur tampilan menjadi fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //nextButton.setVisibility(View.VISIBLE);


        questionTextView = findViewById(R.id.questionTextView);
        optionRadioGroup = findViewById(R.id.optionRadioGroup);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        nextButton = findViewById(R.id.nextButton);
        answerTextView = findViewById(R.id.answerTextView);

        // Inisialisasi daftar pertanyaan
       initialQuestions();
        score = 0;
        // Acak urutan pertanyaan
        Collections.shuffle(questionList);

        // Tampilkan pertanyaan pertama
        showQuestion(0);
    }

    private static final int MAX_QUESTIONS = 10;
    private void initialQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new question("What is the gerund form of the verb \"swim\"?", "swimming", "swam", "swum", 0));
        questionList.add(new question("Choose the correct gerund form of the verb to complete the sentence:\n" +
                "My brother enjoys ........ basketball in the park.", "played", "playing", "play", 1));
        questionList.add(new question("What is the gerund form of the verb \"dance\"?", "dance", "danced", "dancing", 2));
        questionList.add(new question("Choose the correct gerund form of the verb to complete the sentence:\n" +
                "Sarah and her friends love ........ movies on the weekends.","watch","watched","watching",2));
        questionList.add(new question("What is the gerund form of the verb \"read\"?", "read", "reading", "reads", 1));
        questionList.add(new question("Choose the correct gerund form of the verb to complete the sentence:\n"+
                "The students are practicing ........ for the school play.","sing","singing","sang",1));
        questionList.add(new question("What is the gerund form of the verb \"draw\"?","drawing","drew","draw",0));
        questionList.add(new question("Choose the correct gerund form of the verb to complete the sentence:\n" +
                "The dog loves ........ in the park.","run","running","ran",1));
        questionList.add(new question("What is the gerund form of the verb \"write\"?","writing","wrote","written",0));
        questionList.add(new question("Apa bahasa Inggrisnya \"mobil\"","ship","car","plane",1));
        questionList.add(new question("Apa bahasa Inggrisnya\"sepatu\"","shoes","doll","pants",0));
        if (questionList.size() > MAX_QUESTIONS) {
            List<question> randomQuestions = new ArrayList<>();
            Random random = new Random();
            while (randomQuestions.size() < MAX_QUESTIONS) {
                int randomIndex = random.nextInt(questionList.size());
                randomQuestions.add(questionList.get(randomIndex));
                questionList.remove(randomIndex);
            }
            questionList = randomQuestions;
        }
    }

    public void onNextButtonClick(View view) {
        // Cek jawaban yang dipilih
        int selectedAnswer = optionRadioGroup.getCheckedRadioButtonId();
        if (selectedAnswer == -1) {
            Toast.makeText(this, "Pilih jawaban terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        // Cek jawaban yang benar
        RadioButton selectedRadioButton = findViewById(optionRadioGroup.getCheckedRadioButtonId());
        int answerIndex = optionRadioGroup.indexOfChild(selectedRadioButton);
        question currentQuestion = questionList.get(currentQuestionIndex);

        if (answerIndex == currentQuestion.getCorrectAnswer()) {
            // Jawaban benar
            score++;
            answerTextView.setVisibility(View.INVISIBLE);
        } else {
            String correctAnswerText = "";
            switch (currentQuestion.getCorrectAnswer()) {
                case 0:
                    correctAnswerText = currentQuestion.getOption1();
                    break;
                case 1:
                    correctAnswerText = currentQuestion.getOption2();
                    break;
                case 2:
                    correctAnswerText = currentQuestion.getOption3();
                    break;
            }
            answerTextView.setText("Jawaban yang benar: " + correctAnswerText);
            answerTextView.setVisibility(View.VISIBLE);
            Toast.makeText(this,"Jawaban Kamu Salah", Toast.LENGTH_SHORT).show();
        }

        // Sembunyikan answerTextView jika jawaban benar
        answerTextView.setVisibility(answerIndex == currentQuestion.getCorrectAnswer() ? View.INVISIBLE : View.VISIBLE);

        nextButton.setVisibility(View.VISIBLE);
        optionRadioGroup.setVisibility(View.INVISIBLE);
        nextButton.setEnabled(true);
        // Pindah ke pertanyaan berikutnya
        currentQuestionIndex++;
        if (currentQuestionIndex < questionList.size()) {
            showQuestion(currentQuestionIndex);
        } else {
            // Kuis selesai
            showFinalScore();
        }
    }

    private void showQuestion(int questionIndex) {
        // Tampilkan pertanyaan berdasarkan indeks
        question question = questionList.get(questionIndex);

        // Set pertanyaan dan pilihan jawaban ke komponen UI
        questionTextView.setText(question.getQuestion());
        option1RadioButton.setText(question.getOption1());
        option2RadioButton.setText(question.getOption2());
        option3RadioButton.setText(question.getOption3());

        // Reset pilihan jawaban
        optionRadioGroup.clearCheck();
        optionRadioGroup.setVisibility(View.VISIBLE);

    }

    private void showFinalScore() {
        // Tampilkan skor akhir atau tindakan lain yang diinginkan
        int totalQuestions = questionList.size();
        int scorePercentage = (score * 100) / totalQuestions;

        // Menampilkan skor akhir
        Intent intent = new Intent(this, skor.class);
        intent.putExtra("SCORE", scorePercentage);
        startActivity(intent);
    }

}
